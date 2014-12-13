var hasMore = $(".datas-lists-size").html() == 8;
var setPage = 2;
var downStatus = false;
var timer;
$("#worksList").on("touchmove",function(){	
	if($(document).height()-$(window).height() <= $(document).scrollTop()){ 
		downStatus = true;
		$('#morebtn').show();
		timer = setTimeout(function(){
			if(hasMore){
				if(downStatus){
					getLoad(setPage);
				}
			}
			else{
				$("#morebtn").show();
				$("#morebtn").html("没有更多了");
			}
		},1000);
	}
});


function getLoad(page){
	var style = $(".styleid").html();
	jQuery.ajax({
		url:ctx + "/works",
		type:"POST",
		dataType:'json',
		async: false,
		data:{styleId:style, pageNo:page, limit:8},
		beforeSend:function(){
			$('#morebtn').show();
		},
	    success:function(data){
	    	if(data.length < 8){
	    		hasMore = false;
	    	}
			var htmlLoad = '';
			jQuery.each(data,function(i,item){	
				var locationHref = "location.href='"+item.url+"'";
				htmlLoad += '<div class="dWorks" onClick="'+locationHref+'">';
					htmlLoad += '<img src="'+ imagePath + '/'+item.image+'">';
					htmlLoad += '<div class="dWorksTitle clear">';
						htmlLoad += '<h2>'+item.name+'</h2>';
						htmlLoad += '<div class="dWorksTitleRight clear">';
							htmlLoad += '<span class="dWorker">'+item.author+'<i>作品</i></span>';
							htmlLoad += '<span class="dSite">'+item.address+'</span>';
							htmlLoad += '<span class="dLike">'+item.hearts+'</span>';
						htmlLoad += '</div>';
					htmlLoad += '</div>';
				htmlLoad += '</div>';
			});
			$(".dWorksWarp").append(htmlLoad);
			setPage = setPage+1;
		},
		complete:function(){
			$("#morebtn").hide();
			clearTimeout(timer);
			downStatus = false;
		}
	});
}
