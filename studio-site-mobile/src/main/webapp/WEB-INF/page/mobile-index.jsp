<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp"%>
<div class="iBox clear">
	<a href="${ctx}/photographer" data-ajax="false" class="iSys ui-link">
	    <img src="${ctx}/images/newindex01.png"/>
	</a>
	<a href="${ctx}/works" data-ajax="false" class="iWorks ui-link">
	    <img src="${ctx}/images/newindex02.jpg"/>
	</a>
</div>
<div class="iBox clear">
	<a href="" data-ajax="false" class="iDsf ui-link">
	    <img src="${ctx}/images/newindex03.png"/>
	</a>
    <a href="" data-ajax="false" class="iXjb ui-link">
        <img src="${ctx}/images/newindex04.png">
    </a>
</div>
<div class="iBox clear">
	<c:forEach var="item" items="${recommend}">
		<a href="${ctx}/activity/${item.url}" data-ajax="false" class="ui-link">
		    <img src="${imagePath}/${item.image}"/>
		</a>
	</c:forEach>
</div>
<div id="footerbtn" class="iTel">
	<a href="tel:${telphone}" class="ui-link">电话咨询</a>
</div>
