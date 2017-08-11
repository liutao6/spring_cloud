package com.liutao.sys;

import com.liutao.common.interceptor.MessageAspect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringCloudApplication
@MapperScan(basePackages = {"com.liutao.sys.dao.mapper"})
public class HbSysApplication {


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
		SpringApplication.run(HbSysApplication.class, args);
	}
}
