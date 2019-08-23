<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>${fns:getConfig('productName')} 登录</title>
        <meta name="decorator" content="default"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link type="image/x-icon" href="${ctxStatic}/admin/images/favicon.ico" rel="shortcut icon">
        <link rel="stylesheet" href="${ctxStatic}/admin/css/fullPage.css">
        <script type="text/javascript">
		$(document).ready(function() {
			$("#loginForm").validate({
				rules: {
					validateCode: {remote: "${pageContext.request.contextPath}/servlet/validateCodeServlet"}
				},
				messages: {
					username: {required: "请填写用户名."},password: {required: "请填写密码."},
					validateCode: {remote: "验证码不正确.", required: "请填写验证码."}
				},
				errorLabelContainer: "#messageBox",
				errorPlacement: function(error, element) {
					error.appendTo($("#loginError").parent());				
				} 
			});
			
			$('#loginForm').on('click',function(){
				setTimeout(function(){
					$('#messageBox').fadeOut();
				},2000)
			})
			
			$('#myCarousel').carousel({
				interval: 2000,
				 pause: 'none'
			})
			
			$("#tologin").click(function(){
				/* document.body.scrollTop = document.documentElement.scrollTop = 0; */
				window.location.reload();
			});
		});
		// 如果在框架或在对话框中，则弹出提示并跳转到首页
		if(self.frameElement && self.frameElement.tagName == "IFRAME" || $('#left').length > 0 || $('.jbox').length > 0){
			alert('未登录或登录超时。请重新登录，谢谢！');
			top.location = "${ctx}";
		}
	</script>
        <style>
          *{
            margin: 0;
            padding: 0;
          }
          body{
            /* font-family: 'Microsoft YaHei'; */
            font-family: 'HanHei SC', PingHei, 'PingFang SC', 'Helvetica Neue', Helvetica, Arial, 'Microsoft Yahei', 'Hiragino Sans GB', 'Heiti SC', 'WenQuanYi Micro Hei', sans-serif;
            line-height: normal;
          }
          /*版心*/
          .center{
            width: 80%;
            margin: 0 auto;
          }
          input {
            padding-top: 0;
            padding-bottom: 0;
            font-family: "SimSun",'Microsoft YaHei';
            border: 1px solid #dcdcdc;
          }
          select, input {
              vertical-align: middle;
          }
          select, input, textarea {
              /*font-size: 12px;*/
              margin: 0;
          }
          /*清除浮动*/
          .clearfix:before, .clearfix:after {
              content: "";
              display: table;
          }
          .clearfix:after {
              clear: both;
          }
          .clearfix {
              *zoom: 1;
          }
          .fl{
            float: left;
          }
          .fr{
            float: right;
          }
          .pr{
            position: relative;
          }
          .pa{
            position: absolute;
          }
          /*第一页*/
          #section_one{
            height: 100vh;
          }
          .topNav{
          width:100%;
            height: 10vh;
            background-color: rgba(0, 0, 0, 0.2);
            position: fixed;
            top: 0px;
            z-index: 1000;
            display: none;
          }
          #tologin {
			    cursor: pointer;
			    float: right;
			    height: 4vh;
			    line-height: 4vh;
			    width: 6%;
			    text-align: center;
			    color: #fff;
			    border: 1px solid #fff;
			    margin-right: 10%;
			    font-size: 18px;
			    border-radius:5px;
			}
          .bottom{
          position: relative;
          }
          .topNav .center{
            padding-top: 2.5vh;
          }
          #section_one .top .center div{
            float: right;
            height: 4vh;
            line-height: 4vh;
            width: 6%;
            text-align: center;
            color: #fff;
            border: 1px solid #fff;
            margin-right: 15px;
            font-size: 18px;
            
          }
          #section_one .bottom .center{
            height: 90vh;
          }
          #section_one .bottom img{
            left: 5%;
            top: 50%;
            transform: translateY(-50%);
          }
          #section_one .bottom .login{
            height: 50%;
            background-color: #fff;
            width: 30%;
            float: right;
            text-align: center;
            right: 0;
            top: 50%;
            transform: translateY(-60%);
          }
          #section_one .bottom .login .title{
            font-size: 18px;
            color: #444;
            font-weight: bold;
            margin-top: 20px;
            margin-bottom: 35px;
          }
          #section_one .bottom .login input{
            width: 65%;
            height: 8%;
            padding-left: 30px;
            margin-bottom: 25px;
          }
          #section_one .bottom .login input[placeholder]{
            padding-left: 35px;
            font-size: 13px;
            color: #c1c1c1;
          }
          #section_one .bottom .login .username{
            background: url(${ctxStatic}/images/login.png) no-repeat 8px center;
          }
          #section_one .bottom .login .password{
            background: url(${ctxStatic}/images/lock.png) no-repeat 8px center;
          }
          #section_one .bottom .login .identify{
            background: url(${ctxStatic}/images/message.png) no-repeat 8px center;
            width: 35%;
            margin-right: 10%;
          }
          #section_one .bottom .login span{
            border: 1px solid #dcdcdc;
            display: inline-block;
            width: 20%;
            height: 8%;
            vertical-align: top;
          }
          #section_one .bottom .login .sign_up{
            width: 73%;
            margin: 0 auto;
          }
          #section_one .bottom .login .sign_up a{
            text-decoration: none;
            color: #478ceb;
          }
          #section_one .bottom .login .submit{
            width: 73%;
            background-color: #478ceb;
            padding: 0;
            border: 0;
            height: 12%;
            border-radius: 5px;
            margin-top: 8%;
            font-size: 16px;
            color: #fff;
            font-weight: 600;
          } 
          /*第二页*/
           #section_two,#section_three{
            height: 100vh;
             color: white;
          }
          #section_two .center,#section_three .center,#section_four .center,#section_five .center{
            height: 100vh;
          }
          #section_two img{
            transform: translateY(-50%);
          }
          .form-signin {
		    position: relative;
		    text-align: center;
		    width: 300px;
		    padding: 25px 29px 29px;
		    background-color: #fff;
		    border: 1px solid #e5e5e5;
		    -webkit-border-radius: 5px;
		    -moz-border-radius: 5px;
		    border-radius: 5px;
		    -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
		    -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
		    box-shadow: 0 1px 2px rgba(0,0,0,.05);
		    top:15%;
		    float: right;
		} 
		.form-signin .input-label {
    font-size: 16px;
    line-height: 23px;
    color: #999;
}
label {
    display: inline-block;
    margin-bottom: 0;
}
.form-signin .input-block-level {
    font-size: 16px;
    height: auto;
    margin-bottom: 15px;
    padding: 7px;
    _padding: 7px 7px 9px 7px;
}
.form-signin .btn.btn-large {
    font-size: 16px;
}
.alert {
    position: relative;
    width: 300px;
    margin: 0 auto;
}
label.error {
    background: none;
    width: 270px;
    font-weight: normal;
    color: inherit;
    margin: 0;
}
.input-block-level {
    display: block;
    width: 100%;
    min-height: 30px;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
    border-radius: 4px;
}
.header {
    height: 80px;
    padding-top: 20px;
}
#tologin{
cursor: pointer;
}
.form-signin div.validateCode {
    padding-bottom: 15px;
}
.form-signin-heading {
 	position: relative;
    font-family: Helvetica, Georgia, Arial, sans-serif, 黑体;
    font-size: 36px;
    margin-bottom: 20px;
    color: white;
    text-align: center;
    margin-top: 20px;
    top:15%;
}
.footer{
	width: 100%;
    height: 50px;
    text-align: center;
    position: absolute;
    bottom: 10px;
    color: white;
}
.bott{
text-align: center;
  width: 50%;
  color: white;
  position: absolute;
  right: -100%;
  display: inline-block;
  top:70%;
}
.bottom_item{
position: absolute;left: -100%;display: inline-block;
}
/* ::-webkit-scrollbar {
    width: 0px;
    height: 0px;
} */
	.fontSend{ font-size: 24px;
            line-height:35px;}
  .left_item{position: absolute;left: -100%;display: inline-block;}
   .right_item{position: absolute;right: -100%;display: inline-block;} 
  .fontColor{color:#fff; font-size: 40px;
            font-weight: 500;
            margin-bottom: 30px;}	
  .btn-primary,.btn-primary:HOVER{background-color:#478ceb;}
   
        </style>
    </head>
    <body>
    
    <div class="topNav clearfix">
      <img alt="" src="${ctxStatic}/images/logo.png" style="height: 5.5vh;margin-left: 15%;float: left;margin-top: 2vh">
       <div class="center clearfix">
         <div id="tologin">登录</div>
       </div>
     </div>
      
    <div id="loginPage">
      <div id="section_one" class="section">
          <%-- <div class="top clearfix">
           <img alt="" src="${ctxStatic}/images/logo.png" style="height: 8vh;margin-left: 50px;float: left;margin-top: 1vh">
            <div class="center clearfix">
              <div id="tologin">登录</div>
            </div>
          </div> --%>
          <div class="bottom"> 
            <div class="center pr">
              <img src="${ctxStatic}/images/login01.png" alt="" class="pa left_item">
              <!--[if lte IE 6]><br/><div class='alert alert-block' style="text-align:left;padding-bottom:10px;"><a class="close" data-dismiss="alert">x</a><h4>温馨提示：</h4><p>你使用的浏览器版本过低。为了获得更好的浏览体验，我们强烈建议您 <a href="http://browsehappy.com" target="_blank">升级</a> 到最新版本的IE浏览器，或者使用较新版本的 Chrome、Firefox、Safari 等。</p></div><![endif]-->
              
                 <div class="header">
				<div id="messageBox" class="alert alert-error ${empty message ? 'hide' : ''}"><button data-dismiss="alert" class="close">×</button>
					<label id="loginError" class="error">${message}</label>
				</div>
				</div>
              <div class="right_item" style='right:10%;top:30%'>
              	<h1 class="form-signin-heading">${fns:getConfig('productName')}</h1>
	              <form id="loginForm" class="form-signin" action="${ctx}/login" method="post" style="text-align: left;">
					<label class="input-label" for="username">登录名</label>
					<input type="text" id="username" name="username" class="input-block-level required" value="${username}">
					<label class="input-label" for="password">密码</label>
					<input type="password" id="password" name="password" class="input-block-level required">
					<c:if test="${isValidateCodeLogin}"><div class="validateCode">
						<label class="input-label mid" for="validateCode">验证码</label>
						<tags:validateCode name="validateCode" inputCssStyle="margin-bottom:0;"/>
					</div></c:if><%--
					<label for="mobile" title="手机登录"><input type="checkbox" id="mobileLogin" name="mobileLogin" ${mobileLogin ? 'checked' : ''}/></label> --%>
					<input class="btn btn-large btn-primary" type="submit" value="登 录"/>&nbsp;&nbsp;
					<label for="rememberMe" title="下次不需要再登录"><input type="checkbox" id="rememberMe" name="rememberMe" ${rememberMe ? 'checked' : ''}/> 记住我（公共场所慎用）</label>
				</form>
              </div>
           
            </div> 
         </div>
      </div>
      <div id="section_two" class="section">
        <div class="center pr">
          <img src="${ctxStatic}/images/login02.png" alt="" class="pa bottom_item" >
          <div class="left pa bott">
            <p class='fontColor'>多端融合快速成单</p>
            <p class="fontSend">依托国内最大社交用户聚集平台微信，打造强大的智能客户跟进管理系统，助您智能跟进高效成单。</p>
          </div>
        </div>
      </div>
      <div id="section_three" class="section">
        <div class="center pr">
          <img src="${ctxStatic}/images/login03.png" alt="" class="pa bottom_item">
          <div class="left pa bott">
            <p class='fontColor'>可视化报表随时掌握核心数据</p>
            <p class="fontSend">全面实时的可视化报表统计，随时掌握企业核心运营数据，为企业的运营决策人员提供强大支撑。</p>
          </div>
        </div>
      </div>
      <div id="section_four" class="section">
        <div class="center pr">
          <img src="${ctxStatic}/images/login04.png" alt="" class="pa bottom_item">
          <div class="left pa bott">
            <p class='fontColor'>高效便捷的智能客户管理系统</p>
            <p class="fontSend">精准分类无缝衔接的客户分组及任务系统，助您轻松高效管理客户资源。</p>
          </div>
        </div>
      </div>
      <div id="section_five" class="section">
        <div class="center pr">
          <img src="${ctxStatic}/images/login05.png" alt="" class="pa bottom_item">
          <div class="left pa bott">
            <p class='fontColor'>智能标签系统助您精准营销</p>
            <p class="fontSend">基于客户大数据分析打造的智能客户标签系统，为企业精准营销提供强大支持，让每一次营销都志在必得。</p>
          </div>
        </div>
        <div class="footer">
		Copyright © 2016-2017 <a href="/oms-web">OMS</a> -V1.1.0 
	</div>
      </div>
     
</div>	
      <script src="${ctxStatic}/common/fullPage.min.js" type="text/javascript"></script>
      <script src="${ctxStatic}/common/easing.min.js" type="text/javascript"></script>
      <script type="text/javascript">
      
          $(function(){
            $('#loginPage').fullpage({
                sectionsColor: ['#5093ee', '#4266ea', '#17c17e', '#4559c7','#10bc9d'], //设置每一屏的背景颜色
                navigation:true, //是否显示导航小园点
                navigationPosition:'right',
                navigationColor:'#000',
                css3:true,
                //滚动到某一屏后的回调函数，接收 anchorLink 和 index 两个参数，anchorLink 是锚链接的名称，index 是序号，从1开始计算
                afterLoad: function(anchorLink, index){
                    if(index == 1){
                        $('#section_one').find('.left_item').delay(200).animate({
                            left:'5%',opacity:1,top:'50%',transform: 'translateY(-50%)'
                        },1000,'easeOutQuint');
                        $('#section_one').find('.right_item').delay(200).animate({
                            right:'10%',opacity:1,top:'30%'       
                        },1000,'easeOutQuint');
                        $('.topNav').css('display','none');
                    }

                    if(index == 2){
                        $('#section_two').find('.bottom_item').delay(200).animate({
                            left:'32%',opacity:1,top:'38%',transform: 'translateY(-50%)'
                        },1000,'easeOutQuint');
                        $('#section_two').find('.bott').delay(200).animate({
                        	right:'25%',opacity:1,top:'70%'       
                        },1000,'easeOutQuint');
                        $('.topNav').fadeIn(500);
                        
                    }

                    if(index == 3){
                    	 $('#section_three').find('.bottom_item').delay(200).animate({
                             left:'34%',opacity:1,top:'15%',transform: 'translateY(-50%)'      
                         },1000,'easeOutQuint');
                        $('#section_three').find('.bott').delay(200).animate({
                        	right:'25%',opacity:1,top:'75%'
                        },1000,'easeOutQuint');
                    }

                    if(index == 4){
                        $('#section_four').find('.bottom_item').delay(200).animate({
                            left:'35%',opacity:1,top:'15%',transform: 'translateY(-50%)'
                        },1000,'easeOutQuint');
                        $('#section_four').find('.bott').delay(200).animate({
                        	right:'25%',opacity:1,top:'70%'       
                        },1000,'easeOutQuint');
                    }

                    if(index == 5){
                        $('#section_five').find('.bottom_item').delay(200).animate({
                            left:'23%',opacity:1,top:'15%'
                        },1000,'easeOutQuint');
                        $('#section_five').find('.bott').delay(200).animate({
                        	right:'25%',opacity:1,top:'65%',transform: 'translateY(-50%)'      
                        },1000,'easeOutQuint');
                    }

                },
                /*滚动前的回调函数，接收 index、nextIndex 和 direction 3个参数：
                index 是离开的“页面”的序号，从1开始计算；
                nextIndex 是滚动到的“页面”的序号，从1开始计算；
                direction 判断往上滚动还是往下滚动，值是 up 或 down。*/
                 onLeave: function(index, direction){
                    if(index == '1'){
                        $('#section_one').find('.left_item').animate({
                            left:'-100%',opacity:0
                        },1000,'easeOutExpo');
                        $('#section_one').find('.right_item').animate({
                            right:'-100%',opacity:0
                        },1000,'easeOutExpo');
                    }

                    if(index == '2'){
                        $('#section_two').find('.bottom_item').delay(200).animate({
                        	left: "-100%",opacity:0  
                        },1000,'easeOutExpo');
                        $('#section_two').find('.bott').delay(200).animate({
                        	right: "-100%",opacity:0 
                        },1000,'easeOutExpo');
                    }

                    if(index == '3'){
                        $('#section_three').find('.bottom_item').delay(200).animate({
                        	left: "-100%",opacity:0 
                        },1000,'easeOutExpo');
                        $('#section_three').find('.bott').delay(200).animate({
                        	right: "-100%",opacity:0  
                        },1000,'easeOutExpo');
                    }

                     if(index == '4'){
                        $('#section_four').find('.bottom_item').delay(200).animate({
                        	left: "-100%",opacity:0 
                        },1000,'easeOutExpo');
                        $('#section_four').find('.bott').delay(200).animate({
                        	right: "-100%",opacity:0 
                        },1000,'easeOutExpo');
                    }

                    if(index == '5'){
                        $('#section_five').find('.bottom_item').delay(200).animate({
                        	left: "-100%",opacity:0
                        },1000,'easeOutExpo');
                        $('#section_five').find('.bott').delay(200).animate({
                        	right: "-100%",opacity:0
                        },1000,'easeOutExpo');
                    }

                } 
            });
        });
  
    </script>
    </body>
</html>