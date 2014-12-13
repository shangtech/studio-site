// JavaScript Document
$(window).on("load", function(event) {
	center();
});
$(document).on("pageinit", "#pageone", function() {
	// 此处是 jQuery 事件...
});

function center() {
	var tWidth = $(".dDetailsTitleP").width();
	$("p.dDetailsTitleP").css({
		"width" : tWidth + "px",
		"margin-left" : (-(tWidth / 2)) + "px",
		"left" : 50 + "%"
	});
	var tWidth1 = $(".dDetailsTitleP1").outerWidth(true);
	$(".dDetailsTitleP1").css({
		"width" : tWidth1 + "px",
		"margin-left" : (-(tWidth1 / 2)) + "px",
		"left" : 50 + "%"
	});
}

$(function() {
	// 样片欣赏导航切换
	var navLi = $("#aAppNav").children("li");
	navLi.on("tap", function() {
		$(this).addClass("aChecked").siblings().removeClass("aChecked");
	});

	// 摄影师档期选择
	(function() {
		var sYearsBtn = $("#sYearsBtn");
		var sDate = $("#sDate");
		var sDateList = $("#sDateList");
		var sDateLi = sDateList.children("li");
		var sDateLeft = null;
		$(document).on("tap", function() {
			sDateList.hide();
		});
		sDateLi.on("tap", function() {
			if (!$(this).hasClass("sDisable")) {
				$(this).addClass("sClick").siblings().removeClass("sClick");
				sDateList.hide();
				sDateLeft = $(this).children().children(".sDateLeft").html();// 获取当前点击的日期
				sDate.html(sDateLeft);// 设置选中的日期
				// 设置选中时间的键名 赵永丹
				jQuery("input[name=surplus]").val(
						$(this).children().children(".sDateLeft").attr('ref'));
				jQuery(".sYears").css("border", "");
			}
			return false;
		});

		sYearsBtn.on("tap", function() {
			sDateList.show();
			return false;
		});
	})();
	// 服装图片切换
	(function() {
		var tabNum = 0;
		var tabLi = $("#dSecondImgUl").children("li");
		var imgNum = $("#imgNum");
		var imgZ = $("#imgZ");
		var dSecondImgList = tabLi.find(".dSecondImgList");
		var dSecondImg = tabLi.find(".dSecondImgList").children("img");
		var docW = $(window).width();
		var docH = $(window).height();
		dSecondImgList.css({
			"width" : docW + "px",
			"height" : docH + "px",
			"overflow" : "hidden"
		});
		dSecondImg.css({
			"width" : docW + "px",
			"height" : (docW * 2) / 3 + "px"
		});

		// 横竖屏切换
		$(window).on("orientationchange", function(event) {
			docW = $(window).width();
			docH = $(window).height();
			dSecondImgList.css({
				"width" : docW + "px",
				"height" : docH + "px",
				"overflow" : "hidden"
			});
			dSecondImg.css({
				"width" : docW + "px",
				"height" : (docW * 2) / 3 + "px"
			});
		});
		imgZ.html(tabLi.length);
		imgNum.html(1);
		tabLi.on("swipeleft", function(event) {
			tabNum++;
			if (tabNum > tabLi.length - 1) {
				tabNum = 0;
			}
			dressImg();
			event.preventDefault()// 阻止浏览器默认行为
		})

		tabLi.on("swiperight", function(event) {
			tabNum--;
			if (tabNum < 0) {
				tabNum = tabLi.length - 1;
			}
			dressImg();
			event.preventDefault()// 阻止浏览器默认行为
		})

		function dressImg() {
			tabLi.eq(tabNum).fadeIn().siblings().hide();
			imgNum.html(tabNum + 1);
		}

		// 遮罩层显示隐藏
		var dMask = $("#dMask");
		$("#dSecondImgUl").on("tap", function() {
			dMask.toggle();
		});
	})();

	var dMask = $("#dMask").find(".dBack");
	$("#dMask").on("tap", function(event) {
		event.stopPropagation();
	});

	// 2014.11.19 作品列表页风格筛选导航 更多风格
	var more = $("#more");
	var moreListNav = $("#moreListNav");
	more.on("tap", function() {
		moreListNav.toggleClass("show");
		return false;
	});

	// 2014.11.19 导航
	var iMainNavBox = $("#iMainNavBox");
	var first = $("#first");// 主体
	var iHeader = $("#iHeader");// 导航
	var footerbtn = $("#footerbtn");// 底部
	var iNavListBox = $("#iNavListBox");
	iMainNavBox.on("click", function() {
		iNavListBox.height($(window).height())
		if (iNavListBox.is(":hidden")) {
			iNavListBox.show()
			first.css("left", -50 + "%");
			iHeader.css("left", -50 + "%");
			footerbtn.css("left", -50 + "%");
		} else {
			iNavListBox.hide()
			first.css("left", 0);
			iHeader.css("left", 0);
			footerbtn.css("left", 0);
		}
	});

	var sSysList = $("#sSysList");
	sSysList.on("scrollstart", "li", function() {
		$(this).css("background-color", "#ddd").siblings().css(
				"background-color", "#fff");
	});

});