<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp"%>
<article class="warpBox">
    <div class="dSysInformation">
        <div class="dOrderNums">预约次数<span>${photographer.appointments}</span></div>
        <div class="clear">
            <div class="dSysInformationLeft">
                <img src="${imagePath}/${photographer.image}">
            </div>
            <div class="dSysInformationRight">
                <h1>${photographer.name}</h1>
                <div class="dSysCost">
                	<p class="dSysTeamCost">团队服务费<span>￥${photographer.price}</span>/天</p>
                    <p>${photographer.members}</p>
                </div>
                <p class="dYears">从业<span>${photographer.experience}</span>年</p>
            </div>
        </div>
        <p class="dIntroduction">${photographer.description}</p>
    </div>
    <div class="dRecommend">
       	<h1>【推荐】${recommend.name}</h1>
        <div class="dPhotoBox dPhotoBox1">
        	${recommend.pageContent}
        </div>
	</div>
    <div class="dWorksBox">
        <h1>老黑的作品</h1>
			<div class="dWorksWarp"><!-- 摄影师有多套作品的时候显示此div -->
				<c:forEach items="${works}" var="item">
				<div class="dWorks">
					<a href="/theme/themeDetail/160" data-ajax="false" class="ui-link"><img src="${imagePath}/${item.image}"></a>
                    <div class="dWorksTitle clear">
                    	<h2>${item.name}</h2>
                        <div class="dWorksTitleRight clear">
                        	<span class="dSite">${item.address}</span>
                            <span class="dLike">${item.hearts}</span>
                        </div>
                    </div>
                </div>
                </c:forEach>
			</div>
	</div>
	<div id="footerbtn" class="iTel clear">
        <a data-ajax="false" href="${ctx}/appointment?url=${photographer.url}" class="zxyy ui-link">在线预约</a>
    </div>
</article>