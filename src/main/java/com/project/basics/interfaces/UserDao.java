package com.project.basics.interfaces;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.project.basics.dto.UserDTO;

public interface UserDao 
{
	
	void save(UserDTO userform);

}
