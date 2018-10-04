<jsp:include page="/layouts/header.jsp" />

	<label id="root_path"></label>
	<div class="container">
		<div class="table-responsive">
			<table class="table table-bordered table-striped" id="tblDepartmentList">
				<tr>
					<th>Department ID</th>
					<th>Department Name</th>
					<th>View</th>
					<th>Actions</th>
				</tr>
			</table>
		</div>
	</div>
<jsp:include page="/layouts/footer.jsp" />

<script>
	$(document).ready(function(){
		getAllDepartment();
	});
</script>
