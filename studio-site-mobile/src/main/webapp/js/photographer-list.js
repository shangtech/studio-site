var iTotal = '36';
//点击加载更多
var setPage = 2;
var downStatus = false;
var timer = null;
$("#sSysList").on("touchmove",function(){	
	if($(document).height()-$(window).height() <= $(document).scrollTop()){ 
		downStatus = true;
		$('#morebtn').show();
		timer = setTimeout(function(){			
			if(setPage*8<iTotal){
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
	jQuery.ajax({
		url:"/photographer",
		type:"POST",
		dataType:'json',
		async: false,
		data:{pageNo:page, limit: 8},
		beforeSend:function(){
			$('#morebtn').show();
		},	
		success:function(data){
			var htmlLoad = '';
			jQuery.each(data,function(i,item){	
				var locationHref = "location.href='/photographer/"+item.url+"'";
				htmlLoad += '<li class="clear" onClick="'+locationHref+'">';
					htmlLoad += '<img src="'+item.f_url+'" class="sSysImg">';
					htmlLoad += '<div class="sSysContent">';
						htmlLoad += '<h1>'+item.usersname+'</h1>';
						htmlLoad += '<div class="sOrderNumTips">已被预约<span>'+item.order_count+'</span>次 </div>';
						htmlLoad += '<p class="sCost">团队服务费<span>￥'+item.shotfeeoneday+'</span>/天</p>';
						htmlLoad += '<p class="sNewYears">从业<span>'+item.year+'</span>年</p>';
						htmlLoad += '<p class="sUserDesc">'+item.usersdesc+'</p>';
					htmlLoad += '</div>';
				htmlLoad += '</li>';
			});
			$(".sSysList").append(htmlLoad);
			setPage = setPage+1;
		},
		complete:function(){
			$("#morebtn").hide();
			clearTimeout(timer);
			downStatus = false;
		}
	});
}