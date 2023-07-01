package com.example.restful_blog.service;

import com.example.restful_blog.model.Blog;
import com.example.restful_blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> displayCategory();

    void createCategory(Category category);
    void editCategory(Category category);
    Category detailCategory(Integer id);

    void deleteById(Integer id);
}
