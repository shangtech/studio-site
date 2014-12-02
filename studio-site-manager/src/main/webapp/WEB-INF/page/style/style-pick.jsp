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
				<img src="${ctx}/${item.image}"/>
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
</div>