<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>店铺背景图管理</title>
	<meta name="decorator" content="default"/>
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
		<li><a href="${ctx}/shop/bgimg/list">店铺背景图列表</a></li>
		<li class="active"><a href="${ctx}/shop/bgimg/form?code=${data.code}">店铺背景图<shiro:hasPermission name="shop:bgimg:edit">${not empty data.code?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="shop:bgimg:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form id="inputForm"  action="${ctx}/shop/bgimg/${not empty data.code?'edit':'save'}" method="post" class="form-horizontal">
		<input type="hidden" name="code" value="${data.code}">
		<tags:message content="${message}"/>
		
		<div class="control-group">
			<label class="control-label">店铺背景图名称:</label>
			<div class="controls">
				<input type="text" id="name" name="name" value="${data.name}" maxlength="50" class="required input-xlarge" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">店铺背景图:</label>
				<div class="controls">
			      <div id="image_btn" style="border: 1px solid #e0e6eb;width:120px;height:120px;line-height:100px;text-align:center">
				       <c:if test="${!empty data.spe}">
				       		<img width="120px" height="120px" src="${fns:getUploadUrl()}${data.spe}"/>
				       </c:if>
				       <c:if test="${empty data.spe}">
				                                  选择图片
				       </c:if>
				    </div>
				<input type="hidden" id="input_image" name="spe" value="${data.spe}"/>
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
			<shiro:hasPermission name="shop:bgimg:edit">
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
				width:640,
				height:290
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