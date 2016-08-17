/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.special.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
}
