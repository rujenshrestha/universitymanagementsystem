<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layouts/header.jsp" />
	<div class="div-container">
		<div class="div-container-item">
			<a href="<%=session.getAttribute("hostURL")%>/course/addForm">
				<label class="lbl-content"><i class="fa fa-plus" aria-hidden="true"></i> Add Course</label>
			</a>
		</div>
		<div class="div-container-item">
			<a href="<%=session.getAttribute("hostURL")%>/course/view">
				<label class="lbl-content"><i class="fa fa-list" aria-hidden="true"></i> View Course</label>
			</a>
		</div>
		<div class="div-container-item">
			<a href="<%=session.getAttribute("hostURL")%>/course/searchForm">
				<label class="lbl-content"><i class="fa fa-search" aria-hidden="true"></i> Search Course</label>
			</a>
		</div>	
	</div>

<jsp:include page="/layouts/footer.jsp" />