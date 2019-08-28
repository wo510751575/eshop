<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>公用素材管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$(".copyBtn").click(function(){
				$(this).attr("data-clipboard-text",window.location.href+"/viewH5?code="+$(this).attr("data-code"));
			})
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
		<style type="text/css">
	.container{
	padding: 10px 30px;
    width: 100%;
    min-height: 800px;
    background: #fff;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
	}
	</style>
</head>
<body>
<div class="container">
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/marketing/materialcommon/">公用素材列表</a></li>
		<shiro:hasPermission name="marketing:materialcommon:edit">
			<li><a href="${ctx}/marketing/materialcommon/form">公用素材添加</a></li>
			<%-- <li><a href="${ctx}/marketing/materialcommon/setting">公用素材模板</a></li> --%>
		</shiro:hasPermission>
	</ul>
	<form id="searchForm" action="${ctx}/marketing/materialcommon/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>商品名称：</label>
				<input type="text" name="productName" class="input-medium" maxlength="100" placeholder="商品名称" value="${productName}">
			</li>
			<%-- <li><label style="width:110px">素材类型名称：</label>
				<select name="param.materialTypeCode" id="materialTypeCode" >
			 			<option value="">全部</option>
			 			<c:forEach items="${materialType }" var="item">
			 			<option value="${item.code}" <c:if test="${item.code eq findMaterialReturnPage.param.materialTypeCode}">selected="selected"</c:if> >${item.typeName}</option>
			 			</c:forEach>
					 </select>
			</li> --%>
			
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>标题</th>
<!--				<th>分享次数</th>
 				<th>缩略图</th>
				<th>素材类型名称</th> -->
				<th>商品名称</th>
<%--				<th>门店名称</th>
 				<th>门店类型</th>
				<th>网址链接</th> --%>
				<shiro:hasPermission name="business:material:edit">
				<th>操作</th>
				</shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="item" varStatus="number"> 
			<tr>
				<td>
				<a href="${ctx}/marketing/materialcommon/form?code=${item.code}&&tempId=${item.tempId}&cmMaterialCode=${item.cmMaterialCode}">${item.title}</a>					
				</td>
				<%--<td>
					${item.respondNum}
				</td> 
				<td>
					${item.materialTypeName}
				</td>--%>
				<td>${item.productName}</td>
				<%--<td>
					<c:forEach items="${productList}" var="item2">
			 			<c:if test="${item.productCode eq item2.code}">${item2.name}</c:if>
			 		</c:forEach>
				</td>
				<td>${item.shopName}</td>
				<td>${item.shopType}</td>
			    <td>
			    	<c:if test="${empty item.linkUrl}">
						<a href="${ctx}/marketing/materialcommon/view?code=${item.code}" target="_black">查看链接</a>
					</c:if>
					<c:if test="${not empty item.linkUrl}">
						<a href="${item.linkUrl}" target="_black">查看链接</a>
					</c:if>
				</td>--%>
				<shiro:hasPermission name="marketing:materialcommon:edit">
				<td>
					<%--<a href="${ctx}/marketing/materialcommon/del?code=${item.code}" onclick="return confirmx('确定删除吗？', this.href)">删除</a>--%>
					<a class="copyBtn" href="javascript:;" data-clipboard-text="" data-code="${item.code}">复制链接</a>
					<a href="${ctx}/marketing/materialcommon/view?code=${item.code}" target="_black">预览</a>
					<a href="${ctx}/marketing/materialcommon/form?code=${item.code}&&tempId=${item.tempId}">修改</a>
				</td>
				</shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
	
	<script type="text/javascript" src="${ctxStatic}/common/clipboard.min.js"></script>
	<script>
    var clipboard = new Clipboard('.copyBtn');

    clipboard.on('success', function(e) {
    	showTip("已将链接复制到粘贴板","info");
    });

    clipboard.on('error', function(e) {
        console.log(e);
    });
    </script>
</div>	
</body>
</html>