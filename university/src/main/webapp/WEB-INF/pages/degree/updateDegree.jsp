<jsp:include page="/layouts/header.jsp" />
	<div class="div-form">
		<form action="edit" method="post">
			<label for="degId">Degree ID:</label>
			<input type="text" id="degId" name="degId" value="<%=request.getAttribute("degId")%>" readonly><br>
			<label for="degName">Degree Title:</label>
			<input type="text" id="degName" name="degName" required><br>
			<label for="level">Level&nbsp;&nbsp;:</label>
			<select name="level" id="level" required>
				<option value="">--Specify--</option>
				<option value="G">Graduate</option>
				<option value="U">Undergraduate</option>
			</select><br>
			<label for="deptId">Department&nbsp;&nbsp;:</label>
			<select name="deptId" id="departmentList" required>
				<option value="">--Specify--</option>
			</select><br>
			<button type="submit" >Update</button>
			<button type="button" id="cancel">Cancel</button>
		</form>
	</div>
	
<jsp:include page="/layouts/footer.jsp" />

<script>
	$(document).ready(function(){
		var degId = document.getElementById("degId").value;
		setDegreeFieldValues(degId);
		getDepartmentDropDownList();
				
	});
	
	document.getElementById("cancel").addEventListener("click", function () {
		var hostURL = document.getElementById("hostURL").value;
		window.location.href = hostURL+"/degree/view";
	});
</script>


