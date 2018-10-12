<jsp:include page="/layouts/header.jsp" />

	<form action="" method="post">
		<label>UID:</label><br>
		<input type="text" name="uId" id="uId">
		<button id="btnSearchByUId" type="button">Search</button>
	</form>
	<hr>
	
	<div class="container" id="studentCourses">
	
	</div>

<jsp:include page="/layouts/footer.jsp" />

<script>
	var studentCourses = document.getElementById("studentCourses");
	
	$(document).ready(function() {
		studentCourses.style.display = "none";
	  });
	
	
	document.getElementById("btnSearchByUId").addEventListener("click", function () {
		var uId = document.getElementById("uId").value;
		getStudentResultRow("uId", uId);
		studentCourses.style.display="block";
		
	});
	
</script>