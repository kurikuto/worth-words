package com.mizuumi.words.web.controller;

import com.mizuumi.words.web.dto.WordsDto;
import com.mizuumi.words.web.entity.WordsEntity;
import com.mizuumi.words.web.entity.MemberEntity;
import com.mizuumi.words.web.repository.WordsRepository;
import com.mizuumi.words.web.repository.MemberRepository;

import java.util.Optional;

import com.mizuumi.words.web.util.dateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
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

    @Autowired
    MemberRepository memberRepository;

    /**
     * ことば画面
     * 
     * @param id
     * @param mav
     * @return
     */
    @GetMapping("/words/read/{id}")
    public ModelAndView read(@PathVariable long id, ModelAndView mav) {
        WordsDto words = new WordsDto();
        Optional<WordsEntity> data = wordsRepository.findByWordsId(id);
        BeanUtils.copyProperties(data.get(), words);

        if (words.getTitle() == null) {
            words.setTitle("no title");
        }
        Optional<MemberEntity> member = memberRepository.findByMemberId(data.get().getMemberId());
        words.setContributor(member.get().getNickname());
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
        words.setTitle("no title");
        words.setCategory(1);
        words.setWordsDate(dateUtil.getNowDate());
        words.setContributor("今日の投稿者");
        mav.addObject("words", words);

        mav.setViewName("read");
        return mav;
    }

}
