$(document).ready(function(){
	$('body').on('change', '#file-temp', function(){
		var id = new Date().getTime();
		var thumbnail = $('<div class="col-sm-6 col-md-3 works-image-form" id="thumbnail-' + id + '"></div>').insertBefore($('#thumbnail-add-btn'));
		var form = $('<form style="display:none;" enctype="multipart/form-data" method="post" action="' + ctx + '/upload"></form>').appendTo($('body'));
		$(this).clone().insertBefore($(this));
		form.append($(this).removeAttr('id').attr('name', 'thumbnail-' + id));
		form.ajaxSubmit({
			success: function(data){
				form.remove();
				if(data.data){
					for(var key in data.data){
						var html = 	'<a class="thumbnail" href="javascript:;">';
						html += 		'<img src="' + ctx + '/' + data.data[key] + '" style="height:253px;" data-src="' + data.data[key] + '"/>';
						html += 		'<div class="caption">';
						html += 			'<p class="center">';
						html +=					'<button href="javascript;:" class="btn btn-default pull-left move-left">左移</button>';
						html +=					'<button href="javascript;:" class="btn btn-default remove">移除</button>';
						html +=					'<button href="javascript;:" class="btn btn-default pull-right move-right">右移</button>';
						html +=				'</p>';
						html +=			'</div>';
						html +=		'</a>';
						$('#' + key).html(html);
					}
				}
			},
			uploadProgress: function(e, position, total, per){
				thumbnail.html(per + '%');
			}
		});
	});
	
	$('body').on('click', '.move-left', function(){
		var me = $(this).closest('.works-image-form');
		var prev = me.prev();
		if(!prev){
			return;
		}
		me.insertBefore(prev);
	});
	
	$('body').on('click', '.remove', function(){
		$(this).closest('.works-image-form').remove();
	});
	
	$('body').on('click', '.move-right', function(){
		var me = $(this).closest('.works-image-form');
		var next = me.next();
		if(!next){
			return;
		}
		next.insertBefore(me);
	});
});

function checkWorksForm(){
	var images = '';
	$('.works-image-form img').each(function(){
		if(images != ''){
			images += ',';
		}
		images += $(this).data('src');
	});
	$('input[name="images"]').val(images);
	return true;
}