package com.project.basics.dto;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author Emmanuel Raj
 * 
 * POJOS/GETTERS/SETTERS (Encapsulation))
 *
 */



public class UserDTO 
{
	
	// form:hidden - hidden value
		private Integer id;

		// form:input - textbox
		private String name;
		
		
		// form:input - textbox
		private Date dob;

		// form:input - textbox
		private String email;

		// form:textarea - textarea
		private String address;

		// form:input - password
		private String password;

		// form:input - password
		private String confirmPassword;

		// form:checkbox - single checkbox
		private boolean newsletter;

		// form:checkboxes - multiple checkboxes
		private List<String> framework;

		// form:radiobutton - radio button
		private String sex;

		
		// form:select - form:option - dropdown - single select
		private String country;

		// form:select - multiple=true - dropdown - multiple select
		private List<String> skill;

		//Check if this is for New of Update
		public boolean isNew() {
			return (this.id == null);
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getConfirmPassword() {
			return confirmPassword;
		}

		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}

		public boolean isNewsletter() {
			return newsletter;
		}

		
		
		public void setNewsletter(boolean newsletter) {
			this.newsletter = newsletter;
		}
		
		

		public List<String> getFramework() {
			return framework;
		}

		public void setFramework(List<String> framework) {
			this.framework = framework;
		}

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

	
		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public List<String> getSkill() {
			return skill;
		}

		public void setSkill(List<String> skill) {
			this.skill = skill;
		}

		public Date getDob() {
			return dob;
		}

		public void setDob(Date dob) {
			this.dob = dob;
		}

		@Override
		public String toString() {
			return "UserDTO [id=" + id + ", name=" + name + ", dob=" + dob
					+ ", email=" + email + ", address=" + address
					+ ", password=" + password + ", confirmPassword="
					+ confirmPassword + ", newsletter=" + newsletter
					+ ", framework=" + framework + ", sex=" + sex
					+ ", country=" + country + ", skill=" + skill + "]";
		}

       
		
		
	
	
	
}
