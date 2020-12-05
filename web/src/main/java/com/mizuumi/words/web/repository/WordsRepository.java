package com.mizuumi.words.web.repository;

import com.mizuumi.words.web.entity.WordsEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordsRepository extends JpaRepository<WordsEntity, Long>{

}
