<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>素材类型管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
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
		<li class="active"><a href="${ctx}/marketing/materialtype/list">素材类型列表</a></li>
<%-- 		<shiro:hasPermission name="member:guid:edit"> --%>
			<%-- <li><a href="${ctx}/marketing/materialtype/form">素材类型添加</a></li> --%>
<%-- 		</shiro:hasPermission> --%>
	</ul>
 	<form id="searchForm" action="${ctx}/marketing/materialtype/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<!-- <li><label>标题：</label>
				<input type="text" name="title" class="input-medium" maxlength="100" placeholder="标题">
			</li> -->
			
			<li><label>素材维度：</label>
				<select class="selectEnum"  name="materialDimension">
                    <option value="">全部</option>
                    <c:forEach items="${materialDimensionStatuss}" var="item">
						<option value="${item.value}"
							<c:if test="${item.value eq findMaterialTypePage.materialDimension}">selected="selected"</c:if> >${item.chName}</option>
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
				<th>素材类型名称</th>
				<!-- <th>所属导购</th> -->
 				<th>素材量</th>
				<th>维度</th>
				<!--<th>客户关注率</th>-->
				<th>备注</th>
<%-- 				<shiro:hasPermission name="member:guid:edit"> --%>
				<th>操作</th>
<%-- 				</shiro:hasPermission> --%>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="item" varStatus="number"> 
			<tr>
				<td>
					${item.typeName}
				</td>
				<%-- <td>
					${item.memberNameGm}
				</td> --%>
				<td>
					${item.typeCount}
				</td>
				<!-- <td></td>
				<td></td>
				<td></td>-->
				<td>
					<c:forEach items="${materialDimensionStatuss}" var="p">
							<c:choose> 
								<c:when test="${p.value == item.materialDimension}">${p.chName}</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:forEach>
				</td>
				<td>
					${item.remark}
				</td>
<%--<shiro:hasPermission name="member:guid:edit"> --%>
				<td>
<%--<a href="${ctx}/marketing/materialtype/form?code=${item.code}">修改</a>--%>
				</td>
<%-- 				</shiro:hasPermission> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
	</div>
</body>
</html>