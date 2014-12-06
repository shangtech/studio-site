<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp"%>
<ul class="sSysList" id="sSysList">
	<c:forEach items="${pagination.items}" var="item">
	<li class="clear" onclick="location.href='/photographer/${item.url}'" style="background-color: rgb(255, 255, 255);">
		<img src="http://image.onlylover.com/201408/25/image_14089577863468_240_240.jpg" class="sSysImg">
		<div class="sSysContent">
			<h1>${item.name}</h1>
			<div class="sOrderNumTips">已被预约<span>${item.appointments}</span>次 </div>
			<p class="sCost">团队服务费<span>￥${item.price}</span>/天</p>
			<p class="sNewYears">从业<span>${item.experience}</span>年</p>
			<p class="sUserDesc">${item.description}</p>
		</div>
	</li>
	</c:forEach>
</ul>
<a class="morebtn ui-link" id="morebtn" style="display: none;">加载中...</a>
<div class="ui-loader ui-corner-all ui-body-a ui-loader-default"><span class="ui-icon-loading"></span><h1>loading</h1></div>
<script type="text/javascript" src="${ctx}/js/photographer-list.js"></script>