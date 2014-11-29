<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp"%>
<div class="clear">
	<div class="pull-right">
		<a href="${ctx}/photographer/create" class="btn btn-default">添加摄影师</a>
	</div>
</div>
<div class="manager-content">
	<c:if test="${empty pagination.items}">
	<div class="alert alert-info" role="alert">还没有任何摄影师记录,马上<a href="${ctx}/photographer/create">添加摄影师</a></div>
	</c:if>
	<c:if test="${not (empty pagination.items)}">
	<div class="row">
		<c:forEach items="${pagination.items}" var="item">
		<div class="col-sm-6 col-md-3">
			<div class="thumbnail">
				<img src="${ctx}/${item.image}"/>
				<div class="caption">
					<h3>${item.name}</h3>
					<p>从业：${item.experience}</p>
					<p>预约次数：${item.appointments}</p>
					<p>团队服务费：${item.price}</p>
					<p>团队成员：(${item.members})</p>
					<p class="center">
						<a class="btn btn-default pull-left" href="${ctx}/photographer/edit?id=${item.id}">编辑</a>
						<a class="btn btn-default" href="javascript:;">作品管理</a>
						<a class="btn btn-default pull-right" href="javascript:;">删除</a>
					</p>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
	</c:if>
</div>