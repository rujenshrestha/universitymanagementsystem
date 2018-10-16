<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layouts/header.jsp" />
	<div class="div-container">
		<a href="<%=session.getAttribute("hostURL")%>/department/addForm">
			<div class="div-container-item">
				<label class="lbl-content"><i class="fa fa-plus" aria-hidden="true"></i> Add Department</label>			
			</div>
		</a>
		<a href="<%=session.getAttribute("hostURL")%>/department/view">
			<div class="div-container-item">
				<label class="lbl-content"><i class="fa fa-list" aria-hidden="true"></i> View Department</label>			
			</div>
		</a>
	</div>
<jsp:include page="/layouts/footer.jsp" />