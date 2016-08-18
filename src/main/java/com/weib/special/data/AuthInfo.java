/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.special.data;

import java.util.Objects;

/**
 *
 * @author zhangjingwei
 */
public class AuthInfo {
    private Long id;
    private Long userId;
    private String password;
    
    public AuthInfo(){}
    
    public AuthInfo(Long id, Long userId, String password){
        this.id = id;
        this.userId = userId;
        this.password = password;
    }
    
    public AuthInfo(Long userId, String password){
        this(null, userId, password);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.userId);
        hash = 97 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AuthInfo other = (AuthInfo) obj;
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return Objects.equals(this.userId, other.userId);
    }
    
    
}
