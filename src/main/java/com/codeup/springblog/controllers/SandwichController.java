package com.codeup.springblog.controllers;

import com.codeup.springblog.Models.Sandwich;
import com.codeup.springblog.Repositories.sandwichRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        model.addAttribute("allSandwiches", sandDao.findAll());
            List<Sandwich> allSandwichDetails = sandDao.findAll();
//        for (int i =0; i < sandDao.findAll().size(); i++) {
//            allSandwichDetails.get(i).getSandwichDetails();
//        }
        return "sandwiches/index";
    }
}
