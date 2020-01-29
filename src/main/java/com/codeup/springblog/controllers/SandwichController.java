package com.codeup.springblog.controllers;

import com.codeup.springblog.Models.Sandwich;
import com.codeup.springblog.Models.postRepository;
import com.codeup.springblog.Models.sandwichRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class SandwichController {
    private final sandwichRepository sandDao;

    public SandwichController(sandwichRepository sandDao) {
        this.sandDao = sandDao;
    }
//
//
    @GetMapping("/sandwich")
    public String showSandwich(Model model) {
        Sandwich sandy = sandDao.getOne(1L);
        model.addAttribute("sandy",sandy);
        model.addAttribute("historyOfSandwich", sandy.getSandwichDetails().getHistoryOfSandwich());
//        model.addAttribute("")
        return "sandwiches/index";
    }
}
