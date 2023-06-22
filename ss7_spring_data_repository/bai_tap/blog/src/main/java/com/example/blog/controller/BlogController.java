package com.example.blog.controller;

import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blogs")
public class BlogController {
   @Autowired
    private IBlogService blogService;
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("blogList", blogService.displayBlog());
        return "display";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        if (blogService.detailBlog(id) == null) {
            redirectAttributes.addFlashAttribute("msg", "not fount by id");
            return "redirect:/";
        } else {
            model.addAttribute("blogList", blogService.detailBlog(id));
            return "detail";
        }
    }

    @GetMapping("/add")
    public String showFormAdd(Model model) {
        Blog blog = new Blog();
        model.addAttribute("blog", blog);
        return "create";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.createBlog(blog);
        redirectAttributes.addFlashAttribute("msg", "create success");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        if (blogService.detailBlog(id) == null) {
            redirectAttributes.addFlashAttribute("msg", "not fount by id");
            return "redirect:/";
        } else {
            model.addAttribute("blog", blogService.detailBlog(id));
            return "update";
        }
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.editBlog(blog);
        redirectAttributes.addFlashAttribute("msg", "edit success");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        if (blogService.detailBlog(id) == null) {
            redirectAttributes.addFlashAttribute("msg", "not fount by id");
            return "redirect:/";
        }else {
            blogService.deleteBlog(blogService.detailBlog(id));
            redirectAttributes.addFlashAttribute("msg", "delete success");
            return "redirect:/";
        }

    }

}
