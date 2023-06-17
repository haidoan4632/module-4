package com.example.calculate.controller.controller;

import com.example.calculate.controller.service.IConvertMoneyService;
import com.example.calculate.controller.service.impl.ConvertMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
@Autowired
    private IConvertMoneyService convertMoneyService;

    @GetMapping()
    public String calculate() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam(name = "money") float money, Model model) {
        float result = convertMoneyService.changeMoney(money);
        model.addAttribute("result", result);
        return "index";
    }
}
