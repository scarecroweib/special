/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.special.data;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;



/**
 *
 * @author WeibHOME
 */
@Entity(name="books")
public class Book implements Serializable {
    @Id
    private Long id;
    
    private Long userid;
    
    private String name;

    public Book() {
    }
    
    public Book(Long id, Long userid, String name){
        this.id = id;
        this.userid = userid;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
