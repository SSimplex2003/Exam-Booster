package com.code.wings.exambooster.service;


import com.code.wings.exambooster.dao.QuestionRepository;
import com.code.wings.exambooster.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> findAll() {
        return questionRepository.findAllByOrderByCreatorAsc();
    }

    @Override
    public Question findById(int theId) {
        Optional<Question> result = questionRepository.findById(theId);

        Question theQuestion = null;

        if (result.isPresent()) {
            theQuestion = result.get();
        }
        else {
            // we didn't find the question
            throw new RuntimeException("Did not find question id - " + theId);
        }

        return theQuestion;
    }

    @Override
    public void save(Question theQuestion) {
        questionRepository.save(theQuestion);
    }

    @Override
    public void deleteById(int theId) {
        questionRepository.deleteById(theId);
    }

    @Override
    public List<Question> searchBy(String theCategory) {

        List<Question> results = null;

        if (theCategory != null && (theCategory.trim().length() > 0)) {
            results = questionRepository.findByCategoryContainsAllIgnoreCase(theCategory);
        }
        else {
            results = findAll();
        }

        return results;
    }

}
