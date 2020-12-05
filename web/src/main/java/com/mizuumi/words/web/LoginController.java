package com.mizuumi.words.web;

import com.mizuumi.words.web.repository.MemberRepository;
import com.mizuumi.words.web.entity.MemberEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    MemberRepository memberRepository;
    
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
        Iterable<MemberEntity> memberList = memberRepository.findAll();
        mav.addObject("memberList", memberList);
        mav.setViewName("login");
        return mav;
    }

}
