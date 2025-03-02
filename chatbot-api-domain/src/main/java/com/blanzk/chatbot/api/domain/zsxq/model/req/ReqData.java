package com.blanzk.chatbot.api.domain.zsxq.model.req;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yicun
 * @Description: TODO
 * @DateTime: 2025/3/2 上午11:40
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqData {
    private String text;

    @JsonProperty("image_ids")
    private List<String> imageIds = new ArrayList<>();

    @JsonProperty("mentioned_user_ids")
    private List<String> mentionedUserIds = new ArrayList<>();

    public ReqData(String text) {
        this.text = text;
    }
}
