
function setEntityFieldValues(varId, value, entityName){
	
	$.getJSON("http://localhost:8080/university/"+entityName+"/get?var="+varId+"&value="+value, function(data){
		Object.keys(data).forEach(function(key) {
			  console.log('Key : ' + key + ', Value : ' + data[key]);
			  if(key != "attr"){
				  document.getElementById(key).value = data[key];
			  }
		})
	});	
}

function deleteEntityRecord(entityName, varId, value){
	var hostURL =  document.getElementById("hostURL").value;
	if (confirm("Do you want to delete "+entityName+" record " + value + "?")) {
		window.location.href = hostURL+"/"+entityName+"/delete?"+varId+"="+value;
	}
}