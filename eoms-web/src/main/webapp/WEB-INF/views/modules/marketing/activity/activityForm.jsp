<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>${not empty data.code?'活动修改':'活动添加'}</title>
    <meta name="decorator" content="default"/>
	<script type="text/javascript" src="${ctxStatic}/common/ajaxfileupload.js"></script>
	<script type="text/javascript" src="${ctxStatic}/editor/kindeditor.js"></script>
	<script type="text/javascript" src="${ctxStatic}/editor/init.js"></script>
	<script src="${ctxStatic}/common/plupload.full.min.js" type="text/javascript"></script>
    <script type="text/javascript">
   
    </script>
    <style type="text/css">
    .nav-child li a{
          line-height: 10px;
    }
    .nav-child li.active a{
          border: 1px dotted #ddd;
          border-bottom-color: transparent;
    }
    .photo-file{
	 	position: absolute;
	    top: 350px;
	    left: 190px;
	    opacity: 0;
	    filter: alpha(opacity:0);
	    cursor:pointer;
	}
	img {
	    border: 0 none;
	    height: 80px;
	    max-width: 100%;
	    vertical-align: middle;
	}
	.container{
	padding: 10px 30px;
    width: 100%;
    min-height: 800px;
    background: #fff;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
	}
	#image_btn img{
	float: left;
	}
	.close-Icon{
	position: absolute;
    background: url(${ctxStatic}/images/closeImg.png) no-repeat;
    z-index: 100;
    width: 20px;
    height: 20px;
    background-size: 100%;
    right: -7px;
    top: -7px;
       cursor: pointer;
	}
	.img_info{
	position:relative;
	width: 120px;
	height: 120px;
	float: left;
	margin: 10px;
	
	}
    </style>
</head>
<body>
<div class="container">
    <ul class="nav nav-tabs">
        <li><a href="${ctx}/cm/activity">活动列表</a></li>
	    <li class="active"><a href="${ctx}/cm/activity/form?code=${data.code}">${not empty data.code?'活动修改':'活动添加'}</a></li>
    </ul><br/>

    <form id="inputForm" action="${ctx}/cm/activity/${not empty data.code?'edit':'save'}"  method="post" enctype="multipart/form-data" class="form-horizontal">
        <input id="code" name="code" type="hidden" value="${data.code}"/>
        <tags:message content="${message}"/>
        <div id="base_div" class="tab_div">
        	<div class="control-group">
                <label class="control-label">标题:</label>
                <div class="controls">
                    <input type="text" id="title" name="title"  maxlength="127" class="required input-xxlarge" value="${data.title}"/>
                    <span class="help-inline"><font color="red">*</font></span>
                </div>
            </div>
            
            <div class="control-group">
                <label class="control-label">活动开始时间:</label>
                <div class="controls">
                    <input id="startDate" name="startDate" type="text" readonly="readonly" maxlength="20" class="input-xxlarge Wdate required" 
				value="<fmt:formatDate value="${data.startDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:true});"/>
                    <span class="help-inline"><font color="red">*</font></span>
                </div>
            </div>
            
            
				
            <div class="control-group">
                <label class="control-label">网址链接:</label>
                <div class="controls">
                    <input type="text" id="linkUrl" name="linkUrl"  maxlength="127" class=" input-xxlarge required" value="${data.linkUrl}"/>
                     <span class="help-inline"><font color="red">*</font></span> 
                </div>
            </div>
            
             <div class="control-group">
                <label class="control-label">缩略图:</label>
                <div class="controls">
            		<div id="image_btn" style="border: 1px solid #ddd;width:50%;line-height:100px;text-align:center;overflow: auto;">
                	<c:choose>
                		<c:when test="${data.imgAddr==null ||  data.imgAddr==''}">
                			选择图片
                		</c:when>
                		<c:when test="${data.imgAddr!=null &&  data.imgAddr!=''}">
                			<c:forEach items="${data.imgAddr.split(',') }" var="imgaddr">
	                			<div class="img_info">
	                			<span class="close-Icon"></span>
	                			<img src="${fns:getUploadUrl()}${imgaddr}"  height="120px" width="120px">
	                			</div>
                			</c:forEach>
                		</c:when>
                	</c:choose>
		    		</div>
                     <input id="input_image" type="hidden" name="imgAddr" value="${data.imgAddr}">
                     <span class="help-inline">建议图片尺寸1080*1540</span>
                </div>
            </div>
            
            <div class="control-group">
                <label class="control-label">封面图:</label>
                <div class="controls">
					<div id="showImgAddr_btn" style="border: 1px solid #e0e6eb; width: 120px; height: 120px; line-height: 100px; text-align: center">
						<c:if test="${!empty data.showImgAddr}">
							<img width="120px" height="120px" src="${fns:getUploadUrl()}${data.showImgAddr}" />
						</c:if>
						<c:if test="${empty data.showImgAddr}">选择图片</c:if>
					</div>
					<input id="input_showImgAddr" type="hidden" name="showImgAddr" value="${data.showImgAddr}">
					<span class="help-inline">建议图片尺寸1080*500</span>
				</div>
            </div>
<!--             <div class="control-group"> -->
<!--                 <label class="control-label">内容:</label> -->
<!--                 <div class="controls"> -->
<%--                      <textarea class="editor" name="content" id="editor">${data.content }</textarea> --%>
<!--                 </div> -->
<!--             </div> -->
        </div>
        <div class="form-actions">
            <input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
            <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)">
        </div>
    </form>
   </div> 
    
    <script>
    var uploader = new plupload.Uploader({ //实例化一个plupload上传对象
		browse_button : 'image_btn',
		url : '${ctx}/file/upload?dirName=activity',
		multi_selection:false,
		auto_start : true,
		flash_swf_url : '${ctxStatic}/common/Moxie.swf',
		silverlight_xap_url : '${ctxStatic}/common/Moxie.xap',
		filters: {
		  mime_types : [ //只允许上传图片文件
		    { title : "图片文件", extensions : "jpg,gif,png" }
		  ],
		  max_file_size : '10240kb',
		  prevent_duplicates : true 
		},
		multipart_params: {
			fileType: 'image',
			width:1080,
			height:1540
		}
	});
	uploader.init(); //初始化
	uploader.bind('FilesAdded',function(uploader,files){
		if(files.length>0){
			uploader.start();
		}
	});
	uploader.bind('Error',function(uploader,errObject){
		if(errObject.code!=-602){
			showTip(errObject.message,"info");
		}
	});
	uploader.bind('FileUploaded',function(uploader,file,responseObject){
			var response = $.parseJSON(responseObject.response);
			var child=$("#image_btn").children();
			var html="";
			if(child.length>0){
				html=$("#image_btn").html();
			}
			html=html+'<div class="img_info"><span class="close-Icon" ></span><img width="120px" height="120px" src="'+uploadUrl+'/eoms'+response.url+'"/></div>';
			$("#image_btn").html(html);
			
			$(".close-Icon").on("click",function(e){
				imgClose(this,e);
	        });
	});
	
	var uploader_show = new plupload.Uploader({ //实例化一个plupload上传对象
		browse_button : 'showImgAddr_btn',
		url : '${ctx}/file/upload?dirName=activity',
		multi_selection:false,
		auto_start : true,
		flash_swf_url : '${ctxStatic}/common/Moxie.swf',
		silverlight_xap_url : '${ctxStatic}/common/Moxie.xap',
		filters: {
		  mime_types : [ //只允许上传图片文件
		    { title : "图片文件", extensions : "jpg,gif,png" }
		  ],
		  max_file_size : '10240kb',
		  prevent_duplicates : true 
		},
		multipart_params: {
			fileType: 'image',
			width:1080,
			height:500
		}
	});
	uploader_show.init(); //初始化
	uploader_show.bind('FilesAdded',function(uploader_show,files){
		if(files.length>0){
			uploader_show.start();	
		}
	});
	uploader_show.bind('Error',function(uploader_show,errObject){
		if(errObject.code!=-602){
			showTip(errObject.message,"info");
		}
	});
	uploader_show.bind('FileUploaded',function(uploader_show,file,responseObject){
			var response = $.parseJSON(responseObject.response);
			$("#showImgAddr_btn").html('<img width="120px" height="120px" src="'+uploadUrl+'/eoms'+response.url+'"/>');
			$("#input_showImgAddr").val("/eoms" + response.url);
	});
	
	 $(document).ready(function() {
	    	
	        $("#inputForm").validate({
	            submitHandler: function(form){
	            	var imgInfo="";
					var imgJi=$("#image_btn img");
					for(var i=0;i<imgJi.length;i++){
						if(i==imgJi.length-1){
							imgInfo=imgInfo+imgJi[i].src.split(uploadUrl)[1];
						}else{
							imgInfo=imgInfo+imgJi[i].src.split(uploadUrl)[1]+",";
						}
					}
					$("#input_image").val(imgInfo);
	                form.submit();
	                return false;
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
	        $("#materialTypeCode").change(function(){
	    		$("#materialTypeName").val($(this).find("option:selected").text());
	        });
	        
	        $(".close-Icon").on("click",function(e){
	        	imgClose(this,e);
	        });
	    });
	 
		function imgClose(event,e){
			$(event).parent().remove();
        	var show=$("#image_btn").children();
        	if(show.length==0){
        		$("#image_btn").html("选择图片");
        	}
        	e.stopPropagation(); 
        	return false;
		}	 
	    function tabChange(id,ths){
	        $(".tab_div").hide();
	        $(".nav-child li").removeClass("active");
	        $(id).show();
	        $(ths).addClass("active");
	    }
    </script>
</body>
</html>