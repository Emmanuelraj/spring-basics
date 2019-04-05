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

