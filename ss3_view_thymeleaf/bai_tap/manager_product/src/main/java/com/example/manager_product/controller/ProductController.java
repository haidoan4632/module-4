package com.example.manager_product.controller;


import com.example.manager_product.model.Product;
import com.example.manager_product.service.IProdcutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProdcutService iProductService;

    @GetMapping()
    public String display(Model model) {
        model.addAttribute("products",iProductService.getAll());
        return "/list";
    }
    @GetMapping("/create-form")
    public String createForm(Model model) {
        model.addAttribute("product",new Product());
        return "/create";
    }
    @GetMapping("/detail/{id}")
    public String view(@PathVariable int id, Model model) {

        if (iProductService.findById(id)!=null){
            model.addAttribute("products", iProductService.findById(id));
            model.addAttribute("mess", "Found id. ");
            return "/detail";
        }
        else {
            model.addAttribute("mess", "Not found id. ");
            return "redirect:/";
        }

    }
    @PostMapping("/create1")
    public String create(@ModelAttribute Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
       if (bindingResult.hasErrors()){
           redirectAttributes.addFlashAttribute("mess", "Add not successful!");
           return "redirect:/product";
       }else {
           iProductService.save(product);
           redirectAttributes.addFlashAttribute("mess", "Add successful!");
           return "redirect:/product";
       }
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
            return "redirect:/product";
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        iProductService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("mess", "Update successful!");
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (iProductService.findById(id) != null) {
            iProductService.delete(id);
            String message = "delete success";
            redirectAttributes.addFlashAttribute("mess", message);
            return "redirect:/product";
        }
        else {
            String message = "delete not success";
            redirectAttributes.addFlashAttribute("mess", message);
            return "redirect:/product";
        }
    }

    @GetMapping("/search")
    public String listSearch(@RequestParam(value = "nameProduct") String name, Model model) {
        model.addAttribute("products", iProductService.findByName(name));
        return "/list";
    }
}