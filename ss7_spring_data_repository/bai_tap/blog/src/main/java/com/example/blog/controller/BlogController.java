package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping()
    public String display(Model model) {
        model.addAttribute("blogList", blogService.findAll());
        return "/home";
    }

    @GetMapping("/create-form")
    public String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @GetMapping("/update/{id}")
    public String showFormEdit(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/update";
    }

    @GetMapping("/detail/{id}")
    public String showFormDetail(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (blogService.remove(id)) {
            redirectAttributes.addFlashAttribute("msg", "Xóa thành công. ");
        } else {
            redirectAttributes.addFlashAttribute("msg", "Không tìm thấy id. ");
        }
        return "redirect:/blog";
    }

    @PostMapping("/update")
    public String edit(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        if (blogService.update(blog)) {
            redirectAttributes.addFlashAttribute("msg", "Sửa thành công. ");
        } else {
            redirectAttributes.addFlashAttribute("msg", "Không tìm thấy id. ");
        }
        return "redirect:/blog";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.create(blog);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công. ");
        return "redirect:/blog";
    }
}