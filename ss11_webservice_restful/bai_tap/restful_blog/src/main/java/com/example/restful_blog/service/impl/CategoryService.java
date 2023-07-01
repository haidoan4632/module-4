package com.example.restful_blog.service.impl;

import com.example.restful_blog.model.Blog;
import com.example.restful_blog.model.Category;
import com.example.restful_blog.repository.IBlogRepository;
import com.example.restful_blog.repository.ICategoryRepository;
import com.example.restful_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service

public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public List<Category> displayCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void editCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category detailCategory(Integer id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }

}
