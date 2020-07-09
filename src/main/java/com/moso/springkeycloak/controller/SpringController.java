package com.moso.springkeycloak.controller;

import com.moso.springkeycloak.model.Users;
import com.moso.springkeycloak.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class SpringController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    /***
     * Get list details user before login success.
     */
    @RequestMapping("/users")
    public String user(Principal principal, Model model) {

        Iterable<Users> users = userRepository.findUserByUsername(principal.getName());
        model.addAttribute("users", users);
        model.addAttribute("userLogin", principal.getName());
        return "users";
    }

    /***
     * Register new user
     */
    @RequestMapping("/registration")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerAccount(@ModelAttribute("users") @Valid Users users, BindingResult result) {
        Users checkExists = userRepository.findByUsername((users.getUsername()));
        if (checkExists != null) {
            result.rejectValue("username", "This is already an account registered with that username ");
        }
        if (result.hasErrors()) {
            return "register";
        }
        userRepository.save(users);
        return "redirect://register";
    }
}
