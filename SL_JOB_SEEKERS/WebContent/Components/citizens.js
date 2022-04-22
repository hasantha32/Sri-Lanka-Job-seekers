$(document).ready(function()
{
	if ($("#alertSuccess").text().trim() == "")
	{
	$("#alertSuccess").hide();
	}
	$("#alertError").hide();
});

//SAVE
$(document).on("click", "#btnSave", function(event)
	{
	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();
	
	// Form validation-------------------
	var status = validateCitizenForm();
	if (status != true)
	{
	$("#alertError").text(status);
	$("#alertError").show();
	return;
	}
	
	// If valid------------------------
	var type = ($("#hidCitizenIDSave").val() == "") ? "POST" : "PUT";
	$.ajax(
	{
	url : "CitizensAPI",
	type : type,
	data : $("#formCitizen").serialize(),
	dataType : "text",
	complete : function(response, status)
	{
	onCitizenSaveComplete(response.responseText, status);
	}
	});
});


function onCitizenSaveComplete(response, status)
{
	if (status == "success")
	{
	var resultSet = JSON.parse(response);
	if (resultSet.status.trim() == "success")
	{
	$("#alertSuccess").text("Successfully saved.");
	$("#alertSuccess").show();
	$("#divCitizensGrid").html(resultSet.data);
	} else if (resultSet.status.trim() == "error")
	{
	$("#alertError").text(resultSet.data);
	$("#alertError").show();
	}
	} else if (status == "error")
	{
	$("#alertError").text("Error while saving.");
	$("#alertError").show();
	} else
	{
	$("#alertError").text("Unknown error while saving..");
	$("#alertError").show();
	}
	$("#hidCitizenIDSave").val("");
	$("#formCitizen")[0].reset();
}


$(document).on("click", ".btnUpdate", function(event)
{

	
	
	$("#hidCitizenIDSave").val($(this).data("citizenid"));
		$("#citizenNic").val($(this).closest("tr").find('td:eq(0)').text());
	$("#citizenName").val($(this).closest("tr").find('td:eq(1)').text());
	$("#citizenAge").val($(this).closest("tr").find('td:eq(2)').text());
	$("#citizenAddress").val($(this).closest("tr").find('td:eq(3)').text());
	
		$("#citizenLocation").val($(this).closest("tr").find('td:eq(4)').text());
	$("#citizenProfession").val($(this).closest("tr").find('td:eq(5)').text());
	$("#citizenEmail").val($(this).closest("tr").find('td:eq(6)').text());
	$("#citizenAffliation").val($(this).closest("tr").find('td:eq(7)').text());
	$("#citizenPassword").val($(this).closest("tr").find('td:eq(8)').text());
})


$(document).on("click", ".btnRemove", function(event)
{
	$.ajax(
	{
	url : "CitizensAPI",
	type : "DELETE",
	data : "citizenID=" + $(this).data("citizenid"),
	dataType : "text",
	complete : function(response, status)
	{
	onCitizenDeleteComplete(response.responseText, status);
	}
	});
})


function onCitizenDeleteComplete(response, status)
{
	if (status == "success")
	{
	var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success")
		{
		$("#alertSuccess").text("Successfully deleted.");
		$("#alertSuccess").show();
		$("#divCitizensGrid").html(resultSet.data);
		} 
		else if (resultSet.status.trim() == "error")
		{
		$("#alertError").text(resultSet.data);
		$("#alertError").show();
		}
	} 
	else if (status == "error")
	{
	$("#alertError").text("Error while deleting.");
	$("#alertError").show();
	} 
	else
	{
	$("#alertError").text("Unknown error while deleting..");
	$("#alertError").show();
	}
}





// CLIENT-MODEL================================================================
function validateCitizenForm()
{


// Nic
	if ($("#citizenNic").val().trim() == "")
	{
	return "Insert Citizen Nic.";
	}
// Name
	if ($("#citizenName").val().trim() == "")
	{
	return "Insert Citizen Name.";
	}
//Age
	if ($("#citizenAge").val().trim() == "")
	{
	return "Insert Citizen Age.";
}









// Address------------------------
if ($("#citizenAddress").val().trim() == "")
{
return "Insert Citizen Address.";
}

// Location
	if ($("#citizenLocation").val().trim() == "")
	{
	return "Insert Citizen Location.";
	}
// Name
	if ($("#citizenProfession").val().trim() == "")
	{
	return "Insert Citizen Profession.";
	}
//Age
	if ($("#citizenEmail").val().trim() == "")
	{
	return "Insert Citizen Email.";
}
//Affliation
	if ($("#citizenAffliation").val().trim() == "")
	{
	return "Insert Citizen Affliation.";
	}
//Password
	if ($("#citizenPassword").val().trim() == "")
	{
	return "Insert Citizen Password.";
}


	
	
return true;
}