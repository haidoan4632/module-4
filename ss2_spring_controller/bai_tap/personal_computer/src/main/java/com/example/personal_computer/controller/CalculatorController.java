package com.example.personal_computer.controller;

import com.example.personal_computer.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CalculatorController {

    @Autowired
    ICalculatorService calculatorService;

    @GetMapping("/a")
    public String calculator() {
        return "calculator";
    }

    @GetMapping("/b")
    public String calculator(@RequestParam(name = "number1", required = false) Double number1, @RequestParam(name = "number2", required = false) Double number2,
                             @RequestParam(name = "operation",required = false) String operation, RedirectAttributes redirectAttributes) {

        if (number1!=null && number2!=null&& operation!=null){
            String result = calculatorService.calculate(number1, number2,operation);
            redirectAttributes.addFlashAttribute("result", result);
            return "redirect:/a";
        }
        else {
            return "redirect:/a";
        }

    }


}
