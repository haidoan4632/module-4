package com.example.restful_blog.repository;

import com.example.restful_blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findAllByFlagDeleteIsFalse();

    Blog getBlogByIdAndFlagDeleteIsFalse(Integer id);

}
