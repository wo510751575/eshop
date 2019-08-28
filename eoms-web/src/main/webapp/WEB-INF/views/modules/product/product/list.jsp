<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商品管理</title>
	<meta name="decorator" content="default"/>
	<%@include file="/WEB-INF/views/include/treetable.jsp" %>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#treeTable").treeTable({expandLevel : 3}).show();
		});
		$(document).ready(function() {
			//详情
			$('.view_btn').click(function() {
				var code = $(this).attr("data-code");
				
				// 正常打开	
				/* top.$.jBox.open("iframe:${ctx}/product/product/form?code="+code+"&isView="+true,"商品详情", 680, 360,{//宽高
					id:9527,
					draggable: true,
					showClose: true,
					buttons:{},		//去除按钮
					iframeScrolling: 'no',
					loaded:function(h){
						top.$('.jbox-container .jbox-title-panel').css("height","35px").css('background','#376EA5');
						top.$('.jbox-container .jbox-title').css('line-height','35px').css("color","#ffffff");
					},
					closed: function () { 
					} // 信息关闭后执行的函数
				}); */
		    });
		});
		//跳页
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
		<li class="active"><a href="${ctx}/product/product/">商品列表</a></li>
		<shiro:hasPermission name="product:product:edit"><li><a href="${ctx}/product/product/form" >商品添加</a></li></shiro:hasPermission>
	</ul>
		<form id="searchForm" action="${ctx}/product/product/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
		    <li><label>商品名称：</label>
		    	<input type="text" name="param.name" value="${reqParam.param.name}" class="input-medium" maxlength="100" placeholder="商品名称">
			</li>
			<li><label>状态：</label>
				<select style="width: 177px;" name="param.status">
                    <option value="">全部</option>
                    <c:forEach items="${prodcutStatuss}" var="item">
						<option value="${item.value}"
							<c:if test="${item.value eq reqParam.param.status}">selected="selected"</c:if>>${item.chName}</option>
					</c:forEach>
                </select>
			</li>
			<li><label>商品类目：</label>
			  <tags:treeselect id="catalog" name="param.catalogTypeCode" value="${productCatalog.code}" 
                labelName="parentCatalogName" allowClear="true" labelValue="${productCatalog.catalogName}"
					title="商品分类" url="/product/catalog/treeData" extId="${productCatalog.code}" cssClass="required"/>
			</li>
			
			<li>
				<label>供应商：</label>
				<select name="param.supplyCode">
					<option></option>
						<c:forEach items="${supplys}" var="p">
								<c:choose >
									<c:when test="${p.code eq reqParam.param.supplyCode}">
										<option value="${p.code }" selected="selected">${p.supplyName}</option>
									</c:when>
									<c:otherwise><option value="${p.code }">${p.supplyName}</option></c:otherwise>
								</c:choose>
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
				<th>商品名称</th>
				<th>icon</th>
				<th>供应商</th> 
				<th>状态</th>
				<th>商品类目</th>
				<th>库存</th>
				<th>已售数量</th>
				<th>录入时间</th>
				<th>操作</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${page.list}" var="item">
				<tr id="${item.code}">
					<td title="${item.name}"><a class="view_btn" data-code="${item.code}">${item.name}</a></td>
					<td>
						<c:if test="${!empty item.productIcon }">
							<img src="${fns:getUploadUrl()}${item.productIcon } " width="60" height="60"/>
						</c:if>
					</td>
					<td>${item.supplyName}</td>
					<td>  
						<c:forEach items="${prodcutStatuss}" var="p">
							<c:choose> 
								<c:when test="${p.value == item.status}">${p.chName}</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:forEach>
					</td>
					<td>  
						 ${item.catalog.parentCatalogName }-
						 ${item.catalog.catalogName }
					</td>
					<td>  
						 ${item.cnt }
					</td>
					<td>  
						 ${item.saleCnt }
					</td>
					<td> <fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd"/></td>
					<shiro:hasPermission name="product:product:edit"><td nowrap>
						<a href="${ctx}/product/product/form?code=${item.code}">修改</a>
						<c:if test="${item.status=='0'}">
								<a href="${ctx}/product/product/status?code=${item.code}&status=1" onclick="return confirmx('确定下架商品吗？', this.href)">下架</a>
						</c:if>
						<c:if test="${item.status=='1'}">
								<a href="${ctx}/product/product/status?code=${item.code}&status=0" onclick="return confirmx('确定上架商品吗？', this.href)">上架</a>
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