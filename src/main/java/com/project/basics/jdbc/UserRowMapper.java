package com.project.basics.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;

import com.project.basics.dto.UserDTO;

/**
 * 
 * @author Emmanuel 
 *
 * purpose :ResultSetExtractor is an useful interface provided by Spring JDBC, 
 * it accept a resultset as input parameter and returns list 
 * implementation of extracted data from database.
 */

public class UserRowMapper implements  RowMapper<UserDTO>{

	public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
        UserJdbcExtractor jdbcExtractor = new UserJdbcExtractor();
        
        return jdbcExtractor.extractData(rs);
		
	}
	
	
	
	
	
	
}
