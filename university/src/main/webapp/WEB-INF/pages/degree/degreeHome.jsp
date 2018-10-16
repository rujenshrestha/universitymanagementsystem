<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layouts/header.jsp" />
	<div class="div-container">
		<a href="<%=session.getAttribute("hostURL")%>/degree/addForm">
			<div class="div-container-item">
				<label class="lbl-content"><i class="fa fa-plus" aria-hidden="true"></i> Add Degree</label>			
			</div>
		</a>
		<a href="<%=session.getAttribute("hostURL")%>/degree/view?var=&value=">	
			<div class="div-container-item">
				<label class="lbl-content"><i class="fa fa-list" aria-hidden="true"></i> View Degree</label>			
			</div>
		</a>
		<a href="<%=session.getAttribute("hostURL")%>/degree/searchForm">
			<div class="div-container-item">
				<label class="lbl-content"><i class="fa fa-search" aria-hidden="true"></i> Search Degree</label>			
			</div>
		</a>	
	</div>

<jsp:include page="/layouts/footer.jsp" />