<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layouts/header.jsp" />
	<div class="div-container">
		<a href="<%=session.getAttribute("hostURL")%>/student/addForm">
			<div class="div-container-item">
				<label class="lbl-content"><i class="fa fa-plus" aria-hidden="true"></i> Add Student</label>
			</div>
		</a>
		<a href="<%=session.getAttribute("hostURL")%>/student/view">
			<div class="div-container-item">
				<label class="lbl-content"><i class="fa fa-list" aria-hidden="true"></i> View Students</label>			
			</div>
		</a>
		<a href="<%=session.getAttribute("hostURL")%>/student/searchForm">
			<div class="div-container-item">
				<label class="lbl-content"><i class="fa fa-search" aria-hidden="true"></i> Search Student</label>
			</div>	
		</a>
		<a href="<%=session.getAttribute("hostURL")%>/student/courseForm">
			<div class="div-container-item">
				<label class="lbl-content"><i class="fa fa-book" aria-hidden="true"></i> Manage Courses</label>
			</div>
		</a>
	</div>

<jsp:include page="/layouts/footer.jsp" />