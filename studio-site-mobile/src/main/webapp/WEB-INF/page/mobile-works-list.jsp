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
		<a href="${ctx}/works" data-ajax="false" styleid="all" class="ui-link">全部</a>
		<!-- 当前页面添加class “active” -->
		<c:forEach var="item" items="${style}" begin="0" end="2" step="1" varStatus="status">
		   <a href="${ctx}/works?styleId=${item.id}" styleid="${item.id}" data-ajax="false" class="ui-link">${item.name}</a>
		</c:forEach>
        <a href="http://m.onlylover.com/theme/lists###" data-ajax="false" id="more" class="ui-link">更多</a>
	</div>
	<div id="moreListNav" class="moreListNav ">
		<!-- 更多风格 选择后一样添加 加class “active”-->
		<c:if test="${style.size()>3}">
		    <c:forEach var="item" items="${style}" begin="3" step="1" varStatus="status">
			<a href="${ctx}/works?styleId=${item.id}" data-ajax="false" styleid="${item.id}" class="ui-link">${item.name}</a>
			</c:forEach>
		</c:if>
        <span class="arrowdown"></span>
	</div>
</div>
<div class="styleid" style="display: none;">${styleId}</div>
<div class="datas-lists-size" style="display: none;">${pagination.items.size()}</div>
<script type="text/javascript" src="${ctx}/js/works-list.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var style = $(".styleid").html();
	if(style==''){
		$("a[styleid='all']").addClass('active');
	}else{
		$("a[styleid='"+style+"']").addClass('active');
	}
});
</script>