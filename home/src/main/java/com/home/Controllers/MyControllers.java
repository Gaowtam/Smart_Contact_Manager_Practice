package com.home.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.entites.User;
import com.home.forms.UserForm;
import com.home.helpers.Message;
import com.home.helpers.MessageType;
import com.home.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class MyControllers {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index()
    {
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String home(Model model)
    {
        model.addAttribute("name","Welcome To The Home Page.");
        model.addAttribute("youtubeChannel","Learn Code With Durgesh");
        model.addAttribute("githubRepo", "https://www.youtube.com/watch?v=SAqi7zmW1fY");
        return "home";
    }


    //about page
    @RequestMapping("/about")
    public String aboutPage(Model model)
    {
        model.addAttribute("isLogin", false);
        return "about";
    }

    //services
    @RequestMapping("/services")
    public String servicesPage()
    {
        return "services";
    }

    //contact
   @GetMapping("/contact")
   public String contactPage() {
       return "contact";
   }

    //login
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }


    // //login for redirect when login info is wrong
    // @PostMapping("/login")
    // public String loginPage() {
    //     return "login";
    // }


    //signup
    @GetMapping("/register")
    public String registerPage(Model model) {

        UserForm userForm=new UserForm();

        //default set data
        // userForm.setName("Gaowtam");
        // userForm.setAbout("Thies is about :Write something about yourself");

        model.addAttribute("userForm", userForm);

        return "register";
    }

    //  Procesing register
      @RequestMapping(value = "/do-register",method = RequestMethod.POST)
      public String processRegister(@Valid @ModelAttribute UserForm userForm,BindingResult rBindingResult, HttpSession session)
      {
        
        if(rBindingResult.hasErrors())
        {
            return "register";
        }

        User user=new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("https://www.facebook.com/photo/?fbid=3835683316679175&set=a.1385021651745366");
        

        userService.saveUser(user);
        System.out.println("user saved  : ");

        //message="Registration Succecssfull"

        //add the message;
        // Message m=Message.builder().content("Registration Successfull").type(MessageType.green).build();
        Message m=Message.builder().content("Registration Successfull").type(MessageType.green).build();
        session.setAttribute("message",m); 
        // session.setAttribute("message","Higg"); 

        //redirect to login page;
        return "redirect:/register";
      }
}
