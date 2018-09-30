<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layouts/header.jsp" />

	<div class="div-container">
		<div class="div-subcontainer-top">
			<div class="div-content">
				<a href="http://localhost:8080/university/student/">
					<img class="img-content" src="<c:url value="/resources/img/icons/std_icon.png"></c:url>" alt="" >
					<label class="lbl-content">Student</label>
				</a>
			</div>
			<div class="div-content">
				<a href="http://localhost:8080/university/department/">
					<img class="img-content" src="<c:url value="/resources/img/icons/dept_icon.png"></c:url>" alt="" >
					<label class="lbl-content">Department</label>
				</a>
			</div>
		</div>
		<div class="div-subcontainer-bottom">
			<div class="div-content">
				<img class="img-content" alt="" src="<c:url value="/resources/img/icons/news_icon.png"></c:url>">
				<label class="lbl-content">News</label>
			</div>
			<div class="div-content">
				<img class="img-content" alt="" src="<c:url value="/resources/img/icons/task_icon.png"></c:url>">
				<label class="lbl-content">Task</label>
			</div>
		</div>
		
	</div>
	
<jsp:include page="/layouts/footer.jsp" />
