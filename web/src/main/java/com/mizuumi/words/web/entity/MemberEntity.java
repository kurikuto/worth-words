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
@Table(name="t_members")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id", nullable = false)
    private Integer memberId;

    @Column(name = "password", length = 64, nullable = false)
    private String password;

    @Column(name = "nickname", length = 10)
    private String nickname;

    @Column(name = "created", length = 19, nullable = false)
    private String created;

    @Column(name = "modified", length = 19, nullable = false)
    private String modified;

    @Column(name = "del_flg", length = 1, nullable = false)
    private boolean delFlg;

}
