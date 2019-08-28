<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>活动管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$(".copyBtn").click(function(){
				$(this).attr("data-clipboard-text",window.location.href+"/viewH5?code="+$(this).attr("data-code"));
			})
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
		<style type="text/css">
	.container{
	padding: 10px 30px;
    width: 100%;
    min-height: 800px;
    background: #fff;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
	}
	</style>
</head>
<body>
<div class="container">
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/cm/activity">活动列表</a></li>
		<shiro:hasPermission name="cm:activity:edit">
			<li><a href="${ctx}/cm/activity/form">活动添加</a></li>
		</shiro:hasPermission>
	</ul>
	<form id="searchForm" action="${ctx}/cm/activity" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>标题：</label>
				<input type="text" name="title" class="input-medium" maxlength="100" placeholder="标题" value="${findActivityPage.title}">
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>标题</th>
				<th>封面图</th>
				<th>阅读量</th>
				<th>分享量</th>
				<th>网址链接</th>
				<th>活动开始时间</th>
				<shiro:hasPermission name="cm:activity:edit">
				<th>操作</th>
				</shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="item" varStatus="number"> 
			<tr>
				<td>
					<a href="${ctx}/cm/activity/form?code=${item.code}">${item.title}</a>					
				</td>
				<td>
<%-- 					<c:set var="imgAddr" value="${fn:split(item.imgAddr, ',')}" /> --%>
<%-- 					<c:forEach items="${imgAddr}" var="img"> --%>
<%-- 						<img src="${fns:getUploadUrl()}${img}" width="40" height="40"> 	 --%>
<%-- 					</c:forEach> --%>
					<img src="${fns:getUploadUrl()}${item.showImgAddr}" width="40" height="40">
				</td>
				<td>
					${item.readCount}
				</td>
				<td>
					${item.shareCount}
				</td>
				<td>
					<c:if test="${empty item.linkUrl}">
						<a href="${ctx}/cm/activity/view?code=${item.code}" target="_black">查看链接</a>
					</c:if>
					<c:if test="${not empty item.linkUrl}">
						<a href="${item.linkUrl}" target="_black">查看链接</a>
					</c:if>
				</td>
				<td>
					<fmt:formatDate value="${item.startDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				
				<shiro:hasPermission name="cm:activity:edit">
				<td>
					<a href="${ctx}/cm/activity/form?code=${item.code}">修改</a>
					<a class="copyBtn" href="javascript:;" data-clipboard-text="" data-code="${item.code}">复制链接</a>
					<a href="${ctx}/cm/activity/view?code=${item.code}" target="_black">预览</a>
				</td>
				</shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
	
	<script type="text/javascript" src="${ctxStatic}/common/clipboard.min.js"></script>
	<script>
    var clipboard = new Clipboard('.copyBtn');

    clipboard.on('success', function(e) {
    	showTip("已将链接复制到粘贴板","info");
    });

    clipboard.on('error', function(e) {
        console.log(e);
    });
    </script>
</div>	
</body>
</html>