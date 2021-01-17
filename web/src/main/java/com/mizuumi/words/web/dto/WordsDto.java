package com.mizuumi.words.web.dto;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class WordsDto {

    private long wordsId;

    private Integer memberId;

    @Size(max = 20)
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
