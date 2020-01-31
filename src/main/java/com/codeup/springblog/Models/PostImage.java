package com.codeup.springblog.Models;

import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
@Table(name="post_images")
public class PostImage {
    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageTitle;

    @Column(nullable=false)
    private String url;

    public Post getPost() {
        return post;
    }

    public Long getId() {
        return id;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public String getUrl() {
        return url;
    }

}

