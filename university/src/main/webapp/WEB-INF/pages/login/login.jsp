<jsp:include page="/layouts/loginHeader.jsp" />
	<h4><%=session.getAttribute("msg")%></h4>
	<div class="div-form">
		<form action="http://localhost:8080/university/login/signin" method="get">
			<label>Username : </label>
			<input type="text" name="username" placeholder="Username" required><br>
			<label>Password : </label>
			<input type="password" name="password" placeholder="password" required><br>
			<button type="submit" value="submit">Log In</button>
		</form>
	</div>

<jsp:include page="/layouts/footer.jsp" />