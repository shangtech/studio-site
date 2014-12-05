<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>网站后台</title>
	
	<!-- Bootstrap -->
	<link href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.css" rel="stylesheet">
	<link href="${ctx}/css/studio-manager.css" rel="stylesheet">
	
	<script type="text/javascript" src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
	<script type="text/javascript" src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">var ctx = '${ctx}';</script>
</head>
<body>
<div class="login-wrapper">
	<div class="modal">
  		<div class="modal-dialog">
  		<form class="form" method="post" onsubmit="return checkForm();" action="${ctx}/login">
    		<div class="modal-content">
      			<div class="modal-body">
		      			<c:if test="${not empty msg}">
						<div class="alert alert-danger" role="alert">${msg}</div>
						</c:if>
        				<div class="form-group">
        					<div class="input-group">
        						<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
        						<input type="text" name="username" class="form-control" placeholder="Username">
        					</div>
        				</div>
        				<div class="form-group">
        					<div class="input-group">
        						<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
        						<input type="password" name="password" class="form-control" placeholder="Password">
        					</div>
        				</div>
      			</div>
      			<div class="modal-footer">
        			<input type="submit" class="btn btn-primary" value="登  录  后  台"/>
      			</div>
    		</div>
    	</form>
 		</div>
	</div>
</div>
<script type="text/javascript" src="${ctx}/javascript/login.js"></script>
</body>