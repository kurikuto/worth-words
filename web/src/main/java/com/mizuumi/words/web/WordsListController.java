package com.mizuumi.words.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WordsListController {
    
    @GetMapping("/list")
    public String get() {
        return "list";
    }

    @PostMapping("/list")
    public ModelAndView post(
        @RequestParam(value="category",required=false)String category,
        ModelAndView mav) 
    {
        mav.addObject("category", "category: " + category);
        mav.setViewName("list");
        return mav;
    }

}
