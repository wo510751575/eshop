<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>店铺详情</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(function() {
			});
</script>
<style type="text/css">
	.container{
	padding: 20px 30px;
    width: 100%;
    min-height: 800px;
    background: #fff;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
	}
	.nav-tabs > li > a {
    padding-top: 0px;
}
.data-dia table tr, .data-dia table td {
    border: none;
    text-align: left;
}
.table-form tr td {
    padding: 0 3px 20px 3px;
    width: 35%;
    height: auto;
    font-size: 14px;
    position: relative;
}
.table-form tr td:nth-child(2n) {
    color: #333;
}
.table-form tr td:nth-child(2n+1) {
    width: 18%;
}

.text-right{text-align:right;font-weight: bold;}

</style>
</head>
<body>
<div class="container">
	<div class="store-details">
		<table class="table-form" style="width: 100%;">
			<tbody>
				<tr>
					<td width="10%" class="text-right">店铺名称 ：</td>
					<td>${data.shopName}</td>
					<td class="text-right">访问量 ：</td>
					<td>${data.readNum}</td>
				</tr>
				<tr>
					<td class="text-right">店铺状态 ：</td>
					<td>
						<c:forEach items="${shopStatus}" var="status">
							<c:if test="${status.value eq data.status}">${status.chName}</c:if>
						</c:forEach>
					</td>
					<td class="text-right">店铺等级 ：</td>
					<td>
						<c:forEach items="${shopGrades}" var="grade">
							<c:if test="${grade.value eq data.shopGarde}">${grade.chName}</c:if>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td class="text-right">开店申请日期：</td>
					<td><fmt:formatDate value="${data.createTime}" pattern="yyyy-MM-dd"/></td>
					<td class="text-right">开店日期 ：</td>
					<td colspan="2"><fmt:formatDate value="${data.openTime }" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
					<td class="text-right">关店日期：</td>
					<td><fmt:formatDate value="${data.closeTime }" pattern="yyyy-MM-dd"/></td>
					<td class="text-right">关店原因 ：</td>
					<td colspan="2">${data.closeReason}</td>
				</tr>
				<tr>
					<td style="vertical-align: middle" class="text-right">店铺头像图片：</td>
					<td colspan="2">
						<div class="upImg">
							<c:choose>
			    				<c:when test="${fn:startsWith(data.img, 'http')}">
			    					<img width="100px" height="100px" src="${data.img}" alt="">
			    				</c:when>
			    				<c:otherwise>
			    					<img width="100px" height="100px" src="${fns:getUploadUrl()}${data.img}" alt="">
			    				</c:otherwise>
			    			</c:choose>
						</div>
					</td>
				</tr>
				<tr class="mt30">
					<td class="text-right">地 区 ：</td>
					<td >${fns:getAreaName(data.shopProvide)}${fns:getAreaName(data.shopCity)}${fns:getAreaName(data.shopArea)}</td>
					<td class="text-right">设备 ：</td>
					<td >${data.mimeCode}</td>
				</tr>
				<tr>
					<td class="text-right">详细地址 ：</td>
					<td colspan="2">${fns:getAreaName(data.shopProvide)}${fns:getAreaName(data.shopCity)}${fns:getAreaName(data.shopArea)}${data.shopAddinfo}</td>
				</tr>
				<tr>
					<td class="text-right">店铺背景图片 ：</td>
					<td colspan="2">
						<div class="upImg">
							<c:choose>
			    				<c:when test="${fn:startsWith(data.bgUrl, 'http')}">
			    					<img width="100px" height="100px" src="${data.bgUrl}" alt="">
			    				</c:when>
			    				<c:otherwise>
			    					<img width="100px" height="100px" src="${fns:getUploadUrl()}${data.bgUrl}" alt="">
			    				</c:otherwise>
			    			</c:choose>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	
</div>
</body>
</html>