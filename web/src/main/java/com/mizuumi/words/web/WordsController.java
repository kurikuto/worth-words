package com.mizuumi.words.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.mizuumi.words.web.dto.Words;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WordsController {
    
    @RequestMapping("/words/read/{id}")
    public ModelAndView read(@PathVariable int id, ModelAndView mav) {
        int res = 1;
        for (int i = 1; i < id; i++) {
            res += 1;
        }

        Words words = new Words();
        // 現在日時
        LocalDateTime nowDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        // Wordsクラス設定
        words.setWords("ことば" + res);
        words.setSource("出典" + res);
        words.setCategory(res);
        words.setWordsDate(nowDateTime.format(formatter));
        words.setContributor("投稿者" + res);
        mav.addObject("words", words);

        mav.setViewName("read");
        return mav;
    }

    @RequestMapping("/words/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/words/today")
    public ModelAndView today(ModelAndView mav) {
        Words words = new Words();
        // 現在日時
        LocalDateTime nowDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        // Wordsクラス設定
        words.setWords("今日のことば");
        words.setSource("今日の出典");
        words.setCategory(1);
        words.setWordsDate(nowDateTime.format(formatter));
        words.setContributor("今日の投稿者");
        mav.addObject("words", words);

        mav.setViewName("read");
        return mav;
    }

}
