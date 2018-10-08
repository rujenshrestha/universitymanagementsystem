<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layouts/header.jsp" />
	<div class="div-container">
		<div class="div-container-item">
			<a href="<%=session.getAttribute("hostURL")%>/student/addForm">
				<label class="lbl-content"><i class="fa fa-plus" aria-hidden="true"></i> Add Student</label>
			</a>
		</div>
		<div class="div-container-item">
			<a href="<%=session.getAttribute("hostURL")%>/student/view">
				<label class="lbl-content"><i class="fa fa-list" aria-hidden="true"></i> View Students</label>
			</a>
		</div>
		<div class="div-container-item">
			<a href="<%=session.getAttribute("hostURL")%>/student/searchForm">
				<label class="lbl-content"><i class="fa fa-search" aria-hidden="true"></i> Search Student</label>
			</a>
		</div>	
	</div>

<jsp:include page="/layouts/footer.jsp" />