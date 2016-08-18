/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.special.controller;

import com.weib.special.data.AuthInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author zhangjingwei
 */
@Controller
@RequestMapping("/")
public class IndexController {
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String applicationIndex(Model model){
        
        model.addAttribute("authInfo", new AuthInfo());
        
        return "index";
    }
    
}
