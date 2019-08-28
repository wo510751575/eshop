<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商品管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript" src="${ctxStatic}/common/ajaxfileupload.js"></script>
	<script type="text/javascript" src="${ctxStatic}/editor/kindeditor.js"></script>
	<script type="text/javascript" src="${ctxStatic}/editor/init.js"></script>
	<script src="${ctxStatic}/common/plupload.full.min.js" type="text/javascript"></script>
    <script type="text/javascript">
   
    </script>
    <style type="text/css">
    .nav-child li a{
          line-height: 10px;
    }
    .nav-child li.active a{
          border: 1px dotted #ddd;
          border-bottom-color: transparent;
    }
    .photo-file{
	 	position: absolute;
	    top: 350px;
	    left: 190px;
	    opacity: 0;
	    filter: alpha(opacity:0);
	    cursor:pointer;
	}
	img {
	    border: 0 none;
	    height: 80px;
	    max-width: 100%;
	    vertical-align: middle;
	}
	.pre-container {
    float: right;
    width: 354px;
    height: 630px;
    background: url(${ctxStatic}/images/iphone.png) no-repeat;
    background-size: 100% auto;
	}
	
	.container{
	padding: 10px 30px;
    width: 100%;
    min-height: 800px;
    background: #fff;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
	}
	#product_img_bt img{
	float: left;
	}
	.close-Icon{
	position: absolute;
    background: url(${ctxStatic}/images/closeImg.png) no-repeat;
    z-index: 100;
    width: 20px;
    height: 20px;
    background-size: 100%;
    right: -7px;
    top: -7px;
       cursor: pointer;
	}
	.img_info{
	position:relative;
	width: 120px;
	height: 120px;
	float: left;
	margin: 10px;
	
	}
    </style>
	<script type="text/javascript">
		function setFlags(){
			var htmls='';
			$("input[name='flagsBox']:checkbox:checked").each(function(i){ 
				htmls+='<input name="flags['+i+'].productFlag" value="'+$(this).attr("productFlag")+'" type="hidden"/>';
				htmls+='<input name="flags['+i+'].code" value="'+$(this).val()+'" type="hidden"/>';
				htmls+='<input name="flags['+i+'].flagType" value="'+$(this).attr("flagType")+'" type="hidden"/>';
				htmls+='<input name="flags['+i+'].productSeq" value="'+$(this).attr("productSeq")+'" type="hidden"/>';
				
			});
			$("#checkedFlags").html(htmls);
		}
		
		
		
		function setProductPics(){
			//设置图片
			var imgInfo="";
			var imgJi=$("#product_img_bt img");
			for(var i=0;i<imgJi.length;i++){
				if(i==imgJi.length-1){
					imgInfo=imgInfo+$(imgJi[i]).attr('url');
				}else{
					imgInfo=imgInfo+$(imgJi[i]).attr('url')+",";
				}
			}
			
			$("#product_input_images").val(imgInfo);
		}
		
		function setProductMaterialPics(){
			//设置商品素材图片介绍 
			var imgInfo="";
			var imgJi=$("#product_material_img_bt img");
			for(var i=0;i<imgJi.length;i++){
				if(i==imgJi.length-1){
					imgInfo=imgInfo+$(imgJi[i]).attr('url');
				}else{
					imgInfo=imgInfo+$(imgJi[i]).attr('url')+",";
				}
			}
			
			$("#product_material_images").val(imgInfo);
			//设置商品素材图片介绍 END 
		}
		
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate({
				 ignore: [],
				submitHandler: function(form){
					setFlags();//设置标签
					//设置图片介绍 
					var descPic="";
					var imgJi=$("#product_desc_img_bt img");
					for(var i=0;i<imgJi.length;i++){
						if(i==imgJi.length-1){
							descPic=descPic+$(imgJi[i]).attr('url');
						}else{
							descPic=descPic+$(imgJi[i]).attr('url')+",";
						}
					}
					$("#product_desc_images").val(descPic);
					//设置图片介绍 END
					
					
					
					loading('正在提交，请稍等...');
	                form.submit();
	                return false;
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
<div class="container" style="height:950px;overflow-x:visible;overflow-y:scroll;">
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/product/product/">商品列表</a></li>
		<li class="active"><a href="${ctx}/product/product/form?code=${data.code}">商品<shiro:hasPermission name="product:product:edit">${not empty data.code?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="product:product:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/> 
	<form id="inputForm"  action="${ctx}/product/product/${not empty data.code?'edit':'save'}" method="post" class="form-horizontal">
		<input type="hidden" name="code" value="${data.code}">
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">商品名称:</label>
			<div class="controls">
				<input type="text" name="name" value="${data.name}" maxlength="64" class="required input-xlarge" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">商品分类:</label>
			<div class="controls">
                <tags:treeselect id="catalog" name="catalogTypeCode" value="${data.catalogTypeCode}" 
                labelName="parentCatalogName" labelValue="${productCatalog.catalogName}"
					title="商品分类" url="/product/catalog/treeData" extId="${data.catalogTypeCode}" cssClass="required"/>
					<span class="help-inline"><font color="red">*</font> </span><span class="help-inline">请选择在二级分类下否则商品无法正常展示 </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label"><span class="help-inline"><font color="red">*</font> </span> 商品图标:</label>
			<div class="controls">
			      <div id="image_btn" style="border: 1px solid #e0e6eb;width:120px;height:120px;line-height:100px;text-align:center">
				       <c:if test="${!empty data.productIcon}">
				       		<img width="120px" height="120px" src="${fns:getUploadUrl()}${data.productIcon}"/>
				       </c:if>
				       <c:if test="${empty data.productIcon}">
				                                  选择图片
				       </c:if>
				    </div>
				<input type="hidden" id="input_image" class="required" name="productIcon" value="${data.productIcon}"/>
			
			</div>
		</div>
		<div class="control-group">
                <label class="control-label"><span class="help-inline"><font color="red">*</font> </span>商品图:</label>
                <div class="controls">
            		<div id="product_img_bt" style="border: 1px solid #ddd;width:50%;line-height:100px;text-align:center;overflow: auto;">
                	<c:choose>
                		<c:when test="${empty data.imgs}">
                			选择图片
                		</c:when>
                		<c:when test="${data.imgs!=null}">
                			<!-- data.imgAddr.split(',') -->
                			<c:forEach items="${data.imgs }" var="imgaddr">
	                			<div class="img_info">
	                			<span class="close-Icon"></span>
	                			<img src="${fns:getUploadUrl()}${imgaddr.img}" url="${imgaddr.img}"  height="120px" width="120px">
	                			</div>
                			</c:forEach>
                		</c:when>
                	</c:choose>
		    		</div>
                     <input id="product_input_images" type="hidden" class="required"  name="imgAddr" value="${imgAddr}">
                     <!-- <span class="help-inline">建议图片尺寸1080*1540</span> -->
                </div>
         </div>
         
		<div class="control-group">
			<label class="control-label">状态:</label>
			<div class="controls">
				<select name="status" class="required">
					<option></option>
						<c:forEach items="${prodcutStatuss}" var="p">
								<c:choose >
									<c:when test="${p.value eq data.status}">
										<option value="${p.value }" selected="selected">${p.chName}</option>
									</c:when>
									<c:otherwise><option  value="${p.value }">${p.chName}</option></c:otherwise>
								</c:choose>
							</c:forEach>
				</select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">供应商:</label>
			<div class="controls">
				<select name="supplyCode" class="required" onchange="supplyNameId.value=$(this).find('option:selected').text();">
					<option></option>
						<c:forEach items="${supplys}" var="p">
								<c:choose >
									<c:when test="${p.code eq data.supplyCode}">
										<option value="${p.code }" selected="selected">${p.supplyName}</option>
									</c:when>
									<c:otherwise><option  value="${p.code }">${p.supplyName}</option></c:otherwise>
								</c:choose>
							</c:forEach>
				</select>
				<input id="supplyNameId" type="hidden"  name="supplyName" value="${data.supplyName }"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		 <div class="control-group">
			<label class="control-label">库存单位:</label>
			<div class="controls">
				<input type="text" name="unit" value="${data.unit}" maxlength="8" style="width: 40px;" class="required input-xlarge" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">服务:</label>
			<div class="controls">
				<c:choose>
					<c:when test="${empty data}">
						<input type="checkbox" id="collectFlag" checked="checked" name="collectFlag" value="0" maxlength="32" class="input-xlarge" />
					</c:when>
					<c:when test="${data.collectFlag eq '0' }">
						<input type="checkbox" id="collectFlag" checked="checked" name="collectFlag" value="0" maxlength="32" class="input-xlarge" />
					</c:when>
					<c:otherwise>
						<input type="checkbox" id="collectFlag" name="collectFlag" value="0" maxlength="32" class="input-xlarge" />
					</c:otherwise>
				</c:choose>
				<label for="collectFlag">邮费到付</label>
				&nbsp;
				<c:choose>
					<c:when test="${empty data}">
						<input type="checkbox" id="returnFlag" checked="checked" name="returnFlag" value="0" maxlength="32" class="input-xlarge" />
					</c:when>
					<c:when test="${data.returnFlag eq '0' }">
						<input type="checkbox" id="returnFlag" checked="checked" name="returnFlag" value="0" maxlength="32" class="input-xlarge" />
					</c:when>
					<c:otherwise>
						<input type="checkbox" id="returnFlag" name="returnFlag" value="0" maxlength="32" class="input-xlarge" />
					</c:otherwise>
				</c:choose>
				<label for="returnFlag">24小时无理由退货</label>
				&nbsp;
				<c:choose>
					<c:when test="${data.packFlag eq '0' }">
						<input type="checkbox" id="packFlag" checked="checked" name="packFlag" value="0" maxlength="32" class="input-xlarge" />
					</c:when>
					<c:otherwise>
						<input type="checkbox" id="packFlag" name="packFlag" value="0" maxlength="32" class="input-xlarge" />
					</c:otherwise>
				</c:choose>
				<label for="packFlag">精美礼盒包装</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">商品标签:</label>
			<div class="controls">
					<c:forEach items="${flags}" var="p">
						<input name="flagsBox" value="${p.code }" type="checkbox" id="${p.code}_id" productFlag="${p.productFlag }" flagType="${p.flagType }" productSeq="${p.productSeq }"/>
						<label for="${p.code}_id">${p.productFlag}</label>
					</c:forEach>
			</div>
			<div>
				<c:forEach items="${productFlags}" var="item">
					<input name="pFlags" value="${item.flagCode}" type="hidden" />
				</c:forEach>
			</div>
			<div id="checkedFlags">
			</div>
		</div>
<script>
	//设置规格
	function checkedRules(obj){
		var id=$(obj).attr("code");
		var productFlag=$(obj).attr("productFlag");
		if($(obj).is(':checked')){
			var html="";
			html+='<div id="rule_'+id+'" flagName="'+productFlag+'" class="control-group">';
			html+='<label class="control-label">'+productFlag+':</label>';
			html+='<div class="controls">';
			html+='	<div id="attrs_'+id+'" style="float: left;">';
			html+='		<div  style="float: left;" ><input type="text" name="attrname_'+id+'" onchange="$(\'#priceTable\').html(\'\');" maxlength="128"  class="attrname required" style="width:80px;"/>&nbsp;<span class="close-Icon" onclick="removeAttrs(this);" style="position: static;padding:10px;padding-top:0px;">&nbsp;</span></div>';
			html+='	</div>';
			html+='	&nbsp;<input type="button" value="新增属性" rulecode="'+id+'"   onclick="addAttrs(this);"/>';
			html+='</div>';
			html+='</div>';
			
			$("#checkedRules").append(html);
		}else{
			$("#rule_"+id).remove();
		}
	}
	//新增规格属性
	function addAttrs(obj){
		var rulecode=$(obj).attr("rulecode");
		var id="attrs_"+rulecode;
		var htmls='<div style="float:left;"><input type="text"  maxlength="128" onchange="$(\'#priceTable\').html(\'\');" class="attrname required" style="width:80px;"/>&nbsp;<span class="close-Icon" onclick="removeAttrs(this);" style="position: static;padding:10px;padding-top:0px;">&nbsp;</span><div>';
		$("#"+id).append(htmls);
		//重命名 用于校验
		$("#rule_"+rulecode).find(".attrname").each(function(j){
			 $(this).attr("name","attrname_"+rulecode+j)
		});
		//重置校验 避免重复
		$("#rule_"+rulecode).find("label[class='error']").each(function(j){
			 $(this).remove();
		});
		$("#priceTable").html("");
	}
	//删除规格属性
	function removeAttrs(obj){
		$(obj).parent("div").remove();
		$("#priceTable").html("");
	}
	//设置提交的规格及属性值
	function setRules(){
		var htmls='';
		$("#checkedRules").find(".control-group").each(function(i){
			var flagName=$(this).attr("flagName");
			htmls+='<input type="hidden" name="rules['+i+'].name" value="'+flagName+'"/>';
			$(this).find(".attrname").each(function(j){
				var attrname=$(this).val();
				if(attrname!=""){
					htmls+='<input type="hidden" name="rules['+i+'].spes['+j+'].ruleDetail" value="'+attrname+'"/>';
				}
			});
		});
		$("#rulesInfo").html(htmls);
	}
	//初始化设置价格的表单
	function setPrice(){
		//校验是否正确及重复
		var attrs = new Map() ;
		$(".attrname").each(function(j){
			var attrname=$(this).val();
			var t = $(this).attr("type");
			if(t&&t=='text'){
				if(attrname==""){
					$(this).valid();
				}else{ 
					if(attrs.get(attrname)!=null){
						$(this).val("");//重复直接滞空
						$(this).valid();
						$(this).next("label").html(attrname+"重复！");
					}
					attrs.set(attrname, attrname);
				}
			}
		});
		if($(".attrname.error").length>0){//有未合格的属性值，则不显示价格输入表单
			showTip("属性不合规，无法展示价格输入表单。"); 
			return ;
		};//校验是否正确及重复
		
		var rules=new Array();
		var divObj=$("#checkedRules");
		if($("#showRules").length > 0){
			divObj=$("#showRules");
		} 
		divObj.find(".control-group").each(function(i){
			var r=new Object();
			var flagName=$(this).attr("flagName");
			r.name=flagName;
			var spes=new Array();
			$(this).find(".attrname").each(function(j){
				var attrname=$(this).val();
				if($(this).attr("ruleDetail")){
					attrname=$(this).attr("ruleDetail");
				}
				var spe=new Object();
				if($(this).attr("code")){
					spe.code=$(this).attr("code");
				}
				spe.name=attrname;
				spes[j]=spe;
				//spes[j]=attrname;
			});
			r.spes=spes;
			rules[i]=r;
		});
		//alert(JSON.stringify(rules));
		var mRules=rules[0];
		for (var i = 0; i < rules.length-1; i++) {
			mRules=mergeRules(mRules,rules[i+1]);
		} 
		//alert(JSON.stringify(mRules));
		//根据合并的属性设置表单用于填价格和库存
	
		$("#priceTable").html("");
		setPriceHead(mRules.name);
		for (var i = 0; i < mRules.spes.length; i++) {
			var e2= mRules.spes[i];
			var htmls='';
			htmls+='<tr class="inputTr">';
			htmls+=setPriceTr(e2.name);
			htmls+='<td>';
			if(e2.code){
				htmls+='	<input name="skus['+i+'].productSpes" class="skuProductSpes" type="hidden" value="'+e2.code+'"  style="width: 80px;"/>';
			}
			htmls+='	<input name="skus['+i+'].skuDesc" class="skuDesc" type="hidden" value="'+e2.name+'" />';
// 			htmls+='<input name="skus['+i+'].costPrice"  class="skuCostPrice required number" maxlength="10" style="width: 80px;"/></td>';
			htmls+='<input name="skus['+i+'].salePrice"  class="skuSalePrice required number" maxlength="10" style="width: 80px;"/></td>';
// 			htmls+='<td><input name="skus['+i+'].price" class="skuPrice required number" maxlength="10" style="width: 80px;"/></td>';

			//特权价格
			var memberRankDtos = jQuery.parseJSON('${memberRankDtos}');
			$(memberRankDtos).each(function(key,value){
				htmls+='<td>';
				htmls+='<input type="hidden" name="skus['+i+'].rankPriceDtos['+key+'].rankCode" value="'+value.code+'"/>';
				htmls+='<input name="skus['+i+'].rankPriceDtos['+key+'].rankPrice" class="skuPrice required number" maxlength="10" style="width: 80px;"/>';
				htmls+='</td>';
		    });

			htmls+='<td><input name="skus['+i+'].cnt" class="skuCnt required digits" maxlength="10" style="width: 80px;"/></td>';
			if(i==0){
				htmls+='<td><input type="radio" checked="checked" onclick="setIsDefault(this)" class="skuIsDefault" value="0" name="skus['+i+'].isDefault" /></td>';
			}else{
				htmls+='<td><input type="radio" value="0" onclick="setIsDefault(this)" class="skuIsDefault" name="skus['+i+'].isDefault" /></td>';	
			}
			htmls+='<td><label onclick="removeSku(this)">删除</label></td>';
			htmls+='</tr>';
			$("#priceTable").append(htmls);
		}
	}
	//设置未默认，则把其他设置未非默认，只允许一个默认
	function setIsDefault(obj){
		 var ck=$(obj)[0].checked;
		 if(ck){
			 $(".skuIsDefault").each(function(i){
					$(this)[0].checked=false;//要用dom操作否则无用
			    });
		 }
		 $(obj).attr('checked',true);
	}
	
	function removeSku(obj){
		$(obj).parent('td').parent('tr').remove();
		$("#priceTable").find(".inputTr").each(function(i){
			$(this).find(".skuProductSpes").attr("name","skus["+i+"].productSpes");
			$(this).find(".skuDesc").attr("name","skus["+i+"].skuDesc");
			$(this).find(".skuCostPrice").attr("name","skus["+i+"].costPrice");
			$(this).find(".skuSalePrice").attr("name","skus["+i+"].salePrice");
			$(this).find(".skuPrice").attr("name","skus["+i+"].price");
			$(this).find(".skuCnt").attr("name","skus["+i+"].cnt");
			$(this).find(".skuIsDefault").attr("name","skus["+i+"].isDefault");
	    });
		
		if($("input[type='radio']:checked").filter(".skuIsDefault").length!=1){//无默认则第一个设置为默认
			$(".skuIsDefault").eq(0).attr("checked","true") ;
		};
	}
	function setPriceHead(e2){
		//设置表头
		var htmls='';
		htmls+='<tr style="font-weight: bold;">';
		htmls+=setPriceTr(e2);
// 		htmls+='<td>出厂价(￥)</td>';
// 		htmls+='<td>市场价(￥)</td>';
		htmls+='<td>售价(￥)</td>';
		
		//特权价格
		var memberRankDtos = jQuery.parseJSON('${memberRankDtos}');
		$(memberRankDtos).each(function(key,value){
			htmls+='<td>'+value.name+'售价(￥)</td>';
	    });
		htmls+='<td>库存</td>';
		htmls+='<td>是否默认</td>';
		htmls+='<td>操作</td>';
		htmls+='</tr>';
		$("#priceTable").append(htmls);
	}
	function setPriceTr(names){
		var n=names.split(",");
		var htmls='';
		for (var i = 0; i < n.length; i++) {
			htmls+='<td>'+n[i]+'</td>';
		}
		return htmls;
	}
	//合并属性
	function mergeRules(r1,r2){
		var r=new Object();
		r.name=(r1.name +"," +r2.name);
		var spes=new Array();
		var k=0;
		for (var i = 0; i < r1.spes.length; i++) {
			var e1=r1.spes;
			for (var j = 0; j < r2.spes.length; j++) {
				var e2=r2.spes;
				var spe=new Object();
				if(e1[i].code&&e2[j].code){
					spe.code=e1[i].code+"," +e2[j].code;
				}
				spe.name=e1[i].name+"," +e2[j].name;
				spes[k]=spe;
				//spes[k]=e1[i]+"," +e2[j];
				k++;
			}
		}
		r.spes=spes;
		return r;
	}
	
	//修改SKU 库存及价格
	function updateSku(obj){
			var code=$(obj).attr("code");
			
// 			var a=$("#sku_costPrice_"+code).valid();
			var b=$("#sku_salePrice_"+code).valid();
// 			var c=$("#sku_price_"+code).valid();
			var e=$("#sku_cnt_"+code).valid();
			if(!(b&&e)){
				return ;
			}
			var param=new Object();
			 param.code=code;
// 			 param.costPrice=$("#sku_costPrice_"+code).val();
			 param.salePrice=$("#sku_salePrice_"+code).val();
// 			 param.price=$("#sku_price_"+code).val();
			 param.cnt=$("#sku_cnt_"+code).val();
			 param.productCode=$(obj).attr("productCode");
			 if($("#sku_isDefault_"+code).get(0).checked){
				 param.isDefault="0";
			 }
			 
			 $.ajax({
				  type: 'POST',
				  url: "${ctx}/product/product/sku/edit",
				  data: param,
				  success: function(data, textStatus, jqXHR){
					   if(data.result){
						   showTip("修改成功"); 
					   }else{
						   showTip(data.msg);
					   }
				  },
				  dataType: "json"//xml、json、script 或 html
				});
	}
</script>		
	 	<c:if test="${empty productRules}">
				<div class="control-group">
					<label class="control-label">商品规格:</label>
					<div class="controls">
							<c:forEach items="${sysSpes}" var="p">
								<input name="rulesBox" value="${p.code }"  code="${p.code }" productFlag="${p.speName}"  type="checkbox" onchange="checkedRules(this);" id="${p.code}_id1" />
								<label for="${p.code}_id1">${p.speName}</label>
							</c:forEach>
					</div>
				</div>
				<div id="checkedRules">
				</div>
				<div id="rulesInfo">
				</div>
		</c:if>	
		<c:if test="${!empty productRules}">
				<div id="showRules">
					<c:forEach items="${productRules}" var="p">
						<div class="control-group" flagName="${p.name }" >
							<label class="control-label" >${p.name }:</label>
								<div class="controls">
									<c:forEach items="${p.spes}" var="item">
										<label class="attrname" code="${item.code }" ruleDetail="${item.ruleDetail }" style="border: 1px solid #ccc;padding: 0 13px;">${item.ruleDetail }</label>
									</c:forEach>
								</div>
						</div>
					</c:forEach>
				</div>
		</c:if>
		
		<c:if test="${empty productSkus}">
			<div class="control-group">
			<label class="control-label">价格:</label>
			<div class="controls">
				<input type="button" value="设置价格" onclick="setPrice()" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">设置价格:</label>
			<div class="controls">
			       <table id="priceTable" class="table-form" style="width:70%;" >
			       </table>
			</div>
		</div>
		</c:if>
		
		<c:if test="${!empty productSkus}">
		<div class="control-group">
			<label class="control-label">价格:</label>
				<div class="controls">
				       <table id="priceTable" class="table-form" style="width:70%;" >
					       	<tr style="font-weight: bold;">
					       		<c:forEach items="${productRules}" var="p">
									<td>${p.name }</td>
					       		</c:forEach>
<!-- 					       		<td>出厂价(￥)</td> -->
					       		<td>售价(￥)</td>
<!-- 					       		<td>市场价(￥)</td> -->
								<c:forEach items="${memberRankDtosNotJson}" var="item">
									<td>${item.name}售价(￥)</td>
					       		</c:forEach>
					       		<td>库存</td>
					       		<td>是否默认</td>
					       		<td>操作</td>
					       	</tr>
					       	<c:forEach items="${productSkus}" var="p">
				       		<tr>
				       			<c:forEach items="${p.skuDesc.split(',') }" var="imgaddr">
		                			 <td>${imgaddr }</td>
                				</c:forEach>
<%-- 					       		<td><input id="sku_costPrice_${p.code }" name="sku_costPrice_${p.code }" value="${p.costPrice}" maxlength="10" class="required number" style="width: 80px;"/></td> --%>
					       		<td><input id="sku_salePrice_${p.code }" name="sku_salePrice_${p.code }" value="${p.salePrice}" maxlength="10" class="required number"  style="width: 80px;"/></td>
<%-- 					       		<td><input id="sku_price_${p.code }" name="sku_price_${p.code }" value="${p.price}" maxlength="10" class="required number"  style="width: 80px;"/></td> --%>
					       		<c:forEach items="${memberRankDtosNotJson}" var="item">
									<c:forEach items="${p.rankPriceDtos}" var="r">
										<c:if test="${item.code eq r.rankCode}">
											<td><input id="sku_rank_price_${r.code }" name="sku_rank_price_${r.code }" value="${r.rankPrice}" maxlength="10" class="required number"  readonly="readonly" style="width: 80px;"/></td>											
										</c:if>
						       		</c:forEach>
					       		</c:forEach>
					       		<td><input id="sku_cnt_${p.code }" name="sku_cnt_${p.code }" value="${p.cnt}" maxlength="10" class="required digits" style="width: 80px;"/></td>
					       		<td>
					       			<c:if test="${p.isDefault eq '0'}">
					       				<input type="radio" id="sku_isDefault_${p.code }" name="skuIsDefault" checked="checked">
					       			</c:if>
					       			<c:if test="${!(p.isDefault eq '0')}">
					       				<input type="radio" id="sku_isDefault_${p.code }" name="skuIsDefault" >
					       			</c:if>
					       		</td>
					       		<td><input type="button" value="修改"  code="${p.code}" productCode="${p.productCode}" onclick="updateSku(this);"/></td>
				       		</tr>
				       		</c:forEach>
				       </table>
				</div>
			</div>
		</c:if>
		
		
		<div class="control-group">
			<label class="control-label">商品规格图:</label>
			<div class="controls">
			      <div id="spe_img_bt" style="border: 1px solid #e0e6eb;width:120px;height:120px;line-height:100px;text-align:center">
				       <c:if test="${!empty data.speImg}">
				       		<img width="120px" height="120px" src="${fns:getUploadUrl()}${data.speImg}"/>
				       </c:if>
				       <c:if test="${empty data.productIcon}">
				                                  选择图片
				       </c:if>
				    </div>
				<input type="hidden" id="spe_img" name="speImg" value="${data.speImg}"/>
			</div>
		</div>
		
	<%-- 	<div class="control-group">
			<label class="control-label">商品介绍:</label>
			<div class="controls">
				<textarea  name="productDesc" id="editor" class="editor" maxlength="128" class="input-xlarge" >${data.productDesc}</textarea>
			</div>
		</div>   --%>
		
		<div class="control-group">
                <label class="control-label">商品素材图:</label>
                <div class="controls">
            		<div id="product_material_img_bt" style="border: 1px solid #ddd;width:50%;line-height:100px;text-align:center;overflow: auto;">
                	<c:choose>
                		<c:when test="${empty data.productMaterial}">
                			选择图片
                		</c:when>
                		<c:when test="${data.productMaterial!=null}">
                			
                			<c:forEach items="${data.productMaterial.split(',') }" var="materialImga">
	                			<div class="img_info">
	                			<span picType="2" class="close-Icon"></span>
	                			<img src="${materialImga}" url="${materialImga}"  height="120px" width="120px">
	                			</div>
                			</c:forEach>
                		</c:when>
                	</c:choose>
		    		</div>
                     <input id="product_material_images" type="hidden" name="productMaterial" >
                     <!-- <span class="help-inline">建议图片尺寸1080*1540</span> -->
                </div>
         </div>
		
			<div class="control-group">
                <label class="control-label">商品介绍图:</label>
                <div class="controls">
            		<div id="product_desc_img_bt" style="border: 1px solid #ddd;width:50%;line-height:100px;text-align:center;overflow: auto;">
                	<c:choose>
                		<c:when test="${empty data.productDesc}">
                			选择图片
                		</c:when>
                		<c:when test="${data.productDesc!=null}">
                			
                			<c:forEach items="${data.productDesc.split(',') }" var="imgaddr">
	                			<div class="img_info">
	                			<span picType="2" class="close-Icon"></span>
	                			<img src="${fns:getUploadUrl()}${imgaddr}" url="${imgaddr}"  height="120px" width="120px">
	                			</div>
                			</c:forEach>
                		</c:when>
                	</c:choose>
		    		</div>
                     <input id="product_desc_images" type="hidden" name=productDesc value="${data.productDesc}">
                     <!-- <span class="help-inline">建议图片尺寸1080*1540</span> -->
                </div>
         </div>
         
         
		
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<textarea  name="remarks" maxlength="128" class="input-xlarge" >${data.remarks}</textarea>
			</div>
		</div>  
		 
		 
		<div class="form-actions">
			<shiro:hasPermission name="member:member:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit" onclick="setRules()" value="保 存"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form>
	</div>

<script type="text/javascript">
	//icon
	var uploader = new plupload.Uploader({ //实例化一个plupload上传对象
		browse_button : 'image_btn',
		url : '${ctx}/file/upload?dirName=product',
		multi_selection:false,
		auto_start : true,
		flash_swf_url : '${ctxStatic}/common/Moxie.swf',
		silverlight_xap_url : '${ctxStatic}/common/Moxie.xap',
		filters: {
		  mime_types : [ //只允许上传图片文件
		    { title : "图片文件", extensions : "jpg,gif,png" }
		  ],
		  max_file_size : '1024kb',
		  prevent_duplicates : true 
		},
		multipart_params: {
			fileType: 'image',
			width:400,
			height:400
		}
	});
	uploader.init(); //初始化
	uploader.bind('FilesAdded',function(uploader,files){
		if(files.length>0){
			uploader.start();
		}
	});
	uploader.bind('Error',function(uploader,errObject){
		showTip(errObject.message,"info");
	});
	
	uploader.bind('FileUploaded',function(uploader,file,responseObject){
			var response = $.parseJSON(responseObject.response);
			$("#image_btn").html('<img width="120px" height="120px" src="'+uploadUrl+'/eoms'+response.url+'"/>');
			$("#input_image").val("/eoms" + response.url);
	});//END
	
	//规格图
	var uploaderSpeImg = new plupload.Uploader({ //实例化一个plupload上传对象
		browse_button : 'spe_img_bt',
		url : '${ctx}/file/upload?dirName=product',
		multi_selection:false,
		auto_start : true,
		flash_swf_url : '${ctxStatic}/common/Moxie.swf',
		silverlight_xap_url : '${ctxStatic}/common/Moxie.xap',
		filters: {
		  mime_types : [ //只允许上传图片文件
		    { title : "图片文件", extensions : "jpg,gif,png" }
		  ],
		  max_file_size : '1024kb',
		  prevent_duplicates : true 
		},
		multipart_params: {
			fileType: 'image',
			/* width:800 ,
			height:800  */
			width:640,
			height:525 
		}
	});
	uploaderSpeImg.init(); //初始化
	uploaderSpeImg.bind('FilesAdded',function(uploader,files){
		if(files.length>0){
			uploader.start();
		}
	});
	uploaderSpeImg.bind('Error',function(uploader,errObject){
		showTip(errObject.message,"info");
	});
	
	uploaderSpeImg.bind('FileUploaded',function(uploader,file,responseObject){
			var response = $.parseJSON(responseObject.response);
			$("#spe_img_bt").html('<img width="120px" height="120px" src="'+uploadUrl+'/eoms'+response.url+'"/>');
			$("#spe_img").val("/eoms" + response.url);
	});
	//规格图END
	
	 //商品图	
	 var uploaderProductImg = new plupload.Uploader({ //实例化一个plupload上传对象
		browse_button : 'product_img_bt',
		url : '${ctx}/file/upload?dirName=product',
		multi_selection:false,
		auto_start : true,
		flash_swf_url : '${ctxStatic}/common/Moxie.swf',
		silverlight_xap_url : '${ctxStatic}/common/Moxie.xap',
		filters: {
		  mime_types : [ //只允许上传图片文件
		    { title : "图片文件", extensions : "jpg,gif,png" }
		  ],
		  max_file_size : '10240kb',
		  prevent_duplicates : true 
		},
		multipart_params: {
			fileType: 'image',
			width:800 ,
			height:800 
		}
	});
	uploaderProductImg.init(); //初始化
	uploaderProductImg.bind('FilesAdded',function(uploader,files){
		if(files.length>0){
			uploader.start();
		}
	});
	uploaderProductImg.bind('Error',function(uploader,errObject){
		if(errObject.code!=-602){
			showTip(errObject.message,"info");
		}
	});
	uploaderProductImg.bind('FileUploaded',function(uploader,file,responseObject){
			var response = $.parseJSON(responseObject.response);
			var child=$("#product_img_bt").children();
			var html="";
			if(child.length>0){
				html=$("#product_img_bt").html();
			}
			html=html+'<div class="img_info"><span class="close-Icon" ></span><img width="120px" height="120px" src="'+uploadUrl+'/eoms'+response.url+'" url="/eoms'+response.url+'" /></div>';
			$("#product_img_bt").html(html);
			setProductPics();
			$(".close-Icon").on("click",function(e){
				imgClose(this,e);
	        });
			
	});//商品图
	
	
	//商品素材图-start	
	 var uploaderProductImg = new plupload.Uploader({ //实例化一个plupload上传对象
		browse_button : 'product_material_img_bt',
		url : '${ctx}/file/upload?dirName=product',
		multi_selection:false,
		auto_start : true,
		flash_swf_url : '${ctxStatic}/common/Moxie.swf',
		silverlight_xap_url : '${ctxStatic}/common/Moxie.xap',
		filters: {
		  mime_types : [ //只允许上传图片文件
		    { title : "图片文件", extensions : "jpg,gif,png" }
		  ],
		  max_file_size : '10240kb',
		  prevent_duplicates : true 
		},
		multipart_params: {
			fileType: 'image',
			width:800 ,
			height:800 
		}
	});
	uploaderProductImg.init(); //初始化
	uploaderProductImg.bind('FilesAdded',function(uploader,files){
		if(files.length>0){
			uploader.start();
		}
	});
	uploaderProductImg.bind('Error',function(uploader,errObject){
		if(errObject.code!=-602){
			showTip(errObject.message,"info");
		}
	});
	uploaderProductImg.bind('FileUploaded',function(uploader,file,responseObject){
		var response = $.parseJSON(responseObject.response);
		var child=$("#product_material_img_bt").children();
		var html="";
		if(child.length>0){
			html=$("#product_material_img_bt").html();
		}
		html=html+'<div class="img_info"><span picType="2" class="close-Icon" ></span><img width="120px" height="120px" src="'+uploadUrl+'/eoms'+response.url+'" url="/eoms'+response.url+'" /></div>';
		$("#product_material_img_bt").html(html);
		setProductMaterialPics();
		$(".close-Icon").on("click",function(e){
			imgClose(this,e);
        });
		
	});//商品素材图-end
	 
	$(document).ready(function() {
		 $(".close-Icon").on("click",function(e){
			 imgClose(this,e);
	     });
		 
		 $("input[name='pFlags']").each(function(i){ //勾选已经选中的标签
			 var id=$(this).val()+"_id";
			 $("#"+id).attr("checked","true"); 
		 });
		 
	 });
	
		
	
		function imgClose(event,e){
			$(event).parent().remove();
			var picType=$(event).attr("picType");
			if(picType && picType=='2'){
				var show=$("#product_desc_img_bt").children();
	        	if(show.length==0){
	        		$("#product_desc_img_bt").html("选择图片");
	        	}
	        	
	        	var shows=$("#product_material_img_bt").children();
	        	if(shows.length==0){
	        		$("#product_material_img_bt").html("选择图片");
	        	}
			}else{
				var show=$("#product_img_bt").children();
	        	if(show.length==0){
	        		$("#product_img_bt").html("选择图片");
	        	}
	        	setProductPics();
			}
        	e.stopPropagation(); 
        	return false;
		}	 
		
		//商品介绍图	
		 var uploaderProductImg = new plupload.Uploader({ //实例化一个plupload上传对象
			browse_button : 'product_desc_img_bt',
			url : '${ctx}/file/upload?dirName=product',
			multi_selection:false,
			auto_start : true,
			flash_swf_url : '${ctxStatic}/common/Moxie.swf',
			silverlight_xap_url : '${ctxStatic}/common/Moxie.xap',
			filters: {
			  mime_types : [ //只允许上传图片文件
			    { title : "图片文件", extensions : "jpg,gif,png" }
			  ],
			  max_file_size : '10240kb',
			  prevent_duplicates : true 
			},
			multipart_params: {
				fileType: 'image',
				width:800/* ,
				height:1540 */
			}
		});
		uploaderProductImg.init(); //初始化
		uploaderProductImg.bind('FilesAdded',function(uploader,files){
			if(files.length>0){
				uploader.start();
			}
		});
		uploaderProductImg.bind('Error',function(uploader,errObject){
			if(errObject.code!=-602){
				showTip(errObject.message,"info");
			}
		});
		uploaderProductImg.bind('FileUploaded',function(uploader,file,responseObject){
				var response = $.parseJSON(responseObject.response);
				var child=$("#product_desc_img_bt").children();
				var html="";
				if(child.length>0){
					html=$("#product_desc_img_bt").html();
				}
				html=html+'<div class="img_info"><span picType="2" class="close-Icon" ></span><img width="120px" height="120px" src="'+uploadUrl+'/eoms'+response.url+'" url="/eoms'+response.url+'" /></div>';
				$("#product_desc_img_bt").html(html);
				
				$(".close-Icon").on("click",function(e){
					imgClose(this,e);
		        });
				
		});//商品图介绍图 END
		
		
		
		
		
		
</script>
</body>
</html>