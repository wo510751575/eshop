<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>会员特权管理</title>
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
	
<style type="text/css">
.form-search .ul-form li label{
	width: 110px;
}
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
		<li><a href="${ctx}/member/memberRank/">会员特权列表</a></li>
		<li class="active"><a href="${ctx}/member/memberRank/form?code=${data.code}">会员特权<shiro:hasPermission name="content:wshopinfo:edit">${not empty data.code?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="content:wshopinfo:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form id="inputForm"  action="${ctx}/member/memberRank/${not empty data.code?'edit':'save'}" method="post" class="form-horizontal">
		<input type="hidden" name="code" value="${data.code}">
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">特权名称:</label>
			<div class="controls">
				<input type="text" name="name" value="${data.name}" maxlength="50" class="required input-xlarge" />
				<span class="help-inline"><font color="red">* 请谨慎修改</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">租凭权限（如：5000以下，<br/>存储5000）:</label>
			<div class="controls">
				<input type="text" name="amount" value="${data.amount}" maxlength="50" class="required input-xlarge number" />
				<span class="help-inline"><font >请谨慎修改</font> </span>
			</div>
		</div>
	 	<div class="control-group">
			<label class="control-label">穿戴次数:</label>
			<div class="controls">
				<input type="text" name="scale" value="${data.scale}" maxlength="10" class="input-xlarge number" />
				<span class="help-inline"><font color="#7b7b7b">0 为无数次, 请谨慎修改</font> </span>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">图片:</label>
			<div class="controls">
				<div class="img-div">
				      <div id="img_btn1" style="border: 1px solid #e0e6eb;width:120px;height:120px;line-height:100px;text-align:center">
					       <c:if test="${!empty data.imgSrc}">
					       		<img width="120px" height="120px" src="${fns:getUploadUrl()}${data.imgSrc}"/>
					       </c:if>
					       <c:if test="${empty data.imgSrc}">
					                                  选择图片
					       </c:if>
					    </div>
						<input type="hidden" id="img1" name="imgSrc" value="${data.imgSrc}"/>
				</div>
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
			<label class="control-label">顺序号:</label>
			<div class="controls">
				<input type="text" name="seq" value="${data.seq}" maxlength="10" class="input-xlarge number" />
				<span class="help-inline"><font >请谨慎修改</font> </span>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">录入时间:</label>
			<div class="controls">
				 <input id="billStart" name="createDate" readonly="readonly" type="text"  maxlength="20" class="input-mini Wdate"
				value="<fmt:formatDate value="${data.createDate}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true});"/>
				<span class="help-inline"><font color="#555">*系统内容不可修改</font> </span>
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
		
		initImgUpload('img_btn1', 'img1');
		/* initImgUpload('img_btn2', 'img2');
		initImgUpload('img_btn3', 'img3');
		initImgUpload('img_btn4', 'img4');
		initImgUpload('img_btn5', 'img5'); */
	
		function initImgUpload(image_btn, input_image){
			var uploader = new plupload.Uploader({ //实例化一个plupload上传对象
				browse_button : image_btn,
				url : '${ctx}/file/upload?dirName=wshopinfo',
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
					$("#" + image_btn).html('<img width="120px" height="120px" src="'+uploadUrl+'/eoms'+response.url+'"/>');
					$("#" + input_image).val("/eoms" + response.url);
			});
		}

    </script>
</body>
</html>