/*
 *  #tblDepartmentList : Table ID for listing Department
 *  #departmentList: Select ID for listing Department Name and ID
*/

function setDepartmentTableView(){
	var hostURL =  document.getElementById("hostURL").value;
	$.getJSON(hostURL+"/department/getAll", function(data){
		var department_data = '';
		$.each(data, function(key,value){

			department_data += '<tr>';
			department_data += '<td>'+value["deptId"]+'</td>';
			department_data += '<td>'+value["deptName"]+'</td>';
			department_data += '<td><a href="'+hostURL+'/degree/view?var=deptId&value='+value["deptId"]+'"><i class="fa fa-graduation-cap" aria-hidden="true"></i> View Degrees </a></td>';
			department_data += '<td><a href="editForm?deptId='+value["deptId"]+'" ><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>&nbsp&nbsp'
			department_data += '<a href="javascript:deleteDepartment(`'+value["deptId"]+'`)"><i class="fa fa-trash" aria-hidden="true"></i></a></td>'
			department_data += '</tr>';
		});
		$('#tblViewDepartment').append(department_data);
	});	
}


function getDepartmentDropDownList(){

	var hostURL =  document.getElementById("hostURL").value;
	$.getJSON(hostURL+"/department/getAll", function(data){
		var department_data = '';
		$.each(data, function(key,value){

			department_data += '<option value='+value.deptId+'>'+value.deptName+'</option>';
		});
		$('#departmentList').append(department_data);
	});	

} 
