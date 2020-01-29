package com.codeup.springblog.Models;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {

    @OneToOne(mappedBy="post")
    private PostDetails postDetails;
//
//    @ManyToOne
//    @JoinColumn(name="user_id", nullable=false)
//    private User user;

    @Column(nullable=false)
    private String title;
    @Column(nullable=false, columnDefinition = "TEXT")
    private String body;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, columnDefinition = "INT(11) UNSIGNED")
    private Long id;

    public PostDetails getPostDetails() {
        return postDetails;
    }

    public Post() {

    }
    public Post(String title, String body, Long id) {
        this.title = title;
        this.body = body;
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return this.body;
    }
    public void setBody() {
        this.body = body;
    }
}
