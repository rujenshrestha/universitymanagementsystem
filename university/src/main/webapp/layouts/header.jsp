<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>UMS</title>
		<link rel="stylesheet" href="<c:url value="/resources/css/mystyle.css"></c:url>">
		<script src="<c:url value="/resources/js/util_js.js"></c:url>"></script>
		<script src="<c:url value="/resources/js/degree_js.js"></c:url>"></script>
		<script src="<c:url value="/resources/js/course_js.js"></c:url>"></script>
		<script src="<c:url value="/resources/js/student_js.js"></c:url>"></script>
		<script src="<c:url value="/resources/js/department_js.js"></c:url>"></script>
		<link href="https://fonts.googleapis.com/css?family=Cabin|Montserrat|Average+Sans|Bai+Jamjuree" rel="stylesheet">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
		<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  		 
        
		<meta></meta>
	</head>
	<body onload="hostURL">
		<div class="div-common-head">
			<div class="div-title">
				<div class="div-logo">
			        <a href="<%=session.getAttribute("hostURL") %>/home"><img class="img-logo" src="<c:url value="/resources/img/icons/logo.png"></c:url>" alt="No logo available"></a>
			 	</div>
		 	</div>
		 	<div class="div-menu">
		 		<jsp:include page="/layouts/menu.jsp" />
		 	</div>
		</div>
		<div class="div-main">
		<input type="hidden" id="hostURL" name="hostURL" value="<%=session.getAttribute("hostURL") %>">
	