/**
 * 
 */
package com.project.basics.interfaces;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.basics.dto.UserDTO;

/**
 * @author Admin
 *
 */


public interface UserService {

	void save(UserDTO userform);

}
