/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.special.controller;

import com.weib.special.data.AuthInfo;
import com.weib.special.data.User;
import com.weib.special.repository.UserRepository;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 *
 * @author zhangjingwei
 */
public class IndexControllerTest {
    
    @Test
    public void applicationIndexTest() throws Exception{
        IndexController controller = new IndexController();
        MockMvc mockmvc = standaloneSetup(controller).build();
        
        mockmvc.perform(get("/")).andExpect(view().name("index"));
    }
    
    @Test
    public void processLoginTest() throws Exception{
        AuthInfo authInfo = new AuthInfo("scarecroweib", "19841021");
        User user = new User(1L, 1L, "zhang", "jingwei", "weib", "weib@sohu.com");
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.auth(authInfo)).thenReturn(user);
        
        IndexController controller = new IndexController();
        controller.setUserRepository(userRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        
        mockMvc.perform(post("/").param("account", "scarecroweib").param("password", "19841021")).andExpect(redirectedUrl("/user/1"));
    }
}
