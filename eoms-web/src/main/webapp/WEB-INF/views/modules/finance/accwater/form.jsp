<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>账户流水管理</title>
	<meta name="decorator" content="default"/>
	
	<style>
		.img-div > div{float:left;margin-left:3px;}
		.warn{color:red}
	</style>
	<script type="text/javascript" src="${ctxStatic}/editor/kindeditor.js"></script>
	<script type="text/javascript" src="${ctxStatic}/editor/init.js"></script>
	<script src="${ctxStatic}/common/plupload.full.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
	
	
</head>
<body>
<div class="container">
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/finance/accwater/">账户流水列表</a></li>
		<li class="active"><a href="${ctx}/finance/accwater/form?code=${data.code}">账户流水<shiro:hasPermission name="content:wshopinfo:edit">${not empty data.code?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="content:wshopinfo:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form id="inputForm"  action="${ctx}/finance/accwater/${not empty data.code?'edit':'save'}" method="post" class="form-horizontal">
		<input type="hidden" name="code" value="${data.code}">
		
		<tags:message content="${message}"/>
		<c:if test="${!empty data}">
			<div class="control-group">
				<label class="control-label">流水单号:</label>
				<div class="controls">
					${data.accWaterNo}
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">记帐日期:</label>
				<div class="controls">
					<fmt:formatDate value="${data.accDate}" pattern="yyyy-MM-dd"/>
				</div>
			</div>
		</c:if>
		
	 	<div class="control-group">
			<label class="control-label">流水来源:</label>
			<div class="controls">
				<span>
					<select class="selectEnum" name="accSource">
	                    <option value="">全部</option>
	                    <c:forEach items="${accwatersource}" var="item">
							<option value="${item.value}"
								<c:if test="${item.value eq param.accSource}">selected="selected"</c:if> >${item.chName}</option>
						</c:forEach>
                	</select>
				</span>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">交易订单号:</label>
			<div class="controls">
				<input type="text" name="tranOrderNo" value="${data.tranOrderNo}" maxlength="100" class="input-xlarge" /> 
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">金额:</label>
			<div class="controls">
				<input type="text" name="amt" value="${data.amt}" maxlength="50" class="input-xlarge number" /> 
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">账户编号:</label>
			<div class="controls">
				<input type="text" name="accNo" value="${data.accNo}" maxlength="50" class="input-xlarge" /> 
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">流水状态:</label>
			<div class="controls">
				<select class="selectEnum"  name="status">
                    <option value="">全部</option>
                    <c:forEach items="${statuss}" var="item">
						<option value="${item.value}"
							<c:if test="${item.value eq data.status}">selected="selected"</c:if> >${item.chName}</option>
					</c:forEach>
                </select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">支付方式:</label>
			<div class="controls">
				<select class="selectEnum"  name="payType">
                    <option value="">全部</option>
                    <c:forEach items="${accwaterpaytype}" var="item">
						<option value="${item.value}"
							<c:if test="${item.value eq data.payType}">selected="selected"</c:if> >${item.chName}</option>
					</c:forEach>
                </select>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">期初之前的金额:</label>
			<div class="controls">
				<input type="text" name="beforeAmt" value="${data.beforeAmt}" maxlength="50" class="input-xlarge number" /> 
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">期末之前的金额:</label>
			<div class="controls">
				<input type="text" name="afterAmt" value="${data.afterAmt}" maxlength="50" class="input-xlarge number" /> 
			</div>
			<div  class="controls warn">请慎重填写，该值将会更新帐户的余额 </div>
		</div>
		
		<div class="control-group">
			<label class="control-label">流水业务类型:</label>
			<div class="controls">
				<select class="selectEnum"  name="bizType">
                    <option value="">全部</option>
                    <c:forEach items="${accwaterbiztype}" var="item">
						<option value="${item.value}"
							<c:if test="${item.value eq data.bizType}">selected="selected"</c:if> >${item.chName}</option>
					</c:forEach>
                </select> 
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">账户流水类型:</label>
			<div class="controls">
				<select class="selectEnum"  name="waterType">
                    <option value="">全部</option>
                    <c:forEach items="${accwatertype}" var="item">
						<option value="${item.value}"
							<c:if test="${item.value eq data.waterType}">selected="selected"</c:if> >${item.chName}</option>
					</c:forEach>
                </select>
			</div>
		</div>
		
		 
		<div class="form-actions">
			<shiro:hasPermission name="content:wshopinfo:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form>
	</div>
	
</body>
</html>