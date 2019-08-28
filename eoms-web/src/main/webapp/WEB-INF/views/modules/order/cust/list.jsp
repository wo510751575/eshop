<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>定制订单</title>
	<meta name="decorator" content="default"/>
	<%@include file="/WEB-INF/views/include/treetable.jsp" %>
	<script type="text/javascript">
	$(document).ready(function() {
		
	});
		function page(n, s) {
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
			return false;
		}
	</script>
<style type="text/css">
.container {
	padding: 20px 30px;
	width: 100%;
	min-height: 800px;
	background: #fff;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
}

.page_header {
	font-size: 32px;
	font-weight: normal;
	line-height: 1;
	padding-bottom: 40px;
	color: #666;
}
.nav-tabs > li > a {
    padding-top: 0px;
}
</style>
</head>
<body>
<div class="container">
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/order/cust/list">定制订单列表</a></li>
	</ul>
	<form id="searchForm" action="${ctx}/order/cust/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
		    <li><label>订单号：</label>
		    	<input type="text" name="orderNo" value="${param.orderNo}" class="input-medium" maxlength="100" placeholder="订单号">
			</li>
			<li><label>订单状态：</label>
				<select style="width: 177px;" name="status">
                    <option value="">全部</option>
                    <c:forEach items="${status}" var="item">
						<option value="${item.value}"<c:if test="${item.value eq param.status}">selected="selected"</c:if>>${item.chName}</option>
					</c:forEach>
                </select>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>订单号</th>
				<th>定制描述</th>
				<th>图片</th>
				<th>订单状态</th>
				<th>售价</th>
				<th>定制时间</th>
				<%-- <shiro:hasPermission name="order:retire:edit"><th>操作</th></shiro:hasPermission> --%>
			</tr>
		</thead>
		<tbody id="infolist">
		<c:forEach items="${page.list}" var="item" varStatus="number"> 
			<tr>
			    <td>
			    	${item.orderNo}
				</td>
				<td>
			    	${item.remarks}
				</td>
				<td>
			    	<img alt="" src="${fns:getUploadUrl()}${item.img1}" width="50px" height="50px" > 
				</td>
				<td>
					<c:forEach items="${status}" var="sta">
						<c:if test="${sta.value eq item.status}">${sta.chName}</c:if>
					</c:forEach>
				</td>
				<td>
			    	${item.orgPrice}
				</td>
				<td>
			    	<fmt:formatDate value="${item.createTime }" pattern="yyyy-MM-dd"/>
				</td>
				<%-- <shiro:hasPermission name="order:retire:edit"><td nowrap> --%>
					<!-- 待审核 -->
					<%-- <c:if test="${item.auditStatus eq '0'}">
						<a href="${ctx}/order/retire/status?code=${item.code}&auditStatus=1" onclick="return confirmx('确定审核通过吗？', this.href)">审核通过</a>
						<a href="javascript:;"  class="jjBtn" data-code="${item.code}" >审核拒绝</a>
					</c:if>
				</td></shiro:hasPermission> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
 </div>
</body>
</html>