package com.example.electronic_mailbox.controller;

import com.example.electronic_mailbox.model.Program;
import com.example.electronic_mailbox.service.IProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class ProgramController {
    @Autowired
    private IProgramService iProgramService;

    @GetMapping("hello-servlet")
    public String display(Model model) {
        model.addAttribute("program", iProgramService.getProgram());
        return "list";
    }
    @GetMapping("update-form")
    public String getFormUpdate(Model model) {
        model.addAttribute("program", iProgramService.getProgram());
        return "update";
    }

    @PostMapping("program")
    public String updateProgram(@ModelAttribute Program program, RedirectAttributes redirectAttributes) {
        iProgramService.update(program);
        redirectAttributes.addFlashAttribute("mess", "Cập nhật thành công!");
        return "redirect:hello-servlet";
    }
}