/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.special.controller;

import com.weib.special.data.User;
import com.weib.special.repository.UserRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author zhangjingwei
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    
    private final UserRepository userRepository;
    
    @Autowired
    public RegisterController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public String showRegisterForm(){
        return "register/form";
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String processRegister(@Valid User user, 
            Errors errors, Model model){
        
        if(errors.hasErrors()){
            return "register/form";
        }
        
        User savedUser = userRepository.save(user);
        
        return "redirect:/user/" + savedUser.getId();
    }
    
}
