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
						<a class="btn btn-default" href="${ctx}/works/${item.id}">作品管理</a>
						<a class="btn btn-default pull-right remove" data-id="${item.id}" href="javascript:;">删除</a>
					</p>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
	<c:if test="${pagination.totalPage gt 1}">
	<div class="row">
		<div class="col-sm-12">
			<ul class="pagination pull-right">
				<c:if test="${pagination.isFirst}">
					<li class="disabled"><a href="javascript:;">上一页</a></li>
				</c:if>
				<c:if test="${not pagination.isFirst}">
					<li><a href="${ctx}/photographer?pageNo=${pagination.pageNo-1}">上一页</a></li>
				</c:if>
				<c:forEach begin="1" end="${pagination.totalPage}" var="i">
					<c:choose>
							<c:when test="${(i eq 1) or ((i gt pagination.pageNo-4 or i gt pagination.totalPage-10) and (i lt pagination.pageNo+4 or i lt 10)) or (i eq pagination.totalPage)}">
							<li${pagination.pageNo eq i ? ' class="active"' : ''}><a href="${ctx}/photographer?pageNo=${i}">${i}</a></li>
							</c:when>
							<c:otherwise>
								<c:if test="${(i eq 2) or (i eq pagination.totalPage-1)}">
								<li><a>...</a></li>
								</c:if>
							</c:otherwise>
							</c:choose>
				</c:forEach>
		        <c:if test="${pagination.isLast}">
					<li class="disabled"><a href="javascript:;">下一页</a></li>
				</c:if>
				<c:if test="${not pagination.isLast}">
					<li><a href="${ctx}/photographer?pageNo=${pagination.pageNo+1}">下一页</a></li>
				</c:if>
	      	</ul>
	    </div>
	</div>
	</c:if>
	</c:if>
</div>
<script type="text/javascript" src="${ctx}/javascript/photographer-list.js"></script>