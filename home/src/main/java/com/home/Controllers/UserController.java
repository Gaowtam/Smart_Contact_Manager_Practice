package com.home.Controllers;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {
    
    private Logger logger=LoggerFactory.getLogger(UserController.class);

    //user add dashboard page
    @RequestMapping("/dashboard")
    public String userDashboard() {
        return "user/dashboard";
    }

    //user add profile page
    @RequestMapping("/profile")
    public String userProfile(Principal principal) {

        String name=principal.getName();
        logger.info("User logged in: {}",name);

        return "user/profile";
    }
    
    
    //user add contacts page

    //user view contacts

    //user edit contact

    //user delete contact

    //user search contact
}
