<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp"%>
<style type="text/css">
<!--
body{line-height: 1.7;}
div.content{font-size: 1.5em;}
a.half{float:left;width:50%;}
.iTel a.half{padding-left:0px;}
.content{padding:2em 1em;}
a.iOnline{ background:no-repeat 2.2em 1em; background-size:18px 18px; box-sizing:border-box;}
-->
</style>
<div class="content">
    ${page.pageContent}
</div>
<div id="footerbtn" class="iTel clear">
	<c:choose>
		<c:when test="${page.showAppointment && page.showTel}">
			<a data-ajax="false" href="${ctx}/appointment?url=${page.url}" class="half zxyy ui-link">在线预约</a>
			<a href="tel:${telphone}" class="iOnline ui-link half">电话咨询</a>
		</c:when>
		<c:otherwise>
			<c:if test="${page.showAppointment}">
		        <a data-ajax="false" href="${ctx}/appointment?url=${page.url}" class="half zxyy ui-link">在线预约</a>
		    </c:if>
			<c:if test="${page.showTel}">
				<a href="tel:${telphone}" class="iOnline ui-link">电话咨询</a>
			</c:if>		
		</c:otherwise>
	</c:choose>
</div>
