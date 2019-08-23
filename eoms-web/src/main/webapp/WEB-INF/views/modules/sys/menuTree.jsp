<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<ul id="menu-${param.parentId}" class="nav nav-pills nav-stacked">
	<c:set var="menuList" value="${fns:getMenuList()}" />
	<c:set var="firstMenu" value="true" />
	<c:forEach items="${menuList}" var="menu" varStatus="idxStatus">
          <c:if
			test="${menu.parent.id eq (not empty param.parentId ? param.parentId:1)&&menu.isShow eq '1'}">
			<li class="${firstMenu?'open active':''}"><a
				href="#" title="${menu.remarks}"
				class="dropdown-toggle"><i
					class="icon-${not empty menu.icon?menu.icon:'circle-arrow-right'}"></i>&nbsp;
					<span>${menu.name}</span><i
					class="fa icon-chevron-right drop-icon"></i></a>
				<ul class="submenu">
				    <c:forEach items="${menuList}" var="menu2">
								<c:if test="${menu2.parent.id eq menu.id&&menu2.isShow eq '1'}">
							<li><a 
								href="${fn:indexOf(menu2.href, '://') eq -1?ctx:''}${not empty menu2.href?menu2.href:'/404'}"
								target="${not empty menu2.target?menu2.target:'mainFrame'}">
									<i
									class="icon-${not empty menu2.icon?menu2.icon:'circle-arrow-right'}"></i>&nbsp;${menu2.name}
							</a></li>
							<c:set var="firstMenu" value="false" />
						</c:if>
					</c:forEach>
				</ul></li>
		</c:if>
	</c:forEach>
</ul>