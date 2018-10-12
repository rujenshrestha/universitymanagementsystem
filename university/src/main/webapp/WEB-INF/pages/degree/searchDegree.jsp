<jsp:include page="/layouts/header.jsp" />

	<form action="" method="post">
		<label>Search by Degree ID:</label><br>
		<input type="text" name="degId" id="degId">
		<button id="btnSearchBydegId" type="button">Search</button>
	</form>
	<hr>
	
	<form action="" method="post">
		<label>Search by Degree Title:</label><br>
		<input type="text" name="degName" id="degName">
		<button id="btnSearchBydegName" type="button">Search</button>
	</form>
	<hr>
	
	<div class="container" id="result">
		<div class="table-responsive">
			<table class="table table-bordered table-striped">
				<tr>
					<th>Degree ID</th>
					<th>Degree Title</th>
					<th>Level</th>
					<th>Department</th>
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
		var name = document.getElementById("degName").value;
		getDegreeNameList(name);
	  });
	
	
	document.getElementById("btnSearchBydegId").addEventListener("click", function () {
		var degId = document.getElementById("degId").value;
		getDegreeResultRow("degId", degId);
		result.style.display="block";
		
	});
	
	document.getElementById("btnSearchBydegName").addEventListener("click", function () {
		var degName = document.getElementById("degName").value;
		getDegreeResultRow("degName", degName);
		result.style.display="block";
	});
	
</script>