<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商品分类管理</title>
	<meta name="decorator" content="default"/>
	<%@include file="/WEB-INF/views/include/treetable.jsp" %>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#treeTable").treeTable({expandLevel : 3}).show();
		});
    	function updateSort() {
			loading('正在提交，请稍等...');
	    	$("#listForm").attr("action", "${ctx}/product/catalog/updateSort");
	    	$("#listForm").submit();
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
		<li class="active"><a href="${ctx}/product/catalog/">商品分类列表</a></li>
		<shiro:hasPermission name="product:catalog:edit"><li><a href="${ctx}/product/catalog/form">商品分类添加</a></li></shiro:hasPermission>
	</ul>
	<tags:message content="${message}"/>
	<form id="listForm" method="post">
		<table id="treeTable" class="table table-striped table-bordered table-condensed hide">
			<thead><tr><th>分类名称</th><th>分类缩略图</th><th style="text-align:center;">排序</th><th>操作</th></tr></thead>
			<tbody>
			<c:forEach items="${list}" var="item">
				<tr id="${item.code}" pId="${item.parentCatalogCode ne '1'?item.parentCatalogCode:'0'}">
					<td title="${item.catalogName}"><a href="${ctx}/product/catalog/form?code=${item.code}">${item.catalogName}</a></td>
					<td>
						<c:if test="${item.parentCatalogCode ne '1'}">
							<img src="${fns:getUploadUrl()}${item.imageUrl}" width="40" height="40">
						</c:if>
					</td>
					<td style="text-align:center;">${item.orderNo}</td>
					<shiro:hasPermission name="product:catalog:edit"><td nowrap>
						<a href="${ctx}/product/catalog/form?code=${item.code}">修改</a>
						<a href="${ctx}/product/catalog/delete?code=${item.code}" onclick="return confirmx('要删除该商品分类及所有子商品分类项吗？', this.href)">删除</a>
						<a href="${ctx}/product/catalog/form?parentCatalogCode=${item.code}">添加下级商品分类</a> 
					</td></shiro:hasPermission>
				</tr>
			</c:forEach></tbody>
		</table>
<%-- 		<shiro:hasPermission name="product:catalog:edit"><div class="form-actions pagination-left"> --%>
<!-- 			<input id="btnSubmit" class="btn btn-primary" type="button" value="保存排序" onclick="updateSort();"/> -->
<%-- 		</div></shiro:hasPermission> --%>
	 </form>
	 </div>
</body>
</html>