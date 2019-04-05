<!DOCTYPE html>
<html>
<head>
<title>User Form</title>



<%@include file="include.jsp" %>
   <link href="<c:url value="/resources/core/css/hello.css" />" rel="stylesheet">
  <spring:url value="/resources/core/css/hello.css" var="mainCss" />
  
  
  <style type="text/css">
  
  .form-control
    {
         border-radius:5px;
         width: 90%;
         clear: both;
         width: 100%;
         
    }
  
  #form , h1
  {
    display: table;
    
    margin: 0 auto;
    
    font-family: verdana;
    
  }
  
  
  .container 
  {
	    width:720px;
	   	background: #fff;
	 	margin: 0 auto;
	 	border-radius:6px;
	 	overflow: hidden;
	 	border: 1px solid gold;
	 	padding: 0 0 20px;
	 	box-sizing: border-circle; 
	    box-shadow : 0px 1px 6px rgba(0,0,0,0.2);
	
  }
  
  
  #add
  {
      
      border-radius:5px;
      color: white;
       background-color: #8064A2;
     
      border-top: 20%;
      padding: 15px 32px;
       
  }
  #add:HOVER {
	background-color: #4286f4;
	color: white;	
	  width: 100%; 
 }
 
.msg
{
 width:720px;
 overflow: hidden;
 background-color: pink;
 padding: 0 0 20px;
 box-sizing: border-circle; 
 box-shadow : 0px 1px 6px rgba(0,0,0,0.2);
}


form:errors
{
  color: white;
  background-color: red;
}

#err
{
background-color: pink;
color: black;
}
  
  @media only screen and (max-width: 480px) {
    #form {
        width:95%;
    }
    form:input[type=text], textarea {
        width:75%;
    }
}
  
  </style>
  
  
</head>
<body onload="myFunction()">
         <div class="container">
         
     
         
         
              <div class="msg">
                      <form:errors path="userForm.*"></form:errors>
              </div>

             
             <div class="radioButtons">
                    <input type="checkbox" id="rd">
                    <input type="checkbox" id="rd1">
             </div>
              
			<c:choose>
				<c:when test="${userForm['new']}">
					<h1>Add User</h1>
				</c:when>
				<c:otherwise>
					<h1>Update User</h1>
				</c:otherwise>
			</c:choose>
			<br />
		
			<form:form action="userFormSubmit" name="userForm" method="POST" commandName="userForm" id="form" autocomplete="off">
			
			
			<form:hidden path="id" />
			
					<div class="form-group">
							 <!-- Name -->
						         <spring:message       code="label.name"></spring:message>
						       <form:input path="name"   id="name"  class="form-control" />
						       <form:errors path="name"  class="form-control" id="err"></form:errors>
					 </div>
						      <!-- Email -->
						      
							<div class="form-group">
						          <spring:message code="label.email"></spring:message> 
						       <form:input path="email"   id="email"  class="form-control" />
						       <form:errors path="email" class="form-control" id="err"></form:errors>
						    </div>   
						    
						    <div class="form-group">
						         <spring:message code="label.dob"></spring:message>
						       <form:input path="dob"   id="dob"  placeholder ="Enter dd**MM**yyy" class="form-control" />
						       <form:errors path="dob" class="form-control" id="err"></form:errors>
						    </div>
						    
						      
						     <div class="form-group"> 
						      <!-- Password -->
						          <spring:message code="label.password"></spring:message>
						       <form:input path="password"   id="password" class="form-control" type="password"/>
						       <form:errors path="password" class="form-control" id="err"></form:errors>
						      </div> 
						     
						     <div class="form-group">
						     <!-- Confirm Password -->
						            <spring:message code="label.confirmPassword"></spring:message> 
						       <form:input path="confirmPassword"   id="confirmPassword"   class="form-control" type="password"/>
						       <form:errors path="confirmPassword" class="form-control" id="err"></form:errors>
						    </div>
						    
						    <div class="form-group">
						           <spring:message code="label.address"></spring:message>
						        <form:textarea path="address" id="address" rows="5" cols="30" class="form-control" />
						        <form:errors path="address" class="form-control" id="err"></form:errors>
						     </div>   
						        
						   
						    <div class="form-group">
					             <spring:message code="label.newsletter"></spring:message>
					         <form:checkbox path="newsletter" id="newsletter"  /> 
					        </div>
						   
						   
						   <div class="form-group">
					           <spring:message code="label.framework"></spring:message>
					         <form:checkboxes items="${frameworkList}" path="framework" id="framework" /> 
					        </div>
					        
					        
					       <div class="form-group">
					         <spring:message code="label.sex"></spring:message>
					          	<label class="radio-inline"> 
				                                  <form:radiobutton path="sex" value="M" /> Male
								</label> 
				                                <label class="radio-inline"> 
				                                  <form:radiobutton path="sex" value="F" /> Female
								</label> <br />
					       </div>
					        
					        
					        
					      
					        
					        
					        <div class="form-group">
					              <spring:message code="label.skill"></spring:message>
					                 <form:select path="skill" items="${javaSkillList}" id="skill" class="form-control"></form:select>
					        </div>
					        
					        
					        
					         <div class="form-group">
					                <spring:message code="label.country"></spring:message>
					                <form:select path="country" id=""class="form-control">
									<form:option value="NONE" label="--- Select ---" />
									<form:options items="${countryList}" />
								</form:select>
					         </div>
					        
					        
							<div class="form-group">
							  <div class="col-sm-offset-2 col-sm-10">
								<c:choose>
								  <c:when test="${userForm['new']}">
								     <button type="button" class="btn-lg btn-primary pull-right" id="add">Add
					                 </button>
								  </c:when>
								  <c:otherwise>
								     <button type="button" class="btn-lg btn-primary pull-right">Update
					                 </button>
								  </c:otherwise>
								</c:choose>
							  </div>
							</div>
						 
	        
		   
		    
			             
			                  
			</form:form>

</div>

	<script type="text/javascript">
		<!--
		
		//-->

			const a          = document.querySelector("#name");
			const addBtn     = document.querySelector("#add");
			const nameInput  = document.querySelector("#name");
			const emailInput = document.querySelector('#email');
			const pwdInput   = document.querySelector('#password');
			const cpwdInput  = document.querySelector('#confirmPassword');
			const addrInput  = document.querySelector('#address');
			const msg        = document.querySelector(".msg");
			
			
			a.addEventListener("click", myFunction);
			
			function myFunction(e)
			{	
				e.preventDefault();   
			}
			
			
			
			addBtn.addEventListener("click", onSubmit);
			
			function  timer()
			{
				console.log('msg disappear in 3 seconds');
				msg.remove();
			};
			
			function onSubmit(e)
			{
				e.preventDefault();
				console.log('onSubmit method'+nameInput.value);
				if(nameInput.value === '' || emailInput.value ==='' || pwdInput.value==='' ||cpwdInput === '' || addrInput === '')
					{
					   msg.innerHTML = 'please enter all fields';
					   msg.style.background ='red';
			           setTimeout(timer,3000); //
					}
				else
					{
					document.forms[0].submit();
					   alert("saved");
					}
				
			}
   </script>

</body>
</html>


