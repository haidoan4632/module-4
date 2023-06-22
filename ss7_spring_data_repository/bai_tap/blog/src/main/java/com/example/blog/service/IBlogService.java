package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IBlogService {
    List<Blog> displayBlog();
    void createBlog(Blog blog);
    void editBlog(Blog blog);
    Blog detailBlog(Integer id);
    boolean deleteBlog(Blog blog);


}
