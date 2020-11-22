package com.mizuumi.words.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WordsController {
    
    @RequestMapping("/words/read")
    public String read() {
        return "read";
    }

    @RequestMapping("/words/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/words/today")
    public String today() {
        return "read";
    }

}
