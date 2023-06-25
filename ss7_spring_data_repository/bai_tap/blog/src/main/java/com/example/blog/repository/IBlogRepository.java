package com.example.blog.repository;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.awt.print.Pageable;


    public interface IBlogRepository extends JpaRepository<Blog, Integer> {
        Page<Blog> findBlogByTitleContainsAndCategory( String title, Category category ,Pageable pageable );
        @Modifying
        @Transactional
        @Query(value = "update blog as b set is_flag_delete = 1 where b.id = :id ", nativeQuery = true)
        void isDelete(@Param(value = "id") Integer id);
}
