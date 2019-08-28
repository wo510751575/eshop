<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>广告管理</title>
	<meta name="decorator" content="default"/>
	
	<style>
		.img-div > div{float:left;margin-left:3px;}
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
		<li><a href="${ctx}/content/loading/">广告管理列表</a></li>
		<li class="active"><a href="${ctx}/content/loading/form?code=${data.code}">广告管理<shiro:hasPermission name="content:wshopinfo:edit">${not empty data.code?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="content:wshopinfo:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form id="inputForm"  action="${ctx}/content/loading/${not empty data.code?'edit':'save'}" method="post" class="form-horizontal">
		<input type="hidden" name="code" value="${data.code}">
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">位置:</label>
			<div class="controls">
				<input type="text" name="indexSeq" value="${data.indexSeq}" maxlength="50" class="required input-xlarge number" />
				<span class="help-inline"><font color="red">*位置 (越小越前)</font> </span>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">跳转到活动页面<br/>或商品详情页面:</label>
			<div class="controls">
				<input type="text" name="jumpUrl" value="${data.jumpUrl}" maxlength="50" class=" input-xlarge " />
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">图片:</label>
			<div class="controls">
				<div class="img-div">
				      <div id="img_btn1" style="border: 1px solid #e0e6eb;width:120px;height:120px;line-height:100px;text-align:center">
					       <c:if test="${!empty data.imgUrl}">
					       		<img width="120px" height="120px" src="${fns:getUploadUrl()}${data.imgUrl}"/>
					       </c:if>
					       <c:if test="${empty data.imgUrl}">
					                                  选择图片
					       </c:if>
					    </div>
						<input type="hidden" id="imgUrl" name="imgUrl" value="${data.imgUrl}"/>
				</div>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">广告栏:</label>
			<div class="controls">
					<label><input name="biz" type="radio" value="0" <c:if test="${(empty data) or (empty data.biz) or (data.biz != 1)}" >checked="checked"</c:if> />首页广告栏</label> 
					<label><input name="biz" type="radio" value="1" <c:if test="${(!empty data) and (!empty data.biz) and (data.biz == 1)}" >checked="checked"</c:if> />商品集散广告栏 </label>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">状态:</label>
			<div class="controls">
					<label><input name="status" type="radio" value="0" <c:if test="${(empty data) or (empty data.status) or (data.status != 1)}" >checked="checked"</c:if> />启用</label> 
					<label><input name="status" type="radio" value="1" <c:if test="${(!empty data) and (!empty data.status) and (data.status == 1)}" >checked="checked"</c:if> />停用 </label>
				<span class="help-inline"><font color="red">*</font> </span>
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
	
	<script>
		
		//选择广告栏，截取图片高宽重新设置
		$(':radio[name="biz"]').bind('click', function(){
			switchBindImgUpload($(this).val());
		});
	
		
		//重新绑定截取参数
		switchBindImgUpload('${data.biz}')
		function switchBindImgUpload(bannerBiz){
			
			if(bannerBiz=='' || bannerBiz==0) {
				//banner：640*674， 0：首页广告栏
				initImgUpload('img_btn1', 'imgUrl', 640, 674);
			} else {
				
				//banner：640*674， 1：商品集散广告栏
				initImgUpload('img_btn1', 'imgUrl', 640, 190);
			}
		}

		//初始化上传图片绑定
		var _upload;
		function initImgUpload(image_btn, input_image, width, height){
			
			
			_upload = new plupload.Uploader({ //实例化一个plupload上传对象
				browse_button : image_btn,
				url : '${ctx}/file/upload?dirName=loading',
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
					width:width,
					height:height
				}
			});
			_upload.init(); //初始化
			_upload.bind('FilesAdded',function(uploader,files){
				if(files.length>0){
					uploader.start();
				}
			});
			_upload.bind('Error',function(uploader,errObject){
				showTip(errObject.message,"info");
			});
			_upload.bind('FileUploaded',function(uploader,file,responseObject){
					var response = $.parseJSON(responseObject.response);
					$("#" + image_btn).html('<img width="120px" height="120px" src="'+uploadUrl+'/eoms'+response.url+'"/>');
					$("#" + input_image).val("/eoms" + response.url);
			});
		}

    </script>
</body>
</html>