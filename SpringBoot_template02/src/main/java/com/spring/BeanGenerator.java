package com.spring;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.bean.VersionBean;
import com.google.gson.Gson;
import com.util.Util;

@Configuration
@EnableMBeanExport(defaultDomain="${projectName}")
public class BeanGenerator {
	
	/**
	 * gson instance
	 * @return
	 */
	@Bean
	public Gson gson(){
		return new Gson();
	}
	
	/**
	 * insert this bean into Util constructor, and write current version number into file
	 * @return
	 */
	@Bean(name="VersionBean")
	public VersionBean versionBean(){
		return new VersionBean();
	}
	
	/**
	 * to retrieve beans created in Spring and cope with bean initiation order problem
	 * @return
	 */
	@Bean(name="SpringContextHolder")
	public SpringContextHolder springContextHolder() {
	   return new SpringContextHolder();
	}
	
	
	/**
	 * StartListener called when this application is started
	 * It depends on another bean, SpringContextHolder, to funciton normally
	 * @return
	 */
	@Bean
	@DependsOn("SpringContextHolder")
	public StartListener startListener() {
	   return new StartListener();
	}	
	
}
