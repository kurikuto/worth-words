package com.mizuumi.words.web.repository;

import com.mizuumi.words.web.entity.MemberEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer>{

    public Optional<MemberEntity> findByMemberId(Integer memberId);
}
