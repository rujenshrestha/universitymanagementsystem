<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layouts/header.jsp" />
	<div class="div-container">
		<div class="div-subcontainer-top">
			<div class="div-content">
				<a href="http://localhost:8080/university/department/addForm">
					<img class="img-content" src="<c:url value="/resources/img/icons/add_dept_icon.png"></c:url>" alt="" >
					<label class="lbl-content">Add Department</label>
				</a>
			</div>
			<div class="div-content">
				<a href="http://localhost:8080/university/department/view">
					<img class="img-content" src="<c:url value="/resources/img/icons/view_all_icon.png"></c:url>" alt="" >
					<label class="lbl-content">View All Department</label>
				</a>
			</div>
		</div>
		<div class="div-subcontainer-bottom">
			<div class="div-content">
				<a href="http://localhost:8080/university/student/searchForm">
					<img class="img-content" alt="" src="<c:url value="/resources/img/icons/course_icon.png"></c:url>">
					<label class="lbl-content">Courses</label>
				</a>
			</div>
			<div class="div-content">
				<a href="http://localhost:8080/university/student/searchForm">
					<img class="img-content" alt="" src="<c:url value="/resources/img/icons/faculty_icon.png"></c:url>">
					<label class="lbl-content">Faculty</label>
				</a>
			</div>
		</div>
	
	</div>

<jsp:include page="/layouts/footer.jsp" />