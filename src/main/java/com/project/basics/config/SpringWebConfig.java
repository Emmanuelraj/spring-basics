package com.project.basics.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


/**
 * 
 * @author Emmanuel Raj
 * 
 *  mixing spring xml +javaconfig
 */



@EnableWebMvc
@Configuration
@ComponentScan({ "com.project.basics.controller","com.project.basics.exception", "com.project.basics.validator",   "com.project.basics.jdbc"})

//load dataSource properties
//Load to Environment.
//@PropertySources({ @PropertySource("classpath:ds/datasource-cfg.properties") })

public class SpringWebConfig extends WebMvcConfigurerAdapter{

	
	
	private  final Logger logger = LoggerFactory.getLogger(SpringWebConfig.class); 
	
	//config resources also
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	
	/**
	 * 
	 * @return
	 * in xml equivalent to viewResolver
	 */
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	
	
	/**
	 * return
	 * in  xml equivalent to messageResource
	 * configuring properties file
	 */
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource rb = new ReloadableResourceBundleMessageSource();
		rb.setBasenames(new String[] { "/WEB-INF/messages_en" ,"/WEB-INF/validation_en","resource/application"});
		return rb;
	}
	


}
