<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>店铺风格管理</title>
	<meta name="decorator" content="default"/>
	<%@include file="/WEB-INF/views/include/treetable.jsp" %>
	<script type="text/javascript">
		$(document).ready(function() {
		});
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
	width: 30px;
	height: 30px;
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
.palette-color-picker-button {
    position: relative;
    display: inline-block;
    width: 28px;
    height: 28px;
    margin-right: 8px;
    background-size: cover;
    cursor: pointer;
    outline: 1px solid #bbb;
    border: 2px solid #fff;
}
</style>
</head>
<body>
<div class="container">
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/shop/style">店铺风格列表</a></li>
		<shiro:hasPermission name="shop:style:edit"><li><a href="${ctx}/shop/style/form">店铺风格添加</a></li></shiro:hasPermission>
	</ul>
	<form id="searchForm" action="${ctx}/shop/style" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
		    <li><label>名称：</label>
		    	<input type="text" name="name" value="${param.name}" class="input-medium" maxlength="100" placeholder="店铺风格名称">
			</li>
			<li><label>状态：</label>
				<select style="width: 177px;" name="status">
                    <option value="">全部</option>
                    <c:forEach items="${status}" var="item">
						<option value="${item.value}"<c:if test="${item.value eq param.status}">selected="selected"</c:if>>${item.chName}</option>
					</c:forEach>
                </select>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>店铺风格名称</th>
				<th>店铺风格</th>
				<th>店铺风格状态</th>
				<shiro:hasPermission name="shop:style:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody id="infolist">
		<c:forEach items="${page.list}" var="item" varStatus="number"> 
			<tr>
			    <td>
			    	<a href="${ctx}/shop/style/form?code=${item.code}">${item.name}</a>
				</td>
				<td>
			    	<div class="palette-color-picker-button"  style="background: ${item.spe};"></div>
				</td>
				<td>
					<c:forEach items="${status}" var="sta">
						<c:if test="${sta.value eq item.status}"><span class="label label-${item.status eq '0'?'success':'danger'}">${sta.chName}</span></c:if>
					</c:forEach>
				</td>
				<shiro:hasPermission name="shop:style:edit"><td nowrap>
						<a href="${ctx}/shop/style/form?code=${item.code}">修改</a>
						<a href="${ctx}/shop/style/status?code=${item.code}&status=${item.status eq '0'?'1':'0'}&name=${item.name}" onclick="return confirmx('确定${item.status eq '0'?'禁用':'启用'}店铺风格吗？', this.href)">${item.status eq '0'?'禁用':'启用'}</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
 </div>
</body>
</html>