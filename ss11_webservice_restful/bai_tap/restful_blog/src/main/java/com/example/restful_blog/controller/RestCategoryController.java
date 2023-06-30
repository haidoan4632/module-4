package com.example.restful_blog.controller;

import com.example.restful_blog.model.Category;
import com.example.restful_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
@RequestMapping("/category")
@RestController
public class RestCategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping()
    public List<Category> getCategory() {
        List<Category> categories = categoryService.displayCategory();
        return this.categoryService.displayCategory();

    }

    @GetMapping("{id}")
    public ResponseEntity<Category> getCategoryDetail(@PathVariable Integer id) {
        try {
            Category category = this.categoryService.detailCategory(id);
            return ResponseEntity.ok(category);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createCategory(@RequestBody Category category) {
        this.categoryService.createCategory(category);

    }

    @PutMapping()
    public void updateCategory(@RequestBody Category category) {
        this.categoryService.editCategory(category);
    }

    ;

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        this.categoryService.detailCategory(id);
    }

}
