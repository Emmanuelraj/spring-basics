package com.project.basics.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.util.StringUtils;

import com.project.basics.dto.UserDTO;

public class UserJdbcExtractor implements ResultSetExtractor<UserDTO>
{

	public UserDTO extractData(ResultSet rs) throws SQLException,
			DataAccessException {

		UserDTO user = new UserDTO();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setAddress(rs.getString("address"));
		user.setPassword(rs.getString("password"));
		user.setNewsletter(rs.getBoolean("newsletter"));
		user.setFramework(convertDelimitedStringToList(rs.getString("framework")));
		user.setSex(rs.getString("sex"));
		user.setCountry(rs.getString("country"));
		user.setSkill(convertDelimitedStringToList(rs.getString("skill")));
		user.setDob(rs.getDate("dob"));
		return user;
	}
	
	
	private static List<String> convertDelimitedStringToList(String delimitedString) {

		List<String> result = new ArrayList<String>();

		if (!StringUtils.isEmpty(delimitedString)) {
			result = Arrays.asList(StringUtils.delimitedListToStringArray(delimitedString, ","));
		}
		return result;

	}

	private String convertListToDelimitedString(List<String> list) {

		String result = "";
		if (list != null) {
			result = StringUtils.arrayToCommaDelimitedString(list.toArray());
		}
		return result;

	}
}