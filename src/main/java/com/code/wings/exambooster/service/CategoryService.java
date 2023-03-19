package com.code.wings.exambooster.service;

import com.code.wings.exambooster.entity.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findAll();

    public Category findById(int id);

    public void save(Category category);

    public void deleteById(int id);
}
