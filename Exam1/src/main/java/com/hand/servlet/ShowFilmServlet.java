package com.hand.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.service.ShowFilmService;

public class ShowFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ShowFilmService sfs = new ShowFilmService();
	
    public ShowFilmServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultSet resultSet = sfs.show();
		
		RequestDispatcher rd = null;
		
		String re = resultSet.getString("");
		
		request.setAttribute("resultSet", resultSet);
		rd = request.getRequestDispatcher("/film/showFilm.jsp");
		rd.forward(request,response);
	}

}
