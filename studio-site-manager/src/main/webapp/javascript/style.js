$(document).ready(function(){
	$('.btn-pick').click(function(){
		$('#works-picking-modal').modal('show');
		$('#works-picking-modal .modal-content').load(ctx + '/style/pick?style=' + $('input[name="id"]').val());
	});
	$('body').on('click', '.btn-select-style', function(){
		var btn = $(this);
		$.ajax({
			url: ctx + '/style/' + $('input[name="id"]').val() + '/add',
			data: {works: btn.data('id')},
			type: 'POST',
			dataType: 'json',
			success: function(data){
				if(data.success){
					btn.attr('disabled', 'disabled').removeClass('.btn-select').html(' 已 选 ');
					var works = btn.closest('.works').clone();
					works.find('.options').html('<a class="btn btn-default btn-remove-style" data-id="' + btn.data('id') + '" href="javascript:;"> 移 除 </a>');
					$('#style-works-list').append(works);
				}
			}
		});
	});
	$('body').on('click', '.btn-remove-style', function(){
		var btn = $(this);
		$.ajax({
			url: ctx + '/style/' + $('input[name="id"]').val() + '/remove',
			data: {works: btn.data('id')},
			type: 'POST',
			dataType: 'json',
			success: function(data){
				if(data.success){
					btn.closest('.photo-works-style').remove();
				}
			}
		});
	});
	$('body').on('click', '.remove', function(){
		if(confirm('确定要删除本条数据吗')){
			$.ajax({
				url: ctx + '/style/remove',
				type: 'POST',
				data: {id: $(this).data('id')},
				dataType: 'json',
				success: function(data){
					if(!data.success){
						alert('删除失败');
						return;
					}
					document.location.href = ctx + '/style';
				}
			});
		}
	});
});