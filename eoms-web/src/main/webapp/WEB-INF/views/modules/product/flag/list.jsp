<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商品标签管理</title>
	<meta name="decorator" content="default"/>
	<%@include file="/WEB-INF/views/include/treetable.jsp" %>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#treeTable").treeTable({expandLevel : 3}).show();
		});
		//跳页
		function page(n, s) {
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
			return false;
		}
	</script>
</head>
<body>
<div class="container">
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/product/flag/">商品标签列表</a></li>
		<shiro:hasPermission name="product:flag:edit"><li><a href="${ctx}/product/flag/form" >商品标签添加</a></li></shiro:hasPermission>
	</ul>
		<form id="searchForm" action="${ctx}/product/flag/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
		    <li><label>标签名称：</label>
		    	<input type="text" name="param.productFlag" value="${reqParam.param.productFlag}" class="input-medium" maxlength="100" placeholder="商品标签名称">
			</li>
			<li><label>状态：</label>
				<select style="width: 177px;" name="param.status">
                    <option value="">全部</option>
                    <c:forEach items="${statuss}" var="item">
						<option value="${item.value}"
							<c:if test="${item.value eq reqParam.param.status}">selected="selected"</c:if>>${item.chName}</option>
					</c:forEach>
                </select>
			</li>
			<li><label>类型：</label>
				<select style="width: 177px;" name="param.flagType">
                    <option value="">全部</option>
                    <c:forEach items="${flagTypes}" var="item">
						<option value="${item.value}"
							<c:if test="${item.value eq reqParam.param.flagType}">selected="selected"</c:if>>${item.chName}</option>
					</c:forEach>
                </select>
			</li>
		 	<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form>
	<tags:message content="${message}"/>
		<table id="treeTable" class="table table-striped table-bordered table-condensed hide">
			<thead><tr>
				<th>标签名称</th> 
				<th>标签图标</th>
				<th>状态</th>
				<th>卡位</th>
				<th>类型</th>
				<th>TAB栏商品展示数量</th>
				<th>录入时间</th>
				<th>操作</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${page.list}" var="item">
				<tr id="${item.code}">
					<td title="${item.productFlag}"><a>${item.productFlag}</a></td>
					<td >
						<img src="${fns:getDictValue('上传路径前缀', 'uploadUrl', 'http://192.168.6.60/')}${item.imageUrl}" width="40" height="40"> 
					</td>
					<td>  
						<c:forEach items="${statuss}" var="p">
							<c:choose> 
								<c:when test="${p.value == item.status}">${p.chName}</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:forEach>
					</td>
					<td>  
						 ${item.productSeq }
					</td>
					<td>  
						<c:forEach items="${flagTypes}" var="p">
							<c:choose> 
								<c:when test="${p.value == item.flagType}">${p.chName}</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:forEach>
					</td>
					<td>  
						 ${item.showCnt }
					</td>
					<td> <fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd"/></td>
					<shiro:hasPermission name="product:flag:edit"><td nowrap>
						<a href="${ctx}/product/flag/form?code=${item.code}">修改</a>
						<c:if test="${item.status=='0'}">
								<a href="${ctx}/product/flag/status?code=${item.code}&status=1" onclick="return confirmx('确定停用商品标签吗？', this.href)">停用</a>
						</c:if>
						<c:if test="${item.status=='1'}">
								<a href="${ctx}/product/flag/status?code=${item.code}&status=0" onclick="return confirmx('确定启用商品标签吗？', this.href)">启用</a>
						</c:if>
					</td>
					</shiro:hasPermission>
				</tr>
			</c:forEach></tbody>
		</table>
		<div class="pagination">${page}</div>
	
	 </div>
</body>
</html>