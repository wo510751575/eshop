<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>客户管理</title>
	<meta name="decorator" content="default"/>
	<%@include file="/WEB-INF/views/include/treetable.jsp" %>
	<script type="text/javascript">
	
		
	
		$(document).ready(function() {
			$("#treeTable").treeTable({expandLevel : 3}).show();
		});
		$(document).ready(function() {
			//详情
			$('.view_btn').click(function() {
				var code = $(this).attr("data-code");
				
				// 正常打开	
				top.$.jBox.open("iframe:${ctx}/member/member/form?code="+code+"&isView="+true,"客户详情", 680, 360,{//宽高
					id:9527,
					draggable: true,
					showClose: true,
					buttons:{},		//去除按钮
					iframeScrolling: 'no',
					loaded:function(h){
						top.$('.jbox-container .jbox-title-panel').css("height","35px").css('background','#376EA5');
						top.$('.jbox-container .jbox-title').css('line-height','35px').css("color","#ffffff");
					},
					closed: function () { 
					} /* 信息关闭后执行的函数 */
				});
		    });
			
			$("#btnImport").click(function(){
				$.jBox($("#importBox").html(), {title:"店主会员导入导入数据", buttons:{"关闭":true}, 
					bottomText:"导入文件不能超过10M，仅允许导入“xls”或“xlsx”格式文件！"});
			});
			
			$("#btnCopy").click(function(){
				var merchantCode = '${merchantCode}';
				var url = '${url}';
				$(this).attr("data-clipboard-text",url+merchantCode);
			});
			
		});
		//跳页
		function page(n, s) {
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
			return false;
		}
		
		
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
.img-small {
	width: 40px;
	height: 40px;
}
.lafen-group {
    position: relative;
}
.lafen-group .img-big {
    position: absolute;
    left: 50%;
    top: 50%;
    margin-top: -75px;
    margin-left: 35px;
    opacity: 0;
    transform: scale(.2, .2);
    transition: all .2s ease-in-out;
    width: 130px;
    height: 130px;
}
.lafen-group .img-small:hover + .img-big {
    transform: scale(1, 1);
    opacity: 1;
}
.lafen-group .img-big img {
    width: 130px;
    height: 130px;
}
</style>
</head>
<body>
<div class="container">
	<div id="importBox" class="hide">
		<form id="importForm" action="${ctx}/member/member/import" method="post" enctype="multipart/form-data"
			style="padding-left:20px;text-align:center;" class="form-search" onsubmit="loading('正在导入，请稍等...');"><br/>
			<input id="uploadFile" name="file" type="file" style="width:330px"/><br/><br/>　　
			<input id="btnImportSubmit" class="btn btn-primary" type="submit" value="   导    入   "/>
			<a href="${ctx}/member/member/import/template">下载模板</a>
		</form>
	</div>
	
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/member/member/">客户列表</a></li>
		<%-- <shiro:hasPermission name="member:member:edit"><li><a href="${ctx}/member/member/form">客户添加</a></li></shiro:hasPermission> --%>
	</ul>
		<form id="searchForm" action="${ctx}/member/member/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
		    <li><label>会员名称：</label>
		    	<input type="text" name="param.name" value="${memberPage.param.name}" class="input-medium" maxlength="100" placeholder="会员名称">
			</li>
			<%-- <li><label>openId：</label>
		    	<input type="text" name="param.openId" value="${memberPage.param.openId}" class="input-medium" maxlength="100" placeholder="openId">
			</li> --%>
			<li><label>微信号：</label>
		    	<input type="text" name="param.wxNo" value="${memberPage.param.wxNo}" class="input-medium" maxlength="100" placeholder="微信号">
			</li>
			<li><label>会员状态：</label>
				<select style="width: 177px;" name="param.status">
                    <option value="">全部</option>
                    <c:forEach items="${statuss}" var="item">
						<option value="${item.value}"
							<c:if test="${item.value eq memberPage.param.status}">selected="selected"</c:if>>${item.chName}</option>
					</c:forEach>
                </select>
			</li>
			<li><label>会员类型：</label>
				<select style="width: 177px;" name="param.type">
                    <option value="">全部</option>
                    <c:forEach items="${types}" var="item">
						<option value="${item.value}"
							<c:if test="${item.value eq memberPage.param.type}">selected="selected"</c:if>>${item.chName}</option>
					</c:forEach>
                </select>
			</li>
 			<li> 
 				<label>录入时间：</label> 
 				<input id="beginDate" name="startTime" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate"
 				value="<fmt:formatDate value="${memberPage.startTime}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,maxDate:'#F{$dp.$D(\'endDate\')}'});"/> 
 				-
				<input id="endDate" name="endTime" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate" 
 				value="<fmt:formatDate value="${memberPage.endTime}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,minDate:'#F{$dp.$D(\'beginDate\')}'});"/>&nbsp;&nbsp; 
 			</li> 
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="btns"><input id="btnImport" class="btn btn-primary" type="button" value="店主会员导入"/></li>
			<li class="btns"><input id="btnCopy" class="btn btn-primary" type="button" value="绑定会员"/></li>
			<li class="clearfix"></li>
		</ul>
	</form>
	<tags:message content="${message}"/>
		<table id="treeTable" class="table table-striped table-bordered table-condensed hide">
			<thead><tr>
			<th>会员名称</th>
			<!-- <th>openId</th> -->
			<th>性别</th>
			<th>状态</th>
			<th>手机号码</th>
			<th>微信号</th>
			<th>类型</th>
			<th>会员等级</th>
			<th>头像</th>
			<th>省</th>
			<th>市</th>
			<th>区</th>
			<th>邀请人</th>
			<th>评分等级</th>
			<th>来源</th>
			<th>录入时间</th>
			<th>操作</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${page.list}" var="item">
				<tr id="${item.code}">
					<td title="${item.name}"><a class="view_btn" data-code="${item.code}">${item.name}</a></td>
					<%-- <td> ${item.openId } </td> --%>
					<td>  
						<c:forEach items="${sexs}" var="p">
							<c:choose> 
								<c:when test="${p.value == item.sex}">${p.chName}</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:forEach>
					</td>
					<td> 
						<c:forEach items="${statuss}" var="p">
							<c:choose> 
								<c:when test="${p.value == item.status}">${p.chName}</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:forEach>
					</td>
					<td> ${item.phone } </td>
					<td> ${item.wxNo } </td>
					<td>  
						<c:forEach items="${types}" var="p">
							<c:choose> 
								<c:when test="${p.value == item.type}">${p.chName}</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:forEach>
					
					 </td>
					 <td>
					 <c:choose>
					 	<c:when test="${item.memberRankCode eq '1' }">白银会员</c:when>
					 	<c:when test="${item.memberRankCode eq '2' }">黄金会员</c:when>
					 	<c:when test="${item.memberRankCode eq '3' }">铂金会员</c:when>
					 	<c:when test="${item.memberRankCode eq '4' }">钻石会员</c:when>
						<c:otherwise></c:otherwise>
					 </c:choose>
					 </td>
					<td> 
					<c:if test="${!empty item.avotor }">
						<div class="lafen-group">
						<c:choose>
			    		<c:when test="${fn:startsWith(item.avotor, 'http')}">
   							<img class="img-small" src="${item.avotor}" alt="">
			    			<div class="img-big">
			    				<img  src="${item.avotor }" alt="">
			    			</div>
						</c:when>
						<c:otherwise>
							<img class="img-small" src="${fns:getUploadUrl()}${item.avotor}" alt="">
			    			<div class="img-big">
			    				<img  src="${fns:getUploadUrl()}${item.avotor}" alt="">
			    			</div>
						</c:otherwise>
			    		</c:choose>
			    		</div>
					</c:if>
					</td>
					<td> ${item.province } </td>
					<td> ${item.city } </td>
					<td> ${item.area } </td>
					<td> ${item.myInvite } </td>
					<td>  
						<c:forEach items="${grades}" var="p">
							<c:choose> 
								<c:when test="${p.value == item.grade}">${p.chName}</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:forEach>
					</td>
					<td>  
						<c:forEach items="${sourceFroms}" var="p">
							<c:choose> 
								<c:when test="${p.value == item.sourceFrom}">${p.chName}</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:forEach>
					</td>
					<td> <fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd"/></td>
					<shiro:hasPermission name="member:member:edit"><td nowrap>
						<a href="${ctx}/member/member/form?code=${item.code}">修改</a>
						<c:if test="${item.status=='0'}">
								<a href="${ctx}/member/member/status?code=${item.code}&status=1" onclick="return confirmx('确定注销客户吗？', this.href)">注销</a>
								<a href="${ctx}/member/member/status?code=${item.code}&status=2" onclick="return confirmx('确定冻结客户吗？', this.href)">冻结</a>
						</c:if>
						<c:if test="${item.status=='2'}">
								<a href="${ctx}/member/member/status?code=${item.code}&status=0" onclick="return confirmx('确定取消冻结客户吗？', this.href)">取消冻结</a>
						</c:if>
					</td>
					</shiro:hasPermission>
				</tr>
			</c:forEach></tbody>
		</table>
		<div class="pagination">${page}</div>
	
	 </div>
	 
	 <script type="text/javascript" src="${ctxStatic}/common/clipboard.min.js"></script>
	<script>
		var clipboard = new Clipboard('#btnCopy');
	    clipboard.on('success', function(e) {
	    	showTip("已将链接复制到粘贴板","info");
	    });
	    clipboard.on('error', function(e) {
	        console.log(e);
	    });
    </script>
</body>
</html>