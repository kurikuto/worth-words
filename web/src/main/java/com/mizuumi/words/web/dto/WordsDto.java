package com.mizuumi.words.web.dto;

import lombok.Data;

@Data
public class WordsDto {
    private int wordsId;
    private String title;
    private String words;
    private String source;
    private int category;
    private String wordsDate;
    private String contributor;
    private boolean openFlg;

}
