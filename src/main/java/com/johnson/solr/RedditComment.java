package com.johnson.solr;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RedditComment {
    @Field
    private String id;
    @Field
    private String body;
    @Field
    private String author;
    @Field
    private String permalink;
    @Field
    private String subreddit;
    // The submission for which this is a comment of.
    // Get a link for t3_9kfb40 in this format (dropping t3) https://www.reddit.com/9kfb40
    @Field
    private String link_id;
    // Parent comment if any
    @Field
    private String parent_id;
    @Field
    private Long score;
}
