package com.pyy;



import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;

@MapperScan("com.pyy.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudMybatisPagehelperApplication {

	public static void main(String[] args) {
//		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
//		messageConverters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
//		messageConverters.add(new AllEncompassingFormHttpMessageConverter());
//		messageConverters.add(new MappingJackson2HttpMessageConverter());
		SpringApplication.run(SpringcloudMybatisPagehelperApplication.class, args);
	}
}
