/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.special.repository.runtime.mock;

import com.weib.special.data.User;
import com.weib.special.repository.UserRepository;
import org.springframework.stereotype.Component;

/**
 *
 * @author zhangjingwei
 */
@Component
public class MockUserRepository implements UserRepository {

    @Override
    public User save(User unsaveUser) {
        User savedUser = new User(1L, 1L, "zhang", "jingwei", "weib", "weib@126.com");
        return savedUser;
    }

    @Override
    public User update(User updateUser) {
        User savedUser = new User(1L, 1L, "zhang", "jingwei", "weib", "weib@126.com");
        return savedUser;
    }

    @Override
    public void delete(User deleteUser) {
        
    }

    @Override
    public User findById(Long id) {
        User savedUser = new User(id, 1L, "zhang", "jingwei", "weib", "weib@126.com");
        return savedUser;
    }
    
}
