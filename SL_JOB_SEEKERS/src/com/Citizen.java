package com;

import java.sql.*;

public class Citizen
{ //A common method to connect to the DB
	
	private Connection connect()
	{
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			//Provide the correct details: DBServer/DBName, username, password
			con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nsbm", "root", "");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return con;

	}
	
	
public String insertCitizen(String nic,String name, String age, String address, String location,String profession,String email,String affliation,String password)
{
	String output = "";
	try
	{
		Connection con = connect();
		if (con == null)
		{
			return "Error while connecting to the database for inserting.";
		}
		
		// create a prepared statement
		
		String query = " insert into citizen(`citizenID`,`citizenNic`,`citizenName`,`citizenAge`,`citizenAddress`  ,`citizenLocation`,`citizenProfession`,`citizenEmail`,`citizenAffliation`,`citizenPassword`)"+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement preparedStmt = con.prepareStatement(query);
		
		// binding values
		preparedStmt.setInt(1, 0);
		preparedStmt.setString(2, nic);
		preparedStmt.setString(3, name);
		preparedStmt.setString(4, age);
		preparedStmt.setString(5, address);
		preparedStmt.setString(6, location);
		
		preparedStmt.setString(7, profession);
		preparedStmt.setString(8, email);
		preparedStmt.setString(9, affliation);
		preparedStmt.setString(10, password);
		// execute the statement

		preparedStmt.execute();
		
		con.close();
		
		String newCitizens = readCitizens();
		output = "{\"status\":\"success\", \"data\": \"" +
		        newCitizens + "\"}";
		
	}
	catch (Exception e)
	{
		output = "{\"status\":\"error\", \"data\": \"Error while inserting the citizen.\"}";
			System.err.println(e.getMessage());
	}
		
	return output;
}


public String readCitizens()
{
		String output = "";
		try
		{
				Connection con = connect();
				
			if (con == null)
			{
				return "Error while connecting to the database for reading.";
			}
			
			// Prepare the html table to be displayed

			
            output = "<table border='10' ><tr><th>Citizen Nic</th><th>Citizen Name</th>"
             +"<th>Citizen Age</th><th>Citizen Address</th>"
             + "<th>Citizen Location</th>"
             +"<th>Citizen Profession</th><th>Citizen Email</th>"
             + "<th>Citizen Affliation</th>"
             + "<th>Citizen Password</th>"
             + "<th>Update</th><th>Remove</th></tr>";
	
			String query = "select * from citizen";
			
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		
		// iterate through the rows in the result set
		
		while (rs.next())
		{
//			nic,name,  age,address,location,profession,email,affliation,password

			
			
			
		
			String citizenID = Integer.toString(rs.getInt("citizenID"));
			String citizenNic = rs.getString("citizenNic");
			String citizenName = rs.getString("citizenName");
			String citizenAge = rs.getString("citizenAge");
			String citizenAddress = rs.getString("citizenAddress");
			String citizenLocation = rs.getString("citizenLocation");
			String citizenProfession = rs.getString("citizenProfession");
			String citizenEmail = rs.getString("citizenEmail");
			String citizenAffliation = rs.getString("citizenAffliation");
			String citizenPassword = rs.getString("citizenPassword");
			
			// Add into the html table
			output += "<tr><td><input id='hidCitizenIDUpdate' name='hidCitizenIDUpdate' type='hidden' value='" + citizenID
			+ "'>" + citizenNic + "</td>";
			output += "<td>" + citizenName + "</td>";
			output += "<td>" + citizenAge + "</td>";
			output += "<td>" + citizenAddress + "</td>";
			output += "<td>" + citizenLocation + "</td>";
			output += "<td>" + citizenProfession + "</td>";
			output += "<td>" + citizenEmail + "</td>";
			output += "<td>" + citizenAffliation + "</td>";
			output += "<td>" + citizenPassword + "</td>";
              
      //buttons
            
            output += "<td><input name='btnUpdate' type='button' value='Update' class=' btnUpdate btn btn-secondary' data-citizenid='" + citizenID + "'></td>"
            		+ "<td><input name = 'btnRemove' type='button' value = 'Remove' "
            		+ "class = 'btnRemove btn btn-danger' data-citizenid='" + citizenID + "'>"
            		+"</td></tr>";
            		
		}
		
		con.close();
		
		// Complete the html table
		
		output += "</table>";
		}
		catch (Exception e)
		{
			output = "Error while reading the citizens.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}


	public String updateCitizen(String ID, String nic,String name, String age, String address, String location  ,String profession, String email, String affliation, String password)
	{
			String output = "";
			try
			{
					Connection con = connect();
					
					if (con == null)
					{
						return "Error while connecting to the database for updating.";
					}
					
					// create a prepared statement

					String query = "UPDATE citizen SET citizenNic=?,citizenName=?,citizenAge=?,citizenAddress=?,   citizenLocation=?,citizenProfession=?,citizenemail=?,citizenaffliation=?,,citizenpassword=?WHERE citizenID=?";
					
					PreparedStatement preparedStmt = con.prepareStatement(query);
					// binding values
					preparedStmt.setString(1, nic);
					preparedStmt.setString(2, name);
					preparedStmt.setString(3, age);
					preparedStmt.setString(4, address);
					preparedStmt.setString(5, location);
					preparedStmt.setString(6, profession);
					preparedStmt.setString(7, email);
					preparedStmt.setString(8, affliation);
					preparedStmt.setString(9, password);

					preparedStmt.setInt(10, Integer.parseInt(ID));
					// execute the statement
					preparedStmt.execute();
					
					con.close();
					
					String newCitizens = readCitizens();
					output = "{\"status\":\"success\", \"data\": \"" +
					newCitizens + "\"}";
			}
			catch (Exception e)
			{
				output = "{\"status\":\"error\", \"data\": \"Error while updating the citizen.\"}";
				System.err.println(e.getMessage());
			}
			return output;
	}
	
	
public String deleteCitizen(String citizenID)
{
	String output = "";
	try
	{
			Connection con = connect();
			if (con == null)
			{	
				return "Error while connecting to the database for deleting."; 
			}
			
			// create a prepared statement
			
			String query = "delete from citizen where citizenID=?";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			
			preparedStmt.setInt(1, Integer.parseInt(citizenID));
			// execute the statement
			preparedStmt.execute();
			
			con.close();
			
			String newCitizens = readCitizens();
			output = "{\"status\":\"success\", \"data\": \"" +
			newCitizens + "\"}";
	}
	catch (Exception e)
	{
		output = "{\"status\":\"error\", \"data\": \"Error while deleting the citizen.\"}";
		System.err.println(e.getMessage());
	}
	
	return output;
	}

}