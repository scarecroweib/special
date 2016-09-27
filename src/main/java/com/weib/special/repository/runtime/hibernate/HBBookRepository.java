/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.special.repository.runtime.hibernate;

import com.weib.special.data.Book;
import com.weib.special.repository.BookRepository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author WeibHOME
 */
@Repository
public class HBBookRepository implements BookRepository {
    
    private final SessionFactory fb;
    
    @Autowired
    public HBBookRepository(SessionFactory fb){
        this.fb = fb;
    }
    
    private Session getCurrentSession(){
        return this.fb.openSession();
    }

    @Override
    public List<Book> getAllBooks() {
        return (List<Book>) getCurrentSession().createCriteria(Book.class).list();
    }
    
}
