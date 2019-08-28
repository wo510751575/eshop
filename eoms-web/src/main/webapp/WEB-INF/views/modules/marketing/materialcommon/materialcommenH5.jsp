<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>${data.title}</title>
    <meta name="decorator" content="default"/>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<script type="text/javascript" src="${ctxStatic}/common/ajaxfileupload.js"></script>
	<script type="text/javascript" src="${ctxStatic}/editor/kindeditor.js"></script>
	<script type="text/javascript" src="${ctxStatic}/editor/init.js"></script>
	<script src="${ctxStatic}/common/plupload.full.min.js" type="text/javascript"></script>
	<link href="${ctxStatic}/admin/css/model.css" type="text/css" rel="stylesheet" />
    <style type="text/css">
    html, body {
    margin: 0;
    padding: 0;
    width: 100%;
    height: 100%;
    line-height: 1.5;
    font-family: "微软雅黑", Arial;
    color: #666;
    font-size: 15px;
      -webkit-overflow-scrolling: touch;
	   overflow-y:scroll;
	}
	 .container {
	    width: 100%;
	    background: #fff;
	    padding: 0px;
	    -webkit-overflow-scrolling: touch;
	   overflow-y:scroll;
	}
	.h5_info{
	margin: 0 auto;
    width: 100%;
    background-color:white;
    margin-bottom: 10px;
	}
	.info_title:before, .info_title:after {
    content: " ";
    display: table;
	}
	.info_title{
	width: 98%;
	height: 90px;
	padding-left: 2%;
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
	margin-top: 10px;
	margin-right: 1%;
	}
	.logo img{
	width: 70px;
	height: 70px;
	}
	.name{
	width:75%;
	line-height: 90px;	
	color: black;
	overflow: hidden; white-space: nowrap; text-overflow: ellipsis;
	}
	.introduce{
	width: 96%;
	height: auto;
	padding: 10px 0px;
	margin-left:2%;
	border-top: 1px solid #ddd;
	}
	.introduce_title{
	text-align: center;
	color: black;
	font-size: 18px;
	}
	.introduce_cont{
	width: 96%;
	height:auto;
	text-indent:2em;
	 padding:0px 2%; 
	 margin:0px;
	}
	.pro_detail{
	width: 100%;
	margin:0 auto;
	}
	/* .pro_detail img{
	width: 100%;
	} */
	.pro_detail_title{
	width: 96%;
	text-align: left;
	color: black;
	margin-left: 2%;
	}
	.company{
	width: 96%;
	margin: 2% auto;
	border-top: 1px solid #ddd;
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
        	<div class="h5_info">
        	<c:choose>
        			<c:when test="${temp!='' && temp!=null}">
        			${fns:unescapeHtml(data.content)}
        			</c:when>
        			<c:otherwise>
        		<div class="pro_detail">
        			<c:if test="${not empty data.imgAddr}">
	        			<c:set var="imgAddr" value="${fn:split(data.imgAddr, ',')}" />
		        		<c:forEach items="${imgAddr }" var="imgAddr">
		        			<img alt="" src="${fns:getUploadUrl()}${imgAddr }">
		        		</c:forEach>
        			</c:if>
					${fns:unescapeHtml(data.content)}
        		</div>
        		 <div class="info_title">
        		 	<c:if test="${not empty companyLogo}">
	        			<div class="left logo"><img alt="" src="${fns:getUploadUrl()}"></div>
	<%--         			<div class="left name">${companyName}</div> --%>
					</c:if>
        		</div>
        		<div class="introduce_cont">${companyRemarks }</div>
        		</c:otherwise>
        		</c:choose>
        	</div>
    	</div>
    </div>
    <script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
	<script type="text/javascript">

	 $(document).ready(function() {
			var shareLink="";
			var localurl=location.href.split('#')[0];
			  $.ajax({
			    type : "get",
			    url : "${ctx}/weixin/weixinsdk?url="+encodeURIComponent(localurl),
			    dataType : "json",
			    success : function(data){
			    	shareLink="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+data.appId+"&redirect_uri="+window.location.href+"&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
			        wx.config({
			        debug: false,  // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
			        appId: data.appId,  // 必填，公众号的唯一标识
			        timestamp: data.timestamp,  // 必填，生成签名的时间戳
			        nonceStr: data.noncestr,    // 必填，生成签名的随机串
			        signature: data.signature,  // 必填，签名，见附录1
			        jsApiList: [
						'checkJsApi',
						'onMenuShareTimeline',
						'onMenuShareAppMessage',
						'onMenuShareQQ',
						'onMenuShareWeibo',
						'hideMenuItems',
						'showMenuItems',
						'hideAllNonBaseMenuItem',
						'showAllNonBaseMenuItem',
						'translateVoice',
						'startRecord',
						'stopRecord',
						'onRecordEnd',
						'playVoice',
						'pauseVoice',
						'stopVoice',
						'uploadVoice',
						'downloadVoice',
						'chooseImage',
						'previewImage',
						'uploadImage',
						'downloadImage',
						'getNetworkType',
						'openLocation',
						'getLocation',
						'hideOptionMenu',
						'showOptionMenu',
						'closeWindow',
						'scanQRCode',
						'chooseWXPay',
						'openProductSpecificView',
						'addCard',
						'chooseCard',
						'openCard'
					]
					});
					},
          error:function(data){
             /*  alert("连接失败！"+data.errMsg ); */
          }
			});
			  var shareTitle="${data.title}";
				var shareDesc="${companyRemarks }";
				var shareImageUrl="${fn:split(data.imgAddr, ',')[0]}";
			    //发送朋友或分享朋友圈回调函数，ajax调用
			 	wx.ready(function(){
				    //alert("js权限校验成功");
				    // config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
				    //定义发送朋友
				    wx.onMenuShareAppMessage({
				      title: shareTitle, // 分享标题
				      desc: shareDesc, // 分享描述
				      link:shareLink, // 分享链接
				      imgUrl: shareImageUrl, // 分享图标
				      type: '', // 分享类型,music、video或link，不填默认为link
				      dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
				      success: function () {
				        // 用户确认分享后执行的回调函数
				      },
				      cancel: function () {
				        // 用户取消分享后执行的回调函数
				      }
				    });
				    //定义分享朋友圈
				    wx.onMenuShareTimeline({
				      title: shareTitle, // 分享标题
				      link:shareLink, // 分享链接
				      imgUrl: shareImageUrl, // 分享图标
				      success: function () {
				        // 用户确认分享后执行的回调函数

			   		 //	alert("朋友圈分享success");
				      },
				      cancel: function () {
				        // 用户取消分享后执行的回调函数
				      }
				    });
				    //隐藏qq分享菜单及复制链接
				    wx.hideMenuItems({
				      menuList: [
//				          'menuItem:copyUrl'
				      ] // 要隐藏的菜单项，只能隐藏“传播类”和“保护类”按钮，所有menu项见附录3
				    });
				  });
				  wx.error(function(res){
				   // alert("js权限校验失败");
				    // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
				  });
		 
	    });
</script>
    	
</body>
</html>