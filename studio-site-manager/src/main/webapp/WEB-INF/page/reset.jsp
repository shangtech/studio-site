<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp"%>
	<div class="modal" style="display:block;margin-top:100px;">
  		<div class="modal-dialog">
  		<form class="form-horizontal" method="post" onsubmit="return checkForm();" action="${ctx}/reset">
    		<div class="modal-content">
      			<div class="modal-body">
		      		<c:if test="${not empty msg}">
						<div class="alert alert-danger" role="alert">${msg}</div>
					</c:if>
        			<div class="form-group">
        				<label class="col-sm-2 control-label">原用户名</label>
        				<div class="col-sm-10">
        					<input type="text" name="oldUsername" class="form-control" placeholder="oldUsername">
        				</div>
        			</div>
        			<div class="form-group">
        				<label class="col-sm-2 control-label">新用户名</label>
        				<div class="col-sm-10">
        					<input type="text" name="username" class="form-control" placeholder="Username">
        				</div>
        			</div>
        			<div class="form-group">
        				<label class="col-sm-2 control-label">原密码</label>
        				<div class="col-sm-10">
        					<input type="password" name="oldPassword" class="form-control" placeholder="oldPassword">
        				</div>
        			</div>
        			<div class="form-group">
        				<label class="col-sm-2 control-label">新密码</label>
        				<div class="col-sm-10">
        					<input type="password" name="password" class="form-control" placeholder="Password">
        				</div>
        			</div>
      			</div>
      			<div class="modal-footer">
        			<input type="submit" class="btn btn-primary" value="保存"/>
      			</div>
    		</div>
    	</form>
 		</div>
	</div>
	<script type="text/javascript" src="${ctx}/javascript/reset.js"></script>