package com.mizuumi.words.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WordsListController {
    
    @RequestMapping("/list")
    public String get() {
        return "list";
    }

}
