<jsp:include page="/layouts/header.jsp" />
<div class="div-form">
	<form action="add" method="post">
		<label for="uId">University ID&nbsp;&nbsp;:</label>
		<input type="text" id="uId" name="uId" required><br>
		<label for="firstName">First Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</label>
		<input type="text" id="firstName" name="firstName" required><br>
		<label for="middleName">Middle Name&nbsp;&nbsp;:</label>
		<input type="text" id="middleName" name="middleName" required><br>
		<label for="lastName">Last Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</label>
		<input type="text" id="lastName" name="lastName" required><br>
		<label for="gender">Gender&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</label>
		<select name="gender" required>
			<option value="S">-Specify-</option>
			<option value="M">Male</option>
			<option value="F">Female</option>
			<option value="U">I do not wish to disclose</option>
		</select><br>
		<button type="submit" >Save</button>
		<button type="reset" >Reset</button>
	</form>
</div>	
<jsp:include page="/layouts/footer.jsp" />