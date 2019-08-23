<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>官方素材管理</title>
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
	
	
</head>
<body>
<div class="container">
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/marketing/materialcommon/">官方素材列表</a></li>
		<li class="active"><a href="${ctx}/marketing/materialcommon/form?code=${data.code}">官方素材<shiro:hasPermission name="content:wshopinfo:edit">${not empty data.code?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="content:wshopinfo:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form id="inputForm"  action="${ctx}/marketing/materialcommon/${not empty data.code?'edit':'save'}" method="post" class="form-horizontal">
		<input type="hidden" name="code" value="${data.code}">
		<input type="hidden" name="bizType" value="1">
		
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">标题:</label>
			<div class="controls">
				<input type="text" name="title" value="${data.title}" maxlength="50" class="required input-xlarge" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">商品编码:</label>
			<div class="controls">
				<input type="text" name="productCode" value="${data.productCode}" maxlength="50" class="required input-xlarge" />
			</div>
		</div>
		
	 	<div class="control-group">
			<label class="control-label">分享次数:</label>
			<div class="controls">
				<span>${data.shareCnt}</span>
			</div>
		</div>
	 	
		
		<div class="control-group">
			<label class="control-label">图片:</label>
			<div class="controls">
				<div class="img-div">
				      <div id="img_btn1" style="border: 1px solid #e0e6eb;width:120px;height:120px;line-height:100px;text-align:center">
					       <c:if test="${!empty data.img1}">
					       		<img width="120px" height="120px" src="${fns:getDictValue('上传路径前缀', 'uploadUrl', 'http://192.168.6.60/')}${data.img1}"/>
					       </c:if>
					       <c:if test="${empty data.img1}">
					                                  选择图片
					       </c:if>
					    </div>
						<input type="hidden" id="img1" name="img1" value="${data.img1}"/>
				      
				      <div id="img_btn2" style="border: 1px solid #e0e6eb;width:120px;height:120px;line-height:100px;text-align:center">
				       <c:if test="${!empty data.img2}">
				       		<img width="120px" height="120px" src="${fns:getDictValue('上传路径前缀', 'uploadUrl', 'http://192.168.6.60/')}${data.img2}"/>
				       </c:if>
				       <c:if test="${empty data.img2}">
				                                  选择图片
				       </c:if>
				    </div>
					<input type="hidden" id="img2" name="img2" value="${data.img2}"/>
				      
				       <div id="img_btn3" style="border: 1px solid #e0e6eb;width:120px;height:120px;line-height:100px;text-align:center">
				       <c:if test="${!empty data.img3}">
				       		<img width="120px" height="120px" src="${fns:getDictValue('上传路径前缀', 'uploadUrl', 'http://192.168.6.60/')}${data.img3}"/>
				       </c:if>
				       <c:if test="${empty data.img3}">
				                                  选择图片
				       </c:if>
				    </div>
					<input type="hidden" id="img3" name="img3" value="${data.img3}"/>
					
					<div id="img_btn4" style="border: 1px solid #e0e6eb;width:120px;height:120px;line-height:100px;text-align:center">
				       <c:if test="${!empty data.img4}">
				       		<img width="120px" height="120px" src="${fns:getDictValue('上传路径前缀', 'uploadUrl', 'http://192.168.6.60/')}${data.img4}"/>
				       </c:if>
				       <c:if test="${empty data.img4}">
				                                  选择图片
				       </c:if>
				    </div>
					<input type="hidden" id="img4" name="img4" value="${data.img4}"/>
				
					<div id="img_btn5" style="border: 1px solid #e0e6eb;width:120px;height:120px;line-height:100px;text-align:center">
				       <c:if test="${!empty data.img5}">
				       		<img width="120px" height="120px" src="${fns:getDictValue('上传路径前缀', 'uploadUrl', 'http://192.168.6.60/')}${data.img5}"/>
				       </c:if>
				       <c:if test="${empty data.img5}">
				                                  选择图片
				       </c:if>
				    </div>
					<input type="hidden" id="img5" name="img5" value="${data.img5}"/>
				
				</div>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<%-- <input type="text" name="detail" value="${data.detail}" maxlength="250" class="input-xlarge" /> --%>
				<textarea  name="remarks" >${data.remarks}</textarea>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">状态:</label>
			<div class="controls">
				<label><input name="status" type="radio" value="0" <c:if test="${(empty data) or (empty data.status) or (data.status != 1)}" >checked="checked"</c:if> />启用 </label> 
				<label><input name="status" type="radio" value="1" <c:if test="${(!empty data) and (!empty data.status) and (data.status == 1)}" >checked="checked"</c:if> />停用 </label> 
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">录入时间:</label>
			<div class="controls">
				 <%-- <input id="billStart" name="createTime" readonly="readonly" type="text"  maxlength="20" class="input-mini Wdate"
				value="<fmt:formatDate value="${data.createTime}" pattern="yyyy-MM-dd"/>" />
				<span class="help-inline"><font color="#555">*系统内容不可修改</font> </span> --%>
				<fmt:formatDate value="${data.createTime}" pattern="yyyy-MM-dd"/>
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
		initImgUpload('img_btn2', 'img2');
		initImgUpload('img_btn3', 'img3');
		initImgUpload('img_btn4', 'img4');
		initImgUpload('img_btn5', 'img5');
	
		function initImgUpload(image_btn, input_image){
			var uploader = new plupload.Uploader({ //实例化一个plupload上传对象
				browse_button : image_btn,
				url : '${ctx}/file/upload?dirName=materialcommon',
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