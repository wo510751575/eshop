<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商品分类管理</title>
	<meta name="decorator" content="default"/>
	<script src="${ctxStatic}/common/plupload.full.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#catalogName").focus();
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
	
<style type="text/css">
.container {
	padding: 20px 30px;
	width: 100%;
	min-height: 800px;
	background: #fff;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
}

.page_header {
	font-size: 32px;
	font-weight: normal;
	line-height: 1;
	padding-bottom: 40px;
	color: #666;
}
.nav-tabs > li > a {
    padding-top: 0px;
}
</style>
</head>
<body>
<div class="container">
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/product/catalog/">商品分类列表</a></li>
		<li class="active"><a href="${ctx}/product/catalog/form?code=${data.code}&parentCatalogCode=${data.parentCatalogCode}">商品分类<shiro:hasPermission name="product:catalog:edit">${not empty data.code?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="product:catalog:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form id="inputForm"  action="${ctx}/product/catalog/${not empty data.code?'edit':'save'}" method="post" class="form-horizontal">
		<input type="hidden" name="code" value="${data.code}">
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">上级商品分类:</label>
			<div class="controls">
                <tags:treeselect id="catalog" name="parentCatalogCode" value="${data.parentCatalogCode}" 
                labelName="parentCatalogName" labelValue="${data.parentCatalogName}"
					title="商品分类" url="/product/catalog/treeData" extId="${data.code}" cssClass="required"/>
					<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">分类名称:</label>
			<div class="controls">
				<input type="text" id="catalogName" name="catalogName" value="${data.catalogName}" maxlength="50" class="required input-xlarge" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">分类图片:</label>
			<div class="controls">
			      <div id="image_btn" style="border: 1px solid #e0e6eb;width:120px;height:120px;line-height:100px;text-align:center">
				       <c:if test="${!empty data.imageUrl}">
				       		<img width="120px" height="120px" src="${fns:getUploadUrl()}${data.imageUrl}"/>
				       </c:if>
				       <c:if test="${empty data.imageUrl}">
				                                  选择图片
				       </c:if>
				    </div>
				<input type="hidden" id="input_image" name="imageUrl" value="${data.imageUrl}"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">排序:</label>
			<div class="controls">
				<input type="text" name="orderNo" value="${data.orderNo}" onkeyup="this.value=this.value.replace(/\D/g, '')"  maxlength="50" class="required input-xlarge" />
				<span class="help-inline"><font color="red">*只允许纯数字</font> </span>
				<span class="help-inline">排列顺序，升序（数值越大越后）。</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否推荐:</label>
			<div class="controls">
				<label><input id="recommend" name="recommend" type="checkbox" value="1" <c:if test="${data.recommend==1}">checked="checked"</c:if>>推荐</label>
				<span class="help-inline">勾选作为推荐分类展示，仅二级分类支持该操作</span>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="product:catalog:edit">
				<input id="btnSubmit" class="btn btn-primary" onclick="if($('#catalogId').val()=='1'){ $('#recommend').attr('checked',false); }" type="submit" value="保 存"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form>
	</div>
	<script>
		var uploader = new plupload.Uploader({ //实例化一个plupload上传对象
			browse_button : 'image_btn',
			url : '${ctx}/file/upload?dirName=catalog',
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