package com.example.blog.repository;

import com.example.blog.model.Blog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
    public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByFlagDeleteIsFalse(Pageable pageable);

    Blog getBlogByIdAndFlagDeleteIsFalse(Integer id);

        @Modifying
        @Transactional
        @Query(value = "update blogs  set blogs.is_flag_delete = true where blogs.id = ?1", nativeQuery = true)
        void isDelete(Integer id);


}
