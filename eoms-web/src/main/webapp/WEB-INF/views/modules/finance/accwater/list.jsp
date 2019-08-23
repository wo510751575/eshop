<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>账户流水管理</title>
	<meta name="decorator" content="default"/>
	<%@include file="/WEB-INF/views/include/treetable.jsp" %>
	
	<style type="text/css">
		.selectEnum{
			width: 177px;
		}
	</style>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#treeTable").treeTable({expandLevel : 3}).show();
		});
		$(document).ready(function() {
			//详情
			$('.view_btn').click(function() {
				var code = $(this).attr("data-code");
				
				// 正常打开	
				top.$.jBox.open("iframe:${ctx}/finance/accwater/form?code="+code+"&isView="+true,"账户流水详情", 800, 560,{//宽高
					id:9527,
					draggable: true,
					showClose: true,
					buttons:{},		//去除按钮
					iframeScrolling: 'yes',
					loaded:function(h){
						top.$('.jbox-container .jbox-title-panel').css("height","35px").css('background','#376EA5');
						top.$('.jbox-container .jbox-title').css('line-height','35px').css("color","#ffffff");
					},
					closed: function () { 
					} /* 信息关闭后执行的函数 */
				});
		    });
			
			$("#btnExport").click(function(){
				top.$.jBox.confirm("确认要导出流水数据吗？","系统提示",function(v,h,f){
					if(v=="ok"){
						$("#searchForm").attr("action","${ctx}/finance/accwater/export");
						$("#searchForm").submit();
					}
				},{buttonsFocus:1});
			});
			$("#btnSubmit").click(function(){
				$("#searchForm").attr("action","${ctx}/finance/accwater/list");
				$("#searchForm").submit();
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
</head>
<body>
<div class="container">
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/finance/accwater/">账户流水列表</a></li>
		<shiro:hasPermission name="finance:accwater:edit"><li><a href="${ctx}/finance/accwater/form">账户流水添加</a></li></shiro:hasPermission>
	</ul>
		<form id="searchForm" action="${ctx}/finance/accwater/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
 			<li> 
 				<label>记账日期：</label> 
 				<input id="beginDate" name="startTime" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate"
 				value="<fmt:formatDate value="${findAccWaterPage.startTime}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true});"/> 
				<input id="endDate" name="endTime" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate" 
 				value="<fmt:formatDate value="${findAccWaterPage.endTime}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true});"/>&nbsp;&nbsp; 
 			</li> 
 			
 			<li><label>流水来源：</label>
				<select class="selectEnum" name="param.accSource">
                    <option value="">全部</option>
                    <c:forEach items="${accwatersource}" var="item">
						<option value="${item.value}"
							<c:if test="${item.value eq findAccWaterPage.param.accSource}">selected="selected"</c:if> >${item.chName}</option>
					</c:forEach>
                </select>
			</li>
			
			<li><label style="width:100px;">流水记账类型：</label>
				<select class="selectEnum"  name="param.accType">
                    <option value="">全部</option>
                    <c:forEach items="${accwateracctype}" var="item">
						<option value="${item.value}"
							<c:if test="${item.value eq findAccWaterPage.param.accType}">selected="selected"</c:if> >${item.chName}</option>
					</c:forEach>
                </select>
			</li>
 		</ul>
 		<ul class="ul-form">	
 			
			
			<li><label>支付方式：</label>
				<select class="selectEnum"  name="param.payType">
                    <option value="">全部</option>
                    <c:forEach items="${accwaterpaytype}" var="item">
						<option value="${item.value}"
							<c:if test="${item.value eq findAccWaterPage.param.payType}">selected="selected"</c:if> >${item.chName}</option>
					</c:forEach>
                </select>
			</li>
			<li style="margin-left:23px"><label style="width:100px;">流水业务类型：</label>
				<select class="selectEnum"  name="param.bizType">
                    <option value="">全部</option>
                    <c:forEach items="${accwaterbiztype}" var="item">
						<option value="${item.value}"
							<c:if test="${item.value eq findAccWaterPage.param.bizType}">selected="selected"</c:if> >${item.chName}</option>
					</c:forEach>
                </select>
			</li>
			
			<li ><label style="width:100px;">账户流水类型：</label>
				<select class="selectEnum"  name="param.waterType">
                    <option value="">全部</option>
                    <c:forEach items="${accwatertype}" var="item">
						<option value="${item.value}"
							<c:if test="${item.value eq findAccWaterPage.param.waterType}">selected="selected"</c:if> >${item.chName}</option>
					</c:forEach>
                </select>
			</li>
		</ul>
 		<ul class="ul-form">	
 			
			<li><label>流水状态：</label>
				<select class="selectEnum"  name="param.status">
                    <option value="">全部</option>
                    <c:forEach items="${statuss}" var="item">
						<option value="${item.value}"
							<c:if test="${item.value eq findAccWaterPage.param.status}">selected="selected"</c:if> >${item.chName}</option>
					</c:forEach>
                </select>
			</li>
			
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="button" value="查询"/></li>
			<li class="btns"><input id="btnExport" class="btn btn-primary" type="button" value="导出"/></li>
			<li class="clearfix"></li>
		</ul>
	</form>
	<tags:message content="${message}"/>
		<table id="treeTable" class="table table-striped table-bordered table-condensed hide">
			<thead><tr>
			<th>账户编号</th>
			<th>记账日期</th>
			<th>流水来源</th>
			<th>流水记账类型</th>
			<th>交易订单号</th>
			<th>金额</th>
			<th>支付方式</th>
			<th>期初之前的金额</th>
			<th>期末之前的金额</th>
			
			<th>流水业务类型</th>
			<th>账户流水类型</th>
			<th>更新时间</th>
			<th>操作人</th>
			<th>流水状态</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${page.list}" var="item">
				<tr id="${item.code}">
					<td> ${item.accNo}</td>
					<td><fmt:formatDate value="${item.accDate}" pattern="yyyy-MM-dd"/> </td>
					<td> 
						<c:forEach items="${accwatersource}" var="p">
							<c:choose> 
								<c:when test="${p.value == item.accSource}">${p.chName}</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:forEach>
					</td>
					<td>
						<c:forEach items="${accwateracctype}" var="p">
							<c:choose> 
								<c:when test="${p.value == item.accType}">${p.chName}</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:forEach>
					</td>
					<td> ${item.tranOrderNo} </td>
					<td> ${item.amt}</td>
					<td> 
						<c:forEach items="${accwaterpaytype}" var="p">
							<c:choose> 
								<c:when test="${p.value == item.payType}">${p.chName}</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:forEach>
					</td>
					<td> ${item.beforeAmt}</td>
					<td> ${item.afterAmt}</td>
					
					<td> 
						<c:forEach items="${accwaterbiztype}" var="p">
							<c:choose> 
								<c:when test="${p.value == item.bizType}">${p.chName}</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:forEach>
					</td>
					<td> 
						<c:forEach items="${accwatertype}" var="p">
							<c:choose> 
								<c:when test="${p.value == item.waterType}">${p.chName}</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:forEach>
					</td>
					<td> <fmt:formatDate value="${item.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td> ${item.opCode}</td>
					<td> 
						<c:if test="${item.status==0}">记账成功</c:if>
						<c:if test="${item.status==1}">记账中</c:if>
						<c:if test="${item.status==2}">记账失败</c:if>
					</td>
				</tr>
			</c:forEach></tbody>
		</table>
		<div class="pagination">${page}</div>
	
	 </div>
</body>
</html>