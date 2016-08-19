/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.special.controller;

import com.weib.special.data.User;
import com.weib.special.repository.UserRepository;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 *
 * @author zhangjingwei
 */
public class UserControllerTest {
    
    @Test
    public void profileTest() throws Exception{
        User user = new User(1L, 1L, "zhang", "jingwei", "weib", "weib@sohu.com");
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.findById(1L)).thenReturn(user);
        
        UserController controller = new UserController(userRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        
        mockMvc.perform(get("/user/profile"))
                .andExpect(view().name("user/profile"))
                .andExpect(model().attributeExists("user"))
                .andExpect(model().attribute("user", user));
    }
    
    @Test
    public void userInfoTest() throws Exception{
        User user = new User(1L, 1L, "zhang", "jingwei", "weib", "weib@sohu.com");
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.findById(1L)).thenReturn(user);
        
        UserController controller = new UserController(userRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        
        mockMvc.perform(get("/user/1"))
                .andExpect(view().name("user/profile"))
                .andExpect(model().attributeExists("user"))
                .andExpect(model().attribute("user", user));
    }
    
}
