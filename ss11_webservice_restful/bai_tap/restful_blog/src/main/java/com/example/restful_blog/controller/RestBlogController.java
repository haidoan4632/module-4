package com.example.restful_blog.controller;

import com.example.restful_blog.model.Blog;
import com.example.restful_blog.service.IBlogService;
import com.example.restful_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
@RequestMapping("/blog")
@RestController
public class RestBlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping()
    public List<Blog> getBlog() {
        List<Blog> blogs = blogService.displayBlog();
        return this.blogService.displayBlog();

    }

    @GetMapping("{id}")
    public ResponseEntity<Blog> getBlogDetail(@PathVariable Integer id) {
        try {
            Blog blog = this.blogService.detailBlog(id);
            return ResponseEntity.ok(blog);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createBlog(@RequestBody Blog blog) {
        this.blogService.createBlog(blog);

    }

    @PutMapping()
    public void updateBlog(@RequestBody Blog blog) {
        this.blogService.editBlog(blog);
    }

    ;

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        this.blogService.deleteBlog(id);
    }
}
