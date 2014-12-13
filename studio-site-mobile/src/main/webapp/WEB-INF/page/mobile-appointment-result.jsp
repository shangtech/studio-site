<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp"%>
<style type="text/css">
/* 预约成功页面*/
.successTitle{ width:5em; font-size:1.6em; background:url(../images/new2014120402.png) no-repeat left center; padding-left:2em; margin:4em auto 1.5em;}
.successP{ font-size:1.6em; text-align:center; color:#999;}
.gbIndex{ display:block; height:3em; line-height:3em; font-size:1.6em; text-align:center; margin-top:2em; color:#d3063c; border:1px solid #d3063c; border-radius:0.5em;}
@media only screen and (min-width: 320px){
	.code{ width:12em;}
}
@media only screen and (min-width: 375px){
	.code{ width:15em;}
}
@media only screen and (min-width: 414px){
	.code{ width:18em;}
}
</style>
<div class="sumbitBtn">
	<h1 class="successTitle">预约成功</h1>
	<p class="successP">你的专属顾问会在12小时内与您取得联系</p>
	<p class="successP">约您进店沟通拍摄详细，幸福一刻从此开始!</p>
	<a href="${ctx}/" data-ajax="false" class="gbIndex ui-link">返回首页</a>
</div>