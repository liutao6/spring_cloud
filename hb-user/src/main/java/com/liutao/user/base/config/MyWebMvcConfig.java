//package com.liutao.user.base.config;
//
//import com.liutao.user.base.properties.SpringCloudProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import javax.annotation.Resource;
//
///**
// * Created by tao on 2017/2/13.
// */
//@Configuration
//public class MyWebMvcConfig extends WebMvcConfigurerAdapter {
//
//    @Resource
//    private SpringCloudProperties springCloudProperties;
//
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        if(springCloudProperties.getSwaggerOpen()){
//            registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//            registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//        }
//        super.addResourceHandlers(registry);
//    }
//}
