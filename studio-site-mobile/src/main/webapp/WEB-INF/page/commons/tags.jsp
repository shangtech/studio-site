<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<c:set var="telphone" value="13520602979"/>
<c:if test="${empty imagePath}">
	<c:set var="imagePath" value="${ctx}"/>
</c:if>
<c:if test="${empty cssPath}">
	<c:set var="cssPath" value="${ctx}"/>
</c:if>
<c:if test="${empty jsPath}">
	<c:set var="jsPath" value="${ctx}"/>
</c:if>