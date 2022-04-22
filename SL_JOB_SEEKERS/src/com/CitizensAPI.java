package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Servlet implementation class CitizensAPI
 */
@WebServlet("/CitizensAPI")
public class CitizensAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  Citizen citizenObj = new Citizen();
  
    public CitizensAPI() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String output = citizenObj.insertCitizen(request.getParameter("citizenNic"),
				request.getParameter("citizenName"),
				request.getParameter("citizenAge"),
				request.getParameter("citizenAddress"),
		request.getParameter("citizenLocation"),
		request.getParameter("citizenProfession"),
		request.getParameter("citizenEmail"),
		request.getParameter("citizenAffliation"),
		request.getParameter("citizenPassword"));
	
		
				response.getWriter().write(output);
	}

	private static Map getParasMap(HttpServletRequest request)
	{
		Map<String, String> map = new HashMap<String, String>();
		
		try
		{
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			
			String queryString = scanner.hasNext() ?
			scanner.useDelimiter("\\A").next() : "";
			
			scanner.close();
			
			String[] params = queryString.split("&");
			
			for (String param : params)
			{
				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
		}
		catch (Exception e)
		{
		}
			return map;
		}
	
	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map paras = getParasMap(request);
	
		String output = citizenObj.updateCitizen(paras.get("hidCitizenIDSave").toString(),
				paras.get("citizenNic").toString(),

		paras.get("citizenName").toString(),
		paras.get("citizenAge").toString(),
		paras.get("citizenAddress").toString(),

		paras.get("citizenLocation").toString(),
		paras.get("citizenProfession").toString(),
		paras.get("citizenEmail").toString(),
		paras.get("citizenAffliation").toString(),

		paras.get("citizenPassword").toString());
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map paras = getParasMap(request);
		
		String output = citizenObj.deleteCitizen(paras.get("citizenID").toString());
		
		response.getWriter().write(output);
	}

}
