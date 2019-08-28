<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>会员特权申请管理</title>
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
				top.$.jBox.open("iframe:${ctx}/member/memberRankApply/form?code="+code+"&isView="+true,"会员特权申请详情", 680, 360,{//宽高
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
		<li class="active"><a href="${ctx}/member/memberRankApply/">会员特权申请列表</a></li>
		<%-- <shiro:hasPermission name="member:memberRankApply:edit"><li><a href="${ctx}/member/memberRankApply/form">会员特权申请添加</a></li></shiro:hasPermission> --%>
	</ul>
		<form id="searchForm" action="${ctx}/member/memberRankApply/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>会员名称：</label>
		    	<input type="text" name="param.memberName" value="${findMemberRankApplyPage.param.memberName}" class="input-medium" maxlength="100" placeholder="标题">
			</li>
			
		    <li><label>审核状态：</label>
				<select class="selectEnum" name="param.status">
                    <option value="">全部</option>
                    <c:forEach items="${statuss}" var="item">
						<option value="${item.value}"
							<c:if test="${item.value eq findMemberRankApplyPage.param.status}">selected="selected"</c:if> >${item.chName}</option>
					</c:forEach>
                </select>
			</li>
			
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form>
	<tags:message content="${message}"/>
		<table id="treeTable" class="table table-striped table-bordered table-condensed hide">
			<thead>
			<tr>
			<th>会员code</th>
			<th>会员名称</th>
			<th>申请特权</th>
			<th>申请时间</th>
			<th>审核时间</th>
			<th>审核状态</th>
			<th>操作</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${page.list}" var="item">
				<tr id="${item.code}">
					<td title="${item.memberCode}">${item.memberCode}</td>
					<td >${item.memberName}</td>
					<td >${item.memberRankName}</td>
					<td> <fmt:formatDate value="${item.applyTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
					<td> <fmt:formatDate value="${item.approveTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td> 
						<c:forEach items="${statuss}" var="p">
							<c:choose> 
								<c:when test="${p.value == item.status}">${p.chName}</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:forEach>
					</td>
					<!--为空或者空才允许审核-->
						<shiro:hasPermission name="member:memberRankApply:edit">
							<c:choose> 
									<c:when test="${(empty item.status) or (item.status eq 0)}">
										<td nowrap>
										<a href="${ctx}/member/memberRankApply/status?code=${item.code}&status=1" onclick="return confirmx('确定已打款标记为审核通过吗？<br/>将无法修改，请谨慎操作', this.href)">审核通过</a>
										<a href="${ctx}/member/memberRankApply/status?code=${item.code}&status=2" onclick="return confirmx('确定要审核不通过吗？将无法修改，请谨慎操作', this.href)">审核不通过</a>
										</td>
									</c:when>
									<c:otherwise>
										<td nowrap>
										</td>
									</c:otherwise>
							</c:choose>
						</shiro:hasPermission>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<div class="pagination">${page}</div>
	
	 </div>
</body>
</html>