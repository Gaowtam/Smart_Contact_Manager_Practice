package com.home.Controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.home.entites.User;
import com.home.helpers.Helper;
import com.home.services.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
    
    private Logger logger=LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    // @ModelAttribute/*Shomosto Request er moddhe automatic kaj korbe */
    // public void addLoggedInUserInformation(Model model,Authentication authentication)
    // {
    //     System.out.println("Adding logged in user information to the model");
    //     String username=Helper.getEmailOfLoggedInUser(authentication);

    //     logger.info("User logged in: {}",username);

    //     System.out.println("User profile");

    //     //database thake data ke ana lagtece

    //     User user=userService.getUserByEmail(username);

    //     System.out.println(user.getName());
    //     System.out.println(user.getEmail());

    //     model.addAttribute("loggedInUser", user);

    //     // String name=principal.getName();
    //     // logger.info("User logged in: {}",name);
    // }

    //user add dashboard page
    @RequestMapping("/dashboard")
    public String userDashboard() {
        return "user/dashboard";
    }

    //user add profile page
    @RequestMapping("/profile")
    public String userProfile(Model model,Authentication authentication) {

        

        return "user/profile";
    }
    
    
    //user add contacts page

    //user view contacts

    //user edit contact

    //user delete contact

    //user search contact
}
