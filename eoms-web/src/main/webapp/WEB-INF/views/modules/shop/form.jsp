<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>店铺管理</title>
	<meta name="decorator" content="default"/>
	<script src="${ctxStatic}/common/plupload.full.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#shopName").focus();
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
		<li><a href="${ctx}/shop/list">店铺列表</a></li>
		<li class="active"><a href="${ctx}/shop/form?code=${data.code}">店铺<shiro:hasPermission name="shop:shop:edit">${not empty data.code?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="shop:shop:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form id="inputForm"  action="${ctx}/shop/${not empty data.code?'edit':'save'}" method="post" class="form-horizontal">
		<input type="hidden" name="code" value="${data.code}">
		<tags:message content="${message}"/>
		
		<div class="control-group">
			<label class="control-label">店铺头像图片:</label>
			<div class="controls">
			      <div id="image_btn" style="border: 1px solid #e0e6eb;width:120px;height:120px;line-height:100px;text-align:center">
				       <c:if test="${!empty data.img}">
				       		<img width="120px" height="120px" src="${data.img}"/>
				       </c:if>
				       <c:if test="${empty data.img}">
				                                  选择图片
				       </c:if>
				    </div>
				<input type="hidden" id="input_image" name="img" value="${data.img}"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">店铺名称:</label>
			<div class="controls">
				<input type="text" id="shopName" name="shopName" value="${data.shopName}" maxlength="50" class="required input-xlarge" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">所在区域:</label>
			<div class="controls">
				<tags:treeselect id="area" name="shopArea" value="${data.shopArea}"
						labelName="" labelValue="${fns:getAreaName(data.shopArea)}" title="所在区域"
						url="/sys/area/treeData" cssClass="required" allowClear="true"
						notAllowSelectParent="true" />
				<span class="help-inline">选择所在区域（如：福田区）</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">店铺所在详细地址:</label>
			<div class="controls">
				<input type="text" name="shopAddinfo" value="${data.shopAddinfo}" maxlength="50" class="required input-xlarge" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>

<!-- 		<div class="control-group"> -->
<!-- 			<label class="control-label">店铺状态:</label> -->
<!-- 			<div class="controls"> -->
<!-- 				<select style="width: 177px;" name="status"> -->
<!--                     <option value="">全部</option> -->
<%--                     <c:forEach items="${shopStatus}" var="item"> --%>
<%-- 						<option value="${item}" --%>
<%-- 							<c:if test="${item.value eq data.shopStatu}">selected="selected"</c:if>>${item.chName}</option> --%>
<%-- 					</c:forEach> --%>
<!--                 </select> -->
<!-- 				<span class="help-inline"><font color="red">*</font> </span> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 		<div class="control-group"> -->
<!-- 			<label class="control-label">店铺等级:</label> -->
<!-- 			<div class="controls"> -->
<!-- 				<select style="width: 177px;" name="status"> -->
<!--                     <option value="">全部</option> -->
<%--                     <c:forEach items="${shopStatus}" var="item"> --%>
<%-- 						<option value="${item}" --%>
<%-- 							<c:if test="${item.value eq data.shopStatu}">selected="selected"</c:if>>${item.chName}</option> --%>
<%-- 					</c:forEach> --%>
<!--                 </select> -->
<!-- 				<span class="help-inline"><font color="red">*</font> </span> -->
<!-- 			</div> -->
<!-- 		</div> -->
		<div class="control-group">
			<label class="control-label">店铺风格:</label>
			<div class="controls">
				<select style="width: 177px;" name="shopStyleCode">
					<c:forEach items="${shopStyles}" var="item">
						<option value="${item.code}"
							<c:if test="${item.code eq data.shopStyleCode}">selected="selected"</c:if>>${item.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">店铺背景图片:</label>
			<div class="controls">
				<select style="width: 177px;" name="shopBgImgCode">
					<c:forEach items="${shopBgImgs}" var="item">
						<option value="${item.code}"
							<c:if test="${item.code eq data.shopBgImgCode}">selected="selected"</c:if>>${item.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
<!--  		<div class="control-group"> -->
<!-- 			<label class="control-label">绑定设备:</label> -->
<!-- 			<div class="controls"> -->
<%-- 				<input type="text" name="mimeCode" value="${data.mimeCode}" maxlength="50" class="required input-xlarge" /> --%>
<!-- 				<span class="help-inline"><font color="red">*</font> </span> -->
<!-- 			</div> -->
<!-- 		</div> -->
		<div class="control-group">
			<label class="control-label">店铺说明:</label>
			<div class="controls">
				<textarea name="shopFlag" rows="3" maxlength="200" class="input-xlarge" >${data.shopFlag}</textarea>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="shop:shop:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form>
	</div>
	<script>
		var uploader = new plupload.Uploader({ //实例化一个plupload上传对象
			browse_button : 'image_btn',
			url : '${ctx}/file/upload?dirName=shop',
			multi_selection:false,
			auto_start : true,
			flash_swf_url : '${ctxStatic}/common/Moxie.swf',
			silverlight_xap_url : '${ctxStatic}/common/Moxie.xap',
			filters: {
			  mime_types : [ //只允许上传图片文件
			    { title : "图片文件", extensions : "jpg,gif,png" }
			  ],
			  max_file_size : '1024kb',
			  prevent_duplicates : true 
			},
			multipart_params: {
				fileType: 'image',
				width:400,
				height:400
			}
		});
		uploader.init(); //初始化
		uploader.bind('FilesAdded',function(uploader,files){
			if(files.length>0){
				uploader.start();
			}
		});
		uploader.bind('Error',function(uploader,errObject){
			showTip(errObject.message,"info");
		});
		
		uploader.bind('FileUploaded',function(uploader,file,responseObject){
				var response = $.parseJSON(responseObject.response);
				$("#image_btn").html('<img width="120px" height="120px" src="'+uploadUrl+'/eoms'+response.url+'"/>');
				$("#input_image").val("/eoms" + response.url);
		});

    </script>
</body>
</html>