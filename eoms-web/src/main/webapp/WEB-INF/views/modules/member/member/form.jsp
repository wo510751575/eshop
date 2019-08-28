<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>客户管理</title>
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
				}
			});
		});
	</script>
</head>
<body>
<div class="container">
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/member/member/">客户列表</a></li>
		<li class="active"><a href="${ctx}/member/member/form?code=${data.code}">客户<shiro:hasPermission name="member:member:edit">${not empty data.code?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="member:member:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form id="inputForm"  action="${ctx}/member/member/${not empty data.code?'edit':'save'}" method="post" class="form-horizontal">
		<input type="hidden" name="code" value="${data.code}">
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">客户名称:</label>
			<div class="controls">
				<input type="text" name="name" value="${data.name}" maxlength="50" class="required input-xlarge" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">头像:</label>
			<div class="controls">
				<c:choose>
						<c:when test="${!empty data.avotor }">
							<c:choose>
								<c:when test="${fn:startsWith(data.avotor, 'http')}">
	   								<img  width="40" height="40"  src="${data.avotor}" alt="">
								</c:when>
								<c:otherwise>
									<img width="40" height="40"  src="${fns:getUploadUrl()}${data.avotor}" alt="">
								</c:otherwise>
			    			</c:choose>
						</c:when>
						<c:otherwise>无头像</c:otherwise>
					</c:choose>
				
				<%-- <input type="text" name="avotor" value="${data.avotor}" maxlength="50" class="input-xlarge" /> --%>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">客户微信号:</label>
			<div class="controls">
				<c:choose>
					<c:when test="${empty data.wxNo}">
						<input type="text" name="wxNo" value="${data.wxNo}" maxlength="50" class="input-xlarge" /> 
					</c:when>
					<c:otherwise>
						<input type="text" readonly="readonly" value="${data.wxNo}" maxlength="50" class="input-xlarge" /> *不可修改
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	 	<div class="control-group">
			<label class="control-label">手机号码:</label>
			<div class="controls">
				<input type="text" name="phone" value="${data.phone}" maxlength="50" class="input-xlarge" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">openId:</label>
			<div class="controls">
				<input type="text" name="tel" readonly="readonly" value="${data.openId}" maxlength="50" class="input-xlarge" />
				<span class="help-inline"><font color="#555">*系统内容不可修改</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">性别:</label>
			<div class="controls">
					<select name="sex">
					<option></option>
						<c:forEach items="${sexs}" var="p">
								<c:choose >
									<c:when test="${p.value eq data.sex}">
										<option value="${p.value }" selected="selected">${p.chName}</option>
									</c:when>
									<c:otherwise><option value="${p.value }">${p.chName}</option></c:otherwise>
								</c:choose>
							</c:forEach>
					</select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">来源:</label>
			<div class="controls">
				<select name="sourceFrom">
					<option></option>
					<c:forEach items="${sourceFroms}" var="p">
						<c:choose >
							<c:when test="${p.value eq data.sourceFrom}">
								<option value="${p.value }" selected="selected">${p.chName}</option>
							</c:when>
							<c:otherwise><option value="${p.value }">${p.chName}</option></c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">状态:</label>
			<div class="controls">
				<select name="status" disabled="disabled" class="required">
					<option></option>
						<c:forEach items="${statuss}" var="p">
								<c:choose >
									<c:when test="${p.value eq data.status}">
										<option value="${p.value }" selected="selected">${p.chName}</option>
									</c:when>
									<c:otherwise><option value="${p.value }">${p.chName}</option></c:otherwise>
								</c:choose>
							</c:forEach>
				</select>
				<span class="help-inline"><font color="#555"> *如需修改请前往列表修改</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">客户类型:</label>
			<div class="controls">
				<select name="type" disabled="disabled"  class="required">
					<option></option>
						<c:forEach items="${types}" var="p">
								<c:choose >
									<c:when test="${p.value eq data.type}">
										<option value="${p.value }" selected="selected">${p.chName}</option>
									</c:when>
									<c:otherwise><option value="${p.value }">${p.chName}</option></c:otherwise>
								</c:choose>
							</c:forEach>
				</select>
				<span class="help-inline"><font color="#555">*系统内容不可修改</font></span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">省:</label>
			<div class="controls">
				<input type="text" name="province" value="${data.province}" maxlength="50" class=" input-xlarge" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">市:</label>
			<div class="controls">
				<input type="text" name="city" value="${data.city}" maxlength="50" class=" input-xlarge" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">区:</label>
			<div class="controls">
				<input type="text" name="area" value="${data.area}" maxlength="50" class=" input-xlarge" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">邀请人:</label>
			<div class="controls">
				<input type="text" name="myInvite" value="${data.myInvite}" maxlength="50" class=" input-xlarge" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">评分等级:</label>
			<div class="controls">
				<select name="grade" >
					<option></option>
						<c:forEach items="${grades}" var="p">
								<c:choose >
									<c:when test="${p.value eq data.grade}">
										<option value="${p.value }" selected="selected">${p.chName}</option>
									</c:when>
									<c:otherwise><option value="${p.value }">${p.chName}</option></c:otherwise>
								</c:choose>
							</c:forEach>
				</select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">录入时间:</label>
			<div class="controls">
				 <input id="billStart" name="createTime" readonly="readonly" type="text"  maxlength="20" class="input-mini Wdate"
				value="<fmt:formatDate value="${data.createTime}" pattern="yyyy-MM-dd"/>" />
				<span class="help-inline"><font color="#555">*系统内容不可修改</font> </span>
			</div>
		</div>
		 
		<div class="form-actions">
			<shiro:hasPermission name="member:member:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form>
	</div>
</body>
</html>