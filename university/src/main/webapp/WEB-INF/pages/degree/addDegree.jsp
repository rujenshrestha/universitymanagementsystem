<jsp:include page="/layouts/header.jsp" />
<div class="div-form">
	<form action="add" method="post">
		<label for="degId">Degree ID&nbsp;&nbsp;:</label>
		<input type="text" id="degId" name="degId" required><br>
		<label for="degName">Degree Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</label>
		<input type="text" id="degName" name="degName" required><br>
		<label for="level">Level&nbsp;&nbsp;:</label>
		<select name="level" required>
			<option value="S">-Specify-</option>
			<option value="G">Graduate</option>
			<option value="U">Undergraduate</option>
		</select><br>
		<label for="deptId">Department&nbsp;&nbsp;:</label>
		<select name="deptId" id="departmentList" required>
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
