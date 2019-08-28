<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>店铺押金退出申请管理</title>
	<meta name="decorator" content="default"/>
	<%@include file="/WEB-INF/views/include/treetable.jsp" %>
	<script type="text/javascript">
	$(document).ready(function() {
		$("#amtbtn").click(function(){
			 var code=$(this).attr("data-code");
			 var retireNo = $(this).attr("data-retireNo");
			 promptx2("请输入打款金额", "打款金额：", "扣除原因：", function(){
		    	  var txt=top.$("#ptxt").val();
		    	  if(txt>2000) {
			    	  alert('金额不能大于2000.00元');
 						return;
				  }
		    	  var txt2=top.$("#ptxt2").val();
		    	  confirmx("金额将打入会员账户中，是否确认打款？", "${ctx}/shop/retire/status?code="+code+"&retireStatus=1&retireNo="+retireNo+"&amount="+txt+"&remarks="+txt2);
			 });
		  });
		$("#unStatusBtn").click(function(){
			 var code=$(this).attr("data-code");
			 var retireNo = $(this).attr("data-retireNo");
			 promptx("审核失败原因", "审核失败", function(){
		    	  var txt=top.$("#txt").val();
		    	  confirmx("是否确认审核失败？", "${ctx}/shop/retire/status?code="+code+"&retireNo="+retireNo+"&auditStatus=2&remarks="+txt);
			 });
		  });
	});
		function page(n, s) {
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
			return false;
		}
		
		
		function promptx2(title, lable, lable2, href, closed){
			top.$.jBox("<div class='form-search' style='padding:20px;text-align:center;'>" + lable + "<input type='text' id='ptxt' name='txt'/><br/><br/>"
					+ lable2 + "<input type='text' id='ptxt2' name='txt2'/></div>", {
						
					title: title, submit: function (v, h, f){
			    if (f.txt == '') {
			        top.$.jBox.tip("请输入" + lable + "。", 'error');
			        return false;
			    }
				if (typeof href == 'function') {
					href();
				}else{
					resetTip(); //loading();
					location = href + encodeURIComponent(f.txt);
				}
			},closed:function(){
				if (typeof closed == 'function') {
					closed();
				}
			}});
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
</style>
</head>
<body>
<div class="container">
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/shop/retire">店铺押金退出申请列表</a></li>
	</ul>
	<form id="searchForm" action="${ctx}/shop/retire" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
		    <li><label>申请编号：</label>
		    	<input type="text" name="retireNo" value="${param.retireNo}" class="input-medium" maxlength="100" placeholder="申请编号">
			</li>
			<li><label>审核状态：</label>
				<select style="width: 177px;" name="auditStatus">
                    <option value="">全部</option>
                    <c:forEach items="${auditStatus}" var="item">
						<option value="${item.value}"<c:if test="${item.value eq param.auditStatus}">selected="selected"</c:if>>${item.chName}</option>
					</c:forEach>
                </select>
			</li>
			<li><label>退款状态：</label>
				<select style="width: 177px;" name="retireStatus">
                    <option value="">全部</option>
                    <c:forEach items="${retireStatus}" var="item">
						<option value="${item.value}"<c:if test="${item.value eq param.retireStatus}">selected="selected"</c:if>>${item.chName}</option>
					</c:forEach>
                </select>
			</li>
			<li><label>收货状态：</label>
				<select style="width: 177px;" name="expressStatus">
                    <option value="">全部</option>
                    <c:forEach items="${expressStatus}" var="item">
						<option value="${item.value}"<c:if test="${item.value eq param.expressStatus}">selected="selected"</c:if>>${item.chName}</option>
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
				<th>申请编号</th>
				<th>会员名称</th>
				<th>店铺名称</th>
				<th>快递单号</th>
				<th>审核状态</th>
				<th>退款状态</th>
				<th>收货状态</th>
				<th>审核人</th>
				<th>上次审核时间</th>
				<th>申请时间</th>
				<shiro:hasPermission name="shop:retire:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody id="infolist">
		<c:forEach items="${page.list}" var="item" varStatus="number"> 
			<tr>
			    <td>
			    	${item.retireNo}
				</td>
				<td>
			    	${item.memberName}
				</td>
				<td>
			    	${item.shopName}
				</td>
				<td>
			    	${item.expressNo}
				</td>
				<td>
					<c:forEach items="${auditStatus}" var="sta">
						<c:if test="${sta.value eq item.auditStatus}">${sta.chName}</c:if>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${retireStatus}" var="sta">
						<c:if test="${sta.value eq item.retireStatus}">${sta.chName}</c:if>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${expressStatus}" var="sta">
						<c:if test="${sta.value eq item.expressStatus}">${sta.chName}</c:if>
					</c:forEach>
				</td>
				<td>
			    	${item.auditor}
				</td>
				<td>
			    	<fmt:formatDate value="${item.updateTime }" pattern="yyyy-MM-dd"/>
				</td>
				<td>
			    	<fmt:formatDate value="${item.createTime }" pattern="yyyy-MM-dd"/>
				</td>
				<shiro:hasPermission name="shop:retire:edit"><td nowrap>
					<!-- 待审核 -->
					<c:if test="${item.auditStatus eq '0'}">
						<a href="${ctx}/shop/retire/status?code=${item.code}&auditStatus=1&retireNo=${item.retireNo}" onclick="return confirmx('确定审核通过吗？', this.href)">审核通过</a>
						<%--<a href="${ctx}/shop/retire/status?code=${item.code}&auditStatus=2&retireNo=${item.retireNo}" onclick="return confirmx('确定审核拒绝吗？', this.href)">审核拒绝</a>--%>
						<a href="javascript:;" id="unStatusBtn" data-code="${item.code}" data-retireNo="${item.retireNo}">审核拒绝</a>
					</c:if>
					<!--审核通过 -->
					<c:if test="${item.auditStatus eq '1' && item.expressStatus ne '1'}">
						<a href="${ctx}/shop/retire/status?code=${item.code}&expressStatus=1&retireNo=${item.retireNo}" onclick="return confirmx('确定已收货吗？', this.href)">已收货</a>
					</c:if>
					<!--已收货 -->
					<c:if test="${item.expressStatus eq '1'}">
						<c:if test="${(empty item.retireStatus) or (item.retireStatus eq '2')}">
							<a href="javascript:;" id="amtbtn" data-code="${item.code}" data-retireNo="${item.retireNo}">已打款</a>
							<a href="${ctx}/shop/retire/status?code=${item.code}&retireStatus=2&retireNo=${item.retireNo}" onclick="return confirmx('确定打款失败吗？', this.href)">打款失败</a>
						</c:if>
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