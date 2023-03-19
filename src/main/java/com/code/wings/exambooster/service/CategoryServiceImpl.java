package com.code.wings.exambooster.service;

import com.code.wings.exambooster.dao.CategoryRepository;
import com.code.wings.exambooster.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        Optional<Category> result = categoryRepository.findById(id);

        Category theCategory  = null;

        if (result.isPresent()) {
            theCategory = result.get();
        }
        else {
            // we didn't find the category
            throw new RuntimeException("Did not find category id - " + id);
        }

        return theCategory;
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }
}
