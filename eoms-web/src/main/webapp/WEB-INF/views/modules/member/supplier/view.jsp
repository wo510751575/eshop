<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>供应商详情</title>
	<meta name="decorator" content="default"/>
</head>
<body>
<div class="container" style="padding-left: 5px;">
		<div style="width: 50%;float: left;padding-bottom: 10px;padding-top: 10px; border-bottom: 1px solid #ccc ;">
			<label  style="width:140px; float: left;font-weight: bold;">供应商名称:</label>
			<div class="controls" style="float: left;">
				 ${data.supplyName}
			</div>
		</div>
		<div style="width: 50%;float: left;padding-bottom: 10px;padding-top: 10px; border-bottom: 1px solid #ccc ;">
			<label style="width:140px; float: left;font-weight: bold;"> 供应商编码:</label>
			<div class="controls">
				 ${data.supplyCode} 
			</div>
		</div>
	 	<div style="width: 50%;float: left;padding-bottom: 10px;padding-top: 10px; border-bottom: 1px solid #ccc ;">
			<label style="width:140px; float: left;font-weight: bold;">联系方式:</label>
			<div class="controls">
				 ${data.tel}
			</div>
		</div>
		<div style="width: 50%;float: left;padding-bottom: 10px;padding-top: 10px; border-bottom: 1px solid #ccc ;">
			<label style="width:140px; float: left;font-weight: bold;">email:</label>
			<div class="controls">
				${data.email}
			</div>
		</div>
		<div style="width: 50%;float: left;padding-bottom: 10px;padding-top: 10px; border-bottom: 1px solid #ccc ;">
			<label style="width:140px; float: left;font-weight: bold;">状态:</label>
			<div class="controls">
			<c:choose>
				<c:when test="${data.status=='1' }">
					停用
				</c:when>
				<c:otherwise>
					启用 
				</c:otherwise>
			</c:choose>
			</div>
		</div>

		<div style="width: 50%;float: left;padding-bottom: 10px;padding-top: 10px; border-bottom: 1px solid #ccc ;">
			<label style="width:140px; float: left;font-weight: bold;">传真:</label>
			<div class="controls">
				${data.fax}
			</div>
		</div>
		<!-- /** 0:周结 1：双周结 2：月结 3：季度结 4：T+N*/ -->
		<div style="width: 50%;float: left;padding-bottom: 10px;padding-top: 10px; border-bottom: 1px solid #ccc ;">
			<label style="width:140px; float: left;font-weight: bold;">结算方式:</label>
			<div class="controls">
					<c:forEach items="${payTypes}" var="p">
						<c:choose >
							<c:when test="${p.value eq data.payType}">
								${p.chName}
							</c:when>
						</c:choose>
					</c:forEach>
			</div>
		</div>
    	<div style="width: 50%;float: left;padding-bottom: 10px;padding-top: 10px; border-bottom: 1px solid #ccc ;">
			<label style="width:140px; float: left;font-weight: bold;">结算周期（T的N）:</label>
			<div class="controls">
				${(empty data.accountDays)?0:data.accountDays}
			</div>
		</div>
 		<div style="width: 50%;float: left;padding-bottom: 10px;padding-top: 10px; border-bottom: 1px solid #ccc ;">
			<label style="width:140px; float: left;font-weight: bold;">结算银行卡号:</label>
			<div class="controls">
				${data.bankNo}
			</div>
		</div>
		<div style="width: 50%;float: left;padding-bottom: 10px;padding-top: 10px; border-bottom: 1px solid #ccc ;">
			<label style="width:140px; float: left;font-weight: bold;">结算银行卡所属银行:</label>
			<div class="controls"> 
					<c:forEach items="${bankCodes}" var="p">
						<c:choose >
							<c:when test="${p eq data.bankName}">
								${p.text}
							</c:when>
						</c:choose>
					</c:forEach>
			</div>
		</div>   
	 	<div style="width: 50%;float: left;padding-bottom: 10px;padding-top: 10px; border-bottom: 1px solid #ccc ;">
			<label style="width:140px; float: left;font-weight: bold;">银行卡户主名:</label>
			<div class="controls">
				${data.bankAccName}
			</div>
		</div>
		<div style="width: 50%;float: left;padding-bottom: 10px;padding-top: 10px; border-bottom: 1px solid #ccc ;">
			<label style="width:140px; float: left;font-weight: bold;">银行卡分行名:</label>
			<div class="controls">
				${data.bankBranch}
			</div>
		</div>
		<div style="width: 50%;float: left;padding-bottom: 10px;padding-top: 10px; border-bottom: 1px solid #ccc ;">
			<label style="width:140px; float: left;font-weight: bold;">供应商整体折扣:</label>
			<div class="controls">
				${data.discountOff}
			</div>
		</div>
		<div style="width: 50%;float: left;padding-bottom: 10px;padding-top: 10px; border-bottom: 1px solid #ccc ;">
			<label style="width:140px; float: left;font-weight: bold;">账单开始日期:</label>
			<div class="controls">
			<fmt:formatDate value="${data.billStart}" pattern="yyyy-MM-dd"/>
			</div>
		</div>

		<div style="width: 100%;float: left;padding-bottom: 10px;padding-top: 10px; border-bottom: 1px solid #ccc ;">
			<label style="width:140px; float: left;font-weight: bold;">供应商地址:</label>
				<div class="controls">
					${data.addrs}
				</div>
		</div>

		<div style="width: 100%;float: left;padding-bottom: 10px;padding-top: 10px; border-bottom: 1px solid #ccc ;">
			<label style="width:140px; float: left;font-weight: bold;">备注:</label>
			<div class="controls">
				${data.remarks}
			</div>
		</div>
	</div>
</body>
</html>