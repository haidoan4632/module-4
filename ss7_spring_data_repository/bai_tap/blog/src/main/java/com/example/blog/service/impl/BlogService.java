package com.example.blog.service.impl;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository repository;

    @Override
    public List<Blog> displayBlog() {
        return blogRepository.findAll();
    }

    @Override
    public void createBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void editBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog detailBlog(Integer id) {
        try {
            return blogRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }

    }

    @Override
    public boolean deleteBlog(Blog blog) {
        blogRepository.delete(blog);
        return true;
    }
}
