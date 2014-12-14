<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp"%>
<style type="text/css">
<!--
body{line-height: 1.7}
.content{padding:2em 1em;}
.iTel a{ float:left; width:50%; height:4em; line-height:3em; text-align:center; font-size:1.6em; color:#fff; background:url(../images/newtel.png) no-repeat 2em 1em; background-size:18px 18px; padding-left:1em; box-sizing:border-box;}
.iTel .iOnline{ background:no-repeat 2.2em 1em; background-size:18px 18px; padding-left:1.5em; box-sizing:border-box;}
-->
</style>
<div class="content">
    ${page.pageContent}
</div>
<div id="footerbtn" class="iTel clear">
    <c:if test="${page.showAppointment}">
        <a data-ajax="false" href="${ctx}/appointment?${page.url}" class="zxyy ui-link">在线预约</a>
    </c:if>
	<c:if test="${page.showTel}">
		<a href="tel:${telphone}" class="iOnline ui-link">电话咨询</a>
	</c:if>
</div>
