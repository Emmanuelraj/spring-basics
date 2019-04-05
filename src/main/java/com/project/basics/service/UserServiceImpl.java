package com.project.basics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.basics.dto.UserDTO;
import com.project.basics.interfaces.UserDao;
import com.project.basics.interfaces.UserService;

/**
 * 
 * @author Emmanuel Raj
 * This class holds business Logic and send into dao Layer
 * 
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	 UserDao userDao;
	
	
	public void save(UserDTO userform) 
	{
	 
	   this.userDao.save(userform);	
	}

}
