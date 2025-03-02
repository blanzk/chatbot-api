package com.blanzk.chatbot.api.domain.zsxq;

import com.blanzk.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;

import java.io.IOException;

/**
 * @Author: yicun
 * @Description: TODO
 * @DateTime: 2025/3/2 上午1:33
 **/
public interface IZsxqService {
    UnAnsweredQuestionsAggregates getUnAnsweredQuestionsAggregates(String groupId, String cookie) throws IOException;

    boolean answerText(String topicId, String text, String cookie) throws IOException;
}
