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
});