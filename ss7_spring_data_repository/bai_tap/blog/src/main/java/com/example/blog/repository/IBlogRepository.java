package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
    public interface IBlogRepository extends JpaRepository<Blog, Integer> {
        @Query(value = "select * from blocks join categorys where blocks.flag = false", nativeQuery = true)
        List<Blog> findAllByIsFlag();
@Modifying
@Transactional
    @Query(value = "UPDATE blocks SET  flag = true where id=?1", nativeQuery = true)
     void deleteByIsFlag(Integer id);
}
