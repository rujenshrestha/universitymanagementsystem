
function setDegreeTableView(url){
	var hostURL =  document.getElementById("hostURL").value;
	$.getJSON(url, function(data){
		var row_data = '';
		$.each(data, function(key,value){
			var viewCourse = hostURL+'/course/view?var=degId&value='+value["degId"];
			var deleteURL='javascript:deleteEntityRecord(`degree`,`degId`,`'+value["degId"]+'`)';
			row_data += '<tr>';
			row_data += '<td>'+value["degId"]+'</td>';
			row_data += '<td>'+value["degName"]+'</td>';
			row_data += '<td>'+value["levelDesc"]+'</td>';
			row_data += '<td>'+value["deptName"]+'</td>';
			row_data += '<td><a href="'+viewCourse+'"><i class="fa fa-book" aria-hidden="true"></i> View Courses</a></td>';
			row_data += '<td><a href="editForm?degId='+value["degId"]+'" ><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>&nbsp&nbsp'
			row_data += '<a href="'+deleteURL+'"><i class="fa fa-trash" aria-hidden="true"></i></a></td>'
			row_data += '</tr>';
		});
		if(row_data == ''){
			row_data += '<tr><td colspan="5" id="emptyRecord">No Records Found</td></tr>';
		}
		$('#tblViewDegree').append(row_data);
	});	
}

function setDegreeFieldValues(value){
	var hostURL =  document.getElementById("hostURL").value;
	$.getJSON(hostURL+"/degree/get?var=degId&value="+value, function(data){
		
		document.getElementById("degId").value = data["degId"];
		document.getElementById("degName").value = data["degName"];
		var oldLevel= document.getElementById("level").options[0];
		oldLevel.value =   data["level"];
		oldLevel.text =  data["levelDesc"];
		var oldDept= document.getElementById("departmentList").options[0];
		oldDept.value =  data["deptId"];
		oldDept.text = data["deptName"];
	});	
}

function getDegreeNameList(name){
	var hostURL =  document.getElementById("hostURL").value;
	var degreeList = [];
	$.getJSON(hostURL+"/degree/suggest?name="+ name, function(data){
		
		$.each(data, function(index,value){
			degreeList.push(value);
		});

	});	
	$("#degName").autocomplete({
		source : degreeList
	});
}

function getDegreeResultRow(key, value){
	var hostURL =  document.getElementById("hostURL").value;
	$.getJSON(hostURL+"/degree/get?var="+key+"&value="+value, function(data){
		var row_data = '';

		row_data += '<td>'+data["degId"]+'</td>';
		row_data += '<td>'+data["degName"]+'</td>';
		row_data += '<td>'+data["levelDesc"]+'</td>';
		row_data += '<td><a href="'+data["deptId"]+'">'+data["deptName"]+'</a></td>';
		row_data += '<td><a href="editForm?degId='+data["degId"]+'" ><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>&nbsp&nbsp'
		row_data += '<a href="javascript:deleteStudent(`'+data["degId"]+'`)"><i class="fa fa-trash" aria-hidden="true"></i></a></td>'
		$('#resultRow').html(row_data);
	});	
}

function getDegreeDropDownList(){
	var deptId= document.getElementById("departmentList").value;
	var hostURL =  document.getElementById("hostURL").value;
	$.getJSON(hostURL+"/degree/getBy?var=deptId&value="+deptId, function(data){
		var option_data = '';
		$.each(data, function(key,value){

			option_data += '<option value='+value.degId+'>'+value.degName+'</option>';
		});
		if(option_data == ''){
			option_data += '<option value="N">No Degree Found</option>';
		}
		$('#degreeList').html(option_data);
	});	

} 