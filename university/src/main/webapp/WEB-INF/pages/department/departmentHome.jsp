<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layouts/header.jsp" />
	<div class="div-container">
		<div class="div-container-item">
			<a href="<%=session.getAttribute("hostURL")%>/department/addForm">
				<label class="lbl-content"><i class="fa fa-plus" aria-hidden="true"></i> Add Department</label>
			</a>
		</div>
		<div class="div-container-item">
			<a href="<%=session.getAttribute("hostURL")%>/department/view">
				<label class="lbl-content"><i class="fa fa-list" aria-hidden="true"></i> View Department</label>
			</a>
		</div>
	</div>
<jsp:include page="/layouts/footer.jsp" />