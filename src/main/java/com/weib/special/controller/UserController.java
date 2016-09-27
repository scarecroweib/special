/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.special.controller;

import com.weib.special.data.Book;
import com.weib.special.data.User;
import com.weib.special.repository.BookRepository;
import com.weib.special.repository.UserRepository;
import java.util.List;
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
    private final BookRepository bookRepository;
    
    @Autowired
    public UserController(UserRepository userRepository, BookRepository bookRepository){
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }
    
    @RequestMapping(value="/profile", method=RequestMethod.GET)
    public String profile(Model model){
        long userid = 1L;
        
        User user = userRepository.findById(userid);
        List<Book> books = bookRepository.getAllBooks();
        
        model.addAttribute(user);
        model.addAttribute(books);
        return "user/profile";
    }
    
    @RequestMapping(value="/{userid}", method=RequestMethod.GET)
    public String userInfo(@PathVariable long userid, Model model){
        User user = userRepository.findById(userid);
        List<Book> books = bookRepository.getAllBooks();
        
        model.addAttribute(user);
        model.addAttribute(books);
        return "user/profile";
    }
}
