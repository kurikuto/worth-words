package com.mizuumi.words.web.dto;

import lombok.Data;
import javax.validation.constraints.NotEmpty;

@Data
public class WordsDto {

    private long wordsId;

    private Integer memberId;

    private String title;

    @NotEmpty
    private String words;

    @NotEmpty
    private String source;

    private Integer category;

    @NotEmpty
    private String wordsDate;

    private String created;

    private String contributor;

    private Boolean openFlg;

}
