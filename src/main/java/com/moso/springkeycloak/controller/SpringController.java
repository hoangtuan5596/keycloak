package com.moso.springkeycloak.controller;

import com.moso.springkeycloak.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path ="/")
    public String index () {
        return "index";
    }

    @GetMapping(path = "/users")
    public String user(Model model){
        System.out.println("Vào đây");
       // model.addAttribute("user", userRepository.detailsUser());
        return "user";
    }

}
