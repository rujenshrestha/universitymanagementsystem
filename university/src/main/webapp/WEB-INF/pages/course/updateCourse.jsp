<jsp:include page="/layouts/header.jsp" />
	<div class="div-form">
		<form action="edit" method="post">
			<label for="uId">University ID:</label>
			<input type="text" id="uId" name="uId" value="<%=request.getAttribute("uId")%>" readonly><br>
			<label for="firstName">First Name:</label>
			<input type="text" id="firstName" name="firstName" required><br>
			<label for="middleName">Middle Name:</label>
			<input type="text" id="middleName" name="middleName"><br>
			<label for="lastName">Last Name:</label>
			<input type="text" id="lastName" name="lastName" required><br>
			<label for="gender">Gender:</label>
			<select name="gender" required>
				<option value="S">-Specify-</option>
				<option value="M">Male</option>
				<option value="F">Female</option>
				<option value="U">I do not wish to disclose</option>
			</select><br>
			<button type="submit" >Update</button>
			<button type="button" id="cancel">Cancel</button>
		</form>
	</div>
	
<jsp:include page="/layouts/footer.jsp" />

<script>
	$(document).ready(function(){
		var uId = document.getElementById("uId").value;
		getEntityFieldValues("uId",uId,"student");
	});
	
	document.getElementById("cancel").addEventListener("click", function () {
		var hostURL = document.getElementById("hostURL").value;
		window.location.href = hostURL+"/student/view";
	});
</script>


