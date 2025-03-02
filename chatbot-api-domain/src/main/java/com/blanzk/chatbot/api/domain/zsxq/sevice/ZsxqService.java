package com.blanzk.chatbot.api.domain.zsxq.sevice;

import com.alibaba.fastjson.JSON;
import com.blanzk.chatbot.api.domain.zsxq.IZsxqService;
import com.blanzk.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import com.blanzk.chatbot.api.domain.zsxq.model.req.AnwserReq;
import com.blanzk.chatbot.api.domain.zsxq.model.req.ReqData;
import com.blanzk.chatbot.api.domain.zsxq.model.res.AnwserRes;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Author: yicun
 * @Description: TODO
 * @DateTime: 2025/3/2 上午12:10
 **/
@Slf4j
@Service
public class ZsxqService implements IZsxqService {
    public UnAnsweredQuestionsAggregates getUnAnsweredQuestionsAggregates(String groupId, String cookie) throws IOException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet("https://api.zsxq.com/v2/groups/" + groupId + "/topics?scope=all&count=20");
            request.addHeader("accept", "application/json");
            request.setHeader("cookie", cookie);
            CloseableHttpResponse response = client.execute(request);
            String json = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
            UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = JSON.parseObject(json, UnAnsweredQuestionsAggregates.class);
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new IOException("Server returned an error: " + response.getStatusLine().getStatusCode());
            }
            return unAnsweredQuestionsAggregates;
        }
    }

    @Override
    public boolean answerText(String topicId, String text, String cookie) throws IOException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost("https://api.zsxq.com/v2/topics/" + topicId + "/comments");
            httpPost.addHeader("accept", "application/json");
            httpPost.addHeader("cookie", cookie);
            String jsonString = new ObjectMapper().writeValueAsString(new AnwserReq(new ReqData(text)));
            httpPost.setEntity(new StringEntity(jsonString, StandardCharsets.UTF_8));
            CloseableHttpResponse response = client.execute(httpPost);
            String json = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);

            AnwserRes anwserRes = JSON.parseObject(json, AnwserRes.class);
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new IOException("Server returned an error: " + response.getStatusLine().getStatusCode());
            }
            return anwserRes.isSucceeded();
        }
    }
}
