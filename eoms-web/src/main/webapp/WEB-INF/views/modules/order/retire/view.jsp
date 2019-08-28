<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>退货退货订单详情</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
		});
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
		<li><a href="${ctx}/order/retire/list">退货订单列表</a></li>
		<li class="active"><a>退货订单详情</a></li>
	</ul><br/>

	<form:form id="inputForm" modelAttribute="user" action="${ctx}/sys/user/info" method="post" class="form-horizontal">
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">订单号:</label>
			<div class="controls">
			     <label class="lbl">${data.orderNo}</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">退货订单号:</label>
			<div class="controls">
			     <label class="lbl">${data.retireNo}</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">快递单号:</label>
			<div class="controls">
				<label class="lbl">${data.expressNo}</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">快递公司:</label>
			<div class="controls">
				<label class="lbl">${data.expressName}</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<label class="lbl">${data.remarks}</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">退货订单状态:</label>
			<div class="controls">
				<label class="lbl">
					<c:forEach items="${auditStatus}" var="status">
						<c:if test="${status.value eq data.auditStatus}">${status.chName}</c:if>
					</c:forEach>
				</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">审核人:</label>
			<div class="controls">
				<label class="lbl">${data.auditor}</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">失败原因:</label>
			<div class="controls">
				<label class="lbl">${data.failReason}</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">退货单金额:</label>
			<div class="controls">
				<label class="lbl">${data.amt}</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">下单时间:</label>
			<div class="controls">
				<label class="lbl">
					<fmt:formatDate value="${data.createTime }" pattern="yyyy-MM-dd"/>
				</label>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</div>	
</body>
</html>