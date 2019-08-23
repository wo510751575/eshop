<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>会员特权</title>
<meta name="decorator" content="default" />
<style>
.img-div>div {
	float: left;
	margin-left: 3px;
}
</style>

<script type="text/javascript" src="${ctxStatic}/editor/kindeditor.js"></script>
<script type="text/javascript" src="${ctxStatic}/editor/init.js"></script>
<script src="${ctxStatic}/common/plupload.full.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#name").focus();
				$("#inputForm")
						.validate(
								{
									submitHandler : function(form) {
										loading('正在提交，请稍等...');
										form.submit();
									},
									errorContainer : "#messageBox",
									errorPlacement : function(error, element) {
										$("#messageBox").text("输入有误，请先更正。");
										if (element.is(":checkbox")
												|| element.is(":radio")
												|| element.parent().is(
														".input-append")) {
											error.appendTo(element.parent()
													.parent());
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
						<td style="text-align: right; font-weight: bold; width: 120px;">标题
							：</td>
						<td>${data.title}</td>
					</tr>
					<tr>
						<td style="text-align: right; font-weight: bold;">概要 ：</td>
						<td>${data.flagInfo}</td>
					</tr>
					<tr>
						<td style="text-align: right; font-weight: bold;">阅读量 ：</td>
						<td>${data.readCnt}</td>
					</tr>
					<tr>
						<td style="text-align: right; font-weight: bold;">图片 ：</td>
						<td>
							<div class="img-div">
								<div id="img_btn1"
									style="border: 1px solid #e0e6eb; width: 120px; height: 120px; line-height: 100px; text-align: center">
									<c:if test="${!empty data.img1}">
										<img width="120px" height="120px" src="${data.img1}" />
									</c:if>
								</div>

								<div id="img_btn2"
									style="border: 1px solid #e0e6eb; width: 120px; height: 120px; line-height: 100px; text-align: center">
									<c:if test="${!empty data.img2}">
										<img width="120px" height="120px" src="${data.img2}" />
									</c:if>
								</div>

								<div id="img_btn3"
									style="border: 1px solid #e0e6eb; width: 120px; height: 120px; line-height: 100px; text-align: center">
									<c:if test="${!empty data.img3}">
										<img width="120px" height="120px" src="${data.img3}" />
									</c:if>
								</div>

								<div id="img_btn4"
									style="border: 1px solid #e0e6eb; width: 120px; height: 120px; line-height: 100px; text-align: center">
									<c:if test="${!empty data.img4}">
										<img width="120px" height="120px" src="${data.img4}" />
									</c:if>
								</div>

								<div id="img_btn5"
									style="border: 1px solid #e0e6eb; width: 120px; height: 120px; line-height: 100px; text-align: center">
									<c:if test="${!empty data.img5}">
										<img width="120px" height="120px" src="${data.img5}" />
									</c:if>
								</div>

							</div>
						</td>
					</tr>
					<tr>
						<td style="text-align: right; font-weight: bold; clear: both;">详细文章：</td>
						<td><textarea name="detail" id="editor" class="editor"
								maxlength="128" class="input-xlarge">${data.detail}</textarea></td>
					</tr>

					<tr>
						<td style="text-align: right; font-weight: bold;">状态 ：</td>
						<td><c:choose>
								<c:when test="${data.status=='1' }">
									<label>下架 </label>
								</c:when>
								<c:otherwise>
									<label>发布 </label>
								</c:otherwise>
							</c:choose></td>

					</tr>
					<tr>
						<td style="text-align: right; font-weight: bold;">录入时间：</td>
						<td><fmt:formatDate value="${data.createTime}"
								pattern="yyyy-MM-dd" /></td>
					</tr>

				</tbody>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		KindEditor.ready(function(K) {
			setTimeout(function() {
				$('.ke-container').attr('style', 'width: 550px;');
			}, 300);
		});
	</script>

</body>
</html>