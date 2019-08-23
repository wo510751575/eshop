<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>会员特权申请管理</title>
	<meta name="decorator" content="default"/>
	
	<style>
		.img-div > div{float:left;margin-left:3px;}
	</style>
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
		<li><a href="${ctx}/member/memberRankApply/">会员特权申请列表</a></li>
		<li class="active"><a href="${ctx}/member/memberRankApply/form?code=${data.code}">会员特权申请<shiro:hasPermission name="content:wshopinfo:edit">${not empty data.code?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="content:wshopinfo:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form id="inputForm"  action="${ctx}/member/memberRankApply/${not empty data.code?'edit':'save'}" method="post" class="form-horizontal">
		<input type="hidden" name="code" value="${data.code}">
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">特权名称:</label>
			<div class="controls">
				<input type="text" name="name" value="${data.name}" maxlength="50" class="required input-xlarge" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">租凭权限（如：5000以下，<br/>存储5000）:</label>
			<div class="controls">
				<input type="text" name="amount" value="${data.amount}" maxlength="50" class="required input-xlarge number" />
			</div>
		</div>
	 	<div class="control-group">
			<label class="control-label">穿戴次数:</label>
			<div class="controls">
				<input type="text" name="scale" value="${data.scale}" maxlength="10" class="input-xlarge number" />
				<span class="help-inline"><font color="#7b7b7b">0为无数次</font> </span>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">描述</label>
			<div class="controls">
				<%-- <input type="text" name="remark" value="${data.remark}" maxlength="250" class="input-xlarge" /> --%>
				<textarea name="remark" >${data.remark}</textarea>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">录入时间:</label>
			<div class="controls">
				 <input id="billStart" name="createDate" readonly="readonly" type="text"  maxlength="20" class="input-mini Wdate"
				value="<fmt:formatDate value="${data.createDate}" pattern="yyyy-MM-dd"/>" />
				<span class="help-inline"><font color="#555">*系统内容不可修改</font> </span>
			</div>
		</div>
		 
		<div class="form-actions">
			<%-- <shiro:hasPermission name="content:wshopinfo:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			</shiro:hasPermission> --%>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form>
	</div>
</body>
</html>