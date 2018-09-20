<jsp:include page="/layouts/header.jsp" />

	<form action="edit" method="post">
		<label for="uId">University ID:</label>
		<input type="text" id="uId" name="uId" value="<%=request.getAttribute("uId")%>" required><br>
		<label for="firstName">First Name:</label>
		<input type="text" id="firstName" name="firstName" required><br>
		<label for="middleName">Middle Name:</label>
		<input type="text" id="middleName" name="middleName" required><br>
		<label for="lastName">Last Name:</label>
		<input type="text" id="lastName" name="lastName" required><br>
		<label for="gender">Gender:</label>
		<input type="text" id="gender" name="gender" required><br>
		<button type="submit" >Update</button>
		<button type="button" id="cancel">Cancel</button>
	</form>
	
<jsp:include page="/layouts/footer.jsp" />

<script>
	$(document).ready(function(){
		var uId = document.getElementById("uId").value;
		getStudentInputField("uId",uId);
	});
	
	document.getElementById("cancel").addEventListener("click", function () {
		window.location.href = "http://localhost:8080/university/student/view";
	});
</script>


