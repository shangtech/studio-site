function checkForm(){
	var isOldUsernameValid = true;
	var isUsernameValid = true;
	var isOldPasswordValid = true;
	var isPasswordValid = true;
	if(!$('input[name="oldUsername"]').val()){
		isOldUsernameValid = false;
		$('input[name="oldUsername"]').closest('.form-group').addClass('has-error');
	}
	else{
		$('input[name="oldUsername"]').closest('.form-group').removeClass('has-error');
	}
	if(!$('input[name="username"]').val()){
		isUsernameValid = false;
		$('input[name="username"]').closest('.form-group').addClass('has-error');
	}
	else{
		$('input[name="username"]').closest('.form-group').removeClass('has-error');
	}
	if(!$('input[name="oldPassword"]').val()){
		isOldPasswordValid = false;
		$('input[name="oldPassword"]').closest('.form-group').addClass('has-error');
	}
	else{
		$('input[name="oldPassword"]').closest('.form-group').removeClass('has-error');
	}
	if(!$('input[name="password"]').val()){
		isPasswordValid = false;
		$('input[name="password"]').closest('.form-group').addClass('has-error');
	}
	else{
		$('input[name="password"]').closest('.form-group').removeClass('has-error');
	}
	return isOldUsernameValid && isUsernameValid && isOldPasswordValid && isPasswordValid;
}