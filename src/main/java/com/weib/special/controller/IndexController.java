/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.special.controller;

import com.weib.special.data.AuthInfo;
import com.weib.special.data.User;
import com.weib.special.repository.UserRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author zhangjingwei
 */
@Controller
@RequestMapping("/")
public class IndexController {
    
    private UserRepository userRepository;
    
    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public String applicationIndex(Model model){
        
        model.addAttribute("authInfo", new AuthInfo());
        
        return "index";
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String processLogin(@ModelAttribute @Valid AuthInfo authInfo, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("errors", errors);
            model.addAttribute("authInfo", authInfo);
            return "index";
        }
        
        User user = userRepository.auth(authInfo);
        if(user == null || user.getAuthId() == null){
            model.addAttribute("autherror", "Index.error.Error_Auth_Failed");
            return "index";
        }
        
        return "redirect:/user/" + user.getId();
    }
}
