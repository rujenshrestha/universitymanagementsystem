<jsp:include page="/layouts/header.jsp" />
	<div class="div-form">
		<form action="edit" method="post">
			<label for="crseId">Course ID:</label>
			<input type="text" id="crseId" name="crseId" value="<%=request.getAttribute("crseId")%>" readonly><br>
			<label for="crseName">Course Title:</label>
			<input type="text" id="crseName" name="crseName" required><br>
			<label for="level">Level&nbsp;&nbsp;:</label>
			<select name="level" id="level" required>
				<option value="">--Specify--</option>
				<option value="G">Graduate</option>
				<option value="U">Undergraduate</option>
			</select><br>
			<label for="deptId">Department&nbsp;&nbsp;:</label>
			<select name="deptId" id="departmentList" required onchange="getDegreeDropDownList()">
				<option value="S">-Specify-</option>
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
		var crseId = document.getElementById("crseId").value;
		setCourseFieldValues(crseId);
		getDepartmentDropDownList();
	});
	
	document.getElementById("cancel").addEventListener("click", function () {
		var hostURL = document.getElementById("hostURL").value;
		window.location.href = hostURL+"/course/view?var=&value=";
	});
</script>


