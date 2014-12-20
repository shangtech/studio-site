<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp"%>
<link href="${ctx}/css/bootstrap3-wysihtml5.min.css" rel="stylesheet">
<link href="${ctx}/css/font-awesome.min.css" rel="stylesheet">
<div class="row">
	<div class="col-sm-3">
		<c:if test="${pagination.totalCount gt 0}">
		<div class="list-group">
			<c:if test="${pagination.pageNo gt 1}">
			<a href="${ctx}/special?pageNo=${pagination.pageNo-1}" class="list-group-item">上一页</a>
			</c:if>
			<c:forEach items="${pagination.items}" var="item">
			<a href="${ctx}/special/${item.id}?pageNo=${pagination.pageNo}" class="list-group-item<c:if test="${item.id eq id}"> active</c:if>">${item.name}</a>
			</c:forEach>
			<c:if test="${pagination.pageNo lt pagination.totalPage}">
			<a href="${ctx}/special?pageNo=${pagination.pageNo+1}" class="list-group-item">下一页</a>
			</c:if>
		</div>
		</c:if>
		
		<div class="list-group">
			<a href="${ctx}/special" class="list-group-item<c:if test="${empty id}"> active</c:if>">新建页面</a>
		</div>
	</div>
	<div class="col-sm-9">
		<form class="form-horizontal" onsubmit="return checkForm();" action="${ctx}/special/save" method="post" role="form">
			<input type="hidden" name="id" value="${id}"/>
			<div class="form-group">
				<label class="col-sm-2 control-label">页面名称</label>
				<div class="col-sm-10">
					<div class="input-group">
						<div class="input-group-addon">页面名称</div>
						<input type="text" class="form-control" name="name" value="${special.name}" placeholder="页面名称"/>
						<div class="input-group-addon">访问路径</div>
						<input type="text" class="form-control" name="url" value="${special.url}" placeholder="访问路径"/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">页面标题</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="pageTitle" value="${special.pageTitle}" placeholder="页面标题"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">封面</label>
				<div class="col-sm-10">
					<div class="input-group">
						<div class="progress">
							<div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 0;"></div>
						</div>
						<span class="input-group-btn">
							<a href="javascript:;" class="btn btn-default">浏览</a>
						</span>
					</div>
					<input type="file" class="transparent hiddenfile auto-upload" for="image"/>
					<input type="hidden" class="form-control" name="image" value="${special.image}"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">页面描述</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="pageDescription" value="${special.pageDescription}" placeholder="页面描述"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">页面关键词</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="pageKeyWords" value="${special.pageKeyWords}" placeholder="页面关键词"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-10 col-sm-offset-2">
					<label class="checkbox-inline">
				    	<input type="checkbox" name="showAppointment"<c:if test="${special.showAppointment}"> checked</c:if>> 显示预约按钮
				    </label>
				    <label class="checkbox-inline">
				    	<input type="checkbox" name="showTel"<c:if test="${special.showTel}"> checked</c:if>> 显示电话按钮
				    </label>
				    <label class="checkbox-inline">
				    	<input type="checkbox" name="showIndex"<c:if test="${special.showIndex}"> checked</c:if>> 推到首页
				    </label>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">页面内容</label>
				<div class="col-sm-10">
					<textarea name="pageContent" class="form-control">${special.pageContent}</textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-10 col-sm-offset-2 center">
					<input class="btn btn-default pull-left" type="submit" value=" 保 存 "/>
					<c:if test="${not empty special}">
					<a class="btn btn-default remove" data-id="${special.id}" href="javascript:;">删除该页面</a>
					</c:if>
					<input class="btn btn-default pull-right" type="reset" value=" 清 空 "/>
				</div>
			</div>
		</form>
	</div>
</div>

<script type="text/javascript" src="${ctx}/js/wysihtml5x-toolbar.min.js"></script>
<script type="text/javascript" src="${ctx}/js/handlebars.runtime.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap3-wysihtml5.min.js"></script>
<script type="text/javascript" src="${ctx}/javascript/special.js"></script>