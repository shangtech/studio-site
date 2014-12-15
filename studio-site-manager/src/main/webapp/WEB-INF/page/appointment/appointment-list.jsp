<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp"%>
<div class="row">
	<div class="col-sm-3">
		<c:if test="${not empty list}">
		<div class="list-group">
			<c:forEach items="${list}" var="item">
			<a href="${ctx}/appointment/${type}/${item.id}" class="list-group-item<c:if test="${item.id eq id}"> active</c:if>">${item.name}</a>
			</c:forEach>
		</div>
		</c:if>
	</div>
	<div class="col-sm-9">
		<c:if test="${not empty pagination.items}">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>电话</th>
					<th>提交时间</th>
					<th>预约对象</th>
					<th>备注</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pagination.items}" var="item">
				<tr>
					<td>${item.mobile}</td>
					<td>${item.createTime}</td>
					<td>${item.target.name}</td>
					<td>${item.memo}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:if>
		<c:if test="${pagination.totalPage gt 1}">
		<div class="row">
			<div class="col-sm-12">
				<ul class="pagination pull-right">
					<c:if test="${pagination.isFirst}">
						<li class="disabled"><a href="javascript:;">上一页</a></li>
					</c:if>
					<c:if test="${not pagination.isFirst}">
						<li><a href="?pageNo=${pagination.pageNo-1}">上一页</a></li>
					</c:if>
					<c:forEach begin="1" end="${pagination.totalPage}" var="i">
						<c:choose>
							<c:when test="${(i eq 1) or ((i gt pagination.pageNo-4 or i gt pagination.totalPage-10) and (i lt pagination.pageNo+4 or i lt 10)) or (i eq pagination.totalPage)}">
								<li${pagination.pageNo eq i ? ' class="active"' : ''}><a href="?pageNo=${i}">${i}</a></li>
							</c:when>
							<c:otherwise>
								<c:if test="${(i eq 2) or (i eq pagination.totalPage-1)}">
									<li><a>...</a></li>
								</c:if>
							</c:otherwise>
						</c:choose>
					</c:forEach>
			        <c:if test="${pagination.isLast}">
						<li class="disabled"><a href="javascript:;">下一页</a></li>
					</c:if>
					<c:if test="${not pagination.isLast}">
						<li><a href="?pageNo=${pagination.pageNo+1}">下一页</a></li>
					</c:if>
		      	</ul>
		    </div>
		</div>
		</c:if>
	</div>
</div>