
package com.blanzk.chatbot.api.domain.zsxq.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Auto-generated: 2025-03-02 0:17:12
 *
 * @author www.pcjson.com
 * @website http://www.pcjson.com/json2java/
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Owner {

    @JsonProperty("user_id")
    private String userId;
    private String name;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    private String location;

}