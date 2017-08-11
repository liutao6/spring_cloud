package com.liutao.user;

import com.liutao.common.interceptor.MessageAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class UserApplication extends WebMvcConfigurerAdapter {


	@Bean
	public ResourceBundleMessageSource messageSource(){
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("i18n.message");
		return source;
	}

	@Bean
	public MessageAspect messageAspect(){
		return new MessageAspect();
	}


	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
}
