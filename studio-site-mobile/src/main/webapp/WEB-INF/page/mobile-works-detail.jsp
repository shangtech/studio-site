<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp"%>
<div class="workTitle">
	<h1>${work.name}</h1>
	<div class="clear">
		<p class="wSite">${work.address}</p>
		<p class="wLike">${work.hearts}</p>
	</div>
	<a style="display: block; width: 100%;" href="${ctx}/photographer/${author.url}" data-ajax="false" class="ui-link">
		<div class="worksSys clear">
			<div class="worksSysImg">
				<img src="${imagePath}/${author.image}">
			</div>
			<p class="workSysName">
				${author.name}<span>作品</span>
			</p>
			<div class="workOrder">已被预约<span>${author.appointments}</span>次&gt;
			</div>
		</div>
	</a>
	<div class="workImgBox">
	    <c:forTokens var="str" items="${work.images}" delims="|," varStatus="status">  
		    <img src="${imagePath}//${str}">
	    </c:forTokens>
	</div>
</div>
<a href="${ctx}/photographer/${author.url}" class="dOrderBtn ui-link" id="footerbtn" data-ajax="false">${author.name}&nbsp;&nbsp;服务详情&gt;</a>
