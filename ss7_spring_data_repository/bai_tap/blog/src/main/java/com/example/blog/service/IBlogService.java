package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface IBlogService {
    Page<Blog> getAll(Pageable pageable);
    void save(Blog blog);

    void delete(int id);

    void update(Blog blog);

    Blog findById(int id);
}
