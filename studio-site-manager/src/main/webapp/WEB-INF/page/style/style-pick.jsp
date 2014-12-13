<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp"%>
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">关闭</span></button>
	<h4 class="modal-title">${style.name}</h4>
</div>
<div class="modal-body">
	<div class="row">
		<c:forEach items="${pagination.items}" var="item">
		<div class="col-sm-6 col-md-4 works">
			<div class="thumbnail">
				<img src="${imagePath}/${item.image}"/>
				<div class="caption">
					<h3>${item.name}</h3>
					<p>${item.photographer.name}作品</p>
					<p class="center options">
						<c:if test="${not item.selected}">
						<a class="btn btn-default btn-select-style" data-id="${item.id}" href="javascript:;"> 选 择 </a>
						</c:if>
						<c:if test="${item.selected}">
						<a class="btn btn-default" disabled="disabled" href="javascript:;"> 已 选 </a>
						</c:if>
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
						<li${pagination.isFirst ? ' class="disabled"' : ''}><a data-page="${pagination.pageNo-1}" href="javascript:;">上一页</a></li>
						<c:forEach begin="1" end="${pagination.totalPage}" var="i">
							<c:choose>
							<c:when test="${(i eq 1) or ((i gt pagination.pageNo-4 or i gt pagination.totalPage-10) and (i lt pagination.pageNo+4 or i lt 10)) or (i eq pagination.totalPage)}">
							<li${pagination.pageNo eq i ? ' class="active"' : ''}><a data-page="${i}" href="javascript:;">${i}</a></li>
							</c:when>
							<c:otherwise>
								<c:if test="${(i eq 2) or (i eq pagination.totalPage-1)}">
								<li><a>...</a></li>
								</c:if>
							</c:otherwise>
							</c:choose>
						</c:forEach>
						<li${pagination.isLast ? ' class="disabled"' : ''}><a data-page="${pagination.pageNo+1}" href="javascript:;">下一页</a></li>
			      	</ul>
			    </div>
			</div>
	</c:if>
</div>