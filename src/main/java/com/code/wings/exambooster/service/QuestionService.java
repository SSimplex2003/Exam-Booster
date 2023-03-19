package com.code.wings.exambooster.service;

import com.code.wings.exambooster.entity.Question;
import java.util.List;

public interface QuestionService {

    public List<Question> findAll();

    public Question findById(int id);

    public void save(Question question);

    public void deleteById(int id);

    public List<Question> searchBy(String category);
}
