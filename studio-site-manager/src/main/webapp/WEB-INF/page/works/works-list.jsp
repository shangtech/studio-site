<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp"%>
<div class="row">
	<div class="col-sm-3">
		<div class="list-group">
			<c:forEach items="${photographers}" var="item">
				<a href="${ctx}/works/${item.id}" class="list-group-item<c:if test="${item.id eq author}"> active</c:if>">${item.name}</a>
			</c:forEach>
		</div>
	</div>
	<div class="col-sm-9">
		<div class="clear">
			<div class="pull-right">
				<a href="${ctx}/works/<c:if test="${not empty author}">${author}/</c:if>create" class="btn btn-default">添加作品</a>
			</div>
		</div>
		<div class="manager-content">
			<c:if test="${empty pagination.items}">
			<div class="alert alert-info" role="alert">还没有作品记录,马上<a href="${ctx}/works/<c:if test="${not empty author}">${author}/</c:if>create">添加摄影作品</a></div>
			</c:if>
			<c:if test="${not (empty pagination.items)}">
			<div class="row">
				<c:forEach items="${pagination.items}" var="item">
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img src="${ctx}/${item.image}"/>
						<div class="caption">
							<h3>${item.name}</h3>
							<c:if test="${(empty author) and (not empty item.photographer)}">
							<p>${item.photographer.name}作品</p>
							</c:if>
							<p>赞：${item.hearts}</p>
							<p>拍摄地：${item.address}</p>
							<p class="center">
								<a class="btn btn-default pull-left" href="${ctx}/works/<c:if test="${not empty author}">${author}/</c:if>edit?id=${item.id}">编辑</a>
								<a class="btn btn-default pull-right remove" data-id="${item.id}" href="javascript:;">删除</a>
								<br clear="both"/>
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
							<li><a href="?pageNo=${pagination.pageNo-1}">上一页</a></li>
						</c:if>
						<c:forEach begin="1" end="${pagination.totalPage}" var="i">
							<c:choose>
							<c:when test="${(i eq 1) or ((i gt pagination.pageNo-4 or i gt pagination.totalPage-10) and (i lt pagination.pageNo+4 or i lt 10)) or (i eq pagination.totalPage)}">
							<li${pagination.pageNo eq i ? ' class="active"' : ''}><a href="?pageNo=${i}">${i}</a></li>
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
							<li><a href="?pageNo=${pagination.pageNo+1}">下一页</a></li>
						</c:if>
			      	</ul>
			    </div>
			</div>
			</c:if>
			</c:if>
		</div>
	</div>
</div>