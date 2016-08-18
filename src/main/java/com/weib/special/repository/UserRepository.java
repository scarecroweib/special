/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.special.repository;

import com.weib.special.data.User;

/**
 *
 * @author zhangjingwei
 */
public interface UserRepository {
    User save(User unsaveUser);
    
    User update(User updateUser);
    
    void delete(User deleteUser);
    
    User findById(Long id);
}
