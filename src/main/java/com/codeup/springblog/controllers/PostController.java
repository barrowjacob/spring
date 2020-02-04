package com.codeup.springblog.controllers;

import com.codeup.springblog.Models.Post;
import com.codeup.springblog.Models.User;
import com.codeup.springblog.Repositories.postRepository;
import com.codeup.springblog.Repositories.userRepository;
import com.codeup.springblog.Services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @GetMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }


    @GetMapping(path = "/posts/{id}/update")
    public String sendPostToUpdateForm(@PathVariable Long id,
                          Model model) {
        model.addAttribute("post",postDao.getOne(id));
        return "posts/update";
    }
    @PostMapping("/posts/{id}/update")
    public String returnUpdatedPost(@ModelAttribute Post post) {
        postDao.save(post);
        return "redirect:/posts";
    }


    @GetMapping("/posts/create")
    public String create(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        post.setUsers(user);
        postDao.save(post);
        email.prepareAndSend(post, "you made a new post! " + post.getTitle(), "here's the body " + post.getBody());
        return "redirect:/posts";
    }


    @PostMapping("/posts")
    public String creates() {
        return "create a new post";
    }

    private final postRepository postDao;
    private final userRepository userDao;
    private final EmailService email;
    public PostController(postRepository postDao, userRepository userDao, EmailService email) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.email = email;
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
