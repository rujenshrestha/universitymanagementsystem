<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layouts/header.jsp" />
	<div class="div-container">
		<a href="<%=session.getAttribute("hostURL")%>/course/addForm">
			<div class="div-container-item">
				<label class="lbl-content"><i class="fa fa-plus" aria-hidden="true"></i> Add Course</label>			
			</div>
		</a>
		<a href="<%=session.getAttribute("hostURL")%>/course/view?var=&value=">
			<div class="div-container-item">
				<label class="lbl-content"><i class="fa fa-list" aria-hidden="true"></i> View Course</label>			
			</div>
		</a>
		<a href="<%=session.getAttribute("hostURL")%>/course/searchForm">
			<div class="div-container-item">
				<label class="lbl-content"><i class="fa fa-search" aria-hidden="true"></i> Search Course</label>			
			</div>
		</a>	
	</div>

<jsp:include page="/layouts/footer.jsp" />