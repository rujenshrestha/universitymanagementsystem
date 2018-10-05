<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layouts/header.jsp" />
	<div class="div-container">
		<div class="div-subcontainer-top">
			<div class="div-content">
				<a href="<%=session.getAttribute("hostURL")%>/student/addForm">
					<img class="img-content" src="<c:url value="/resources/img/icons/add_std_icon.png"></c:url>" alt="" >
					<label class="lbl-content">Add Student</label>
				</a>
			</div>
			<div class="div-content">
				<a href="<%=session.getAttribute("hostURL")%>/student/view">
					<img class="img-content" src="<c:url value="/resources/img/icons/view_all_icon.png"></c:url>" alt="" >
					<label class="lbl-content">View All Students</label>
				</a>
			</div>
		</div>
		<div class="div-subcontainer-bottom">
		<div class="div-content">
			<a href="<%=session.getAttribute("hostURL")%>/student/searchForm">
				<img class="img-content" alt="" src="<c:url value="/resources/img/icons/search_icon.png"></c:url>">
				<label class="lbl-content">Search Student</label>
			</a>
		</div>
		</div>
	
	</div>

<jsp:include page="/layouts/footer.jsp" />