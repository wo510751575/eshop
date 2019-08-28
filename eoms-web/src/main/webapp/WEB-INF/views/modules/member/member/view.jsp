<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>客户管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
<div class="container">
	 	<div class="store-details">
			<table class="table-form" style="width: 100%;">
				<tbody>
					<tr>
						<td style="padding: 10px;font-weight: bold;width: 90px;text-align:right;">客户名称 ：</td>
						<td  >${data.name}</td>
						<td  style="padding: 10px;font-weight: bold;width: 80px;text-align:right;">头像：</td>
						<td>
							<c:choose>
								<c:when test="${!empty data.avotor }">
									<c:choose>
										<c:when test="${fn:startsWith(data.avotor, 'http')}">
			   								<img  width="40" height="40"  src="${data.avotor}" alt="">
										</c:when>
										<c:otherwise>
											<img width="40" height="40"  src="${fns:getUploadUrl()}${data.avotor}" alt="">
										</c:otherwise>
					    			</c:choose>
								</c:when>
								<c:otherwise>无头像</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td style="padding: 10px;font-weight: bold;text-align:right;">客户微信号 ：</td>
						<td>${data.wxNo}</td>
						<td style="padding: 10px;font-weight: bold;text-align:right;">手机号码 ：</td>
						<td> 
						 	${data.phone}
						</td>
					</tr>
					<tr>
						<td  style="padding: 10px;font-weight: bold;text-align:right;">openId ：</td>
						<td>${data.openId}</td>
						<td style="padding: 10px;font-weight: bold;text-align:right;">性别 ：</td>
						<td> 
						 	 <c:forEach items="${sexs}" var="p">
								<c:choose >
									<c:when test="${p.value eq data.sex}">
										${p.chName}
									</c:when>
								</c:choose>
							</c:forEach>
						</td>
					</tr>
					<tr>
						<td style="padding: 10px;font-weight: bold;text-align:right;">来源：</td>
						<td>
							<c:forEach items="${sourceFroms}" var="p">
								<c:choose >
									<c:when test="${p.value eq data.sourceFrom}">
										${p.chName}
									</c:when>
								</c:choose>
							</c:forEach>
						</td>
						<td style="padding: 10px;font-weight: bold;text-align:right;"> 状态 ：</td>
						<td> 
						 	 <c:forEach items="${statuss}" var="p">
								<c:choose >
									<c:when test="${p.value eq data.status}">
										${p.chName}
									</c:when>
								</c:choose>
							</c:forEach>
						</td>
					</tr>
					<tr>
						<td style="padding: 10px;font-weight: bold;text-align:right;">客户类型：</td>
						<td>
								<c:forEach items="${types}" var="p">
									<c:choose >
										<c:when test="${p.value eq data.type}">
											${p.chName} 
										</c:when>
									</c:choose>
								</c:forEach>
						</td>
						<td style="padding: 10px;font-weight: bold;text-align:right;">地区 ：</td>
						<td> 
						 	 ${data.province} ${data.city} ${data.area}
						</td>
					</tr>
					<tr>
						<td style="padding: 10px;font-weight: bold;text-align:right;">邀请人：</td>
						<td>
								 ${data.myInvite}
						</td>
						<td style="padding: 10px;font-weight: bold;text-align:right;">评分等级：</td>
						<td> 
						 	<c:forEach items="${grades}" var="p">
								<c:choose >
									<c:when test="${p.value eq data.grade}">
										${p.chName}
									</c:when>
								</c:choose>
							</c:forEach>
						</td>
					</tr>
					<tr>
						<td style="padding: 10px;font-weight: bold;text-align:right;">录入时间：</td>
						<td>
								 <fmt:formatDate value="${data.createTime}" pattern="yyyy-MM-dd"/>
						</td>
						<td>&nbsp;</td>
						<td> 
						 	 &nbsp;
						</td>
					</tr>
				</tbody>
			</table>
	</div>
	</div>
	
</body>
</html>