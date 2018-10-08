<jsp:include page="/layouts/header.jsp" />

	<label id="root_path"></label>
	<div class="container">
		<div class="table-responsive">
			<table class="table table-bordered table-striped" id="tblStudentList">
				<tr>
					<th>UID</th>
					<th>First Name</th>
					<th>Middle Name</th>
					<th>Last Name</th>
					<th>Gender</th>
					<th>Actions</th>
				</tr>
			</table>
		</div>
	</div>
<jsp:include page="/layouts/footer.jsp" />

<script>
	$(document).ready(function(){
		getAllStudent();
	});
</script>
