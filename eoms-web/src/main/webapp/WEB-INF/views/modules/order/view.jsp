<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>订单详情</title>
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
		<li><a href="${ctx}/order/order">订单列表</a></li>
		<li class="active"><a href="${ctx}/order/order/view?code=${data.code}">订单详情</a></li>
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
			<label class="control-label">下单人姓名:</label>
			<div class="controls">
				<label class="lbl">${data.mbrName}</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">下单人手机号:</label>
			<div class="controls">
				<label class="lbl">${data.mbrPhone}</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">店铺名称:</label>
			<div class="controls">
				<label class="lbl">${data.shopName}</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">收货人姓名:</label>
			<div class="controls">
				<label class="lbl">${data.revicerName}</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">收货人电话:</label>
			<div class="controls">
				<label class="lbl">${data.revicePhone}</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否需要发票:</label>
			<div class="controls">
				<label class="lbl">
					<c:forEach items="${invoices}" var="status">
						<c:if test="${status.value eq data.isInvoice}">${status.chName}</c:if>
					</c:forEach>
				</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">发票抬头:</label>
			<div class="controls">
				<label class="lbl">${data.invoiceTitle}</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">发票明细:</label>
			<div class="controls">
				<label class="lbl">${data.invoiceInfo}</label>
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
			<label class="control-label">订单状态:</label>
			<div class="controls">
				<label class="lbl">
					<c:forEach items="${orderStatus}" var="status">
						<c:if test="${status.value eq data.status}">${status.chName}</c:if>
					</c:forEach>
				</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">支付方式:</label>
			<div class="controls">
				<label class="lbl">
					<c:forEach items="${payTypes}" var="pay">
						<c:if test="${pay.value eq data.payType}">${pay.chName}</c:if>
					</c:forEach>
				</label>
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