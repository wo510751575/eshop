<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>${fns:getConfig('productName')}管理平台</title>
<link rel="stylesheet" type="text/css" href="${ctxStatic}/admin/css/bootstrap.min.css">
<link href="${ctxStatic}/bootstrap/2.3.1/awesome/font-awesome.min.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href='${ctxStatic}/admin/css/theme_styles${layout==null?"_blue":layout}.css'>
<link type="image/x-icon" href="${ctxStatic}/admin/images/favicon.ico" rel="shortcut icon">
<%-- <link href="${ctxStatic}/admin/css/css" rel="stylesheet" type="text/css"> --%>
<link href="${ctxStatic}/jquery-jbox/2.3/Skins2/Blue/jbox.css" rel="stylesheet" />	
<!--[if lt IE 9]>
		<script src="js/html5shiv.js"></script>
		<script src="js/respond.min.js"></script>
	<![endif]-->
<style type="text/css">
.cf-hidden {
	display: none;
}
.cf-invisible {
	visibility: hidden;
}
.logotitle{
  line-height: 30px;
  font-size: 30px;
}
.logotitle span{
  font-size: 18px;position: absolute;margin-left: 15px;
}
div.jbox .jbox-container {
    background-color: #fff;
    border: 1px solid #b3acac;
}
div.jbox .jbox-button-panel {
    border-top: 1px solid #eee;
    background-color: #fafafa;
}
/* div.jbox .jbox-button { */
/*     background: transparent; */
/*     border: #e0e6eb 1px solid; */
/*     color: #888; */
/*     border-radius: 3px 3px 3px 3px; */
/*     margin: 1px 7px 0 0; */
/*     height: 22px; */
/*     cursor: pointer; */
/* } */
/* div.jbox .jbox-title-panel { */
/*     background: #fff; */
/*     border-bottom: 1px solid #eee; */
/*     color: #888; */
/* } */
#menu .active a{
     background-color: #fff;
}
.theme-whbl #header-navbar .nav>li>a:hover,.theme-whbl #header-navbar .nav>li>a:focus{
     background-color: #3C8DBC;
}
.theme-whbl #header-navbar{
background-color:#3C8DBC;
}
.theme-whbl #header-navbar .nav>li>a>span,.theme-whbl #header-navbar .nav>li>a{
color: white;
}
#menu li{border-right: 1px solid #3981ab;}
.navbar>.container .navbar-brand{
    padding-left: 20px;
    font-weight: 500 !important;
}
.mainul{
    list-style: none;
}
#sidebar-nav .nav>li.menu_title>a>span {
    margin-left: 0px;
    color:rgba(255, 255, 255, 0.78);
}
.nav-small .menu_title{display:none;}
.t{color:#4ab2f1;}
.nav-small #nav-col #user-left-box {
    display: block;
}
.nav-small #user-left-box .user-box{
  display:none;
}
.nav-small #user-left-box img {
    width: 50px;
    margin-left: 0px;
}
.nav-small #user-left-box {
    padding: 7px 7px;
}
#logo.logo-small{width: 64px;padding-left: 15px;}
#logo.logo-small span{display:none;}
#sidebar-nav .nav>li.menu_title{pointer-events: none;}
#sidebar-nav .nav>li.menu_title>a{
  padding-left:10px;
}
.theme-whbl .nav-small #nav-col #sidebar-nav .nav-pills>li.active>a{
    background-color: rgba(255, 255, 255, 0.12);
    margin-left: 6px;
    margin-right: 10px;
    padding-left: 14px;
    border-radius: 4px;
}
.theme-whbl .nav-small #user-left-box{
    border-bottom: 1px solid #23b7e5;
}
._lightblue{color:#23b7e5;}
._black{color:#2C3E50;}
._darkblue{color:#3C8DBC;}
._green{color:#00ADA7;}

#sidebar-nav .active { 
background-color: rgba(255, 255, 255, 0.12);
    border-color: #6ba7ca;
    border-bottom-color: #6ba7ca;
    color: rgba(255,255,255,.89);
 } 

.chose span{
height:78px;
border-bottom: 2px solid #204e69 !important; 
}
.chose a span{
display:inline-block;
color:#204e69 !important;
}
.menu_title span{
display: inline-block !important;
height: 45px !important;

}
.menu_title span:hover {
color:#204e69 !important;
}
#header-navbar,.navbar-brand,#header-navbar .nav>li>a{
min-height: 80px;
}
.navbar-nav>li>a{
padding-top: 30px;
font-size: 1.7rem !important;
}
.theme-whbl .navbar>.container .navbar-brand{
background-color: #204e69 !important;
}

#header-navbar .nav>li>a>span.count {
    background: none repeat scroll 0 0 #e74c3c;
    border-radius: 50%;
    background-clip: padding-box;
    color: #fff;
    display: block;
    font-size: 9px;
    height: 16px !important;
    line-height: 16px !important;
    position: absolute;
    right: 10px;
    text-align: center;
    top: 23px;
    width: 16px !important;
}
#logo.navbar-brand>img{
width:60px;
 height:60px !important;
 border-radius:100%;
 padding-right:0px;
}
#header-navbar .profile-dropdown>a{
padding-top: 23px !important;
}
.theme-whbl #header-navbar .nav .open>a{
background-color: #3C8DBC !important;
}
.navbar-nav>li>.dropdown-menu{
min-width:150px;
}
.theme-whbl .navbar-toggle:hover,.navbar-toggle:hover{
background:#3C8DBC;
}

</style>
</head>
<body class="pace-done theme-whbl">
	<div class="pace  pace-inactive">
		<div class="pace-progress" data-progress-text="100%"
			data-progress="99" style="width: 100%;">
			<div class="pace-progress-inner"></div>
		</div>
		<div class="pace-activity"></div>
	</div>
	<div id="theme-wrapper">
		<header class="navbar" id="header-navbar">
			<div class="container">
							<a href="${ctx}/sys/user/info" target="mainFrame" id="logo" class="navbar-brand logotitle"> 
								<c:if test="${!empty user_photo}">
						      	 <img alt=""  src="${fns:getUploadUrl()}${user_photo}"/>
						       </c:if>
						       <c:if test="${empty user_photo}">   
						             <img alt="" src="${ctxStatic}/admin/images/user-logo.jpg">
						       </c:if>
 									<span class="name" style="font-size: 0.5em;">
										您好<br>
										<shiro:principal property="name"/>
									</span>
									<span class="status">
									</span>

							</a>
				<div class="clearfix">
					<button class="navbar-toggle" data-target=".navbar-ex1-collapse"
						data-toggle="collapse" type="button" style="padding-top: 28px">
						 <span class="icon-reorder"></span>
					</button>
					<div
						class="nav-no-collapse navbar-left pull-left hidden-sm hidden-xs">
						<ul id="menu" class="nav navbar-nav pull-left">
							<li><a class="btn" id="make-small-nav"> <i
									class="icon-reorder"></i>
							</a></li>
						</ul>
					</div>
					<div class="pull-left">
						<ul class="nav nav-pills navbar-nav">
						
								<!-- 									一级菜单 -->
									<c:set var="firstMenu" value="true"/>
									<c:set var="menuList" value="${fns:getMenuList()}"/>
									 <c:forEach items="${menuList}" var="menu" >
										<c:if test="${menu.parent.id eq '1' && menu.isShow eq '1'}">
										     <li class="menu_title menu pull-left ${firstMenu?'chose':''}">
												<c:if test="${empty menu.href}">
													<a class="menu" href="javascript:" data-href="${ctx}/sys/menu/tree?parentId=${menu.id}" data-id="${menu.id}"><span><i class="icon-${menu.icon}"></i>&nbsp;${menu.name}</span></a>
												</c:if>
												<c:if test="${not empty menu.href}">
													<a class="menu" href="${fn:indexOf(menu.href, '://') eq -1 ? ctx : ''}${menu.href}" data-id="${menu.id}" target="${not empty menu.target?menu.target:'mainFrame'}"><span><i class="icon-${menu.icon}"></i>${menu.name}</span></a>
												</c:if>
											</li>
											<c:set var="firstMenu" value="false" />
										</c:if>
									</c:forEach>			
						</ul>					
					</div>
					<div class="nav-no-collapse pull-right" id="header-nav">
						<ul class="nav navbar-nav pull-right collapse navbar-collapse navbar-ex1-collapse ">
						  <li class="dropdown">
								<a class="btn dropdown-toggle" data-toggle="dropdown">
								<i class="icon-fire"></i>
								<span class="hidden-xs">主题</span>
								</a>
								<ul class="dropdown-menu">
								    <c:forEach items="${fns:getDictList('sys_layout')}" var="item">
									    <li class="item">
											<a href="${ctx}/changeLayout?layout=${item.value}">
												<i class="icon-circle ${item.value}"></i>${item.label}
											</a>
										</li> 
									</c:forEach>
								</ul>
							</li>
						  
						  <%--  <li class="hidden-xxs"><a href="${ctx}" class="btn">
						   <i class="icon-bookmark"></i> 网站首页 
							</a></li> --%>
						   
						   <%-- <li class="dropdown hidden-xs">
								<a class="btn dropdown-toggle" data-toggle="dropdown">
								<i class="icon-globe"></i>
								<span class="hidden-xs">${current_lang.name}</span>
								</a>
								<ul class="dropdown-menu">
								    <c:forEach items="${langList}" var="item">
								    <li class="item">
										<a href="${ctx}/changeLang?id=${item.id}" >
											${item.name}
										</a>
									</li>
									</c:forEach>							
								</ul>
							</li> --%>
						    
<!-- 						    <li class="dropdown hidden-xs"> -->
<!-- 								<a class="btn dropdown-toggle" data-toggle="dropdown"> -->
<!-- 								<i class="icon-bell-alt"></i> -->
<!-- 								<span class="count">2</span> -->
<!-- 								</a> -->
<!-- 								<ul class="dropdown-menu notifications-list"> -->
<!-- 									<li class="pointer"> -->
<!-- 									<div class="pointer-inner"> -->
<!-- 									<div class="arrow"></div> -->
<!-- 									</div> -->
<!-- 									</li> -->
<!-- 									<li class="item-header">你有2个新通知</li> -->
<!-- 									<li class="item"> -->
<!-- 									<a href="#"> -->
<!-- 									<i class="fa fa-comment"></i> -->
<!-- 									<span class="content">新的询价单</span> -->
<!-- 									<span class="time"><i class="fa fa-clock-o"></i>5 分钟前.</span> -->
<!-- 									</a> -->
<!-- 									</li> -->
<!-- 									<li class="item"> -->
<!-- 									<a href="#"> -->
<!-- 									<i class="fa fa-eye"></i> -->
<!-- 									<span class="content">新订单</span> -->
<!-- 									<span class="time"><i class="fa fa-clock-o"></i>13 分钟前.</span> -->
<!-- 									</a> -->
<!-- 									</li> -->
<!-- 									<li class="item-footer"> -->
<!-- 									<a href="#"> -->
<!-- 									查看所有通知 -->
<!-- 									</a> -->
<!-- 									</li> -->
<!-- 								</ul> -->
<!-- 							</li> -->
							<li class="dropdown profile-dropdown"><a
								href="#"
								class="dropdown-toggle" data-toggle="dropdown"> 
						<%-- <c:if test="${!empty user_photo}">
						       <img alt="" width="35px" height="35px" src="${user_photo}"/>
						       </c:if>
						       <c:if test="${empty user_photo}">
						             <img alt="" width="35px" height="35px" src="${ctxStatic}/admin/images/user-logo.jpg">
						       </c:if> --%>
									<span
									class="hidden-xs"><shiro:principal property="name"/></span> <b class="caret"></b>
							</a>
								<ul class="dropdown-menu">
									<li><a
										href="${ctx}/sys/user/info" target="mainFrame"><i
											class="icon-user"></i>个人信息</a></li>
											<li><a
										href="${ctx}/sys/user/modifyPwd" target="mainFrame"><i
											class="icon-lock"></i>修改密码</a></li>
								</ul></li>
							<li class="hidden-xxs"><a href="${ctx}/logout" class="btn"> <i
									class="icon-off"></i>
							</a></li>
						</ul>
					</div>
				</div>
			</div>
		</header>
		<div id="page-wrapper" class="container">
			<div class="row">
			  <!-- left -->       
				<div id="nav-col">
					<section id="col-left" class="col-left-nano">
						<div id="col-left-inner" class="col-left-nano-content">
						    
							<div class="" id="sidebar-nav">
								<ul class="nav nav-pills nav-stacked">
									<c:set var="firstMenu" value="true"/>
									<c:set var="menuList" value="${fns:getMenuList()}"/>
									 <c:forEach items="${menuList}" var="menu" >
										<c:if test="${menu.parent.id eq '1' && menu.isShow eq '1'}">
										    <%--  <li class="menu_title menu" >
												<c:if test="${empty menu.href}">
													<a class="menu" href="javascript:" data-href="${ctx}/sys/menu/tree?parentId=${menu.id}" data-id="${menu.id}"><span>${menu.name}</span></a>
												</c:if>
												<c:if test="${not empty menu.href}">
													<a class="menu" href="${fn:indexOf(menu.href, '://') eq -1 ? ctx : ''}${menu.href}" data-id="${menu.id}" target="mainFrame"><span>${menu.name}</span></a>
												</c:if>
											</li> --%>
											
												
<%-- 												<c:forEach items="${menuList}" var="menu2"> --%>
<%-- 											          <c:if test="${menu2.parent.id eq (not empty menu.id ? menu.id:1)&&menu2.isShow eq '1'}"> --%>
<%-- 														<li class="${firstMenu?'open active':''}"> --%>
														
<%-- 														<a href="#" title="${menu2.remarks}" class="dropdown-toggle"> --%>
<%-- 															<i class="icon-${not empty menu2.icon?menu2.icon:'circle-arrow-right'}"></i>&nbsp; --%>
<%-- 																<span>${menu2.name}</span> --%>
<!-- 															<i class="fa icon-chevron-right drop-icon"></i> -->
<!-- 														</a> -->
														
<!-- 															<ul class="submenu"> -->
<%-- 															    <c:forEach items="${menuList}" var="menu3"> --%>
<%-- 																			<c:if test="${menu3.parent.id eq menu2.id&&menu3.isShow eq '1'}"> --%>
<!-- 																		<li><a  -->
<%-- 																			href="${fn:indexOf(menu3.href, '://') eq -1?ctx:''}${not empty menu3.href?menu3.href:'/404'}" --%>
<%-- 																			target="${not empty menu3.target?menu3.target:'mainFrame'}"> --%>
<%-- 																				<i class="icon-${not empty menu3.icon?menu3.icon:'circle-arrow-right'}"></i>&nbsp;${menu3.name} --%>
<!-- 																		</a></li> -->
<%-- 																		<c:set var="firstMenu" value="false" /> --%>
<%-- 																	</c:if> --%>
<%-- 																</c:forEach> --%>
<!-- 															</ul></li> -->
<%-- 															<c:set var="firstMenu" value="false"/> --%>
<%-- 													</c:if> --%>
<%-- 												</c:forEach> --%>
												
												<c:forEach items="${menuList}" var="menu2">
												<c:if test="${menu2.parent.id eq (not empty menu.id ? menu.id:1)&&menu2.isShow eq '1'}">
													<li class="${firstMenu?'open active':''}  ${menu.id}">
													
														<c:if test="${not empty menu2.href}">
															<a class="menu2 menuHide" href="${fn:indexOf(menu2.href, '://') eq -1?ctx:''}${not empty menu2.href?menu2.href:'/404'}"  title="${menu2.remarks}"  target="${not empty menu2.target?menu2.target:'mainFrame'}">
																<i class="icon-${not empty menu2.icon?menu2.icon:'circle-arrow-right'}"></i>&nbsp;
																<span>${menu2.name}</span>
															</a>
														</c:if>
														<c:if  test="${empty menu2.href}">
															<a href="#" title="${menu2.remarks}" class="dropdown-toggle menuHide">
																<i class="icon-${not empty menu2.icon?menu2.icon:'circle-arrow-right'}"></i>&nbsp;
																<span>${menu2.name}</span>
																<i class="fa icon-chevron-right drop-icon"></i>
															</a>
															<ul class="submenu">
															<c:forEach items="${menuList}" var="menu3">
																<c:if test="${menu3.parent.id eq menu2.id&&menu3.isShow eq '1'}">
																	<li><a href="${fn:indexOf(menu3.href, '://') eq -1?ctx:''}${not empty menu3.href?menu3.href:'/404'}"
																		target="${not empty menu3.target?menu3.target:'mainFrame'}">
																			<i class="icon-${menu3.icon}"></i>&nbsp;${menu3.name}
																	</a></li>
																	<c:set var="firstMenu" value="false" />
																</c:if>
															</c:forEach>
														</ul>
														</c:if>
														</li>
													<c:set var="firstMenu" value="false" />
												</c:if>
											</c:forEach>
												
										</c:if>
									 </c:forEach>
								</ul>	 
							</div>
						</div>
					</section>
				</div>
				<!-- left end -->
				
				<!-- right -->
				<div id="content-wrapper">
					<iframe id="mainFrame" name="mainFrame" src="" style="overflow:visible;border-radius: 3px;"

						scrolling="no" frameborder="no" width="100%" height="650">

					</iframe>
					
					<!-- footer -->
					<footer id="footer-bar" class="row" style="opacity: 1;">
						<p id="footer-copyright" class="col-xs-12">
							© 2017 <a href="#">${fns:getConfig('productName')}</a>. Powered by ${fns:getConfig('company')} ${fns:getConfig('version')}.
						</p>
					</footer>
				</div>
			</div>
		</div>
	</div>
	<script src="${ctxStatic}/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>
	<script src="${ctxStatic}/admin/js/bootstrap.js"></script>
	<script src="${ctxStatic}/admin/js/jquery.nanoscroller.min.js"></script>
	<script src="${ctxStatic}/admin/js/scripts.js"></script>
    <script src="${ctxStatic}/jquery-jbox/2.3/jquery.jBox-2.3.min.js" type="text/javascript"></script>

	<script type="text/javascript">
		$(document).ready(function() {

			var choseId=$(".chose a").attr("data-id");
			 var mn1=$('.menuHide').parent();
			 $('.menuHide').parent().hide();
			 $("."+choseId).show();
			
			$(".menu_title").click(function(){
				$(this).addClass("chose").siblings().removeClass("chose");
				choseId =$(".chose a").attr("data-id");
				$('.menuHide').parent().hide();
				 $("."+choseId).show();
				//默认打开首个二级菜单
				 	$(".nav-pills li:visible .menuHide:first")[0].click();
					if($(".nav-pills li:visible .submenu a:first")[0]!=undefined){
						$(".nav-pills li:visible .submenu a:first")[0].click();
					} 
			});
	
				
				// 二级内容
				$(".submenu a").click(
					function() {
						$('#sidebar-nav .nav li').removeClass("active").removeClass("open");
						$('#sidebar-nav .nav li .submenu').hide();
						$(".submenu a").removeClass("active");
						$(this).addClass("active");
						$(this).parent().parent().parent().addClass("active").addClass("open");
						$(this).parent().parent().show();
						
						var url=$(this).attr("href");
					 	var u = window.location.href;
					 	var end = u.indexOf("#");
					  	var rurl = u.substring(0,end);
					  	var choseId =$(".chose a").attr("data-id");
					  	//设置新的锚点
					  	window.location.href = rurl + "#" + url+"?"+choseId;
						
				});
				
				//无子级一级菜单
				$(".menu2").click(
						function() {
							$('#sidebar-nav .nav li').removeClass("active").removeClass("open");
							$('#sidebar-nav .nav li .submenu').hide();
							
							$('.menu2').removeClass("active")
							$(this).parent().addClass("active");
							
							var url=$(this).attr("href");
						 	var u = window.location.href;
						 	var end = u.indexOf("#");
						  	var rurl = u.substring(0,end);
						  	var choseId =$(".chose a").attr("data-id");
						  	//设置新的锚点
						  	window.location.href = rurl + "#" + url+"?"+choseId;
					});
				
		});
		//刷新后打开最后点击的菜单
		document.addEventListener('DOMContentLoaded', function () {
		     var hash = location.hash;
		     if(hash){
		    	 var url = hash.substring(1,hash.length);
		    	 var start = url.indexOf("?");
		    	 var choseId = hash.substring(start+2,hash.length);
		    	 $("a[data-id='"+choseId+"']").click(); 
		    	 url = hash.substring(1,start+1);
		    	 $("a[href='"+url+"']")[0].click();
		     }else{
		    	//无锚点,初始化默认打开首页
				$(".menu2:first")[0].click();
		     }
		}, false);
	</script>
</body>
</html>