<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp"%>
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