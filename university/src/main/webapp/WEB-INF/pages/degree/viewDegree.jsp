<jsp:include page="/layouts/header.jsp" />
	<div class="container">
	<% System.out.println("var:"+request.getParameter("var")+":var");
	if(!request.getParameter("var").toString().equals("")){%>
		<input type="hidden" id="url" value="<%=session.getAttribute("hostURL")+"/degree/getBy?var="+request.getParameter("var")+"&value="+request.getParameter("value") %>">
	<%}else{%> 
		<input type="hidden" id="url" value="<%=session.getAttribute("hostURL")+"/degree/getAll"%>">
	<%}%>	
		<div class="table-responsive">
			<table class="table table-bordered table-striped" id="tblViewDegree">
				<tr>
					<th>Degree ID</th>
					<th>Degree Title</th>
					<th>Level</th>
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
		setDegreeTableView(url);
	});
</script>
