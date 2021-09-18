package com.onlinestore.owndns.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {


    @GetMapping("/id{Userid}")
    public @ResponseBody ResponseEntity<?> account(@PathVariable(name = "Userid") Long id, Model model){
        return new ResponseEntity(HttpStatus.OK);//accountService.getUserById;
    }
}
