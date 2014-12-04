<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp"%>
<div class="row">
	<div class="col-sm-3">
		<c:if test="${not empty list}">
		<div class="list-group">
			<c:forEach items="${list}" var="item">
			<a href="${ctx}/appointment/${type}/${item.id}" class="list-group-item<c:if test="${item.id eq id}"> active</c:if>">${item.name}</a>
			</c:forEach>
		</div>
		</c:if>
	</div>
	<div class="col-sm-9">
		<c:if test="${not empty pagination.items}">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>姓名</th>
					<th>电话</th>
					<th>提交时间</th>
					<th>预约对象</th>
					<th>备注</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pagination.items}" var="item">
				<tr>
					<td>${item.name}</td>
					<td>${item.tel}</td>
					<td>${item.createTime}</td>
					<td>${item.target.name}</td>
					<td>${item.memo}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:if>
	</div>
</div>