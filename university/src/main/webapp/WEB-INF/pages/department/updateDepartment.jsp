<jsp:include page="/layouts/header.jsp" />

	<div class="div-form">
		<form action="edit" method="post">
			<label for="deptId">Department ID:</label>
			<input type="text" id="deptId" name="deptId" value="<%=request.getAttribute("deptId")%>" readonly><br>
			<label for="deptName">Department Name:</label>
			<input type="text" id="deptName" name="deptName" required><br>
			<button type="submit" >Update</button>
			<button type="button" id="cancel">Cancel</button>
		</form>
	</div>
	
<jsp:include page="/layouts/footer.jsp" />

<script>
	$(document).ready(function(){
		var deptId = document.getElementById("deptId").value;
		getEntityFieldValues("deptId",deptId,"department");
	});
	
	document.getElementById("cancel").addEventListener("click", function () {
		var hostURL = document.getElementById("hostURL").value;
		window.location.href = hostURL+"/department/view";
	});
</script>


