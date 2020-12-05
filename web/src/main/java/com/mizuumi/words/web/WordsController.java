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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WordsController {

    @Autowired
    WordsRepository wordsRepository;

    @RequestMapping("/words/read/{id}")
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

    @RequestMapping("/words/today")
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
