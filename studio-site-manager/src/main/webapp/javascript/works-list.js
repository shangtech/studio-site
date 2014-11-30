$(document).ready(function(){
	$('body').on('click', '.remove', function(){
		if($(this).attr('op')){
			return;
		}
		$.ajax({
			type: 'POST',
			url: ctx + '/works/remove',
			dataType: 'json',
			data: {id: $(this).data('id')},
			success: function(data){
				$(this).removeAttr('op');
				if(data.success){
					document.location.reload();
				}
			}
		});
	});
});