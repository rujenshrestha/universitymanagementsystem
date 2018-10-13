
function setCourseTableView(url){
	alert(url);
	$.getJSON(url, function(data){
		var row_data = '';
		$.each(data, function(key,value){
			var deleteURL='javascript:deleteEntityRecord(`course`,`crseId`,`'+value["crseId"]+'`)';
			row_data += '<tr>';
			row_data += '<td>'+value["crseId"]+'</td>';
			row_data += '<td>'+value["crseName"]+'</td>';
			row_data += '<td>'+value["levelDesc"]+'</td>';
			row_data += '<td>'+value["deptName"]+'</td>';
			row_data += '<td>'+value["degName"]+'</td>';
			row_data += '<td><a href="editForm?crseId='+value["crseId"]+'" ><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>&nbsp&nbsp'
			row_data += '<a href="'+deleteURL+'"><i class="fa fa-trash" aria-hidden="true"></i></a></td>'
			row_data += '</tr>';
		});
		if(row_data == ''){
			row_data += '<tr><td colspan="5" id="emptyRecord">No Records Found</td></tr>';
		}
		$('#tblViewCourse').append(row_data);
	});	
}

function setCourseFieldValues(value){
	var hostURL =  document.getElementById("hostURL").value;
	$.getJSON(hostURL+"/course/get?var=crseId&value="+value, function(data){
		
		document.getElementById("crseId").value = data["crseId"];
		document.getElementById("crseName").value = data["crseName"];
		var oldLevel= document.getElementById("level").options[0];
		oldLevel.value =   data["level"];
		oldLevel.text =  data["levelDesc"];
		var oldDept= document.getElementById("departmentList").options[0];
		oldDept.value =  data["deptId"];
		oldDept.text = data["deptName"];
		var oldDeg= document.getElementById("degreeList").options[0];
		oldDeg.value =  data["degId"];
		oldDeg.text = data["degName"];
	});	
}