package com.mizuumi.words.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    
    @GetMapping("/login")
    public String get() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView post(
        @RequestParam("id")String userId, 
        @RequestParam("password")String password,
        ModelAndView mav
    ) {
        if(password.equals("pass123")) {
            return new ModelAndView("redirect:/home");
        }
        mav.addObject("msg", "パスワードが誤っています。");
        mav.setViewName("login");
        return mav;
    }

}
