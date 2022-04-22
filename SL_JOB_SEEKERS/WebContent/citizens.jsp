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
	
	  <h2>Citizen Nic:</h2> 
		<input id="citizenNic" name="citizenNic" type="text" class="form-control form-control-sm"><br>
		<h2>Citizen name:</h2>
		<input id="citizenName" name="citizenName" type="text" class="form-control form-control-sm"><br>
		 <h2>Citizen age:</h2>
		<input id="citizenAge" name="citizenAge" type="text" class="form-control form-control-sm"><br> 
		
		<h2> Citizen address:</h2>
		<input id="citizenAddress" name="citizenAddress" type="text" class="form-control form-control-sm"><br>
		

		<h2>Citizen location:</h2>
		<input id="citizenLocation" name="citizenLocation" type="text" class="form-control form-control-sm"><br>
		<h2>Citizen profession:</h2>
		<input id="citizenProfession" name="citizenProfession" type="text" class="form-control form-control-sm"><br>
		<h2> Citizen email:</h2>
		<input id="citizenEmail" name="citizenEmail" type="text" class="form-control form-control-sm"><br> 
		
		 <h2>Citizen affliation:</h2>
		<input id="citizenAffliation" name="citizenAffliation" type="text" class="form-control form-control-sm"><br>
		 <h2>Citizen password:</h2>
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