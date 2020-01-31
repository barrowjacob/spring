package com.codeup.springblog.Models;

import javax.persistence.*;

@Entity
@Table(name="postDetails")
public class PostDetails {
    @OneToOne
    private Post post;

    public Post getPost() {
        return post;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false)
    private long id;
    @Column(nullable=false, columnDefinition = "boolean")
    private boolean isAwesome;
    @Column(nullable=false, columnDefinition = "TEXT")
    private String historyOfPost;
    @Column(nullable=false)
    private String topicDescription;

    public PostDetails() {
    }
    public PostDetails(long id, boolean isAwesome, String historyOfPost, String topicDescription) {
        this.id = id;
        this.isAwesome = isAwesome;
        this.historyOfPost = historyOfPost;
        this.topicDescription = topicDescription;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isAwesome() {
        return isAwesome;
    }

    public void setAwesome(boolean awesome) {
        isAwesome = awesome;
    }

    public String getHistoryOfPost() {
        return historyOfPost;
    }

    public void setHistoryOfPost(String historyOfPost) {
        this.historyOfPost = historyOfPost;
    }

    public String getTopicDescription() {
        return topicDescription;
    }

    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }



}
