<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>卖家素材管理</title>
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
				top.$.jBox.open("iframe:${ctx}/marketing/material/form?code="+code+"&isView="+true,"卖家素材详情", 800, 560,{//宽高
					id:9527,
					draggable: true,
					showClose: true,
					buttons:{},		//去除按钮
					iframeScrolling: 'yes',
					loaded:function(h){
						top.$('.jbox-container .jbox-title-panel').css("height","35px").css('background','#376EA5');
						top.$('.jbox-container .jbox-title').css('line-height','35px').css("color","#ffffff");
					},
					closed: function () { 
					} /* 信息关闭后执行的函数 */
				});
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
</head>
<body>
<div class="container">
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/marketing/material/">卖家素材列表</a></li>
		<%-- <shiro:hasPermission name="marketing:material:edit"><li><a href="${ctx}/marketing/material/form">卖家素材添加</a></li></shiro:hasPermission> --%>
	</ul>
		<form id="searchForm" action="${ctx}/marketing/material/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
		    <li><label>标题：</label>
		    	<input type="text" name="param.title" value="${materialPage.param.title}" class="input-medium" maxlength="100" placeholder="标题">
			</li>
			
 			<li> 
 				<label>录入时间：</label> 
 				<input id="beginDate" name="startTime" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate"
 				value="<fmt:formatDate value="${materialPage.startTime}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true});"/> 
				<input id="endDate" name="endTime" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate" 
 				value="<fmt:formatDate value="${materialPage.endTime}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true});"/>&nbsp;&nbsp; 
 			</li> 
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form>
	<tags:message content="${message}"/>
		<table id="treeTable" class="table table-striped table-bordered table-condensed hide">
			<thead><tr>
			<th>标题</th>
			<th>商品编码</th>
			<th>分享次数</th>
			<th>会员名称</th>
			<!-- <th>商户代码</th> -->
			<th>状态</th>
			<th>录入时间</th>
			<th>操作</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${page.list}" var="item">
				<tr id="${item.code}">
					<td title="${item.title}"><a href="${ctx}/marketing/material/form?code=${item.code}">${item.title}</a></td>
					<td> ${item.productCode } </td>
					<td> ${item.shareCnt} </td>
					<td> ${item.mbrName} </td>
					<%-- <td> ${item.merchantCode} </td> --%>
					<td> 
						<c:if test="${item.status eq 0}">启用</c:if>
						<c:if test="${item.status eq 1}">停用</c:if>
					</td>
					<td> <fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd"/></td>
					<shiro:hasPermission name="marketing:material:edit"><td nowrap>
						<%-- <a href="${ctx}/marketing/material/form?code=${item.code}">修改</a> --%>
						<a href="${ctx}/marketing/material/biztype?code=${item.code}" onclick="return confirmx('确定要加入官方精选？', this.href)">加入官方精选</a>
					</td>
					</shiro:hasPermission>
				</tr>
			</c:forEach></tbody>
		</table>
		<div class="pagination">${page}</div>
	
	 </div>
</body>
</html>