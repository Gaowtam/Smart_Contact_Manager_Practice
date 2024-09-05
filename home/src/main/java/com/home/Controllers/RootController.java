package com.home.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.home.entites.User;
import com.home.helpers.Helper;
import com.home.services.UserService;

@ControllerAdvice /*Shomosto Request er moddhe automatic kaj korbe */
public class RootController {

    private Logger logger=LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;


    @ModelAttribute/*Shomosto Request er moddhe automatic kaj korbe */
    public void addLoggedInUserInformation(Model model,Authentication authentication)
    {
        if(authentication==null)
        {
            return;
        }
        System.out.println("Adding logged in user information to the model");
        String username=Helper.getEmailOfLoggedInUser(authentication);

        logger.info("User logged in: {}",username);

        System.out.println("User profile");

        //database thake data ke ana lagtece

        User user=userService.getUserByEmail(username);
        
        // if (user == null) {
        //     model.addAttribute("loggedInUser", null);
        // } else {
        //     System.out.println(user.getName());
        //     System.out.println(user.getEmail());

        //     model.addAttribute("loggedInUser", user);
        // }

        System.out.println(user);
        System.out.println(user.getName());
        System.out.println(user.getEmail());

        model.addAttribute("loggedInUser", user);

        // String name=principal.getName();
        // logger.info("User logged in: {}",name);
    }
}
