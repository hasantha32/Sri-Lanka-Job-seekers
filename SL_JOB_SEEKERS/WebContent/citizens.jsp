<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@page import = "com.Citizen" %>
      
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Citizen handling</title>


<link rel = "stylesheet" href = "Views/bootstrap.min.css">
<script src = "Components/jquery-3.6.0.min.js"></script>
<script src = "Components/citizens.js"></script>



</head>
<body>

<div class = "container"> 
	<div class="row">
		<div class="col">

		<h1>Citizens Management</h1>
		
	<form id="formCitizen" name="formCitizen"  >
	
	
	  <h4>Citizen Nic:</h4> 
		<input id="citizenNic" name="citizenNic" type="text" class="form-control form-control-sm"><br>
		<h4>Citizen name:</h4>
		<input id="citizenName" name="citizenName" type="text" class="form-control form-control-sm"><br>
		 <h4>Citizen age:</h4>
		<input id="citizenAge" name="citizenAge" type="text" class="form-control form-control-sm"><br> 
		
		<h4> Citizen address:</h4>
		<input id="citizenAddress" name="citizenAddress" type="text" class="form-control form-control-sm"><br>
		

		<h4>Citizen location:</h4>
		<input id="citizenLocation" name="citizenLocation" type="text" class="form-control form-control-sm"><br>
		<h4>Citizen profession:</h4>
		<input id="citizenProfession" name="citizenProfession" type="text" class="form-control form-control-sm"><br>
		<h4> Citizen email:</h4>
		<input id="citizenEmail" name="citizenEmail" type="text" class="form-control form-control-sm"><br> 
		
		 <h4>Citizen affliation:</h4>
		<input id="citizenAffliation" name="citizenAffliation" type="text" class="form-control form-control-sm"><br>
		 <h4>Citizen password:</h4>
		<input id="citizenPassword" name="citizenPassword" type="text" class="form-control form-control-sm"><br>
		
		<input id="btnSave" name="btnSave" type="button" value="Register" class="btn btn-primary">
		<input type="hidden" id="hidCitizenIDSave" name="hidCitizenIDSave" value="">
	</form>
    
    <div id="alertSuccess" class="alert alert-success"></div>
     <div id="alertError" class="alert alert-danger"></div>
    
    <br>
	<div id="divCitizensGrid">
	<%
	Citizen citizenObj = new Citizen();
		out.print(citizenObj.readCitizens());
	%>
	</div>

<br>


</div>
</div>
</div>


</body>
</html>