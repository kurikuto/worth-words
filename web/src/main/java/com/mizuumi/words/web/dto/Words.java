package com.mizuumi.words.web.dto;

import lombok.Data;

@Data
public class Words {
    private int id;
    private String title;
    private String words;
    private String source;
    private int category;
    private String wordsDate;
    private String contributor;

}
