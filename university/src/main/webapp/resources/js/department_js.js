/*
 *  #tblDepartmentList : Table ID for listing Department
 *  #departmentList: Select ID for listing Department Name and ID
*/

function getAllDepartment(){
	var hostURL =  document.getElementById("hostURL").value;
	$.getJSON(hostURL+"/department/getAll", function(data){
		var department_data = '';
		$.each(data, function(key,value){

			department_data += '<tr>';
			department_data += '<td>'+value.deptId+'</td>';
			department_data += '<td>'+value.deptName+'</td>';
			department_data += '<td><a href="#">View Courses</a>';
			department_data += '<a href="#">View Faculty</a></td>';
			department_data += '<td><a href="editForm?deptId='+value.deptId+'" ><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>&nbsp&nbsp'
			department_data += '<a href="javascript:deleteDepartment(`'+value.deptId+'`)"><i class="fa fa-trash" aria-hidden="true"></i></a></td>'
			department_data += '</tr>';
		});
		$('#tblDepartmentList').append(department_data);
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
