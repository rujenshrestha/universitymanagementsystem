<jsp:include page="/layouts/header.jsp" />

	<label id="root_path"></label>
	<div class="container">
		<div class="table-responsive">
			<table class="table table-bordered table-striped" id="tblViewStudent">
				<tr>
					<th>UID</th>
					<th>Name</th>
					<th>Degree</th>
					<th>Actions</th>
				</tr>
			</table>
		</div>
	</div>
<jsp:include page="/layouts/footer.jsp" />

<script>
	$(document).ready(function(){
		setStudentTableView();
	});
</script>
