package com.example.restful_blog.service.impl;

import com.example.restful_blog.model.Blog;

import com.example.restful_blog.repository.IBlogRepository;
import com.example.restful_blog.service.IBlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public List<Blog> displayBlog() {
        return blogRepository.findAllByFlagDeleteIsFalse();
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
        return blogRepository.getBlogByIdAndFlagDeleteIsFalse(id);
    }

    @Override
    public void deleteBlog(Integer id) {
        Blog blog1 = blogRepository.getBlogByIdAndFlagDeleteIsFalse(id);
        blog1.setFlagDelete(true);
        blogRepository.save(blog1);
    }

    @Override
    public Page<Blog> getPage(Pageable pageable) {
        return this.blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findByName(String name) {
        return this.blogRepository.findAllByNameBlogContainingAndFlagDeleteIsFalse(name);
    }
}