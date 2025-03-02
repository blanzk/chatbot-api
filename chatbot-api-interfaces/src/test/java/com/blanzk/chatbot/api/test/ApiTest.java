package com.blanzk.chatbot.api.test;

import com.blanzk.chatbot.api.domain.zsxq.IZsxqService;
import com.blanzk.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import com.blanzk.chatbot.api.domain.zsxq.model.vo.Topics;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @Author: yicun
 * @Description: aoi的单元测试
 * @DateTime: 2025/3/2 上午12:02
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    @Resource
    IZsxqService zsxqService;
    @Value("${chatbot.groupId}")
    private String groupId;
    @Value("${chatbot.cookie}")
    private String cookie;
    @Test
    public void testZsxqService() throws IOException {
        UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqService.getUnAnsweredQuestionsAggregates(groupId, cookie);
        if(!unAnsweredQuestionsAggregates.isSucceeded()){
            log.info("getUnAnsweredQuestionsAggregates failed{}",unAnsweredQuestionsAggregates);
            return;
        }
        List<Topics> topics = unAnsweredQuestionsAggregates.getRespData().getTopics();
        log.info("getUnAnsweredQuestionsAggregates success:{}",topics.size());
        for(Topics topic : topics){
            String topicId = topic.getTopicId();
            String text = topic.getTalk().getText();
            log.info("topicId:{}",topicId);
            log.info("text:{}",text);
            boolean b = zsxqService.answerText(topicId, text, cookie);
            if(!b){
                log.info("answerText failed");
            }
        }
    }
}
