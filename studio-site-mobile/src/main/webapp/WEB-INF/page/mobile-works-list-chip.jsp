<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:forEach items="${pagination.items}" var="item">
	<div class="dWorks" onclick="location.href='${ctx}/works/${item.url}';">
		<img src="http://image.onlylover.com/201408/25/image_14089577863468_240_240.jpg">
		<div class="dWorksTitle clear">
			<h2>${item.name}</h2>
			<div class="dWorksTitleRight clear">
				<span class="dWorker">${item.author}<i>作品</i></span>
				<span class="dSite">${item.address}</span>
			    <span class="dLike">${item.hearts}</span>
			</div>
		</div>
	</div>
</c:forEach>
