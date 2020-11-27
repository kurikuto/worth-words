package com.mizuumi.words.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public ModelAndView get(ModelAndView mav) {
        mav.addObject("userId", "dummy");
        mav.setViewName("home");
        return mav;
    }
    
    // @PostMapping("/home")
    // public ModelAndView post(
    //         @RequestParam("id")String userId, 
    //         @RequestParam("password")String password,
    //         ModelAndView mav) 
    // {
    //     mav.addObject("userId", userId);
    //     mav.setViewName("home");
    //     return mav;
    // }

}
