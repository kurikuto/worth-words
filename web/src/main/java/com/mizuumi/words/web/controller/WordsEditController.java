package com.mizuumi.words.web.controller;

import com.mizuumi.words.web.dto.WordsDto;
import com.mizuumi.words.web.entity.WordsEntity;
import com.mizuumi.words.web.repository.WordsRepository;
import com.mizuumi.words.web.util.dateUtil;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

/**
 * WordsEditController
 */
@Controller
public class WordsEditController {

    @Autowired
    WordsRepository wordsRepository;

    /**
     * ことば編集画面
     * 
     * @param id
     * @param mav
     * @return
     */
    @GetMapping("/words/edit/{id}")
    public ModelAndView edit(
        @ModelAttribute WordsDto dto,
        @PathVariable int id,
        ModelAndView mav) 
    {
        Optional<WordsEntity> data = wordsRepository.findByWordsId((long)id);
        BeanUtils.copyProperties(data.get(), dto);

        mav.addObject("formModel", dto);
        mav.setViewName("edit");
        return mav;
    }

    /**
     * ことば更新処理
     * @param mav
     * @return
     */
    @PostMapping("/words/edit")
    @Transactional
    public ModelAndView update(@ModelAttribute WordsDto dto, ModelAndView mav) {
        // コントローラで暫定処理
        WordsEntity entity = new WordsEntity();
        BeanUtils.copyProperties(dto, entity);
        entity.setModified(dateUtil.getNowDate());
        entity.setDelFlg(false);

        wordsRepository.saveAndFlush(entity);
        return new ModelAndView("redirect:/home");
    }

}
