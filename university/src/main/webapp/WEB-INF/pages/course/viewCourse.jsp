<jsp:include page="/layouts/header.jsp" />
	<% System.out.println("var:"+request.getParameter("var")+":var");
	if(!request.getParameter("var").toString().equals("")){%>
		<input type="hidden" id="url" value="<%=session.getAttribute("hostURL")+"/course/getBy?var="+request.getParameter("var")+"&value="+request.getParameter("value") %>">
	<%}else{%> 
		<input type="hidden" id="url" value="<%=session.getAttribute("hostURL")+"/course/getAll"%>">
	<%}%>	
	<div class="container">
		<div class="table-responsive">
			<table class="table table-bordered table-striped" id="tblViewCourse">
				<tr>
					<th>Course ID</th>
					<th>Course Title</th>
					<th>Level</th>
					<th>Degree</th>
					<th>Department</th>
					<th>Actions</th>
				</tr>
			</table>
		</div>
	</div>
<jsp:include page="/layouts/footer.jsp" />

<script>
	$(document).ready(function(){
		var url = document.getElementById("url").value;
		setCourseTableView(url);
	});
</script>
