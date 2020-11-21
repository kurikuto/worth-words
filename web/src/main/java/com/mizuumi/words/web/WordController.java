package com.mizuumi.words.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WordController {
    
    @RequestMapping("/word/read")
    public String read() {
        return "read";
    }

    @RequestMapping("/word/register")
    public String register() {
        return "register";
    }

}
