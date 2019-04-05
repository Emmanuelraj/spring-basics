/**
 * 
 */
package com.project.basics.dao;



import javax.sql.DataSource;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



import com.project.basics.dto.UserDTO;
import com.project.basics.interfaces.UserDao;

/**
 * @author Admin
 *
 */

public class UserDaoImpl implements UserDao{
	
	
	@Autowired
	private DataSource dataSource;
	
    
	//logger
	private final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	

	public void save(UserDTO userform) 
	{
		
		userform.setId(100);
		
		logger.info("save method"+dataSource+userform);
		
		
		java.util.Date utilDate = userform.getDob(); 
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		
		String sql = "INSERT INTO USERS "+"(NAME, EMAIL, ADDRESS, PASSWORD, NEWSLETTER, FRAMEWORK, SEX,  COUNTRY, SKILL, DOB)VALUES(?, ?, ?, ?, ?, ?, ?,  ?, ?, ?)";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	
		
		jdbcTemplate.update(sql, new Object[]{userform.getName(), userform.getEmail(), userform.getPassword(), userform.isNewsletter(), userform.getFramework(), userform.getSex(), userform.getCountry(), userform.getSkill(), userform.getDob()});
		
		
		
	}

}
