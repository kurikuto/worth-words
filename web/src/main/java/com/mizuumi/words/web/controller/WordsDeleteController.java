package com.mizuumi.words.web.controller;

import com.mizuumi.words.web.dto.WordsDto;
import com.mizuumi.words.web.entity.WordsEntity;
import com.mizuumi.words.web.repository.WordsRepository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

/**
 * WordsDeleteController
 */
@Controller
public class WordsDeleteController {

    @Autowired
    WordsRepository wordsRepository;

    /**
     * ことば削除画面
     * 
     * @param id
     * @param mav
     * @return
     */
    @GetMapping("/words/delete/{id}")
    public ModelAndView delete(
        @ModelAttribute WordsDto dto,
        @PathVariable int id,
        ModelAndView mav)
    {
        Optional<WordsEntity> data = wordsRepository.findByWordsId((long)id);
        BeanUtils.copyProperties(data.get(), dto);

        mav.addObject("formModel", dto);
        mav.setViewName("delete");
        return mav;
    }

    /**
     * ことば削除処理
     * 
     * @param wordsId
     * @param mav
     * @return
     */
    @PostMapping("/words/delete")
    @Transactional
    public ModelAndView remove(
        @RequestParam(value="wordsId") long wordsId,
        @RequestParam(value="memberId") int memberId,
        ModelAndView mav) {
        // コントローラで暫定処理
        wordsRepository.deleteByWordsIdAndMemberId(wordsId, memberId);
        return new ModelAndView("redirect:/home");
    }

}
