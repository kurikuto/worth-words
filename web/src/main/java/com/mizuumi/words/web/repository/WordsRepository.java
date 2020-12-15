package com.mizuumi.words.web.repository;

import com.mizuumi.words.web.entity.WordsEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordsRepository extends JpaRepository<WordsEntity, Long>{

    public Optional<WordsEntity> findByWordsId(Long wordsId);

    public void deleteByWordsIdAndMemberId(Long wordsId, Integer memberId);

    public List<WordsEntity> findByMemberIdOrderByWordsIdDesc(Integer memberId);

}
