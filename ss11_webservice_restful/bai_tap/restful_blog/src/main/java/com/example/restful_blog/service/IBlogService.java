package com.example.restful_blog.service;

import com.example.restful_blog.model.Blog;
import com.example.restful_blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> displayBlog();

    void createBlog(Blog blog);
    void editBlog(Blog blog);
    Blog detailBlog(Integer id);
    void deleteBlog(Integer id);

}
