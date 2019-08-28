<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>店铺管理</title>
	<meta name="decorator" content="default"/>
	<%@include file="/WEB-INF/views/include/treetable.jsp" %>
	<script type="text/javascript">
		$(document).ready(function() {
			//门店详情
			$('.view_btn').click(function() {
				var code = $(this).attr("data-code");
				
				// 正常打开	
				top.$.jBox.open("iframe:${ctx}/shop/view?code="+code+"&isView="+true,"门店详情", 680, 730,{//宽高
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
			
			$(".amtbtn").click(function(){
				 var code=$(this).attr("data-code");
				 var retireNo = $(this).attr("mimeCode");
				 promptx("请输入绑定设备型号", "绑定设备",function(){
					 debugger;
			    	  var txt=top.$("#txt").val();
			    	  confirmx("确认要变更绑定设备号吗", "${ctx}/shop/bindDevice?code="+code+"&mimeCode="+txt);
				 });
			  });
			
			$(".unApprove").click(function(){
				 var code=$(this).attr("data-code");
				 promptx("请输入审核拒绝原因", "审核拒绝",function(){
					 debugger;
			    	  var txt=top.$("#txt").val();
			    	  confirmx("确认要审核拒绝吗?", "${ctx}/shop/status?code="+code+"&status=3&closeReason="+txt);
				 });
			  });
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
}
.img-tx{
	 display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    width: 40px;
    height: 40px; 
    -webkit-box-pack: center;
    -ms-flex-pack: center;
    justify-content: center;
    -webkit-box-align: center;
    -ms-flex-align: center;
    align-items: center;
    overflow: hidden;
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

.lafen-group .img-tx:hover + .img-big {
    transform: scale(1, 1);
    opacity: 1;
}
.lafen-group .img-big img {
    width: 130px;
}
</style>
</head>
<body>
<div class="container">
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/shop/list">店铺列表</a></li>
<%-- 		<shiro:hasPermission name="shop:shop:edit"><li><a href="${ctx}/shop/form">店铺添加</a></li></shiro:hasPermission> --%>
	</ul>
	<form id="searchForm" action="${ctx}/shop/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
		    <li><label>店铺名称：</label>
		    	<input type="text" name="shopName" value="${param.shopName}" class="input-medium" maxlength="100" placeholder="店铺名称">
			</li>
			<li><label>店铺状态：</label>
				<select style="width: 177px;" name="status">
                    <option value="">全部</option>
                    <c:forEach items="${shopStatus}" var="item">
						<option value="${item.value}"
							<c:if test="${item.value eq param.status}">selected="selected"</c:if>>${item.chName}</option>
					</c:forEach>
                </select>
			</li>
<!-- 			<li> -->
<!-- 				<label>录入时间：</label> -->
<!-- 				<input id="beginDate" name="startTime" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate" -->
<%-- 				value="<fmt:formatDate value="${paramMember.startTime}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true});"/> --%>
<!-- 				--  -->
<!-- 				<input id="endDate" name="endTime" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate" -->
<%-- 				value="<fmt:formatDate value="${paramMember.endTime}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true});"/>&nbsp;&nbsp; --%>
<!-- 			</li> -->
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>店铺名称</th>
				<th>店铺头像</th>
				<th>所在省市区</th>
				<th>店铺状态</th>
				<th>店铺等级</th>
				<th>申请日期</th>
				<th>开店日期</th>
				<shiro:hasPermission name="shop:shop:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody id="infolist">
		<c:forEach items="${page.list}" var="item" varStatus="number"> 
			<tr>
				<%--<td>
					<a  href="javascript:;" class="view_btn" data-code="${item.code}" >${item.shopName}</a>
				</td>--%>
				<td title="${item.shopName}"><a class="view_btn" data-code="${item.code}">${item.shopName}</a></td>
				<td>
			    	<div class="lafen-group">
			    	<c:choose>
			    		<c:when test="${fn:startsWith(item.img, 'http')}">
   							<div class="img-tx">
   							<img class="img-small" src="${item.img}" alt="">
   							</div>
			    			<div class="img-big">
			    				<img  src="${item.img }" alt="">
			    			</div>
						</c:when>
						<c:otherwise>
							<div class="img-tx">
							<img class="img-small" src="${fns:getUploadUrl()}${item.img}" alt="">
			    			</div>
			    			<div class="img-big">
			    				<img  src="${fns:getUploadUrl()}${item.img}" alt="">
			    			</div>
						</c:otherwise>
			    	</c:choose>
			    	</div>
				</td>
				<td>
					${fns:getAreaName(item.shopProvide)}${fns:getAreaName(item.shopCity)}${fns:getAreaName(item.shopArea)}
				</td>
				<td>
					<c:forEach items="${shopStatus}" var="status">
						<c:if test="${status.value eq item.status}">${status.chName}</c:if>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${shopGrades}" var="grade">
						<c:if test="${grade.value eq item.shopGarde}">${grade.chName}</c:if>
					</c:forEach>
				</td>
				<td>
					<fmt:formatDate value="${item.createTime }" pattern="yyyy-MM-dd"/>
				</td>
				<td>
					<fmt:formatDate value="${item.openTime }" pattern="yyyy-MM-dd"/>
				</td>
				<shiro:hasPermission name="shop:shop:edit"><td nowrap>
<%-- 						<a href="${ctx}/shop/form?code=${item.code}">修改</a> --%>
						
					   		<a href="javascript:;" class="amtbtn" id="amtbtn" data-code="${item.code}" data-mimeCode="${item.mimeCode}">绑定设备</a>
						<c:if test="${item.status=='0'}">
								<a href="${ctx}/shop/status?code=${item.code}&status=1&shopName=${item.shopName}" onclick="return confirmx('确定审核通过吗？', this.href)">审核通过</a>
								<!-- <a href="${ctx}/shop/status?code=${item.code}&status=3&shopName=${item.shopName}" onclick="return confirmx('确定审核拒绝吗？', this.href)">审核拒绝</a> -->
								<a href="javascript:;" class="unApprove" id="unApprove" data-code="${item.code}" data-mimeCode="${item.mimeCode}">审核拒绝</a>
						</c:if>
						<c:if test="${item.status=='1'}">
								<a href="${ctx}/shop/status?code=${item.code}&status=2&shopName=${item.shopName}" onclick="return confirmx('确定关闭店铺吗？', this.href)">关闭</a>
						</c:if>
						<c:if test="${item.status=='2'}">
								<a href="${ctx}/shop/status?code=${item.code}&status=1&shopName=${item.shopName}" onclick="return confirmx('确定恢复正常吗？', this.href)">恢复正常</a>
						</c:if>
						<a  href="javascript:;" class="view_btn" data-code="${item.code}" >详情</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
 </div>
</body>
</html>