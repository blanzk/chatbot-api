
package com.blanzk.chatbot.api.domain.zsxq.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Auto-generated: 2025-03-02 0:17:12
 *
 * @author www.pcjson.com
 * @website http://www.pcjson.com/json2java/
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSpecific {

    private boolean liked;
    @JsonProperty("liked_emojis")
    private List likedEmojis;
    private boolean subscribed;

}