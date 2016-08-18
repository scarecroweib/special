/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.special.controller;

import com.weib.special.data.User;
import com.weib.special.repository.UserRepository;
import org.junit.Test;

import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 *
 * @author zhangjingwei
 */
public class RegisterControllerTest {
    
    @Test
    public void showRegisterFormTest() throws Exception{
        UserRepository repository = mock(UserRepository.class);
        RegisterController controller = new RegisterController(repository); 
        MockMvc mockMvc = standaloneSetup(controller).build();
        
        mockMvc.perform(get("/register"))
                .andExpect(view().name("register/form"));
    }
    
    @Test
    public void processRegisterTest() throws Exception{
        User unsaveUser = new User("zhang", "jingwei", "weib", "weib@sohu.com");
        User savedUser = new User(1L, 1L, "zhang", "jingwei", "weib", "weib@sohu.com");
        UserRepository repository = mock(UserRepository.class);
        when(repository.save(unsaveUser)).thenReturn(savedUser);
        
        RegisterController controller = new RegisterController(repository); 
        MockMvc mockMvc = standaloneSetup(controller).build();
        
        mockMvc.perform(post("/register")
                .param("firstName", "zhang")
                .param("lastName", "jingwei")
                .param("nickname", "weib")
                .param("email", "weib@sohu.com")
                ).andExpect(MockMvcResultMatchers.redirectedUrl("/user/1"));
    }
    
}
