package com.home.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class UserController {

    //user add dashboard page
    @RequestMapping("/dashboard")
    public String userDashboard() {
        return "user/dashboard";
    }

    //user add profile page
    @RequestMapping("/profile")
    public String userProfile() {
        return "user/profile";
    }
    
    
    //user add contacts page

    //user view contacts

    //user edit contact

    //user delete contact

    //user search contact
}
