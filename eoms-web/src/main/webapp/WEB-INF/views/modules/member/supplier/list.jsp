<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>供应商管理</title>
	<meta name="decorator" content="default"/>
	<%@include file="/WEB-INF/views/include/treetable.jsp" %>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#treeTable").treeTable({expandLevel : 3}).show();
			//详情
			$('.view_btn').click(function() {
				var code = $(this).attr("data-code");
				
				// 正常打开	
				top.$.jBox.open("iframe:${ctx}/member/supplier/form?code="+code+"&isView="+true,"客户详情", 680, 420,{//宽高
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
					} /* 信息关闭后执行的函数 */
				});
		    });
		});
	</script>
</head>
<body>
<div class="container">
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/member/supplier/">供应商列表</a></li>
		<shiro:hasPermission name="member:supplier:edit"><li><a href="${ctx}/member/supplier/form">供应商添加</a></li></shiro:hasPermission>
	</ul>
	<tags:message content="${message}"/>
	<form id="listForm" method="post">
		<table id="treeTable" class="table table-striped table-bordered table-condensed hide">
			<thead><tr><th>名称</th><th>供应商编码</th><th style="text-align:center;">联系电话</th>
			<th style="text-align:center;">邮箱</th>
			<th style="text-align:center;">传真</th>
			<th style="text-align:center;">结算方式</th>
			<th style="text-align:center;">T周期</th>
			<th style="text-align:center;">状态</th>
			<th>操作</th></tr></thead>
			<tbody>
			<c:forEach items="${list}" var="item">
				<tr id="${item.code}">
					<td title="${item.supplyName}"><a class="view_btn" data-code="${item.code}">${item.supplyName}</a></td>
					<td> ${item.supplyCode } </td>
					<td style="text-align:center;"> ${item.tel } </td>
					<td style="text-align:center;"> ${item.email } </td>
					<td style="text-align:center;"> ${item.fax } </td>
					<td style="text-align:center;">
						<c:forEach items="${payTypes}" var="p">
							<c:choose> 
								<c:when test="${p.value == item.payType}">${p.chName}</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:forEach>
					</td>
					<td style="text-align:center;"> 
						<c:choose>
							<c:when test="${!item.payType eq '4' }">${item.accountDays }</c:when>
							<c:otherwise>--</c:otherwise>
						</c:choose>
					
					 </td>
					<td> 
						<c:if test="${item.status=='0'}">启用</c:if>
						<c:if test="${item.status=='1'}">停用</c:if>
					</td>
					<shiro:hasPermission name="member:supplier:edit"><td nowrap>
						<a href="${ctx}/member/supplier/form?code=${item.code}">修改</a>
						<c:if test="${item.status=='0'}">
								<a href="${ctx}/member/supplier/status?code=${item.code}&status=1" onclick="return confirmx('确定停用供应商吗？', this.href)">停用</a>
						</c:if>
						<c:if test="${item.status=='1'}">
								<a href="${ctx}/member/supplier/status?code=${item.code}&status=0" onclick="return confirmx('确定启用供应商吗？', this.href)">启用</a>
						</c:if>
					</td></shiro:hasPermission>
				</tr>
			</c:forEach></tbody>
		</table>
	 </form>
	 </div>
</body>
</html>