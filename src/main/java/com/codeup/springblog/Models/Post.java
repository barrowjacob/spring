package com.codeup.springblog.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="posts")
public class Post {

    @OneToOne(mappedBy="post")
    private PostDetails postDetails;

    @OneToMany(mappedBy="post")
    private List<PostImage> images;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User users;




    public List<PostImage> getImage() {
        return images;
    }

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

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
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

// CONSTRUCTORS

    public Post() {
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body, Long id) {
        this.title = title;
        this.body = body;
        this.id = id;
    }

}
