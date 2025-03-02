package com.blanzk.chatbot.api.domain.zsxq.model.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: yicun
 * @Description: TODO
 * @DateTime: 2025/3/2 上午11:40
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnwserReq {
    @JsonProperty("req_data")
    private ReqData reqData;
}
