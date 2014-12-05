$(document).ready(function(){
	
});
function checkForm(){
	var isUsernameValid = true;
	var isPasswordValid = true;
	if(!$('input[name="username"]').val()){
		isUsernameValid = false;
		$('input[name="username"]').closest('.form-group').addClass('has-error');
	}
	else{
		$('input[name="username"]').closest('.form-group').removeClass('has-error');
	}
	if(!$('input[name="password"]').val()){
		isPasswordValid = false;
		$('input[name="password"]').closest('.form-group').addClass('has-error');
	}
	else{
		$('input[name="password"]').closest('.form-group').removeClass('has-error');
	}
	return isUsernameValid && isPasswordValid;
}