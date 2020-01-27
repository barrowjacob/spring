package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RollController {


    @GetMapping("/roll-dice")
    public String roll() {
        return "roll";
    }
    @PostMapping("/roll-dice")
    public String rollDice(@RequestParam String guess, Model model) {
        Random rando = new Random();
        int newRandom = rando.nextInt(6) + 1;
        model.addAttribute("guess", guess);
        model.addAttribute("random",newRandom);
        return "guessPage";
    }

}
