package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String posts(Model model) {
        Post one = new Post("one", "one");
        Post two = new Post("two", "two");
        Post three = new Post("three", "three");
        Post four = new Post("four", "four");
        ArrayList<Post> array = new ArrayList<>();
        array.add(one);
        array.add(two);
        array.add(three);
        array.add(four);
        model.addAttribute("array",array);
        return "posts/index";
    }

    @GetMapping(path = "/posts/show")
        public String post(Model model) {
        Post post = new Post("title","body");
        model.addAttribute("post",post);
        return "posts/show";
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
}
