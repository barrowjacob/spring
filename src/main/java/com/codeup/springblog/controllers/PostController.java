package com.codeup.springblog.controllers;

import com.codeup.springblog.Models.Post;
import com.codeup.springblog.Models.postRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String posts(Model model) {
       model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

//    @GetMapping(path = "/posts/show")
//        public String post(Model model) {
//        return "posts/show";
//    }

    @GetMapping(path = "/posts/update")
    public String sendPostToUpdateForm(@RequestParam String postTitle,
                          @RequestParam String postBody,
                          @RequestParam Long postId,
                          Model model) {
        model.addAttribute("postTitle",postTitle);
        model.addAttribute("postBody", postBody);
        model.addAttribute("postId", postId);
        return "posts/update";
    }

    //handles what to do when update form sends data to posts/update
    @PostMapping("/posts/update")
    //takes in the parameters
    public String returnUpdatedPost(@RequestParam String postTitle,
                          @RequestParam String postBody,
                          @RequestParam Long postId,
                          Model model) {
        model.addAttribute("postTitle", postTitle);
        model.addAttribute("postBody", postBody);
        model.addAttribute("postId", postId);
        //creates new Post object with updated attributes (same ID)!
        Post newPost = new Post(postTitle, postBody, postId);
        //save takes them and overwrites them based on ID
        postDao.save(newPost);
//        make sure there's no space between ':' and '/'
        return "redirect:/posts";
    }


    @GetMapping("/posts/create")
    @ResponseBody
    public String create() {
        return "view the form for creating a post";
    }


    @PostMapping("/posts")
    public String creates() {
        return "create a new post";
    }

    private final postRepository postDao;

    public PostController(postRepository postDao) {
        this.postDao = postDao;
    }

//  f

}
