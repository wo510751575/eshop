<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>${data.title}</title>
    <meta name="decorator" content="default"/>
	<script type="text/javascript" src="${ctxStatic}/common/ajaxfileupload.js"></script>
	<script type="text/javascript" src="${ctxStatic}/editor/kindeditor.js"></script>
	<script type="text/javascript" src="${ctxStatic}/editor/init.js"></script>
	<script src="${ctxStatic}/common/plupload.full.min.js" type="text/javascript"></script>
	<link href="${ctxStatic}/admin/css/model.css" type="text/css" rel="stylesheet" />
    <script type="text/javascript">
    $(document).ready(function() {
    });
   
    </script>
    <style type="text/css">
    html, body {
    margin: 0;
    padding: 0;
    width: 100%;
    height: 100%;
    min-width: 1250px;
    line-height: 1.5;
    font-family: "微软雅黑", Arial;
    color: #666;
    font-size: 14px;
	}
	    .container {
	    padding: 30px;
	    width: 100%;
	    min-height: 800px;
	    background: #fff;
	    -webkit-box-sizing: border-box;
	    box-sizing: border-box;
	}
	.preview-container {
	    width: 350px;
	    margin: 20px auto 0;
	}
	
	.setting-container {
	    margin-top: 20px;
	    padding-bottom: 64px;
	    width: 350px;
	    min-height: 100px;
	    border-radius: 18px;
	    border: 1px solid #dddddd;
	    position: relative;
	    overflow: hidden;
	}
	.phone-head {
    padding-top: 55px;
    line-height: 0;
    text-align: center;
	}
	
	.phone-head-icon {
	    display: inline-block;
	    width: 60px;
	    height: 8px;
	    border-radius: 10px;
	    background: #ddd;
	    position: relative;
	    transform: translateX(8px);
	}
	.phone-head-icon:before {
	    position: absolute;
	    left: -22px;
	    top: 0;
	    content: '';
	    width: 8px;
	    height: 8px;
	    border-radius: 50%;
	    background: #ddd;
	}
	.phone-head-icon:after {
	    margin-left: -7px;
	    position: absolute;
	    left: 50%;
	    top: -25px;
	    content: '';
	    width: 14px;
	    height: 14px;
	    border-radius: 50%;
	    background: #ddd;
	}
	.phone-title-seciton {
	    margin: 20px auto 0;
	    padding-top: 27px;
	    width: 320px;
	    height: 44px;
	    background: url(${ctxStatic}/admin/images/materialcommen/phone_head_bg.png) no-repeat 0 0;
	    background-size: 100%;
	}
	.app-header {
	    color: #fff;
	    line-height: 30px;
	    text-align: center;
	    font-size: 18px;
	    width: 160px;
	    margin-left: 80px;
	    white-space: nowrap;
	    word-break: break-all;
	    text-overflow: ellipsis;
	    overflow: hidden;
	}
	.h5_info{
	margin: 0 auto;
    padding: 0 0 20px 0;
    width: 320px;
    overflow: hidden; 
    min-height: 570px;
    background-color: rgb(250, 250, 250);
	}
	.h5_info:after {
		margin-left: -25px;
	    position: absolute;
	    left: 50%;
	    bottom: 8px;
	    content: '';
	    width: 45px;
	    height: 45px;
	    border-radius: 50%;
	    border:1px solid #ddd;
	}
	.info_title:before, .info_title:after {
    content: " ";
    display: table;
}
	.info_title{
	width: 100%;
	height: 100px;
	border-top: 1px solid #ddd;
	margin-top: 10px;
	}
	
	.info_title:after{
	clear: both;
	}
	.left{
	float: left;
	}
	.logo{
	height: 70px;
	width: 70px;
	margin-top: 15px;
	margin-right: 1%;
	}
	.logo img{
	width: 70px;
	height: 70px;
	}
	.name{
	line-height: 100px;	
	color: black;
	}
	.introduce{
	width: 100%;
	height: auto;
	margin: 10px 0;
	}
	.introduce_title{
	text-align: center;
	color: black;
	font-size: 18px;
	}
	.introduce_cont{
	width: 100%;
	text-indent:2em;
	 padding:0px; 
	 margin:0px;
	}
	.pro_detail{
	width: 100%;
	}
	/* .pro_detail img{
	width: 100%;
	} */
	.pro_detail_title{
	width: 100%;
	text-align: left;
	color: black;
	margin-bottom: 0px;
	}
	
	
	/*素材类型  */
	input{
		border:none;
	}
	.content{
	width: 48%;
	background: white;
	float: right;
	}
	.modelOne .head{
		width: 90%;
		margin: 0 5%;
	}
	
	.modelOne .head .head_eg_name {
		width: 80%;
		font-size: 20px;
		color: #332b3a;
		border-bottom: 1px solid #a7a4aa;
		margin-top: 3px;
		padding: 10px 0;
	}
	.modelOne .head .head_ch_name {
		width: 70%;
		text-align: right;
		font-size: 18px;
		color: #332b3a;
		line-height: 38px;
		margin-top: 3px;
		font-weight: 600;
	}
	.preview-container {
	    width: 350px;
	    margin: 20px auto 0;
	}
	
	.setting-container {
	    margin-top: 20px;
	    padding-bottom: 64px;
	    width: 350px;
	    min-height: 100px;
	    border-radius: 18px;
	    border: 1px solid #dddddd;
	    position: relative;
	    overflow: hidden;
	}
	.phone-head {
    padding-top: 55px;
    line-height: 0;
    text-align: center;
	}
	
	.phone-head-icon {
	    display: inline-block;
	    width: 60px;
	    height: 8px;
	    border-radius: 10px;
	    background: #ddd;
	    position: relative;
	    transform: translateX(8px);
	}
	.phone-head-icon:before {
	    position: absolute;
	    left: -22px;
	    top: 0;
	    content: '';
	    width: 8px;
	    height: 8px;
	    border-radius: 50%;
	    background: #ddd;
	}
	.phone-head-icon:after {
	    margin-left: -7px;
	    position: absolute;
	    left: 50%;
	    top: -25px;
	    content: '';
	    width: 14px;
	    height: 14px;
	    border-radius: 50%;
	    background: #ddd;
	}
	.phone-title-seciton {
	    margin: 20px auto 0;
	    padding-top: 27px;
	    width: 320px;
	    height: 44px;
	    background: url(${ctxStatic}/admin/images/materialcommen/phone_head_bg.png) no-repeat 0 0;
	    background-size: 100%;
	}
	.app-header {
	    color: #fff;
	    line-height: 30px;
	    text-align: center;
	    font-size: 18px;
	    width: 160px;
	    margin-left: 80px;
	    white-space: nowrap;
	    word-break: break-all;
	    text-overflow: ellipsis;
	    overflow: hidden;
	}
	.h5_info{
	margin: 0 auto;
    padding: 0 0 20px 0;
    width: 320px;
    overflow: auto;
    overflow-x: hidden;
    height: 568px;
    background-color: rgb(250, 250, 250);
	}
	.h5_info:after {
		margin-left: -25px;
	    position: absolute;
	    left: 50%;
	    bottom: 8px;
	    content: '';
	    width: 45px;
	    height: 45px;
	    border-radius: 50%;
	    border:1px solid #ddd;
	}
	.info_title:before, .info_title:after {
    content: " ";
    display: table;
}
	.info_title{
	width: 100%;
	height: 100px;
	border-top: 1px solid #ddd;
	margin-top: 10px;
	}
	
	.info_title:after{
	clear: both;
	}
	
	.modelOne_content{
	width: 100%;
	background: url(${ctxStatic}/admin/images/materialcommen/model1_bg.png) no-repeat 0 0;
	background-size:100% 100%;
	padding: 40px 0;
	}
	.modelOne_introduce{
	width: 80%;
	background: #e8f0f2;
	border-radius:10px;
	margin: 0 auto;
	}
	.modelOne_con_head img{
	width: 25px;
    height: 25px;
    margin-top: 7.5px;
	}
	.modelOne_con_head{
	display: flex;
    justify-content: center;
    height: 40px;
    background: #fff;
    border-top-left-radius:10px;
    border-top-right-radius:10px;
	}
	.modelOne_con_head p{
		margin: 0px;
		line-height: 1;
		color: #332b3a;
	}
	.modelOne_con_head p:first-child{
		font-size: 18px;
		font-weight: 600;
	}
	.modelOne_con_head p:nth-child(2){
		font-size: 12px;
	}
	.modelOne_company_name{
	padding-top: 5px;
	margin-left: 5px;
	}
	.modelOne_foot{
	width: 100%;
	background: url(${ctxStatic}/admin/images/materialcommen/model1_foot.png) no-repeat 0 0;
	background-size:100%;
	padding-bottom: 10px;
	height: 100px;
	}
	.modelOne_foot p{
		width: 38%;
		float: right;
		height: 50px;
		margin-top: 45px;
		padding: 0 5px;
		color: #332b3a;
	}
	.modelOne_introduce_info{
	line-height: 2;
	padding: 5px;
	color: #332b3a;
	font-size: 14px;
	}
    </style>
    
</head>
<body>
    <div class="container">
    	<div class="setting-container preview-container">
    		<div class="phone-head">
            <span class="phone-head-icon"></span>
        	</div>
        	<div class="phone-title-seciton">
            <p class="app-header">${data.title}</p>
        	</div>
        	
        	<div class="h5_info">
        	
        		<c:choose>
        			<c:when test="${temp!='' && temp!=null}">
        			${fns:unescapeHtml(data.content)}
        			</c:when>
        			<c:otherwise>
        				<div class="pro_detail">
	        		<c:if test="${not empty data.imgAddr}">
	        			<c:set var="imgAddr" value="${fn:split(data.imgAddr, ',')}" />
		        		<c:forEach items="${imgAddr}" var="imgAddr">
		        			<img alt="" src="${fns:getUploadUrl()}${imgAddr}">
		        		</c:forEach>
        			</c:if>
	        		${fns:unescapeHtml(data.content)}
        		</div>
        	
        		 <div class="info_title">
        		 <c:if test="${not empty companyLogo}">
        			<div class="left logo"><img alt="" src="${fns:getUploadUrl()}${companyLogo}"></div>
<%--         			<div class="left name">${companyName}</div> --%>
				</c:if>
        		</div>
        		<div class="introduce_cont">${companyRemarks }</div>
        			</c:otherwise>
        		</c:choose>
        		
        	</div>
        	
        	
    	</div>
    </div>
    	
</body>
</html>