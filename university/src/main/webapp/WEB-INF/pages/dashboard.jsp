<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layouts/header.jsp" />

<p class="greetings">Hello <%=session.getAttribute("name") %></p>

<div class="div-container">
	<div class="div-subcontainer-top">
		<a href="http://localhost:8080/university/student/">
			<img class="img-content" src="<c:url value="/resources/img/icons/std_icon.png"></c:url>" alt="" >
		</a>
		<img class="img-content" src="<c:url value="/resources/img/icons/dept_icon.png"></c:url>" alt="" >
	</div>
	<div class="div-subcontainer-bottom">
		<img class="img-content" alt="" src="<c:url value="/resources/img/icons/news_icon.png"></c:url>">
		<img class="img-content" alt="" src="<c:url value="/resources/img/icons/task_icon.png"></c:url>">
	</div>
	
</div>

<jsp:include page="/layouts/footer.jsp" />
