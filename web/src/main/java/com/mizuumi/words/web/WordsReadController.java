package com.mizuumi.words.web;

import com.mizuumi.words.web.dto.WordsDto;
import com.mizuumi.words.web.repository.WordsRepository;

import com.mizuumi.words.web.util.dateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * WordsReadController
 */
@Controller
public class WordsReadController {

    @Autowired
    WordsRepository wordsRepository;

    /**
     * ことば画面
     * 
     * @param id
     * @param mav
     * @return
     */
    @GetMapping("/words/read/{id}")
    public ModelAndView read(@PathVariable int id, ModelAndView mav) {
        int res = 1;
        for (int i = 1; i < id; i++) {
            res += 1;
        }

        WordsDto words = new WordsDto();
        // Wordsクラス設定
        words.setWords("ことば" + res);
        words.setSource("出典" + res);
        words.setCategory(res);
        words.setWordsDate(dateUtil.getNowDate());
        words.setContributor("投稿者" + res);
        mav.addObject("words", words);

        mav.setViewName("read");
        return mav;
    }

    /**
     * 今日のことば画面
     * @param mav
     * @return
     */
    @GetMapping("/words/today")
    public ModelAndView today(ModelAndView mav) {
        WordsDto words = new WordsDto();
        // Wordsクラス設定
        words.setWords("今日のことば");
        words.setSource("今日の出典");
        words.setCategory(1);
        words.setWordsDate(dateUtil.getNowDate());
        words.setContributor("今日の投稿者");
        mav.addObject("words", words);

        mav.setViewName("read");
        return mav;
    }

}
