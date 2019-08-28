<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商品标签管理</title>
	<meta name="decorator" content="default"/>
		<script src="${ctxStatic}/common/plupload.full.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate({
				 ignore: [],
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
		<li><a href="${ctx}/product/flag/">商品标签列表</a></li>
		<li class="active"><a href="${ctx}/product/flag/form?code=${data.code}">商品标签<shiro:hasPermission name="product:flag:edit">${not empty data.code?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="product:flag:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/> 
	<form id="inputForm"  action="${ctx}/product/flag/${not empty data.code?'edit':'save'}" method="post" class="form-horizontal">
		<input type="hidden" name="code" value="${data.code}">
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">标签名称:</label>
			<div class="controls">
				<input type="text" name="productFlag" value="${data.productFlag}" maxlength="32" class="required input-xlarge" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		 
		<div class="control-group">
			<label class="control-label">状态:</label>
			<div class="controls">
				<select name="status" class="required">
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
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<script>
			//类型未专题时必填设置
			function imgSetClass(obj){
				if ($(obj).val() == '1') {
					$('#input_image').addClass('required');
					$('#showCntId').addClass('required');
				} else {
					$('#input_image').removeClass('required');
					$('#showCntId').removeClass('required');
				}
			}
		</script>
		<div class="control-group">
			<label class="control-label">类型:</label>
			<div class="controls">
				<select name="flagType" onchange="imgSetClass(this);" class="required">
					<option></option>
						<c:forEach items="${flagTypes}" var="p">
								<c:choose >
									<c:when test="${p.value eq data.flagType}">
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
			<label class="control-label">卡位:</label>
			<div class="controls">
			 	
			 	<input type="text" name="productSeq" value="${data.productSeq}" maxlength="32" class="required digits input-xlarge" />
				<span class="help-inline"><font color="red">* 数值越大越后</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">TAB栏商品展示数量:</label>
			<div class="controls">
			 	<select id="showCntId" name="showCnt"  <c:if test="${data.flagType=='1' }"> class="required" </c:if> >
			 		<option value="" ></option>
			 		<c:choose>
			 			<c:when test="${data.showCnt==4 }">
				 			<option value=4 selected="selected">4</option>
				 			<option value=6 >6</option>
			 			</c:when>
			 			<c:when test="${data.showCnt==6 }">
				 			<option value=4 >4</option>
				 			<option value=6 selected="selected">6</option>
			 			</c:when>
			 			<c:otherwise>
			 				<option value=4 >4</option>
				 			<option value=6 >6</option>
			 			</c:otherwise>
			 		</c:choose>
			 	</select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">标签图标:</label>
			<div class="controls">
			      <div id="image_btn" style="border: 1px solid #e0e6eb;width:120px;height:120px;line-height:100px;text-align:center">
				       <c:if test="${!empty data.imageUrl}">
				       		<img width="120px" height="120px"  src="${fns:getUploadUrl()}${data.imageUrl}"/>
				       </c:if>
				       <c:if test="${empty data.imageUrl}">
				                                  选择图片
				       </c:if>
				    </div>
				    <c:choose>
					    <c:when test="${data.flagType=='1' }">
					    	<input type="hidden" id="input_image" class="required" name="imageUrl" value="${data.imageUrl}"/>
					    </c:when>
					    <c:otherwise>
					    	<input type="hidden" id="input_image" name="imageUrl" value="${data.imageUrl}"/>
					    </c:otherwise>
				    </c:choose>
				
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
	<script>
		var uploader = new plupload.Uploader({ //实例化一个plupload上传对象
			browse_button : 'image_btn',
			url : '${ctx}/file/upload?dirName=flag',
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
				width:388,
				height:157
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