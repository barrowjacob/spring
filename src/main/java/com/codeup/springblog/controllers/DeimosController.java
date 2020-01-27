package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DeimosController {
    @GetMapping("/deimos/{days}")
    public String deimos(@PathVariable int days, Model model) {
        model.addAttribute("days", days);
        return "deimos";
    }

    @PostMapping("/deimos")
    public String days(@RequestParam String days, Model model) {
        model.addAttribute("days", days);
        return "deimos";
    }
}

