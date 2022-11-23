package com.app.code;

import org.hibernate.Hibernate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
@Validated
@SessionAttributes(value = {"globalUser","infoUser"})
public class ControllerConfig {
    AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(appContext.class);

    @ModelAttribute("globalUser")
    public User globalUser(){
        User user = config.getBean("user",User.class);
        user.setCustomer(config.getBean("customer", Customer.class));
        return user;
    }

    @RequestMapping("/")
    public String showMainPage(){
        return "home";
    }

    @RequestMapping("/home")
    public String showMainPage2(){

        return "home";
    }

    @RequestMapping("/login")
    public String showLoginPage(@ModelAttribute("globalUser")User user,Model model, HttpServletRequest httpServletRequest){
        model.addAttribute("userTest",user);
        return "login";
    }

    @RequestMapping("/register")
    public String showRegisterPage(Model model){
        UserRegistration user = config.getBean("userRegistration",UserRegistration.class);

        model.addAttribute("registerTest",user);
        return "register";
    }

    @RequestMapping("/aboutUs")
    public String showAboutUsPage(){
        return "about";
    }

    @RequestMapping(value="/order",method = RequestMethod.GET)
    public ModelAndView showOrderPage(Model model){
        return new ModelAndView("order","products",HibernateClass.getAllProducts());
    }
    @RequestMapping("/profile")
    public String showProfile(@ModelAttribute("globalUser")User user,Model model){
        user.setCustomer(HibernateClass.getCustomerDetail(user));
        UserRegistration userRegistration = new UserRegistration();
        userRegistration.copy(user,user.getCustomer());
        model.addAttribute("infoUser",userRegistration);
        return "profile";
    }


    @RequestMapping("/aboutUsLogged")
    public String showAboutUsPageLogged(){
        return "aboutLogged";
    }

    @RequestMapping("/orderLogged")
    public String showOrderPageLogged(){
        return "orderLogged";
    }

    @RequestMapping("/homeLogged")
    public String mainPageLogged(@ModelAttribute("globalUser")User user,Model model){
        model.addAttribute("userLogged",user);
        return "homeLogged";
    }

    @RequestMapping(value="/loginCheck",method= RequestMethod.POST)
    public ModelAndView showLogged(@Valid @ModelAttribute("userTest")
    User user,@ModelAttribute("globalUser") User globalUser, BindingResult bindingResult, ModelAndView modelAndView, Model model){
        if(bindingResult.hasErrors() || !HibernateClass.searchUser(user)){
            user.setPassword("");
            return new ModelAndView("login","invalid","Invalid username or/and password");
        }
        else {
            globalUser.setPassword(user.getPassword());
            globalUser.setUsername(user.getUsername());
            model.addAttribute("User",globalUser);
            return new ModelAndView("homeLogged");
        }
    }
    @RequestMapping(value = "/registeredCheck", method = RequestMethod.GET)
    public ModelAndView showRegistered(@Valid @ModelAttribute("registerTest")UserRegistration user,@ModelAttribute("globalUser")User globalUser, BindingResult bindingResult, Model model){
        System.out.println(user);
        if(bindingResult.hasErrors()){
            return new ModelAndView("register");
        }
        else if(!user.checkPassword()){
            return new ModelAndView("register","pass","The passwords doesn't match");
        }
        else if(HibernateClass.verifyUsernameExist(user)){
            return new ModelAndView("register","busy","This username is taken.");
        }
        else{
            UserRegistration.createUser(user);
            globalUser.setPassword(user.getPassword1());
            globalUser.setUsername(user.getUsername());
            return new ModelAndView("registered");
        }
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(){
        return "home";
    }

    @RequestMapping(value="updateProfile",method = RequestMethod.POST)
    public ModelAndView updateProfile(@ModelAttribute("infoUser")UserRegistration infoUser,@ModelAttribute("globalUser")User globalUser,Model model){

        if(!HibernateClass.updateProfile(infoUser))
        {
            return new ModelAndView("profile", "error", "You have some mistakes in your profile.");
        }
        else{
            model.addAttribute("infoUser", infoUser);
            return new ModelAndView("profile");
        }
    }
}
