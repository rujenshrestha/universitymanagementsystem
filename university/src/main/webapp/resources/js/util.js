alert('Hello from util');

function getHostURL(){
	var url = window.location.href;
	var arr = url.split("/");
	var hostURL = arr[0] + "//" + arr[2]
	
	return hostURL;
}