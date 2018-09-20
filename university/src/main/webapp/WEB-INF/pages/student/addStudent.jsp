<jsp:include page="/layouts/header.jsp" />

	<form action="add" method="post">
		<label for="uId">University ID:</label>
		<input type="text" id="uId" name="uId" required><br>
		<label for="firstName">First Name:</label>
		<input type="text" id="firstName" name="firstName" required><br>
		<label for="middleName">Middle Name:</label>
		<input type="text" id="middleName" name="middleName" required><br>
		<label for="lastName">Last Name:</label>
		<input type="text" id="lastName" name="lastName" required><br>
		<label for="gender">Gender:</label>
		<input type="text" id="gender" name="gender" required><br>
		<button type="submit" >Save</button>
		<button type="reset" >Reset</button>
	</form>
	
<jsp:include page="/layouts/footer.jsp" />