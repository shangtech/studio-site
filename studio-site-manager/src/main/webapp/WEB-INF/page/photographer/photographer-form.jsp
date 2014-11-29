<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp"%>
<form class="form-horizontal" action="${ctx}/photographer/save" role="form">
	<input type="hidden" name="id" value="${photographer.id}"/>
	<div class="form-group">
		<label class="col-sm-2 control-label">摄影师姓名</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="name" value="${photographer.name}" placeholder="摄影师姓名"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">照片</label>
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
			<input type="hidden" class="form-control" name="image" value="${photographer.image}" placeholder="摄影师姓名"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">从业年限</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="experience" value="${photographer.experience}" placeholder="从业年限"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">服务价格</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="price" value="${photographer.price}" placeholder="服务价格"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">服务团队</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="members" value="${photographer.members}" placeholder="摄影师,造型师,灯光师"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">预约次数</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="appointments" value="${photographer.appointments}" placeholder="预约次数"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">序号</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="sort" value="${photographer.sort}" placeholder="序号"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">摄影师简介</label>
		<div class="col-sm-10">
			<textarea rows="5" cols="" name="description" class="form-control">${photographer.description}</textarea>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-10 col-sm-offset-2">
			<input class="btn btn-default pull-left" type="submit" value=" 保 存 "/>
			<input class="btn btn-default pull-right" type="reset" value=" 清 空 "/>
		</div>
	</div>
</form>