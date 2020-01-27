package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StringTransformController {
    @GetMapping("/string/reverse/{string}")
    @ResponseBody
    public String reverse(@PathVariable String string) {
        StringBuilder newString = new StringBuilder();
        newString.append(string);
        return newString.reverse().toString();
    }

    @GetMapping("/string/uppercase/{string}")
    @ResponseBody

    public String uppercase(@PathVariable String string) {
        return string.toUpperCase();
    }

    @GetMapping("/string/both/{string}")
    @ResponseBody
    public String both(@PathVariable String string) {
        return reverse(string).toUpperCase();
    }

    @GetMapping("/string/{string}")
    @ResponseBody
    public String wat (@RequestParam(required= false) boolean reverse, @RequestParam(required = false) boolean caps, @PathVariable String string) {
        if (reverse && caps) {
            StringBuilder newWat = new StringBuilder();
            newWat.append(string);
            return newWat.reverse().toString().toUpperCase();
        } else if (reverse) {
            StringBuilder newWat = new StringBuilder();
            newWat.append(string);
            return newWat.reverse().toString();
        } else if (caps) {
            return string.toUpperCase();
        } else {
            return string;
        }
    }

    @RequestMapping(value ="**")
    @ResponseBody
    public String welcome() {
        return "oh no unmapped uri";
    }

    @RequestMapping(value="/wildcard*")
    @ResponseBody
    public String wild() {
        return "WILD CAAAAARD";
    }
}
