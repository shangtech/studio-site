<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp"%>
<article class="warpBox">
    <div class="dSysInformation">
        <div class="dOrderNums">预约次数<span>${photographer.appointments}</span></div>
        <div class="clear">
            <div class="dSysInformationLeft">
                <img src="http://image.onlylover.com/201408/19/image_14084469728707_240_240.jpg">
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
       	<h1>【推荐】1天个性化拍摄服务</h1>
			            <p class="dPrice">总价：3699元</p>
            <div class="dProjectCost">
            	<div class="clear">
                	<span>团队服务费：4对一服务</span>
                    <i>2600/天</i>
                </div>
            </div>
            <div class="dPhotoBox dPhotoBox1">
            	<h2>服装造型：5套【200+品牌服装任你挑】<span class="free">免费</span></h2>
                <img src="/m/images/new112401.png">
            </div>
            <div class="dPhotoBox dPhotoBox1 clear">
            	<div class="dPhotoBoxLeft1">化妆造型：</div>
                <div class="dPhotoBoxRight1">整体形象设计5组造型，免费使用香奈儿化妆品，免费使用时尚仿真睫毛，免费使用摄影专用配饰。</div>
            </div>
            <div class="dPhotoBox dPhotoBox1">
            	<h2>拍摄地：30+拍摄地，想去哪拍都可以</h2>
                <img src="/m/images/new112402.png">
            </div>            
            <div class="dPhotoBox">
            	<h2>相框相册<span>【相框相册可以自由组合购买】</span></h2>
                <div class="dPhoto clear">
                    <div class="dPhotoImg"><img src="/m/images/new111803.png"></div>
                    <div class="dPhotoRight clear">
                    	<div class="dPhotoRightLeft">爵士相册</div>
                    	<div class="dPhotoRightRight">
                        	<p>15寸<span>1本</span><i>239元</i></p>
							<p>18寸<span>1本</span><i>319元</i></p>
                        </div>    
                    </div>
                </div>
                <div class="dPhoto clear">
                    <div class="dPhotoImg"><img src="/m/images/new111804.png"></div>
                    <div class="dPhotoRight clear">
                        <div class="dPhotoRightLeft">大韩水晶放大相框</div>
                        <div class="dPhotoRightRight">
                             <p class="dan">36寸<span>1幅</span><i>306元</i></p>
                        </div>    
                    </div>
                </div>
                <div class="dPhoto clear">
                    <div class="dPhotoImg"><img src="/m/images/new111805.png"></div>
                    <div class="dPhotoRight clear">
                        <div class="dPhotoRightLeft">弧形闪粉桌摆</div>
                        <div class="dPhotoRightRight">
                            <p>7寸 &nbsp;<span>1件</span><i>72元</i></p>
                            <p>10寸<span>1件</span><i>103元</i></p>
                        </div>    
                    </div>
                </div>
            </div>
            <div class="dPhotoChild clear">
            	<p>婚礼海报一幅</p>
                <span>60元</span>
            </div>
            <div class="dPhotoChild clear">
            	<p>照片数：200张(底片全送)</p>
            </div>
            <div class="dPhotoChild clear">
            	<p>精修数量：48张 (加购 20元/张)</p>
            </div>
            <div class="dRemarks">
            	<h2>服务备注</h2>
                <p>1、拍摄过程中所产生的拍摄费用（例如：车费、门票、午餐等费用）由客户承担。</p>
                <p>2、以上定制组合为推荐内容，单项（服装、相框相册）均可进店调整，根据您喜欢的产品自由定制。</p>
                <a href="/index/Guarantee" data-ajax="false" class="ui-link"><img src="/m/images/new112404.png"></a>
            </div>
	</div>
    <div class="dWorksBox">
        <h1>老黑的作品</h1>
			<div class="dWorksWarp"><!-- 摄影师有多套作品的时候显示此div -->
				<c:forEach items="${works}" var="item">
				<div class="dWorks">
					<a href="/theme/themeDetail/160" data-ajax="false" class="ui-link"><img src="http://image.onlylover.com/201409/29/image_14119581495274_325_217.jpg"></a>
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
        <a data-ajax="false" href="/theme/rob/133/92" class="zxyy ui-link">在线预约</a>
        <a data-ajax="false" href="http://qiao.baidu.com/v3/?module=default&amp;controller=im&amp;action=index&amp;ucid=7522785&amp;type=n&amp;siteid=5940394" class="iOnline ui-link">在线客服</a>
    </div>
</article>