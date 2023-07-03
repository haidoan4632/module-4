package com.example.restful_blog.repository;

import com.example.restful_blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findAllByFlagDeleteIsFalse();

    Blog getBlogByIdAndFlagDeleteIsFalse(Integer id);

    List<Blog> findAllByNameBlogContainingAndFlagDeleteIsFalse(String name);


//    @Query(value = "select * from blogs join category on category.id = blogs.id where name_blog = ?",nativeQuery = true)
//    List<Blog> findByName(String name);
}
