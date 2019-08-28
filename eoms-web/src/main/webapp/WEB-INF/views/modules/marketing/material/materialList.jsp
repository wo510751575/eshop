<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>卖家素材管理</title>
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
		function CancelQuery(){
			$(':input','#searchForm')  
			 .not(':button, :submit, :reset')  
			 .val('')  
			 .removeAttr('checked')  
			 .removeAttr('selected'); 
		
			$("#pageNo").val(1);
			$("#searchForm").submit();
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
		<li class="active"><a href="${ctx}/marketing/material/">卖家素材列表</a></li>
		<%-- <shiro:hasPermission name="marketing:material:edit">
			<li><a href="${ctx}/marketing/material/form">卖家素材添加</a></li>
		</shiro:hasPermission> --%>
	</ul>
	<form id="searchForm" action="${ctx}/marketing/material/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
		    <%-- <li><label>卖家姓名：</label>
		    	<input type="text" name="memberNameGm" class="input-medium" maxlength="100" value="${findMaterialReturnPage.memberNameGm}" placeholder="卖家姓名">
			</li> --%>
			<li><label>商品名称：</label>
				<input type="text" name="productName" class="input-medium" maxlength="100" placeholder="商品名称" value="${productName}">
			</li>
			
			<li><label>素材维度：</label>
				<select class="selectEnum"  name="param.type">
                    <option value="">全部</option>
                    <c:forEach items="${materialCmTypes}" var="item">
                      <c:if test="${(item.value eq 0) || (item.value eq 6)}" >
						<option value="${item.value}"
							<c:if test="${item.value eq findMaterialReturnPage.param.type}">selected="selected"</c:if> >${item.chName}</option>
					 </c:if>
					</c:forEach>
                </select>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<!-- <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="reset" onclick="CancelQuery()" value="取消查询"/></li> -->
			<li class="clearfix"></li>
		</ul>
	</form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>卖家姓名</th>
				<th>标题</th>
<!--				<th>分享次数</th>
 				<th>缩略图</th>-->
				<th>素材类型名称</th> 
				<th>商品名称</th>
				<th>素材维度</th>
				<!--<th>网址链接</th -->
				<shiro:hasPermission name="marketing:material:edit">
				<th>操作</th>
				</shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="item" varStatus="number"> 
			<tr>
				<td>
					 <a href="${ctx}/marketing/material/form?code=${item.code}">${item.memberNameGm}</a>
				</td>
				<td>
					${item.title}
				</td>
				<%-- <td>
					${item.respondNum}
				</td> --%>
				<td>
					${item.materialTypeName}					
				</td>
				<td>${item.productName}</td>
				<td>
					<c:forEach items="${materialCmTypes}" var="p">
							<c:choose> 
								<c:when test="${p.value == item.type}">${p.chName}</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${!empty item.choicenessCode}">【精选】</c:if>
				</td>
				<%-- <td>
					<c:if test="${empty item.linkUrl}">
						<a href="${ctx}/marketing/material/view?code=${item.code}" target="_black">查看链接</a>
					</c:if>
					<c:if test="${not empty item.linkUrl}">
						<a href="${item.linkUrl}" target="_black">查看链接</a>
					</c:if>
				</td> --%>
				<shiro:hasPermission name="marketing:material:edit">
				<td>
					<%-- <a href="${ctx}/marketing/material/form?code=${item.code}">修改</a> --%>
					<a class="copyBtn" href="javascript:;" data-clipboard-text="" data-code="${item.code}">复制链接</a>
					<a href="${ctx}/marketing/material/view?code=${item.code}" target="_black">预览</a>
					<c:if test="${empty item.choicenessCode}">
						<a href="${ctx}/marketing/material/biztype?code=${item.cmMaterialCode}" onclick="return confirmx('确定要加入官方精选？', this.href)">加入官方精选</a>
					</c:if>
				</td>
				</shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
	</div>
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
</body>
</html>