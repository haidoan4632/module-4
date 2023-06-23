package com.example.blog.service;


import com.example.blog.model.Blog;
import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void create(Blog blog);

    Blog findById(Integer id);

    boolean update(Blog blog);

    boolean remove(int id);
}
