package com.code.wings.exambooster.dao;

import com.code.wings.exambooster.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

     public List<Question> findAllByOrderByCreatorAsc();

     public List<Question> findByCategoryContainsAllIgnoreCase(String category);
}
