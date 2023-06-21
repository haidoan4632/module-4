package com.example.manager_product.controller;


import com.example.manager_product.model.Product;
import com.example.manager_product.service.IProdcutService;
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
//    @GetMapping("/detail/{id}")
//    public String view(@PathVariable int id, Model model) {
//        model.addAttribute("products", iProductService.findById(id));
//        return "/detail";
//    }
    @PostMapping("create1")
    public String create(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("mess", "Add successful!");
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model) {
        if (iProductService.findById(id)!= null) {
            model.addAttribute("products", iProductService.findById(id));
            return "/update";
        }
        else {
            String message = "not found id";
            model.addAttribute("mess",message);
            return "redirect:/";
        }
    }

    @PostMapping("update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        iProductService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("mess", "Update successful!");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (iProductService.findById(id) != null) {
            iProductService.delete(id);
            String message = "delete success";
            redirectAttributes.addFlashAttribute("mess", message);
            return "redirect:/";
        }
        else {
            String message = "delete not success";
            redirectAttributes.addFlashAttribute("mess", message);
            return "redirect:/";
        }
    }

    @GetMapping("/search")
    public String listSearch(@RequestParam(value = "nameProduct") String name, Model model) {
        model.addAttribute("products", iProductService.findByName(name));
        return "/list";
    }
}