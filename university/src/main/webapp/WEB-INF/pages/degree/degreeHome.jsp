<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layouts/header.jsp" />
	<div class="div-container">
		<div class="div-container-item">
			<a href="<%=session.getAttribute("hostURL")%>/degree/addForm">
				<label class="lbl-content"><i class="fa fa-plus" aria-hidden="true"></i> Add Degree</label>
			</a>
		</div>
		<div class="div-container-item">
			<a href="<%=session.getAttribute("hostURL")%>/degree/view">
				<label class="lbl-content"><i class="fa fa-list" aria-hidden="true"></i> View Degree</label>
			</a>
		</div>
		<div class="div-container-item">
			<a href="<%=session.getAttribute("hostURL")%>/degree/searchForm">
				<label class="lbl-content"><i class="fa fa-search" aria-hidden="true"></i> Search Degree</label>
			</a>
		</div>	
	</div>

<jsp:include page="/layouts/footer.jsp" />