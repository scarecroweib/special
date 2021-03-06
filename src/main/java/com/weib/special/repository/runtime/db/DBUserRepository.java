/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.special.repository.runtime.db;

import com.weib.special.data.AuthInfo;
import com.weib.special.data.User;
import com.weib.special.repository.UserRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

/**
 *
 * @author WeibHOME
 */
@Repository
@Profile("db")
public class DBUserRepository implements UserRepository {

    private final JdbcOperations jdbcOperater;
    
    @Autowired
    public DBUserRepository(JdbcOperations jdbcOperation){
        jdbcOperater = jdbcOperation;
    }
    
    @Override
    public User save(User unsaveUser) {
        jdbcOperater.execute("begin");
        try{
            String insertAuthinfo = "insert into authinfo values(0, ?, ?)";
            jdbcOperater.update(insertAuthinfo, unsaveUser.getAccount(), unsaveUser.getPassword());

            AuthInfo savedAuth = jdbcOperater.queryForObject("select * from authinfo order by id desc limit 1", this::mapAuthInfo);
            String insertUserinfo = "insert into userinfo values(0, ?, ?, ?, ?, ?)";
            jdbcOperater.update(insertUserinfo, savedAuth.getId(), unsaveUser.getFirstName(), unsaveUser.getLastName(), unsaveUser.getNickname(), unsaveUser.getEmail());

            jdbcOperater.execute("commit");

            User savedUser = jdbcOperater.queryForObject("select * from userinfo order by id desc limit 1", this::mapUserInfo);
            return savedUser;
        }catch(Throwable e){
            jdbcOperater.execute("rollback");
            throw e;
        }
    }

    @Override
    public User update(User updateUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(User deleteUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User findById(Long id) {
         User savedUser = new User(1L, 1L, "zhang", "jingwei", "weib", "weib@126.com");
         return savedUser;
    }

    @Override
    public User auth(AuthInfo authInfo) {
        String authSQL = "select * from authinfo where account = ? and password = ?";
        AuthInfo selectAuthInfo = jdbcOperater.queryForObject(authSQL, this::mapAuthInfo, authInfo.getAccount(), authInfo.getPassword());
        
        if(selectAuthInfo == null){
            return null;
        }else{
            User savedUser = new User(1L, 1L, "zhang", "jingwei", "weib", "weib@126.com");
            return savedUser;
        }
    }
    
    private AuthInfo mapAuthInfo(ResultSet rs, int row) throws SQLException{
        return new AuthInfo(rs.getLong("id"), rs.getString("account"), rs.getString("password"));
    }
    
    private User mapUserInfo(ResultSet rs, int row) throws SQLException{
        return new User(rs.getLong("id"), rs.getLong("authid"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("nickname"), rs.getString("email"));
    }
    
}
