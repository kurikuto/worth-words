package com.mizuumi.words.web;

import com.mizuumi.words.web.dto.WordsDto;
import com.mizuumi.words.web.util.dateUtil;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WordsListController {    
    
    @GetMapping("/list")
    public ModelAndView get(ModelAndView mav) {
        // ことばリスト
        List<WordsDto> wordsList = new ArrayList<WordsDto>();
        // 暫定
        this.setSampleList(wordsList);

        mav.addObject("wordsList", wordsList);
        mav.setViewName("list");
        
        return mav;
    }

    @PostMapping("/list")
    public ModelAndView post(
        @RequestParam(value="category",required=false)String category,
        ModelAndView mav) 
    {
        // ことばリスト
        List<WordsDto> wordsList = new ArrayList<WordsDto>();
        // 暫定
        mav.addObject("category", "category: " + category);
        this.setSampleList(wordsList);

        mav.addObject("wordsList", wordsList);
        mav.setViewName("list");
        return mav;
    }

    // sample list
    private List<WordsDto> setSampleList(List<WordsDto> wordsList) {
        for (int i = 1; i < 6; i++) {
            WordsDto words = new WordsDto();
            // Wordsクラス設定
            words.setId(i);
            words.setTitle("ことば" + i);
            words.setWordsDate(dateUtil.getNowDate());
            wordsList.add(words);
        }

        return wordsList;
    }

}
