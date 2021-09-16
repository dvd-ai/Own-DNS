package com.onlinestore.owndns.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountContoller {

    @GetMapping("/id{Userid}")
    public String account(@PathVariable(name = "Userid") Long id, Model model){
        return "account";
    }
}
