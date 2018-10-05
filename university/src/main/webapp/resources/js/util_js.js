
function getEntityFieldValues(vars, value, entityName){
	
	$.getJSON("http://localhost:8080/university/"+entityName+"/get?var="+vars+"&value="+value, function(data){
		Object.keys(data).forEach(function(key) {
			  console.log('Key : ' + key + ', Value : ' + data[key]);
			  if(key != "attr"){
				  document.getElementById(key).value = data[key];
			  }
		})
	});	
}