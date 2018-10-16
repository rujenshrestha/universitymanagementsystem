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
			<select name="gender" id="gender" required>
				<option value="S">-Specify-</option>
				<option value="M">Male</option>
				<option value="F">Female</option>
				<option value="U">I do not wish to disclose</option>
			</select><br>
			<label for="deptId">Department&nbsp;&nbsp;:</label>
			<select name="deptId" id="departmentList" required onchange="setDegreeBlank()">
				<option value="S">-Specify-</option>
			</select><br>
			<label for="level">Level&nbsp;&nbsp;:</label>
			<select name="level" id="level" required onchange="getDegreeDropDownList()">
				<option value="S">-Specify-</option>
				<option value="G">Graduate</option>
				<option value="U">Undergraduate</option>
			</select><br>
			<label for="degId">Degree&nbsp;&nbsp;:</label>
			<select name="degId" id="degreeList" required>
				<option value="S">-Specify-</option>
			</select><br>
			<button type="submit" >Update</button>
			<button type="button" id="cancel">Cancel</button>
		</form>
	</div>
	
<jsp:include page="/layouts/footer.jsp" />

<script>
	$(document).ready(function(){
		var uId = document.getElementById("uId").value;
		setStudentFieldValues(uId);
		getDepartmentDropDownList();
	});
	
	document.getElementById("cancel").addEventListener("click", function () {
		var hostURL = document.getElementById("hostURL").value;
		window.location.href = hostURL+"/student/view";
	});
</script>


