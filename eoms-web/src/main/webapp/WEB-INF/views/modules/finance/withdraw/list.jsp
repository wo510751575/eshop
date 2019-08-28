<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>提现管理</title>
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
</style>
</head>
<body>
<div class="container">
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/finance/withdraw/list">提现管理</a></li>
	</ul>
	<form id="searchForm" action="${ctx}/finance/withdraw/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
		    <li><label>提现人姓名：</label>
		    	<input type="text" name="param.mbrName" value="${findWithdrawPage.param.mbrName}" class="input-medium" maxlength="100" placeholder="提现人姓名">
			</li>
			<li><label>状态：</label>
				<select style="width: 177px;" name="param.status">
                    <option value="">全部</option>
						<option value="0" <c:if test="${'0' eq findWithdrawPage.param.status}">selected="selected"</c:if>>申请中</option>
						<option value="1" <c:if test="${'1' eq findWithdrawPage.param.status}">selected="selected"</c:if>>提现成功</option>
						<option value="2" <c:if test="${'2' eq findWithdrawPage.param.status}">selected="selected"</c:if>>提现失败</option>
						<option value="3" <c:if test="${'3' eq findWithdrawPage.param.status}">selected="selected"</c:if>>取消提现</option>
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
				<th>提现申请编号</th>
				<th>提现人姓名</th>
				<th>提现金额</th>
				<th>银行名称</th>
				<th>银行账户</th>
				<th>失败原因</th>
				<th>申请提现时间</th>
				<th>状态</th>
				<shiro:hasPermission name="finance:withdraw:view"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody id="infolist">
		<c:forEach items="${page.list}" var="item" varStatus="number"> 
			<tr>
				<td>
			    	${item.withdrawNo}
				</td>
			    <td>
					${item.mbrName}
				</td>
				<td>
					<%-- <fmt:formatNumber value="${item.amt}" pattern="#,#0.00"/> --%>
					${item.amt}
				</td>
				<td>
					${item.bankName}
				</td>
				<td>
					${item.bankAccNo}
				</td>
				<td>
					${item.failReason}
				</td>
				<td>
					<fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd hh:mm:ss" type="date" /> 
				</td>
				<td>
					<c:if test="${0 eq item.status}">申请中</c:if>
					<c:if test="${1 eq item.status}">提现成功</c:if>
					<c:if test="${2 eq item.status}">提现失败</c:if>
					<c:if test="${3 eq item.status}">取消提现</c:if>
				</td>
				
				<shiro:hasPermission name="finance:withdraw:view"><td nowrap>
					<c:if test="${item.status=='0'}">
							<a href="${ctx}/finance/withdraw/status?code=${item.code}&status=1" onclick="return confirmx('确定审核通过吗', this.href)">审核通过</a>
							<a href="${ctx}/finance/withdraw/status?code=${item.code}&status=2" onclick="return confirmx('确定审核拒绝吗', this.href)">审核拒绝</a>
					</c:if>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
 </div>
</body>
</html>