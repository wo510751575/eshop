<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>退货管理</title>
	<meta name="decorator" content="default"/>
	<%@include file="/WEB-INF/views/include/treetable.jsp" %>
	<script type="text/javascript">
	$(document).ready(function() {
		$(".jjBtn").click(function(){
			 var code=$(this).attr("data-code");
			 promptx("请输入拒绝原因", "拒绝原因",function(){
		    	  var txt=top.$("#txt").val();
		    	  confirmx("是否确认审核拒绝？", "${ctx}/order/retire/status?code="+code+"&auditStatus=2&failReason="+txt);
			 });
		  });
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
		<li class="active"><a href="${ctx}/order/retire/list">退货列表</a></li>
	</ul>
	<form id="searchForm" action="${ctx}/order/retire/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
		    <li><label>订单号：</label>
		    	<input type="text" name="param.likeOrderNo" value="${orderRetireParam.likeOrderNo}" class="input-medium" maxlength="100" placeholder="订单号">
			</li>
			<li><label>审核状态：</label>
				<select style="width: 177px;" name="param.auditStatus">
                    <option value="">全部</option>
                    <c:forEach items="${auditStatus}" var="item">
						<option value="${item.value}"<c:if test="${item.value eq orderRetireParam.auditStatus}">selected="selected"</c:if>>${item.chName}</option>
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
				<th>退单号</th>
				<th>类型</th>
				<th>快递单号</th>
				<th>快递公司</th>
				<th>审核状态</th>
				<th>审核人</th>
				<th>失败原因</th>
				<th>申请时间</th>
				<shiro:hasPermission name="order:retire:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody id="infolist">
		<c:forEach items="${page.list}" var="item" varStatus="number"> 
			<tr>
			    <td>
			    	<a  href="${ctx}/order/retire/view?code=${item.code}" >${item.orderNo}</a>
				</td>
				<td>
			    	${item.retireNo}
				</td>
				<td>
			    	<c:forEach items="${orderRetireTypes}" var="sta">
						<c:if test="${sta.value eq item.type}">${sta.chName}</c:if>
					</c:forEach>
				</td>
				<td>
			    	${item.expressNo}
				</td>
				<td>
					${item.expressName}
				</td>
				<td>
					<c:forEach items="${auditStatus}" var="sta">
						<c:if test="${sta.value eq item.auditStatus}">${sta.chName}</c:if>
					</c:forEach>
				</td>
				<td>
			    	${item.auditor}
				</td>
				<td>
			    	${item.failReason}
				</td>
				<td>
			    	<fmt:formatDate value="${item.createTime }" pattern="yyyy-MM-dd"/>
				</td>
				<td nowrap>
					<a  href="${ctx}/order/retire/view?code=${item.code}" >详情</a>
					<shiro:hasPermission name="order:retire:edit">
						<!-- 待审核 -->
						<c:if test="${item.auditStatus eq '0'}">
							<a href="${ctx}/order/retire/status?code=${item.code}&auditStatus=1" onclick="return confirmx('确定审核通过吗？', this.href)">审核通过</a>
							<a href="javascript:;"  class="jjBtn" data-code="${item.code}" >审核拒绝</a>
						</c:if>
					</shiro:hasPermission>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
 </div>
</body>
</html>