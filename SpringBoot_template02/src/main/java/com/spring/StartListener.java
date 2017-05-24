package com.spring;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



import org.json.JSONArray;
import org.springframework.context.ApplicationContext;

import com.util.Util;

//@WebListener
//@Component
//@PropertySource("classpath:application.properties")
//@ConfigurationProperties
public class StartListener implements ServletContextListener {
	
    @Override
    public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		Util.getFileLogger().info("contextInitialized Start###################");

		ApplicationContext applicationContext = SpringContextHolder.getApplicationContext();
		if (applicationContext == null) {
			Util.getFileLogger().info("appContext is "
					+ applicationContext);
		} else {
			Util.getFileLogger().info(("SpringContextHolder is " + applicationContext));
		}
		
		Util.getFileLogger().info("contextInitialized End###################");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
