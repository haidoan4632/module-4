package com.example.restful_blog.controller;

import com.example.restful_blog.model.Blog;
import com.example.restful_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/blog")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping()
    public ResponseEntity<List<Blog>> getAllBlogs() {
        List<Blog> blogs = blogService.displayBlog();
        return ResponseEntity.ok(blogs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Integer id) {
        Blog blog = blogService.detailBlog(id);
        if (blog == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(blog);
    }

    @PostMapping()
    public ResponseEntity<Void> createBlog(@RequestBody Blog blog) {
        blogService.createBlog(blog);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBlog(@PathVariable Integer id, @RequestBody Blog blog) {
        Blog existingBlog = blogService.detailBlog(id);
        if (existingBlog == null) {
            return ResponseEntity.notFound().build();
        }
        blog.setId(id);
        blogService.editBlog(blog);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Integer id) {
        Blog existingBlog = blogService.detailBlog(id);
        if (existingBlog == null) {
            return ResponseEntity.notFound().build();
        }
        blogService.deleteBlog(id);
        return ResponseEntity.noContent().build();
    }

    private boolean isBlogExist(Integer id) {
        return blogService.detailBlog(id) != null;
    }








    @GetMapping("/list")
    public ResponseEntity<Page<Blog>> pageBlog(@PageableDefault(size = 20) Pageable pageable) {
        Page<Blog> blogPage = blogService.getPage(pageable);
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }



    @GetMapping("/findListBlog/{name}")
    public ResponseEntity<List<Blog>> findListBlog(@PathVariable String name) {
        List<Blog> blogList = blogService.findByName(name);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }


}