package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping()
    public String getHome(@PageableDefault(size = 2) Pageable pageable, Model model) {
        model.addAttribute("blogList", this.iBlogService.getAll(pageable));
        model.addAttribute("categories", iCategoryService.findCategory());
        return "/home";
    }

    @GetMapping("/create-form")
    public String createForm(Model model) {
        model.addAttribute("blogs", new Blog());
        model.addAttribute("categories", this.iCategoryService.findCategory());
        return "create";
    }

    @PostMapping
    public String create(Blog blog, RedirectAttributes redirectAttributes) {
        this.iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Add successful!");
        return "redirect:/blogs";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable int id, Model model) {

        if (iBlogService.findById(id) != null) {
            iBlogService.delete(id);
            model.addAttribute("blogs", iBlogService.findById(id));
            model.addAttribute("categories", this.iCategoryService.findCategory());
            return "/update";
        } else {
            return "redirect:/blogs";
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        if (iBlogService.findById(blog.getId()) != null) {
            iBlogService.update(blog);
            redirectAttributes.addFlashAttribute("mess", "Update successful!");
            return "redirect:/blogs";
        }
      else {
            return "redirect:/blogs";
        }
    }

    @GetMapping("/{id}/detail")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        model.addAttribute("category", iCategoryService.findCategory());
        return "/detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (iBlogService.findById(id) != null) {
            iBlogService.delete(id);
            redirectAttributes.addFlashAttribute("mess", "Xóa thành công. ");
            return "redirect:/blogs";
        } else {
            redirectAttributes.addFlashAttribute("mess", "Xóa không thành công. ");
            return "redirect:/blogs";
        }
    }
}
