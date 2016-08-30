/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.special.configuration;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 对应web.xml的设置
 * @author zhangjingwei
 */
public class SpecialWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 对应web.xml中的通用Bean配置 ContextLoaderListener
     * @return 
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ RootConfig.class };
    }

    /**
     * 对应web.xml中的DispatcherServlet配置
     * @return 
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{ WebConfig.class };
    }

    /**
     * 对应web.xml中的servlet-mapping
     * @return 
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    
    /**
     * 对应web.xml中DispatcherServlet的自定义配置
     * @param registration 
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setLoadOnStartup(1);
        registration.setMultipartConfig(new MultipartConfigElement("F:\\var\\tmp"));
    }
    
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{};
    }
    
    
    
}
