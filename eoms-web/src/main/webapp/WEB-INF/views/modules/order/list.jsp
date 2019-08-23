<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>订单管理</title>
	<meta name="decorator" content="default"/>
	<%@include file="/WEB-INF/views/include/treetable.jsp" %>
	<script type="text/javascript">
		$(document).ready(function() {
			//发货操作
			$(".shippingBtn").click(function(){
				var code=$(this).attr("data-code");
				 var orderNo = $(this).attr("data-orderNo");
				 
				var html = "<div style='padding:10px;'>快递单号：<input type='text' id='expressNo' name='expressNo' /><br/>快递公司：<input type='text' id='expressName' name='expressName' /></div>"; 
				  $.jBox(html, { title: "发货操作", submit: function (v, h, f) {
				      if (f.expressNo == '') {
				          $.jBox.tip("请填写快递单号！", 'error', { focusId: "expressNo" }); // 关闭设置 yourname 为焦点
				          return false;
				      }else if(f.expressName == ''){
				    	  $.jBox.tip("请填写快递公司！", 'error', { focusId: "expressName" }); // 关闭设置 yourname 为焦点
				          return false;
				      } else{
				    	  confirmx("该操作将导致订单状态变更，是否确认发货？", "${ctx}/order/order/shipping?code="+code+"&orderNo="+orderNo+"&expressNo="+f.expressNo+"&expressName="+f.expressName);
				      }
				      return true;
				  	}
				  });	
			  });
			
			//线下支付操作
// 			$(".payBtn").click(function(){
// 				var code=$(this).attr("data-code");
// 				 var orderNo = $(this).attr("data-orderNo");
// 				 var code=$(this).attr("data-code");
// 				 promptx("请输入付款金额", "付款金额",function(){
// 			    	  var txt=top.$("#txt").val();
// 			    	  confirmx("是否确认已线下支付？", "${ctx}/order/order/payment?code="+code+"&orderNo="+orderNo+"&amt="+txt);
// 				 });
// 			  });
			
			
		});
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
		<li class="active"><a href="${ctx}/order/order">订单列表</a></li>
	</ul>
	<form id="searchForm" action="${ctx}/order/order" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>订单号：</label>
		    	<input type="text" name="orderNo" value="${param.orderNo}" class="input-medium" maxlength="100" placeholder="订单号">
			</li>
		    <li><label>会员姓名：</label>
		    	<input type="text" name="mbrName" value="${param.mbrName}" class="input-medium" maxlength="100" placeholder="会员姓名">
			</li>
			<li><label>店铺名称：</label>
				<input type="text" name="shopName" value="${param.shopName}" class="input-medium" maxlength="100" placeholder="店铺名称">
			</li>
			<li><label>订单状态：</label>
				<select style="width: 177px;" name="status">
                    <option value="">全部</option>
                    <c:forEach items="${orderStatus}" var="item">
						<option value="${item.value}"
							<c:if test="${item.value eq param.orderStatus}">selected="selected"</c:if>>${item.chName}</option>
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
				<th>订单号</th>
				<th>下单人姓名</th>
				<th>店铺名称</th>
				<th>订单金额</th>
				<th>快递公司</th>
				<th>订单状态</th>
				<th>支付方式</th>
				<th>下单时间</th>
				<shiro:hasPermission name="order:order:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody id="infolist">
		<c:forEach items="${page.list}" var="item" varStatus="number"> 
			<tr>
			    <td>
					<a  href="${ctx}/order/order/view?code=${item.code}" >${item.orderNo}</a>
				</td>
				<td>
					${item.mbrName}
				</td>
				<td>
					${item.shopName}
				</td>
				<td>
					${item.amt}
				</td>
				<td>
					${item.expressName}
				</td>
				<td>
					<c:forEach items="${orderStatus}" var="status">
						<c:if test="${status.value eq item.status}">${status.chName}</c:if>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${payTypes}" var="pay">
						<c:if test="${pay.value eq item.payType}">${pay.chName}</c:if>
					</c:forEach>
				</td>
				<td>
					<fmt:formatDate value="${item.createTime }" pattern="yyyy-MM-dd"/>
				</td>
				<shiro:hasPermission name="order:order:edit"><td nowrap>
						<!--待发货状态 -->
						<c:if test="${item.status=='1'}">
								<a href="javascript:;" class="shippingBtn" data-code="${item.code}" data-orderNo="${item.orderNo}">发货</a>
						</c:if>
						<!--待支付状态 -->
						<c:if test="${item.status=='0'}">
<%-- 								<a href="javascript:;" class="payBtn" data-code="${item.code}" data-orderNo="${item.orderNo}">线下支付</a> --%>
							<a href="${ctx}/order/order/payment?code=${item.code}&orderNo=${item.orderNo}" onclick="return confirmx('是否确认已线下支付？', this.href)">线下支付</a>
						</c:if>
						
						<c:if test="${item.status!='9' && item.status!='6'}">
							<a href="${ctx}/order/order/cancel?code=${item.code}" onclick="return confirmx('是否确认取消订单？', this.href)">取消</a>
						</c:if>
						<a  href="${ctx}/order/order/view?code=${item.code}" >详情</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
 </div>
</body>
</html>