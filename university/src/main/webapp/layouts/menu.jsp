<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="nav-menu">
	<a href="http://localhost:8080/university/home" class="menu-title">
		<img class="img-menu" src="<c:url value="/resources/img/icons/home_icon.png"></c:url>" alt="" >
	</a>
	<a href="http://localhost:8080/university/home" class="menu-title">
		<img class="img-menu" src="<c:url value="/resources/img/icons/settings_icon.png"></c:url>" alt="" >
	</a>
	<!-- <div class="div-drop-down">
		<label class="menu-title">Department</label>
		<div class="div-menu-items">
			<a href="#">Link 1</a>
		    <a href="#">Link 2</a>
		    <a href="#">Link 3</a>
		</div>
	</div> -->
	<a href="http://localhost:8080/university/login/logout">
		<img class="img-menu" src="<c:url value="/resources/img/icons/logoff_icon.png"></c:url>" alt="" >
	</a>
</nav>