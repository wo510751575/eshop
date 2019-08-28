<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商户配置</title>
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
			
			$(".addconfig").click(function(){
				var lg=$(".control-group").length;
				console.log(lg);
				var $cp=$(".copyLine").clone();
				var newId=$cp.find("#checkbox-").attr("id")+lg;
				$cp.find("#checkbox-").attr("id",newId);
				$cp.find(".checkbox-nice label").attr("for",newId);
				
				
				$cp.find("#checkbox-").attr("id",newId);
				
				$cp.find("[name='name']").attr("name", "settings["+(lg-2)+"].name");
				$cp.find("[name='value']").attr("name", "settings["+(lg-2)+"].value");
				$cp.find("[name='status']").attr("name","settings["+(lg-2)+"].status");
				$cp.find("[name='types']").attr("name","settings["+(lg-2)+"].types");
				
				$(".form-actions").before($cp);
				
				$("#inputForm .copyLine").removeClass("copyLine");
			});
			
			$(".addImgConfig").click(function(){
				var lg=$(".control-group").length;
				/* console.log(lg); */
				var $cp=$(".copyImgLine").clone();
				var newId=$cp.find("#checkbox-").attr("id")+lg;
				$cp.find("#checkbox-").attr("id",newId);
				$cp.find(".checkbox-nice label").attr("for",newId);
				
				
				$cp.find("#checkbox-").attr("id",newId);
				
				$cp.find("[name='name']").attr("name", "settings["+(lg-2)+"].name");
				$cp.find("[name='value']").attr("name", "settings["+(lg-2)+"].value");
				$cp.find("[name='status']").attr("name","settings["+(lg-2)+"].status");
				$cp.find("[name='types']").attr("name","settings["+(lg-2)+"].types");
				
				$cp.find(".image_btn").attr("id","image_btn_"+(lg-2));
				$cp.find(".input_image").attr("id","input_image_"+(lg-2));
				$cp.find(".image_btn").attr("data-num",lg-2);
				
				$(".form-actions").before($cp);
				
				$("#inputForm .copyImgLine").removeClass("copyImgLine");
			});
			
			$("#inputForm").delegate(".image_btn","click",function(){
				var ret=$(this).data("num");
				$(".moxie-shim").remove();
				createImg(ret);
			});
			
		});
	</script>
	<style type="text/css">
 .control-group{
	width: 95%;
	display: flex;
	justify-content: flex-start;
    align-items: center;
    padding-left:5%;
}

 .control-label{
	padding-top:0px !important;
}
 .control-label input{
	width: 100%;
	padding: 4px 6px;
}
.copyLine{
	display: none;
}
.copyImgLine{
	display: none;
}


</style>
</head>
<body>
<div class="container">
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/member/merchant/list">商户列表</a></li>
		<li class="active"><a href="${ctx}/member/merchant/setting?code=">商户配置</a></li>
	</ul><br/>
	<form id="inputForm"  action="${ctx}/member/merchant/saveSetting" method="post" class="form-horizontal">
		<input type="hidden" name="code" value="${data.code}">
		<tags:message content="${message}"/>
			<%-- <c:if test="${empty list}" >
			<div class="control-group">
			<div class="control_child">
				<label class="control-label"><input type="text" name="settings[0].name" placeholder="配置名称" value="" maxlength="50" class="required input-xlarge" /></label>
				<div class="controls">
				      	<div id="image_btn" style="border: 1px solid #e0e6eb;width:120px;height:120px;line-height:100px;text-align:center">
					                                  选择图片
					    </div>
					<input type="hidden" id="input_image" name="settings[0].value" value="${item.value}"/>
				</div>
			</div>
			<div class="control_child">
				<div class="controls ischose">
					<div class="checkbox-nice">
					<input type="checkbox" id="checkbox-" name="settings[0].value" checked="checked" value="0" onclick="switchVal(this)">
					<label for="checkbox-">
					<span class="help-inline">勾选启用</span>
					</label>
					</div>
				</div>
			</div>
			</div>
			</c:if>
			<c:if test="${!empty list}" >
			<div class="control-group">
			<div class="control_child">
				<label class="control-label">
				<input type="hidden" name="settings[0].code" value="${item.code}" />
				<input type="text" name="settings[0].name" placeholder="配置名称" value="" maxlength="50" class="required input-xlarge" /></label>
				<div class="controls">
				      <div id="image_btn" style="border: 1px solid #e0e6eb;width:120px;height:120px;line-height:100px;text-align:center">
					       <c:if test="${fn:contains(item.value,'/eoms')}">
					       		<img width="120px" height="120px" src="${fns:getUploadUrl()}${item.value}"/>
					       </c:if>
					       <c:if test="${empty item.value}">
					                                  选择图片
					       </c:if>
					    </div>
					<input type="hidden" id="input_image" name="settings[0].value" value="${item.value}"/>
				</div>
			</div>
			<div class="control_child">
							<div class="controls ischose">
								<div class="checkbox-nice">
								<input type="checkbox" id="checkbox-${sta.index+1}" name="settings[0].status" 
									<c:if test="${item.status eq 0}" > checked="checked" </c:if> 
									value="${item.status}" onclick="switchVal(this)">
								<label for="checkbox-${sta.index+1}">
									<span class="help-inline">勾选启用</span>
								</label>
								</div>
							</div>
						</div>
			</div>
			</c:if> --%>
		
			<c:if test="${empty list}" >
				<div class="control-group">
					<div class="control_child">
						<label class="control-label">
						<input type="text" name="settings[0].name" placeholder="配置名称" maxlength="50" class="required input-xlarge name" />
						</label>
						<div class="controls">
						<input type="text" name="settings[0].value" placeholder="配置值" maxlength="50" class="required input-xlarge value" />
						<input type="hidden" name="settings[0].types"/>
						</div>
					</div>
					<div class="control_child">
						<div class="controls ischose">
							<div class="checkbox-nice">
							<input type="checkbox" id="checkbox-1" name="settings[0].status" checked="checked" value="0" onclick="switchVal(this)">
							<label for="checkbox-1">
							<span class="help-inline">勾选启用</span>
							</label>
							</div>
						</div>
					</div>
				</div>
			</c:if>
			
			<c:if test="${!empty list}" >
				<c:forEach items="${list}" var="item" varStatus="sta">
					   	
					   		<div class="control-group">
						<div class="control_child">
							<label class="control-label">
							<input type="hidden" name="settings[${sta.index}].code" value="${item.code}" />
							<input type="text" name="settings[${sta.index}].name"  value="${item.name}" placeholder="配置名称" maxlength="50" class="required input-xlarge name" />
							<input type="hidden" name="settings[${sta.index}].types"  value="${item.types}"/>
							</label>
							
					<c:choose>  
					   <c:when test="${item.types eq 1}">  
					   
					   	<div class="controls" style="width: 285px;">
						      <div id="image_btn_${sta.index}" style="border: 1px solid #e0e6eb;width:120px;height:120px;line-height:100px;text-align:center" class="image_btn" data-num="${sta.index}">
							       <c:if test="${!empty item.value}">
							       		<img width="120px" height="120px" src="${fns:getUploadUrl()}${item.value}" alt="双击选择图片"/>
							       </c:if>
							       <c:if test="${empty item.value}">
							                                  双击选择图片
							       </c:if>
							    </div>
							    <span class="help-inline" style="margin-left: 140px;margin-top: -35px;">双击选择图片</span>
							<input type="hidden" id="input_image_${sta.index}"  class="input_image" name="settings[${sta.index}].value" value="${item.value}"/>
						</div>
					   
					   </c:when>  
					   <c:otherwise>
								<div class="controls">
										<input type="text" name="settings[${sta.index}].value"  value="${item.value}" placeholder="配置值" maxlength="50" class="required input-xlarge value" />
								</div>
					 </c:otherwise>  
					</c:choose> 
							
						</div>
						<div class="control_child">
							<div class="controls ischose">
								<div class="checkbox-nice">
								<input type="checkbox" id="checkbox-${sta.index+1}" name="settings[${sta.index}].status" 
									<c:if test="${item.status eq 0}" > checked="checked" </c:if> 
									value="${item.status}" onclick="switchVal(this)">
								<label for="checkbox-${sta.index+1}">
									<span class="help-inline">勾选启用</span>
								</label>
								</div>
							</div>
						</div>
					</div>
					   		
					
				</c:forEach>
			</c:if>
		
		
		
		<div class="form-actions">
			<shiro:hasPermission name="shop:bgimg:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
			<a href="#" class="btn btn-primary addconfig">
		<i class="fa fa-plus-circle fa-lg"></i> 添加普通配置
		</a>
			<a href="#" class="btn btn-primary addImgConfig">
		<i class="fa fa-plus-circle fa-lg"></i> 添加图片配置
		</a> 
		</div>
	</form>
	
	<div class="control-group copyLine">
			<div class="control_child">
				<label class="control-label"><input type="text" name="name" placeholder="配置名称" value="" maxlength="50" class="required input-xlarge" /></label>
				<div class="controls">
					<input type="text" name="value" value="" maxlength="50" placeholder="配置值" class="required input-xlarge" />
					<input type="hidden" name="types"  value="0"/>
				</div>
			</div>
			<div class="control_child">
				<div class="controls ischose">
					<div class="checkbox-nice">
					<input type="checkbox" id="checkbox-" name="status" checked="checked" value="0" onclick="switchVal(this)">
					<label for="checkbox-">
					<span class="help-inline">勾选启用</span>
					</label>
					</div>
				</div>
			</div>
		</div>
	<div class="control-group copyImgLine">
			<div class="control_child">
				<input type="hidden" name="types"  value="1"/>
				<label class="control-label"><input type="text" name="name" placeholder="配置名称" value="" maxlength="50" class="required input-xlarge" /></label>
				<div class="controls" style="width: 285px;">
				      <div id="image_btn" style="border: 1px solid #e0e6eb;width:120px;height:120px;line-height:100px;text-align:center" class="image_btn" data-num="0">
					       <c:if test="${!empty item.value}">
					       		<img width="120px" height="120px" src="${fns:getUploadUrl()}${item.value}"/>
					       </c:if>
					       <c:if test="${empty item.value}">
					                                  双击选择图片
					       </c:if>
					    </div>
					    <span class="help-inline" style="margin-left: 140px;margin-top: -35px;">双击选择图片</span>
					<input type="hidden" id="input_image"  class="input_image" name="value" value="${item.value}"/>
				</div>
			</div>
			<div class="control_child">
				<div class="controls ischose">
					<div class="checkbox-nice">
					<input type="checkbox" id="checkbox-" name="status" checked="checked" value="0" onclick="switchVal(this)">
					<label for="checkbox-">
					<span class="help-inline">勾选启用</span>
					</label>
					</div>
				</div>
			</div>
		</div>
	
	
	</div>
	<script type="text/javascript" >
		function switchVal(obj){
			if(obj.value==0) {
				obj.value=1;
			} else {
				obj.value=0;
			}
		}
	</script>
    <script>
    var uploader = new plupload.Uploader({ //实例化多个plupload上传对象
		browse_button : ['image_btn'],
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
    uploader.bind('Error',function(uploader,errObject){
		showTip(errObject.message,"info");
	});
	uploader.bind('FileUploaded',function(uploader,file,responseObject){
			var response = $.parseJSON(responseObject.response);
			$("#image_btn").html('<img width="120px" height="120px" src="'+uploadUrl+'/eoms'+response.url+'"/>');
			$("#input_image").val("/eoms" + response.url);
	});
    function createImg(ret){
    	var uploader = new plupload.Uploader({ //实例化多个plupload上传对象
    		browse_button : ['image_btn'],
    		url : '${ctx}/file/upload?dirName=setting',
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
    	uploader.setOption("browse_button",'image_btn_'+ret);
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
				$("#image_btn_"+ret).html('<img width="120px" height="120px" src="'+uploadUrl+'/eoms'+response.url+'"/>');
				$("#input_image_"+ret).val("/eoms" + response.url);
		});
    }
    </script>
</body>
</html>