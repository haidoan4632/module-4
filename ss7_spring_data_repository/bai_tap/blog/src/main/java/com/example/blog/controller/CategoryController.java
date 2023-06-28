package com.example.blog.controller;

import com.example.blog.model.Category;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("")
    public String display(Model model){
        model.addAttribute("category",categoryService.findCategory());
        return "category/index";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("category",new Category());
        return "category/create";
    }
    @PostMapping("/create1")
    public String create(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("msg", "thêm thành công");
        return "redirect:/category";
    }
    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable Integer id, Model model){
        model.addAttribute("category",categoryService.findID(id));
        return "update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Category category, RedirectAttributes redirectAttributes, Model model) {
        if (categoryService.findID(category.getId())==null){
            model.addAttribute("category",categoryService.findID(category.getId()));
            return "category/update";
        }
        categoryService.editCategory(category);
        redirectAttributes.addFlashAttribute("msg", "cập nhật thành công");
        return "redirect:/category";
    }
    @GetMapping("/delete/{id}")
    public String delete(@ModelAttribute Category category, RedirectAttributes redirectAttributes, Model model) {
        if (categoryService.findID(category.getId())==null){
            redirectAttributes.addFlashAttribute("msg", "xóa thất bại");
            return "redirect:/category";
        }
        categoryService.deleteCategory(category);
        redirectAttributes.addFlashAttribute("msg", "xóa thành công");
        return "redirect:/category";
    }
}