<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp"%>
<form class="form-horizontal" action="${ctx}/works/<c:if test="${not empty author}">${author}/</c:if>save" onsubmit="return checkWorksForm();" method="post" role="form">
	<input type="hidden" name="id" value="${works.id}"/>
	<input type="hidden" name="images"/>
	<div class="form-group">
		<div class="col-sm-10 col-sm-offset-2">
			<input class="btn btn-default pull-left" type="submit" value=" 保 存 "/>
			<input class="btn btn-default pull-right" type="reset" value=" 清 空 "/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">摄影师</label>
		<div class="col-sm-10">
			<c:if test="${not empty works.photographer.id}">
			<input type="text" class="form-control" disabled value="${works.photographer.name}"/>
			</c:if>
			<c:if test="${empty works.photographer.id}">
			<select class="form-control" name="author">
				<c:forEach items="${photographers}" var="photographer">
				<option value="${photographer.id}">${photographer.name}</option>
				</c:forEach>
			</select>
			</c:if>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">作品名称</label>
		<div class="col-sm-10">
			<div class="input-group">
				<div class="input-group-addon">作品名称</div>
				<input type="text" class="form-control" value="${works.name}" name="name" placeholder="作品名称"/>
				<div class="input-group-addon">访问路径</div>
				<input type="text" class="form-control" name="url" value="${works.url}" placeholder="访问路径"/>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">作品封面</label>
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
			<input type="hidden" class="form-control" name="image" value="${photographer.image}"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">拍摄地</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" value="${works.address}" name="address" placeholder="拍摄地"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">赞次数</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" value="${works.hearts}" name="hearts" placeholder="赞次数"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">作品风格</label>
		<div class="col-sm-10">
			<c:forEach items="${styles}" var="item">
			<label class="checkbox-inline">
			  <input type="checkbox" name="styles" value="${item.id}"${fn:contains(styleIds, item.id) ? ' checked' : ''}> ${item.name} 
			</label>
			</c:forEach>
		</div>
	</div>
</form>
<div class="row works-image-form-list">
	<c:if test="${not empty works.images}">
	<c:forTokens items="${works.images}" delims="," var="item">
	<div class="col-sm-6 col-md-3 works-image-form">
		<a class="thumbnail" href="javascript:;">
			<img src="${ctx}/${item}" data-src="${item}"/>
			<div class="caption center">
				<button href="javascript;:" class="btn btn-default pull-left move-left">左移</button>
				<button href="javascript;:" class="btn btn-default remove">移除</button>
				<button href="javascript;:" class="btn btn-default pull-right move-right">右移</button>
			</div>
		</a>
	</div>
	</c:forTokens>
	</c:if>
	<div class="col-sm-6 col-md-3" id="thumbnail-add-btn">
		<a href="javascript:;" class="thumbnail btn btn-default" style="position:relative;">
			添加照片
			<input type="file" id="file-temp" class="transparent" style="width:100%;height:100%;position:absolute;top:0px;left:0px;"/>
		</a>
	</div>
</div>
<script type="text/javascript" src="${ctx}/javascript/works-form.js"></script>