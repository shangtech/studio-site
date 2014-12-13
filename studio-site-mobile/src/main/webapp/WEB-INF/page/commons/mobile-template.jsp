<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
	<title>哥哥的手机站点</title>
	
	<!-- jquery & mobile -->
	<script type="text/javascript" src="http://cdn.bootcss.com/jquery/1.9.0/jquery.min.js"></script>
	<script src="http://cdn.bootcss.com/jquery-mobile/1.4.2/jquery.mobile.min.js"></script>
    <!--<link href="http://cdn.bootcss.com/jquery-mobile/1.4.2/jquery.mobile.min.css" rel="stylesheet">-->
	
	<!-- local  -->
	<script src="${ctx}/js/mobile-js.js"></script>
	<link href="${ctx}/css/jquery.mobile-1.4.2.css" rel="stylesheet">
	<link href="${ctx}/css/mobile-css.css" rel="stylesheet">
	
    <script type="text/javascript">
    var ctx = '${ctx}';
    var imagePath = '${imagePath}';
    var jsPath = '${jsPath}';
    var cssPath = '${cssPath}';
    </script>
</head>
<body class="ui-mobile-viewport ui-overlay-a" style="zoom:1;">
    <section data-role="page" id="first" data-theme="a" data-url="first" tabindex="0" class="ui-page ui-page-theme-a ui-page-active" style="min-height: 667px;">
    	<header class="iHeader" id="iHeader">
	    	<img src="${ctx}/images/newLogo.png" onclick="location.href='${ctx}/'" class="iNewLogo">
	        <p class="iCity">北京</p>
	        <p class="iOrderText"><span>911</span>人预约摄影师</p>
	        <nav class="iMainNav">
	        	<div class="iMainNavBox" id="iMainNavBox">
	            	<span></span>
	                <span></span>
	                <span></span>
	            </div>
	        </nav>
	        <div id="iNavListBox" class="iNavListBox">
	            <ul class="navlist">
	                <li><a href="${ctx}/" data-ajax="false" class="isy ui-link">首页</a></li>
	                <li><a href="${ctx}/photographer" data-ajax="false" class="isys ui-link">摄影师</a></li>
	                <li><a href="${ctx}/works" data-ajax="false" class="izp ui-link">作品</a></li>
	                <li><a href="${ctx}/" data-ajax="false" class="ius ui-link">联系我们</a></li>
	            </ul>
	        </div>
        </header>
        <article class="warpBox">
     	    <t:insertAttribute name="content" />
     	</article>
    </section>
</body>
</html>