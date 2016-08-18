/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.special.controller;

import com.weib.special.data.User;
import com.weib.special.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author zhangjingwei
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;
    
    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    @RequestMapping(value="/{userid}", method=RequestMethod.GET)
    public String profile(@PathVariable long userid, Model model){
        User user = userRepository.findById(userid);
        model.addAttribute(user);
        return "user/profile";
    }
}
