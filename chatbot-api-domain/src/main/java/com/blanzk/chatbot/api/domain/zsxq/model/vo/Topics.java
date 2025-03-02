
package com.blanzk.chatbot.api.domain.zsxq.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Auto-generated: 2025-03-02 0:17:12
 *
 * @author www.pcjson.com
 * @website http://www.pcjson.com/json2java/
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topics {

    @JsonProperty("topic_id")
    private String topicId;
    private Group group;
    private String type;
    private Talk talk;
    @JsonProperty("likes_count")
    private int likesCount;
    @JsonProperty("tourist_likes_count")
    private int touristLikesCount;
    @JsonProperty("rewards_count")
    private int rewardsCount;
    @JsonProperty("comments_count")
    private int commentsCount;
    @JsonProperty("reading_count")
    private int readingCount;
    @JsonProperty("readers_count")
    private int readersCount;
    private boolean digested;
    private boolean sticky;
    @JsonProperty("create_time")
    private Date createTime;
    @JsonProperty("user_specific")
    private UserSpecific userSpecific;
    private String title;

}