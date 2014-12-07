<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp"%>
<div id="worksList" class="worksList">
     <!-- 列表 -->
     <div class="dWorksWarp">
     	<%@include file="/WEB-INF/page/mobile-works-list-chip.jsp" %>
	 </div>
    <a class="morebtn ui-link" id="morebtn" style="display: none;">加载中...</a>
</div>
<!-- 导航  -->
<div class="workerNav">
	<div class="clear">
		<a href="http://m.onlylover.com/theme/lists?styleid=0" data-ajax="false" class="active ui-link">全部</a>
		<!-- 当前页面添加class “active” -->
		<c:forEach var="item" items="${style}" begin="0" end="2" step="1" varStatus="status">
		   <a href="http://m.onlylover.com/theme/lists?styleid=1" data-ajax="false" class="ui-link">${item.name}</a>
		</c:forEach>
        <a href="http://m.onlylover.com/theme/lists###" data-ajax="false" id="more" class="ui-link">更多</a>
	</div>
	<div id="moreListNav" class="moreListNav ">
		<!-- 更多风格 选择后一样添加 加class “active”-->
		<c:if test="${style.size()>3}">
		    <c:forEach var="item" items="${style}" begin="3" step="1" varStatus="status">
			<a href="http://m.onlylover.com/theme/lists?styleid=6" data-ajax="false" class="ui-link">${item.name}</a>
			</c:forEach>
		</c:if>
        <span class="arrowdown"></span>
	</div>
</div>

<script type="text/javascript">
var styleid = '0';
var iTotal = '121';
var boolean hasMore = false;
var setPage = 1;
var downStatus = false;
$("#worksList").on("touchmove",function(){	
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
		url:"/works",
		type:"POST",
		dataType:'json',
		async: false,
		data:{pageNo:page, limit: 8},
		beforeSend:function(){
			$('#morebtn').show();
		},
	    success:function(data){
			var htmlLoad = '';
			jQuery.each(data.res,function(i,item){	
				var locationHref = "location.href='"+item.url+"'";
				htmlLoad += '<div class="dWorks" onClick="'+locationHref+'">';
					htmlLoad += '<img src="'+item.image+'">';
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
</script>