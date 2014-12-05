<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp"%>
<form class="form-horizontal" action="${ctx}/properties/save" method="post" role="form">
	<c:forEach items="${properties}" var="item" varStatus="i">
		<div class="form-group">
			<label class="col-sm-2 control-label">${item.propertyName}</label>
			<div class="col-sm-10">
				<c:if test="${not item.isDefault}">
				<div class="input-group">
					<input type="text" class="form-control" name="propertyValue" value="${item.propertyValue}" placeholder="属性值"/>
					<span class="input-group-btn">
            			<button class="btn btn-default remove" data-id="${item.id}" type="button">删除</button>
          			</span>
				</div>
				</c:if>
				<c:if test="${item.isDefault}">
				<input type="text" class="form-control" name="propertyValue" value="${item.propertyValue}" placeholder="属性值"/>
				</c:if>
			</div>
		</div>
	</c:forEach>
	<a href="javascript:;" class="btn btn-default col-sm-12"> 添 加 属 性 </a>
</form>