package com.project.basics.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 
 * @author Emmanuel Raj
 * 
 */
@Configuration
//Load to Environment.
//@PropertySources({ @PropertySource("classpath:ds/datasource-cfg.properties") })

public class SpringDBConfig 
{
	
	//init Logger
	private Logger logger = LoggerFactory.getLogger(SpringDBConfig.class);
	
	
	/**
	 * DataSource datSource
	 */
	@Autowired
	DataSource dataSource;
	
	/**
	 * 
	 * @return DataSource Config
	 */
	
	@Bean(name="dataSource")
	public DataSource dataSource() 
	{
		logger.info("dataSource bean");
	
		
	   DriverManagerDataSource dataSource = new DriverManagerDataSource();
	   
	// See: datasouce-cfg.properties
       dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
       dataSource.setUrl("jdbc:hsqldb:hsql://localhost/");
       dataSource.setUsername("SA");
       dataSource.setPassword("");
 
       logger.info("## getDataSource: " + dataSource);
 
       return dataSource;
	}

}
