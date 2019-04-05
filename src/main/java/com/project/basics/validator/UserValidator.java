package com.project.basics.validator;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.project.basics.dto.UserDTO;
/**
 * 
 * @author Emmanuel Raj
 * Purpose : validate the fields of UserDTO
 *
 */
@Component
public class UserValidator implements Validator {

	
	


	
	//init logger
	private  final Logger logger = LoggerFactory.getLogger(UserValidator.class);
	
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserDTO.class.equals(clazz);
	}

	public void validate(Object obj, Errors err) 
	{
		logger.info("validate method");
		
		UserDTO dto = (UserDTO)obj;
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "name", "NotEmpty.userForm.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "email", "NotEmpty.userForm.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "address", "NotEmpty.userForm.address");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "password", "NotEmpty.userForm.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "confirmPassword","NotEmpty.userForm.confirmPassword");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "sex", "NotEmpty.userForm.sex");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "country", "NotEmpty.userForm.country");
		//ValidationUtils.rejectIfEmptyOrWhitespace(err, "dob", "NotEmpty.userForm.dob"); 
		
		
		
		
		
		if(dto.getCountry().equalsIgnoreCase("none")){
			err.rejectValue("country", "NotEmpty.userForm.country");
		}
		
		if (!dto.getPassword().equals(dto.getConfirmPassword())) {
			err.rejectValue("confirmPassword", "Diff.userform.confirmPassword");
		}
		
		if (dto.getFramework() == null || dto.getFramework().size() < 2) {
			err.rejectValue("framework", "Valid.userForm.framework");
		}

		if (dto.getSkill() == null || dto.getSkill().size() < 3) {
			err.rejectValue("skill", "Valid.userForm.skill");
		}
		
		
	     	
	}

}
