package com.codeup.springblog.controllers;

import com.codeup.springblog.Models.Post;
import com.codeup.springblog.Models.User;
import com.codeup.springblog.Repositories.postRepository;
import com.codeup.springblog.Repositories.userRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String posts(Model model) {
       model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }


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

    @GetMapping("/posts/delete")
    public String deletePost(@RequestParam String postTitle,
                             @RequestParam String postBody,
                             @RequestParam Long postId,
                             Model model) {
        model.addAttribute("postTitle", postTitle);
        model.addAttribute("postBody", postBody);
        model.addAttribute("postId", postId);
        Post post = new Post(postTitle, postBody, postId);
        postDao.delete(post);
        return "redirect:/posts";
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
    public String create(Model model) {
        return "posts/create";
    }
    @PostMapping("/posts/create")
    public String create(Model model, @RequestParam String title, @RequestParam String body) {
        Post post = new Post(title, body);
        User user = userDao.getOne(1L);
        post.setUsers(user);
        postDao.save(post);
        return "redirect:/posts/" + post.getId();
    }


    @PostMapping("/posts")
    public String creates() {
        return "create a new post";
    }

    private final postRepository postDao;
    private final userRepository userDao;

    public PostController(postRepository postDao, userRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }
    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getOne(id));
        return "posts/show";
    }



    @GetMapping("/newtest")
    @ResponseBody
    public String returnDetails() {
        Post post = postDao.getOne(1L);
        return post.getPostDetails().getHistoryOfPost();
    }

    @GetMapping("/images")
    public String postImages(Model model) {
        model.addAttribute("posts", postDao.getOne(1L).getImage());
        return "cats/index";
    }

}
