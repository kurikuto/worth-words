package com.mizuumi.words.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WordsController {
    
    @RequestMapping("/words/read")
    public ModelAndView read(ModelAndView mav) {
        int num = 10;
        int res = 0;
        for (int i = 1; i < num; i++) {
            res += 1;
        }
        mav.addObject("source", "出典" + res);
        mav.setViewName("read");
        return mav;
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
