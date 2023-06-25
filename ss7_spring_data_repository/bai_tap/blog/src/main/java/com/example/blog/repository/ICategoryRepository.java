package com.example.blog.repository;

import com.example.blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
    @Query(value = "select * from category  where id = false ", nativeQuery = true)
    List<Category> findAllByIsFlag();
}
