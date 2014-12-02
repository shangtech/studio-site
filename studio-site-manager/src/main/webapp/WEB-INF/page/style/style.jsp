<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp"%>
<div class="row">
	<div class="col-sm-3">
		<c:if test="${not empty list}">
		<div class="list-group">
			<c:forEach items="${list}" var="item">
			<a href="${ctx}/style/${item.id}" class="list-group-item<c:if test="${item.id eq id}"> active</c:if>">${item.name}</a>
			</c:forEach>
		</div>
		</c:if>
		
		<div class="list-group">
			<a href="${ctx}/style" class="list-group-item<c:if test="${empty id}"> active</c:if>">新建风格</a>
		</div>
	</div>
	<div class="col-sm-9">
		<form class="form-horizontal" action="${ctx}/style/save" method="post" role="form">
			<input type="hidden" name="id" value="${id}"/>
			<div class="form-group">
				<label class="col-sm-2 control-label">风格名称</label>
				<div class="col-sm-10">
					<div class="input-group">
						<div class="input-group-addon">风格名称</div>
						<input type="text" class="form-control" name="name" value="${style.name}" placeholder="风格名称"/>
						<div class="input-group-addon">访问路径</div>
						<input type="text" class="form-control" name="url" value="${style.url}" placeholder="访问路径"/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">描述</label>
				<div class="col-sm-10">
					<textarea name="description" rows="5" class="form-control">${style.description}</textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-10 col-sm-offset-2">
					<input class="btn btn-default pull-left" type="submit" value=" 保 存 "/>
					<input class="btn btn-default pull-right" type="reset" value=" 清 空 "/>
				</div>
			</div>
		</form>
		<div class="row" id="style-works-list">
		<c:forEach items="${pagination.items}" var="item">
		<div class="col-sm-6 col-md-4 photo-works-style">
			<div class="thumbnail">
				<img src="${ctx}/${item.photoWorks.image}"/>
				<div class="caption">
					<h3>${item.photoWorks.name}</h3>
					<p>${item.photoWorks.photographer.name}作品</p>
					<p class="center">
						<a class="btn btn-default btn-remove-style" data-id="${item.photoWorks.id}" href="javascript:;"> 移 除 </a>
					</p>
				</div>
			</div>
		</div>
		</c:forEach>
		</div>
		<c:if test="${not empty style}">
		<a class="btn btn-default col-sm-12 btn-pick" href="javascript:;">  选  择  作  品  </a>
		</c:if>
	</div>
</div>
<div class="modal fade" id="works-picking-modal" role="dialog" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content"></div>
	</div>
</div>
<script type="text/javascript" src="${ctx}/javascript/style.js"></script>