<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>供应商管理</title>
	<meta name="decorator" content="default"/>
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
				},
				rules:{ 
                	discountOff:{
                        range:[0,100]
                    }                    
                } 
			});
		});
	</script>
</head>
<body>
<div class="container">
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/member/supplier/">供应商列表</a></li>
		<li class="active"><a href="${ctx}/member/supplier/form?code=${data.code}">供应商<shiro:hasPermission name="member:supplier:edit">${not empty data.code?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="member:supplier:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form id="inputForm"  action="${ctx}/member/supplier/${not empty data.code?'edit':'save'}" method="post" class="form-horizontal">
		<input type="hidden" name="code" value="${data.code}">
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">供应商名称:</label>
			<div class="controls">
				<input type="text" name="supplyName" value="${data.supplyName}" maxlength="50" class="required input-xlarge" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">供应商编码:</label>
			<div class="controls">
				<input type="text" name="supplyCode" value="${data.supplyCode}" maxlength="50" class="required input-xlarge" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
	 	<div class="control-group">
			<label class="control-label">联系方式:</label>
			<div class="controls">
				<input type="text" name="tel" value="${data.tel}" maxlength="50" class="required input-xlarge" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">email:</label>
			<div class="controls">
				<input type="text" name="email" value="${data.email}" maxlength="50" class="required email input-xlarge" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">状态:</label>
			<div class="controls">
			<c:choose>
				<c:when test="${data.status=='1' }">
					<label><input name="status" type="radio" value="0" />启用 </label> 
					<label><input name="status" type="radio" value="1" checked="checked" />停用 </label> 
				</c:when>
				<c:otherwise>
					<label><input name="status" type="radio" value="0" 
					checked="checked"/>启用 </label> 
					<label><input name="status" type="radio" value="1" />停用 </label> 
				</c:otherwise>
			</c:choose>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">传真:</label>
			<div class="controls">
				<input type="text" name="fax" value="${data.fax}" maxlength="50" class="required input-xlarge" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<!-- /** 0:周结 1：双周结 2：月结 3：季度结 4：T+N*/ -->
		<div class="control-group">
			<label class="control-label">结算方式:</label>
			<div class="controls">
				<select name="payType" class="required">
					<option></option>
					<c:forEach items="${payTypes}" var="p">
						<c:choose >
							<c:when test="${p.value eq data.payType}">
								<option value="${p.value }" selected="selected">${p.chName}</option>
							</c:when>
							<c:otherwise><option value="${p.value }">${p.chName}</option></c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
    	<div class="control-group">
			<label class="control-label">结算周期（T的N）:</label>
			<div class="controls">
				<input type="text" name="accountDays" value="${(empty data.accountDays)?0:data.accountDays}" maxlength="50" class="digits required input-xlarge" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
 		<div class="control-group">
			<label class="control-label">结算银行卡号:</label>
			<div class="controls">
				<input type="text" name="bankNo" value="${data.bankNo}" maxlength="20" class="required input-xlarge" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">结算银行卡所属银行:</label>
			<div class="controls"> 
				<select name="bankName" class="required">
					<option></option>
					<c:forEach items="${bankCodes}" var="p">
						<c:choose >
							<c:when test="${p eq data.bankName}">
								<option value="${p}" selected="selected">${p.text}</option>
							</c:when>
							<c:otherwise><option value="${p }">${p.text}</option></c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>   
	 	<div class="control-group">
			<label class="control-label">银行卡户主名:</label>
			<div class="controls">
				<input type="text" name="bankAccName" value="${data.bankAccName}" maxlength="64" class="required input-xlarge" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">银行卡分行名:</label>
			<div class="controls">
				<input type="text" name="bankBranch" value="${data.bankBranch}" maxlength="64" class="required input-xlarge" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">供应商整体折扣:</label>
			<div class="controls">
				<input type="text" id="discountOff" name="discountOff" value="${data.discountOff}" class="required  digits input-xlarge" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">账单开始日期:</label>
			<div class="controls">
			<input id="billStart" name="billStart" type="text"  maxlength="20" class="input-mini Wdate"
				value="<fmt:formatDate value="${data.billStart}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">供应商地址:</label>
			<div class="controls">
				<input type="text" name="addrs" value="${data.addrs}" maxlength="50" class="required input-xlarge" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<textarea  name="remarks" maxlength="128" class="input-xlarge" >${data.remarks}</textarea>
			</div>
		</div>
  
	 
		<div class="form-actions">
			<shiro:hasPermission name="member:supplier:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form>
	</div>
</body>
</html>