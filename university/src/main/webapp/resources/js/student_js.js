/* #resultRow : Table Row<tr> ID for showing student result
 * #studentName : Input field <input> ID for suggesting student names
 * #"tblView" : Table ID for listing students
*/

function getStudentResultRow(key, value){
		
		$.getJSON("http://localhost:8080/university/student/get?var="+key+"&value="+value, function(data){
			var student_data = '';

			student_data += '<td>'+data.uId+'</td>';
			student_data += '<td>'+data.firstName+'</td>';
			student_data += '<td>'+data.middleName+'</td>';
			student_data += '<td>'+data.lastName+'</td>';
			student_data += '<td>'+data.gender+'</td>';
			student_data += '<td><a href="editForm?uId='+data.uId+'" ><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>&nbsp&nbsp'
			student_data += '<a href="javascript:deleteStudent(`'+data.uId+'`)"><i class="fa fa-trash" aria-hidden="true"></i></a></td>'
			$('#resultRow').html(student_data);
		});	
	}


function getStudentInputField(key, value){
	
	$.getJSON("http://localhost:8080/university/student/get?var="+key+"&value="+value, function(data){
		document.getElementById("firstName").value = data.firstName;
		document.getElementById("middleName").value = data.middleName;
		document.getElementById("lastName").value = data.lastName;
		document.getElementById("gender").value = data.gender;
	});	
}

	
function getStudentNameList(name){
	var studentList = [];
	$.getJSON("http://localhost:8080/university/student/suggest?name="+ name, function(data){
		
		$.each(data, function(index,value){
			studentList.push(value);
		});

	});	
	$("#studentName").autocomplete({
		source : studentList
	});
}

function setStudentTableView(){
	var hostURL =  document.getElementById("hostURL").value;
	$.getJSON(hostURL+"/student/getAll", function(data){
		var student_data = '';
		$.each(data, function(key,value){
			
				student_data += '<tr>';
				student_data += '<td>'+value["uId"]+'</td>';
				student_data += '<td>'+value["firstName"]+value["middleName"]+value["lastName"]+'</td>';
				student_data += '<td>'+value["degName"]+'</td>';
				student_data += '<td><a href="editForm?uId='+value["uId"]+'" ><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>&nbsp&nbsp'
				student_data += '<a href="javascript:deleteStudent(`'+value["uId"]+'`)"><i class="fa fa-trash" aria-hidden="true"></i></a></td>'
				student_data += '</tr>';
		});
		$('#tblViewStudent').append(student_data);
	});	
}

function getStudentCourses(uId){
	var hostURL =  document.getElementById("hostURL").value;
	$.getJSON(hostURL+"/student/courses", function(data){
		var student_data = '';
		$.each(data, function(key,value){

			student_data += '<tr>';
			student_data += '<td>'+value.uId+'</td>';
			student_data += '<td>'+value.firstName+'</td>';
			student_data += '<td>'+value.middleName+'</td>';
			student_data += '<td>'+value.lastName+'</td>';
			student_data += '<td>'+value.gender+'</td>';
			student_data += '<td><a href="editForm?uId='+value.uId+'" ><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>&nbsp&nbsp'
			student_data += '<a href="javascript:deleteStudent(`'+value.uId+'`)"><i class="fa fa-trash" aria-hidden="true"></i></a></td>'
			student_data += '</tr>';
		});
		$('#tblStudentList').append(student_data);
	});	

}


function deleteStudent(uId){
	if (confirm("Do you want to delete student record " + uId + "?")) {
		window.location.href = "http://localhost:8080/university/student/delete?uId="+uId;
	}
}