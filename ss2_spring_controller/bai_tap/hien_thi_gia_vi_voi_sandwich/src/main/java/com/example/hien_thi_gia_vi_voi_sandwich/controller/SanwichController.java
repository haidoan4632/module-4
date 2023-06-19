package com.example.hien_thi_gia_vi_voi_sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SanwichController {
    @GetMapping("/")
    public String list() {
        return "list";
    }

    @GetMapping("/b")
    public String list(@RequestParam(required = false) String[] name, RedirectAttributes redirectAttributes) {
        String str = "";
        if (name == null) {
            str = "Bạn chưa chọn gia vị";
        } else {
            for (String s : name) {
                str += s + "<br>";
            }
        }
        redirectAttributes.addFlashAttribute("ten", str);
        return "redirect:/";
    }
}
