package com.example.form_register.controller;

import com.example.form_register.dto.UserDto;
import com.example.form_register.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RequestMapping("users")
@Controller
public class UserController {
    @GetMapping()
    public String home(Model model){
        model.addAttribute("userDto",new UserDto());
        return "index";
    }
    @PostMapping("/create")
    public String create(@Validated @ModelAttribute UserDto userDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("userDto",userDto);
            return "index";
        }
        else {
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
            model.addAttribute("mess","Thành công tốt đẹp");
            return "result";
        }
    }
}
