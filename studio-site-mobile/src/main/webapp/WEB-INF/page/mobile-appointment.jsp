<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp"%>
<style type="text/css">
.sumbitBtn{ padding:4.5em 2em;}
.sumbitBtn h1{ font-size:2em; font-weight:100; line-height:2em;}
.sumbitBtn input{ height:2.5em; font-size:2em;}
.submitbtn{ display:block; width:100%; height:2.5em; line-height:2.5em; font-size:2em; color:#fff; background-color:#ea3057; text-align:center; margin:0.5em 0;}
.sumbitBtn h2{ font-size:2em; font-weight:100; line-height:2em; text-align:center; color:#ea3057; margin-bottom:2em;}
.sumbitBtn p{ font-size:1.4em; line-height:1.5em; color:#666; margin-top:0.2em;}
.submitbtn span{ margin:0 0.5em;}
.sryzm{ float:left; width:45%;}
.code{float:left; text-align:right; margin:0.5em 0 0 5%; width:50%; text-align:center;}
.code a{ display:block; font-size:1.4em; color:#c2984f; background-color:#fff1ae; padding:1.2em 0.3em; border-radius:0.5em; width:100%;}
.sumbitBtn .submitTel{ color:#d3063c; text-indent:1.4em;}
.sYHtitle{ border-top:1px dashed #999; border-bottom:1px dashed #999; padding:1em 0; margin:1em 0; text-align:center; font-size:1.6em;}
.sumbitBtn .sYHP{ text-align:center; margin:0;}
.sumbitBtn .sYHP span{ color:#ca093d;}
.sYHimg{ margin:1em auto;}
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
	<div class="ui-body-inherit ui-corner-all ui-shadow-inset">
		<input type="text" id="name" placeholder="输入联系人姓名">
	</div>
	<div class="ui-body-inherit ui-corner-all ui-shadow-inset">
		<input type="tel" id="tel" placeholder="输入联系电话">
	</div>
	<a href="javascript:;" id="submitbtn" class="submitbtn ui-link">免费预约<span>${requsetInfo.name}</span>的拍摄服务</a>
    <p>1、预约成功后，顾问将向您致电，邀请您进店挑选服装、相框相册，并沟通具体的拍摄内容。</p>
    <p>2、您可以直接拨打电话进行预约。</p>
    <a href="tel:${telphone}" class="ui-link"><p class="submitTel">电话：${telphone}</p></a>
</div>
<div style="display:none;" class="request-info-id">${requsetInfo.id}</div>
<div style="display:none;" class="from-page">${fromPage}</div>

<script type="text/javascript">
	$(document).on("pagebeforecreate", function() {
		//alert("触发 pagebeforecreate 事件！");
		$("#submitbtn").on("click", function() {
			onSubmit();
		});
	});
	
	function onSubmit(){
		id=$(".request-info-id").html();
		from=$(".from-page").html();
		name=jQuery("#name").val();
		tel=jQuery("#tel").val();
		
		if(name =="") {
			alert("姓名不能为空！"); 
			return false;
		}
		if(tel =="") {
			alert("手机号码不能为空！"); 
			return false;
		}
		if(!tel.match(/^(1[358]{1}[0-9])[0-9]{4}([0-9]{4})$/)){
			alert("手机号码格式不正确！"); 
			return false;
		}
		//alert(name);
		jQuery.ajax({
			url: ctx + '/appointment/save',
			type:'POST',
			//async:false,
			dataType:'json',
			//table 表名 field 字段 code 编号值
			data:{mobile:tel,purpose:id,appointmentType:from,memo:name},
			success:function(data){
				if(data.id==0){
					// 成功 
					window.location.href= ctx + '/appointment/result';
					return true;
				}
			    alert("保存失败，请重试！");
				return false;
			}
		});
	}
</script>