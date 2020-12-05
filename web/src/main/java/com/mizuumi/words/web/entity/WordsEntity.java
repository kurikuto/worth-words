package com.mizuumi.words.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import lombok.Data;

@Data
@Entity
@Table(name="t_words")
public class WordsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "words_id", nullable = false)
    private long wordsId;

    @Column(name = "member_id", nullable = false)
    private Integer memberId;

    @Column(name = "words", length = 300, nullable = false)
    private String words;

    @Column(name = "source", length = 120, nullable = false)
    private String source;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "words_date", length = 10)
    private String wordsDate;

    @Column(name = "created", length = 19, nullable = false)
    private String created;

    @Column(name = "modified", length = 19, nullable = false)
    private String modified;

    @Column(name = "open_flg", length = 1, nullable = false)
    private boolean openFlg;

    @Column(name = "del_flg", length = 1, nullable = false)
    private boolean delFlg;

}
