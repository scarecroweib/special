/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.special.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.weib.special.repository.UserRepository;
import com.weib.special.repository.runtime.db.DBUserRepository;
import java.beans.PropertyVetoException;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author zhangjingwei
 */
@Configuration
@ComponentScan(basePackages={"com.weib.special"},
        excludeFilters={
            @Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)
        })
public class RootConfig {
    
    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        ms.setBasename("message");
        return ms;
    }
    
//    @Bean
//    /**
//     * 定义JDBC数据源
//     * DriverManagerDataSource:每次访问创建一个新的连接
//     * SimpleDriverDataSource:与DriverManagerDataSource相似，直接使用JDBC驱动
//     * SingleConnectionDataSource:只有一个连接的连接池
//     * 
//     * 另外还可以使用
//     * 1.JNDI数据源（定义在server.xml中的JNDI）
//     * 2.第三方连接池
//     */
//    public DataSource datesource(){
//        DriverManagerDataSource datasource = new DriverManagerDataSource();
//        datasource.setDriverClassName("org.gjt.mm.mysql.Driver");
//        datasource.setUrl("jdbc:mysql://localhost:3306/special_db");
//        datasource.setUsername("root");
//        datasource.setPassword("");
//        return datasource; 
//    }
//    
    
    @Bean
    /**
     * 使用第三方连接池c3p0
     */
    public DataSource datasource() throws PropertyVetoException{
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass("com.mysql.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/special_db");
        ds.setUser("root");
        ds.setPassword("");
        
        ds.setInitialPoolSize(10);
        ds.setMaxPoolSize(50);
        ds.setMinPoolSize(1);
        
        return ds;
    }
    
    @Bean
    /**
     * 创建一个适用于Hibernate5的SessionFactory
     * 注入DataSource
     */
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource){
        LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
        sf.setDataSource(dataSource);
        sf.setPackagesToScan(new String[] {"com.weib.special.data"});
        Properties p = new Properties();
        p.setProperty("dialect", "org.hibernate.dialect.MySQL5Dialect");
        sf.setHibernateProperties(p);
        return sf;
    }
    
    @Bean
    /**
     * 创建异常转换功能，会自动给所有@Repository的类加一个通知器（advisor）
     */
    public BeanPostProcessor persistenceTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
    
    @Bean
    /**
     * 定义模板(将数据源注入到模板，再将模板注入到Repository)
     * JdbcOperations为JdbcTemplate的接口
     */
    public JdbcOperations jdbcTemplate(DataSource datasource){
        return new JdbcTemplate(datasource);
    }
    
    @Bean
    /**
     * 定义模板（将值以命令参数绑定的形式）
     */
    public NamedParameterJdbcTemplate namedParamTemplate(DataSource datasource){
        return new NamedParameterJdbcTemplate(datasource);
    }
    
//    @Bean 
//    /**
//     * 定义Hibernate的sessionfactory
//     */
//    public AnnotationSessionFactoryBean sessionFactory(DataSource datasource){
//        AnnotationSessionFactoryBean sf = new AnnotationSessionFactoryBean();
//        sf.setDataSource(datasource);
//        sf.setAnnotatedPackages(new String[]{ "com.weib.special.data" });
//        Properties props = new Properties();
//        props.setProperty("dialect", "org.hibernate.dialect.MySQL5Dialect"); //配置方言
//        sf.setHibernateProperties(props);
//        return sf;
//    }
    
    
//    @Bean
//    public UserRepository userRepository(JdbcOperations jdbcTemplate){
//        return new DBUserRepository(jdbcTemplate);
//    }
}
