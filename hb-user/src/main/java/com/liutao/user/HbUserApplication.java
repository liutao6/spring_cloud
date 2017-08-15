package com.liutao.user;

import com.liutao.common.interceptor.MessageAspect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringCloudApplication
@EnableFeignClients(basePackages = {"com.liutao.user.feign"})
@MapperScan(basePackages = {"com.liutao.user.dao.mapper"})
public class HbUserApplication{


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
		SpringApplication.run(HbUserApplication.class, args);
	}
}
