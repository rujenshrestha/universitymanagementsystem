<jsp:include page="/layouts/header.jsp" />
<div class="div-form">
	<form action="add" method="post">
		<label for="deptId">Department ID&nbsp;&nbsp;:</label>
		<input type="text" id="deptId" name="deptId" required><br>
		<label for="deptName">Department Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</label>
		<input type="text" id="deptName" name="deptName" required><br>
		<button type="submit" >Save</button>
		<button type="reset" >Reset</button>
	</form>
</div>	
<jsp:include page="/layouts/footer.jsp" />