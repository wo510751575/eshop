<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>店铺风格管理</title>
	<meta name="decorator" content="default"/>
	<script src="${ctxStatic}/palette-color-picker/palette-color-picker.js" type="text/javascript"></script>
	<link rel="stylesheet" href="${ctxStatic}/palette-color-picker/palette-color-picker.css">
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
			
			  $('#unique-id').paletteColorPicker({
			    insert: 'after', // default -> 'before'
			    timeout: 2000000,
			    position: 'downside',  // upside | downside
			  });
		});
	</script>
	<style type="text/css">
		.palette-color-picker-bubble {
			position: absolute;
		}
		.palette-color-picker-button{
			position: static;
			width: 26px;
    		height: 26px;
    		margin-top:1px;
		}
		.palette-color-picker-bubble.downside{
			top:18%;
			bottom:none;
		}
	</style>
</head>
<body>
<div class="container">
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/shop/style/list">店铺风格列表</a></li>
		<li class="active"><a href="${ctx}/shop/style/form?code=${data.code}">店铺风格<shiro:hasPermission name="shop:style:edit">${not empty data.code?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="shop:style:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form id="inputForm"  action="${ctx}/shop/style/${not empty data.code?'edit':'save'}" method="post" class="form-horizontal">
		<input type="hidden" name="code" value="${data.code}">
		<tags:message content="${message}"/>
		
		<div class="control-group">
			<label class="control-label">店铺风格名称:</label>
			<div class="controls">
				<input type="text" id="name" name="name" value="${data.name}" maxlength="50" class="required input-xlarge" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">店铺风格:</label>
				<div class="controls">
					<input type="text" style="float:left;" id="unique-id" name="spe" data-palette="[&quot;#D50000&quot;,&quot;#304FFE&quot;,&quot;#00B8D4&quot;,&quot;#69F0AE&quot;,&quot;#FFFF00&quot;]" value="${data.spe}">
				</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否启用:</label>
			<div class="controls">
				<label><input id="roleIdList1" name="status" type="checkbox" value="0" <c:if test="${data.status eq '0'}">checked="checked"</c:if>>启用</label>
				<span class="help-inline">勾选启用</span>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="shop:style:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form>
	</div>
</body>
</html>