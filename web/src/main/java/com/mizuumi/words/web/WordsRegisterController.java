package com.mizuumi.words.web;

import javax.transaction.Transactional;
import com.mizuumi.words.web.dto.WordsDto;
import com.mizuumi.words.web.entity.WordsEntity;
import com.mizuumi.words.web.repository.WordsRepository;

import com.mizuumi.words.web.util.dateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * WordsRegisterController
 */
@Controller
public class WordsRegisterController {

    @Autowired
    WordsRepository wordsRepository;

    /**
     * ことば登録画面
     * @param dto
     * @param mav
     * @return
     */
    @GetMapping("/words/register")
    @Transactional
    public ModelAndView input(
        @ModelAttribute("formModel") WordsDto dto,
        ModelAndView mav
    ) {
        dto.setOpenFlg(true);
        mav.setViewName("register");
        return mav;
    }

    /**
     * ことば登録処理
     * @param dto
     * @param mav
     * @return
     */
    @PostMapping("/words/register")
    @Transactional
    public ModelAndView register(
        @ModelAttribute("formModel") WordsDto dto,
        ModelAndView mav
    ) {
        int memberId = 1001; // 暫定

        // コントローラで暫定処理
        WordsEntity entity = new WordsEntity();
        BeanUtils.copyProperties(dto, entity);
        //日付
        entity.setCreated(dateUtil.getNowDate());
        entity.setModified(dateUtil.getNowDate());
        entity.setDelFlg(false);
        entity.setMemberId(memberId);
        wordsRepository.saveAndFlush(entity);

        return new ModelAndView("redirect:/home");
    }

}
