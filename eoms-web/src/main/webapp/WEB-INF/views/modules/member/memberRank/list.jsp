<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>会员特权管理</title>
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
				top.$.jBox.open("iframe:${ctx}/member/memberRank/form?code="+code+"&isView="+true,"会员特权详情", 680, 360,{//宽高
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
		<li class="active"><a href="${ctx}/member/memberRank/">会员特权列表</a></li>
		<shiro:hasPermission name="member:memberRank:edit"><li><a href="${ctx}/member/memberRank/form">会员特权添加</a></li></shiro:hasPermission>
	</ul>
		<form id="searchForm" action="${ctx}/member/memberRank/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
		    <li><label>名称：</label>
		    	<input type="text" name="param.name" value="${findmemberRankPage.param.name}" class="input-medium" maxlength="100" placeholder="标题">
			</li>
			
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form>
	<tags:message content="${message}"/>
		<table id="treeTable" class="table table-striped table-bordered table-condensed hide">
			<thead><tr>
			<th>特权名称</th>
			<th>租凭权限</th>
			<th>穿戴次数</th>
			<th>顺序</th>
			<th>录入时间</th>
			<th>操作</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${page.list}" var="item">
				<tr id="${item.code}">
					<td title="${item.name}">${item.name}</td>
					<td>
						<fmt:formatNumber value="${item.amount}" pattern="##00.00#"/>
					</td>
					<td> ${item.scale} </td>
					<td> ${item.seq} </td>
					<td> <fmt:formatDate value="${item.createDate}" pattern="yyyy-MM-dd"/></td>
					<shiro:hasPermission name="member:memberRank:edit"><td nowrap>
						<a href="${ctx}/member/memberRank/form?code=${item.code}">修改</a>
						<a href="${ctx}/member/memberRank/delete?code=${item.code}" onclick="return confirmx('确定要删除吗？', this.href)">删除</a>
					</td>
					</shiro:hasPermission>
				</tr>
			</c:forEach></tbody>
		</table>
		<div class="pagination">${page}</div>
	
	 </div>
</body>
</html>