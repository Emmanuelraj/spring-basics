package com.project.basics.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.basics.dto.UserDTO;
import com.project.basics.interfaces.UserService;
import com.project.basics.validator.UserValidator;

@Controller
public class UserController 
{
	
	
	//logger
	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	
	
	
	
	//validator autowired
	@Autowired
	private UserValidator userValidator;
	
	
	
	
	//service class
	@Autowired
	 UserService userService;
	
	/**
	 * 
	 * @param userdto
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public ModelAndView formBackingObject(@ModelAttribute("userForm")UserDTO userdto , BindingResult bindingResult, Model model)
	{
		ModelAndView formView = new ModelAndView("userForm");
		
	    UserDTO dto = new UserDTO();
		
	
		return formView;
		
	}
	
	
	
	
	/**
	 * @param model
	 * prePopulated values 
	 */
	
	@ModelAttribute
	private  void commonObjectMethod(Model model)
	{
			logger.info("commonObjectMethod");
			
			List<String> frameworksList = new ArrayList<String>();
			frameworksList.add("Spring MVC");
			frameworksList.add("Struts 2");
			frameworksList.add("JSF 2");
			frameworksList.add("GWT");
			frameworksList.add("Play");
			frameworksList.add("Apache Wicket");
			
			//create object
		   model.addAttribute("frameworkList", frameworksList);	
	 
		   Map<String, String> country = new LinkedHashMap<String, String>();
			country.put("US", "United Stated");
			country.put("CN", "China");
			country.put("SG", "Singapore");
			country.put("MY", "Malaysia");
		  model.addAttribute("countryList", country);
		
		  Map<String, String> skill = new LinkedHashMap<String, String>();
			skill.put("Hibernate", "Hibernate");
			skill.put("Spring", "Spring");
			skill.put("Struts", "Struts");
			skill.put("Groovy", "Groovy");
			skill.put("Grails", "Grails");
			model.addAttribute("javaSkillList", skill);
	}
	
	
	/**
	 * initBinder method
	 * custom date editors of userform.dob
	 */
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		logger.info("initBinder Method");
		
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd**MM**yyyy");
		binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(sdf, false));
		//register validator
	 	binder.setValidator(userValidator);
		
		
	}
	
	
	
	/**
	 * onSubmit method
	 * Remember : Before submitting the form send validator
	 */
	 @RequestMapping(value="/userFormSubmit", method=RequestMethod.POST)
	 public String onSubmit(@Validated @ModelAttribute("userForm")UserDTO userform ,BindingResult bindingResult,HttpServletRequest request,HttpServletResponse response ,Model model)throws Exception
	  {
		 logger.info("onSubmit method");
		 
		 ModelAndView successView = null;
		 
		 if(bindingResult.hasErrors())
			 {
				 logger.error("bindingResult errors");
				 return "userForm"; //500 internal server error
			 }
		 else
			 {
				 logger.info("no bindingResult");
				 //save into db
				 userService.save(userform);
				 //fetch that particular id
				 return "redirect:/userForm/"+userform.getId();
			 }
	  }
	
	 
	 @RequestMapping(value="/userForm/${id}", method=RequestMethod.GET)
	 public String showUserFormById(@PathVariable("id") int id, Model model)
	 {
		 
		 logger.info("showUserFormById"+id);
		 
		 
		 //fetch it from DB
		 
		 
		 
		 return "";
		 
	 }
	 
	 
	 
	 
	
	
}
