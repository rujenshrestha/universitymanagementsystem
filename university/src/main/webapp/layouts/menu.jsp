<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="nav-menu">
	<a href="<%=session.getAttribute("hostURL")%>/home" class="menu-title">
		<img class="img-menu" src="<c:url value="/resources/img/icons/home_icon.png"></c:url>" alt="" >
	</a>
	<a href="<%=session.getAttribute("hostURL")%>/home" class="menu-title">
		<img class="img-menu" src="<c:url value="/resources/img/icons/settings_icon.png"></c:url>" alt="" >
	</a>
	<a href="<%=session.getAttribute("hostURL")%>/login/logout">
		<img class="img-menu" src="<c:url value="/resources/img/icons/logoff_icon.png"></c:url>" alt="" >
	</a>
</nav>