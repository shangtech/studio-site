$(document).ready(function(){
	$('textarea').wysihtml5({
		toolbar:{
			fa: true
		}
	});
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
	$('body').on('click', '.remove', function(){
		if(confirm('确定要删除本条数据吗')){
			$.ajax({
				url: ctx + '/special/remove',
				type: 'POST',
				data: {id: $(this).data('id')},
				dataType: 'json',
				success: function(data){
					if(!data.success){
						alert('删除失败');
						return;
					}
					document.location.href = ctx + '/special';
				}
			});
		}
	});
});

function checkForm(){
	$('textarea[name="pageContent"]').html($('textarea[name="pageContent"]').val());
	return true;
}