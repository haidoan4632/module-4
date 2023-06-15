package com.example.dictionary.controller;

import com.example.dictionary.service.ITranslateService;
import com.example.dictionary.service.impl.TranslateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TranslateController {
    private ITranslateService service = new TranslateService();

    @GetMapping("/translate")
    public String calculate() {
        return "translate";
    }

    @PostMapping("/translate")
    public String calculate(@RequestParam(name = "english") String wordEnglish, Model model) {
        String result = service.translate(wordEnglish);
        model.addAttribute("english", wordEnglish);
        model.addAttribute("result", result);
        return "translate";
    }
}