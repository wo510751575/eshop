<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<html style="overflow-x:auto;overflow-y:auto;">
<head>
	<title><sitemesh:title/></title>
	<%@include file="/WEB-INF/views/include/head.jsp" %>
	<sitemesh:head/>
</head>
<body>
	<sitemesh:body/>
	<script type="text/javascript">
$(document).ready(function(){
  if(window.parent != window){
	  if ( typeof(page_name) == "undefined" && top.document.getElementById("mainFrame")!=null && top.document.getElementById("jbox-iframe")==null) {
		  var h=(document.body.clientHeight+310);
		  if(h<900){
			  h=1110;
		  }
		  top.document.getElementById("mainFrame").style.height = h+"px";
	  }
  }
 });
</script>
</body>
</html>