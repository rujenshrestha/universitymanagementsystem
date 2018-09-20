<jsp:include page="/layouts/header.jsp" />

	<form action="" method="post">
		<label>Search by UID:</label><br>
		<input type="text" name="uId" id="uId">
		<button id="btnSearchByUId" type="button">Search</button>
	</form>
	<hr>
	
	<form action="" method="post">
		<label>Search by Name:</label><br>
		<input type="text" name="name" id="studentName">
		<button id="btnSearchByName" type="button">Search</button>
	</form>
	<hr>
	
	<div class="container" id="result">
		<div class="table-responsive">
			<table class="table table-bordered table-striped">
				<tr>
					<th>UID</th>
					<th>First Name</th>
					<th>Middle Name</th>
					<th>Last Name</th>
					<th>Gender</th>
					<th>Actions</th>
				</tr>
				<tr id="resultRow">
				</tr>
			</table>
		</div>
	</div>

<jsp:include page="/layouts/footer.jsp" />

<script>
	var result = document.getElementById("result");
	
	$(document).ready(function() {
		result.style.display = "none";
		var name = document.getElementById("studentName").value;
		
		getStudentNameList(name);
	  });
	
	
	document.getElementById("btnSearchByUId").addEventListener("click", function () {
		var uId = document.getElementById("uId").value;
		getStudentResultRow("uId", uId);
		result.style.display="block";
		
	});
	
	document.getElementById("btnSearchByName").addEventListener("click", function () {
		var name = document.getElementById("studentName").value;
		getStudentResultRow("concat(firstName,' ',middleName,' ',lastName)", name);
		result.style.display="block";
	});
	
</script>