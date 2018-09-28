<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layouts/header.jsp" />
	<div class="div-container">
		<div class="div-subcontainer-top">
			<a href="http://localhost:8080/university/student/addForm">
				<img class="img-content" src="<c:url value="/resources/img/icons/add_std_icon.png"></c:url>" alt="" >
			</a>
			<a href="http://localhost:8080/university/student/view">
				<img class="img-content" src="<c:url value="/resources/img/icons/view_all_icon.png"></c:url>" alt="" >
			</a>
		</div>
		<div class="div-subcontainer-bottom">
		<a href="http://localhost:8080/university/student/searchForm">
			<img class="img-content" alt="" src="<c:url value="/resources/img/icons/search_icon.png"></c:url>">
		</a>
		</div>
	
	</div>

<jsp:include page="/layouts/footer.jsp" />