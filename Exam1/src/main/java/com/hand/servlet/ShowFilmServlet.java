package com.hand.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.service.ShowFilmService;

public class ShowFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ShowFilmService sfs = new ShowFilmService();
	private ResultSet resultSet = null;
	
	
    public ShowFilmServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		resultSet = sfs.show();
		
		
		System.out.println(resultSet);
		
		RequestDispatcher rd = null;
		String re = null;
		try {
			 re = resultSet.getString("name");
		} catch (SQLException e) {
			System.out.println("1");
			e.printStackTrace();
			System.out.println("2");
		}
		
		request.setAttribute("resultSet",re);
		rd = request.getRequestDispatcher("/film/showFilm.jsp");
		rd.forward(request,response);
	}

}
