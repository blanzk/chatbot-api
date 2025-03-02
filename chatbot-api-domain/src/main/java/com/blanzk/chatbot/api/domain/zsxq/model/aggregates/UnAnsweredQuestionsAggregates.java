
package com.blanzk.chatbot.api.domain.zsxq.model.aggregates;

import com.blanzk.chatbot.api.domain.zsxq.model.res.RespData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Auto-generated: 2025-03-02 0:15:4
 *
 * @author www.pcjson.com
 * @website http://www.pcjson.com/json2java/
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnAnsweredQuestionsAggregates {

    private boolean succeeded;
    @JsonProperty("resp_data")
    private RespData respData;

}