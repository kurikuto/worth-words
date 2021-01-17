package com.mizuumi.words.web.controller;

import com.mizuumi.words.web.dto.WordsDto;
import com.mizuumi.words.web.entity.WordsEntity;
import com.mizuumi.words.web.repository.WordsRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * WordsListController
 */
@Controller
public class WordsListController {    
    
    @Autowired
    WordsRepository wordsRepository;

    /**
     * ことばリスト画面
     * @param mav
     * @return
     */
    @GetMapping("/list")
    public ModelAndView get(ModelAndView mav) {
        // ことばリスト
        List<WordsDto> wordsList = new ArrayList<WordsDto>();
        // TODO: memberId
        wordsList = this.getWordsList(1001);

        mav.addObject("wordsList", wordsList);
        mav.setViewName("list");
        
        return mav;
    }

    /**
     * ことばリスト画面（カテゴリ選択）
     * @param category
     * @param mav
     * @return
     */
    @PostMapping("/list")
    public ModelAndView post(
        @RequestParam(value="category",required=false)String category,
        ModelAndView mav) 
    {
        // ことばリスト
        List<WordsDto> wordsList = new ArrayList<WordsDto>();
        // TODO: カテゴリ対応
        mav.addObject("category", "category: " + category);
        // TODO: memberId
        wordsList = this.getWordsList(1001);

        mav.addObject("wordsList", wordsList);
        mav.setViewName("list");
        return mav;
    }

    // sample list
    // private List<WordsDto> setSampleList(List<WordsDto> wordsList) {
    //     for (int i = 1; i < 6; i++) {
    //         WordsDto words = new WordsDto();
    //         // Wordsクラス設定
    //         words.setWordsId(i);
    //         words.setTitle("ことば" + i);
    //         words.setWordsDate(dateUtil.getNowDate());
    //         wordsList.add(words);
    //     }
    //     return wordsList;
    // }

    /**
     * 該当ユーザのことば一覧を取得する
     * 
     * @param memberId
     * @return
     */
    private List<WordsDto> getWordsList(int memberId) {
        // ことばリスト
        List<WordsDto> wordsList = new ArrayList<WordsDto>();

        List<WordsEntity> data = wordsRepository.findByMemberIdOrderByWordsIdDesc(memberId);

        for (WordsEntity entity : data) {
            WordsDto dto = new WordsDto();
            BeanUtils.copyProperties(entity, dto);
            if (dto.getTitle() == null) {
                dto.setTitle("no title");
            }
            wordsList.add(dto);
        }
        return wordsList;
    }
    
}
