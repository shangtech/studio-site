$(document).ready(function(){
	$('textarea').wysihtml5({
		toolbar:{
			fa: true
		}
	});
	$('.wysihtml5-sandbox').height(500);
	$('body').on('change', '#insert-image-file', function(){
		var progress = $('#insert-image-progress');
		var form = $('<form style="display:none;" enctype="multipart/form-data" method="post" action="' + ctx + '/upload"></form>').appendTo($('body'));
		$(this).clone().insertBefore($(this));
		form.append($(this));
		$(this).attr('name', 'file');
		form.ajaxSubmit({
			success: function(data){
				form.remove();
				if(data.data){
					for(var key in data.data){
						progress.html(ctx + '/' + data.data[key]);
						$('#insert-image-url').val(ctx + '/' + data.data[key]);
						break;
					}
				}
			},
			uploadProgress: function(e, position, total, per){
				progress.width(per + '%');
			}
		});
	});
	
});

function checkForm(){
	$('textarea[name="pageContent"]').html($('textarea[name="pageContent"]').val());
	return true;
}