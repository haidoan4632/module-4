package com.example.book_application.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class QuantityCheck {
    @AfterThrowing(value = "execution(* com.example.book_application.controller.BookController.*Book(..))")
    public void quantityCheck() {
        System.out.println("da xay ra loi");
    }

}