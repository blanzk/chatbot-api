package com.blanzk.chatbot.api.domain.zsxq.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Auto-generated: 2025-03-02 0:17:12
 *
 * @author www.pcjson.com
 * @website http://www.pcjson.com/json2java/
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {

    @JsonProperty("group_id")
    private String groupId;
    private String name;
    private String type;
    @JsonProperty("background_url")
    private String backgroundUrl;

}