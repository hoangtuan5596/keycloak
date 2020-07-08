package com.moso.springkeycloak.controller;

import com.moso.springkeycloak.model.User;
import com.moso.springkeycloak.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class SpringController {
    Logger logger = LoggerFactory.getLogger(SpringController.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/")
    public String index() {
        return "index";
    }

    /*
    * Get list details user before login success.
    */
    @GetMapping(path = "/users")
    public String user(Principal principal, Model model) {
        logger.info("USER");
        Iterable<User> users = userRepository.detailsUser();
        model.addAttribute("users", users);
        model.addAttribute("usersName", principal.getName());
        logger.info("USER" + users);
        return "user";
    }

}
