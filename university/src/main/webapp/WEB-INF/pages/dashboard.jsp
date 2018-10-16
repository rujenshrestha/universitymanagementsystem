<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layouts/header.jsp" />

	<div class="div-container">
		<div class="div-subcontainer-top">
			<div class="div-content">
				<a href="<%=session.getAttribute("hostURL")%>/student/">
					<img class="img-content" src="<c:url value="/resources/img/icons/std_icon.png"></c:url>" alt="" >
					<label class="lbl-content">Student</label>
				</a>
			</div>
			<div class="div-content">
				<a href="<%=session.getAttribute("hostURL")%>/department/">
					<img class="img-content" src="<c:url value="/resources/img/icons/dept_icon.png"></c:url>" alt="" >
					<label class="lbl-content">Department</label>
				</a>
			</div>
		</div>
		<div class="div-subcontainer-bottom">
			<div class="div-content">
				<a href="<%=session.getAttribute("hostURL")%>/degree">
					<img class="img-content" alt="" src="<c:url value="/resources/img/icons/degree_icon.png"></c:url>">
					<label class="lbl-content">Degree</label>
				</a>
			</div>
			<div class="div-content">
				<a href="<%=session.getAttribute("hostURL")%>/course">
					<img class="img-content" alt="" src="<c:url value="/resources/img/icons/course_icon.png"></c:url>">
					<label class="lbl-content">Courses</label>
				</a>
			</div>
		</div>
		
	</div>
	
<jsp:include page="/layouts/footer.jsp" />
