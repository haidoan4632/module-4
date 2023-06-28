package com.example.book_application.configs;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class MainExceptionHandler extends Throwable {
    @ExceptionHandler(Exception.class)
    public String get500Page(Exception ex, Model model){
        model.addAttribute("errorMsg",ex.getMessage());
        return "/500";
    }
}
