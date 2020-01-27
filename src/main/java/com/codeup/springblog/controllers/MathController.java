package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

//    @GetMapping("/add")
//    @ResponseBody
//    public String add() {
//        return "You're going to add something?";
//    }

    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String add(@PathVariable int num1, @PathVariable int num2) {
        return num1 + " + " + num2 + " = " + (num1 + num2);
    }
    @GetMapping("/subtract/{num1}/and/{num2}")
    @ResponseBody
    public String subtract(@PathVariable int num1, @PathVariable int num2) {
        return num1 + " - " + num2 + " = " + (num1 - num2);
    }
    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiply(@PathVariable int num1, @PathVariable int num2) {
        return num1 + " * " + num2 + " = " + (num1 * num2);
    }
    @GetMapping("/divide/{num1}/and/{num2}")
    @ResponseBody

    public String divide(@PathVariable int num1, @PathVariable int num2) {
        if (num1 == 0 || num2 == 0) {
            throw new ArithmeticException("one cannot divide by 0 without breaking the universe itself.");
        } else {
            return num1 + " / " + num2 + " = " + (num1 / num2);
        }
    }
}
