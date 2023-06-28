package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findCategory();
    void save(Category category);
    void editCategory(Category category);
    boolean deleteCategory(Category category);

    Category findID(Integer id);
}
