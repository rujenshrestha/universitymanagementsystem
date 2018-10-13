<jsp:include page="/layouts/header.jsp" />
<div class="div-form">
	<form action="add" method="post">
		<label for="crseId">Course ID&nbsp;&nbsp;:</label>
		<input type="text" id="crseId" name="crseId" required><br>
		<label for="crseName">Course Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</label>
		<input type="text" id="crseName" name="crseName" required><br>
		<label for="level">Level&nbsp;&nbsp;:</label>
		<select name="level" required>
			<option value="S">-Specify-</option>
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
		<button type="submit" >Save</button>
		<button type="reset" >Reset</button>
	</form>
</div>	
<jsp:include page="/layouts/footer.jsp" />

<script>
	$(document).ready(function(){
		getDepartmentDropDownList();
	});
</script>