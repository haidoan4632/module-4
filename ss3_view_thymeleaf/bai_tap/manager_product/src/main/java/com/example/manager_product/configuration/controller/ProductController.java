package com.example.manager_product.configuration.controller;


import com.example.manager_product.configuration.model.Product;
import com.example.manager_product.configuration.service.IProdcutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class ProductController {
    @Autowired
    private IProdcutService iProductService;

    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("products",iProductService.getAll());
        return "/list";
    }
    @GetMapping("create-form")
    public String createForm(Model model) {
        model.addAttribute("product",new Product());
        return "/create";
    }
    @GetMapping("/{id}/detail")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/detail";
    }
    @PostMapping("create1")
    public String create(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("mess", "Add successful!");
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("products", iProductService.findById(id));
        return "/update";
    }

    @PostMapping("update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        iProductService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("mess", "Update successful!");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes){
        iProductService.delete(id);
        String message = "delete success";
        redirectAttributes.addFlashAttribute("msg",message);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String listSearch(@RequestParam(value = "nameProduct") String name, Model model) {
        model.addAttribute("products", iProductService.findByName(name));
        return "/list";
    }
}