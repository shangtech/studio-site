$(document).ready(function(){
	$('body').on('change', 'input[type="file"].auto-upload', function(){
		var progress = $(this).parent().find('.progress-bar');
		var form = $('<form style="display:none;" enctype="multipart/form-data" method="post" action="' + ctx + '/upload"></form>').appendTo($('body'));
		$(this).clone().insertBefore($(this));
		form.append($(this));
		if(!$(this).attr('name')){
			if($(this).attr('for')){
				$(this).attr('name', $(this).attr('for'));
			}
			else {
				$(this).attr('name', 'file');
			}
		}
		form.ajaxSubmit({
			success: function(data){
				form.remove();
				if(data.data){
					for(var key in data.data){
						$('input[name="' + key + '"]').val(data.data[key]);
					}
				}
			},
			uploadProgress: function(e, position, total, per){
				progress.width(per + '%');
				if(per >= 100){
					setTimeout(function(){
						progress.html('上传成功！');
					}, 0);
				}
			}
		});
	});
});