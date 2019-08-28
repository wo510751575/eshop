<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>微商加油站管理</title>
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
				top.$.jBox.open("iframe:${ctx}/content/wshopinfo/form?code="+code+"&isView="+true,"微商加油站详情", 800, 560,{//宽高
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
		<li class="active"><a href="${ctx}/content/wshopinfo/">微商加油站列表</a></li>
		<shiro:hasPermission name="content:wshopinfo:edit"><li><a href="${ctx}/content/wshopinfo/form">微商加油站添加</a></li></shiro:hasPermission>
	</ul>
		<form id="searchForm" action="${ctx}/content/wshopinfo/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
		    <li><label>标题：</label>
		    	<input type="text" name="title" value="${wshopInfoPage.title}" class="input-medium" maxlength="100" placeholder="标题">
			</li>
			
 			<li> 
 				<label>录入时间：</label> 
 				<input id="beginDate" name="startTime" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate"
 				value="<fmt:formatDate value="${wshopInfoPage.startTime}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true});"/> 
				<input id="endDate" name="endTime" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate" 
 				value="<fmt:formatDate value="${wshopInfoPage.endTime}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true});"/>&nbsp;&nbsp; 
 			</li> 
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form>
	<tags:message content="${message}"/>
		<table id="treeTable" class="table table-striped table-bordered table-condensed hide">
			<thead><tr>
			<th>标题</th>
			<th>概要</th>
			<th>阅读量</th>
			<th>状态</th>
			<th>录入时间</th>
			<th>操作</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${page.list}" var="item">
				<tr id="${item.code}">
					<td title="${item.title}"><a href="${ctx}/content/wshopinfo/form?code=${item.code}">${item.title}</a></td>
					<td> ${item.flagInfo } </td>
					<td> ${item.readCnt} </td>
					<td> 
						<c:if test="${item.status==0}">发布</c:if>
						<c:if test="${item.status==1}">下架</c:if>
					</td>
					<td> <fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd"/></td>
					<shiro:hasPermission name="content:wshopinfo:edit"><td nowrap>
						<a href="${ctx}/content/wshopinfo/form?code=${item.code}">修改</a>
						<c:if test="${item.status=='0'}">
								<a href="${ctx}/content/wshopinfo/status?code=${item.code}&status=1" onclick="return confirmx('确定要下架吗？', this.href)">下架</a>
						</c:if>
						<c:if test="${item.status=='1'}">
								<a href="${ctx}/content/wshopinfo/status?code=${item.code}&status=0" onclick="return confirmx('确定要发布吗？', this.href)">发布</a>
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