/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.special.data;

import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author zhangjingwei
 */
public class User {
    private Long id;
    private Long authId;
    
    @NotNull(message="{firstName.null}")
    @Size(min=3, max=20, message="{firstName.size}")
    private String firstName;
    
    @NotNull(message="{lastName.null}")
    @Size(min=5, max=20, message="{lastName.size}")
    private String lastName;
    
    @NotNull(message="{nickname.null}")
    @Size(min=1, max=15, message="{nickname.size}")
    private String nickname;
    
    @NotEmpty(message="{email.empty}")
    @Email(message="email.format")
    private String email;
    
    public User(){}
    
    public User(Long id, Long authId, String firstName, String lastName, String username, String email){
        this.id = id;
        this.authId = authId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = username;
        this.email = email;
    }
    
    public User(String firstName, String lastName, String username, String email){
        this(null, null, firstName, lastName, username, email);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthId() {
        return authId;
    }

    public void setAuthId(Long authId) {
        this.authId = authId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.authId);
        hash = 41 * hash + Objects.hashCode(this.firstName);
        hash = 41 * hash + Objects.hashCode(this.lastName);
        hash = 41 * hash + Objects.hashCode(this.nickname);
        hash = 41 * hash + Objects.hashCode(this.email);
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
        final User other = (User) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.nickname, other.nickname)) {
            return false;
        }
        return Objects.equals(this.email, other.email);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + nickname + ", email=" + email + '}';
    }
    
}
