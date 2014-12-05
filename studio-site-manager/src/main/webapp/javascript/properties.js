$(document).ready(function(){
	$('.add-property').click(function(){
		var property = $('<div class="form-group" style="margin-left:0px;margin-right:0px;"></div>');
		var html = '<div class="input-group">';
			html += 	'<span class="input-group-addon">属性名称</span>';
			html +=		'<input type="text" class="form-control" name="propertyName"/>';
			html +=		'<span class="input-group-addon">属性编码</span>';
			html +=		'<input type="text" class="form-control" name="propertyCode"/>';
			html +=		'<span class="input-group-addon">属性值</span>';
			html +=		'<input type="text" class="form-control" name="propertyValue"/>';
			html +='</div>';
		property.html(html);
		property.insertBefore($(this));
	});
	$('body').on('click', '.remove', function(){
		$.ajax({
			url: ctx + '/properties/remove',
			data: {id: $(this).data('id')},
			dataType: 'json',
			success: function(data){
				document.location.reload();
			}
		});
	});
});
function checkForm(){
	var isValid = true;
	$('.form-group').each(function(i){
		if(i > 0){
			var valid = true;
			$(this).find('input').each(function(){
				$(this).attr('name', 'list[' + (i-1) + '].' + $(this).attr('name'));
				if(!$(this).val()){
					valid = false;
				}
			});
			if(!valid){
				$(this).closest('.form-group').addClass('has-error');
				isValid = false;
			}
			else{
				$(this).closest('.form-group').removeClass('has-error');
			}
		}
	});
	return isValid;
}