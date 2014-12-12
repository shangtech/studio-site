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
	<link href="${cssPath}/css/studio-manager.css?${cssVersion}" rel="stylesheet">
	
	<script type="text/javascript" src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
	<script type="text/javascript" src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
    var ctx = '${ctx}';
    var imagePath = '${imagePath}';
    </script>
</head>
<body>
	<header class="navbar navbar-static-top manager-nav" rol="banner">
		<div class="container">
			<div class="navbar-header">
				<a href="${ctx}" class="navbar-brand">后台首页</a>
			</div>
			<nav class="collapse navbar-collapse" role="navigation">
				<ul class="nav navbar-nav">
					<li class="<c:if test="${menu eq 'photographer'}">active</c:if>"><a href="${ctx}/photographer">摄影师管理</a></li>
					<li class="<c:if test="${menu eq 'works'}">active</c:if>"><a href="${ctx}/works">作品管理</a></li>
					<li class="<c:if test="${menu eq 'style'}">active</c:if>"><a href="${ctx}/style">作品风格管理</a></li>
					<li class="<c:if test="${menu eq 'special'}">active</c:if>"><a href="${ctx}/special">页面管理</a></li>
					<li class="<c:if test="${menu eq 'appointment-photographer'}">active</c:if>"><a href="${ctx}/appointment/photographer">摄影师预约</a></li>
					<li class="<c:if test="${menu eq 'appointment-special'}">active</c:if>"><a href="${ctx}/appointment/special">活动预约</a></li>
					<li class="<c:if test="${menu eq 'properties'}">active</c:if>"><a href="${ctx}/properties">属性管理</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${ctx}/logout">退出登录</a></li>
					<li><a href="${ctx}/reset">修改密码</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<div class="container manager-container">
		<t:insertAttribute name="content"/>
	</div>
	<script type="text/javascript" src="${jsPath}/js/jquery.form.js?${jsVersion}"></script>
	<script type="text/javascript" src="${jsPath}/js/studio-manager.js${jsVersion}"></script>
</body>