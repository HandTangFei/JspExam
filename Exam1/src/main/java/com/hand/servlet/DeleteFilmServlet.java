package com.hand.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.entity.Film;
import com.hand.service.CheckDeleteFilmService;

/**
 * Servlet implementation class DeleteFilmServlet
 */
public class DeleteFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CheckDeleteFilmService  cdfs= new CheckDeleteFilmService();

	public DeleteFilmServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int film_id = Integer.parseInt(request.getParameter("id"));
		System.out.println(film_id);

		Film film = new Film();
		film.setFilm_id(film_id);

		RequestDispatcher rd = null;
		String forward = null;

		boolean bool = cdfs.check(film);

		if(bool){
			request.setAttribute("msg", "删除成功！");
			
		}else{
			request.setAttribute("msg", "删除失败！");
		}
		forward = "/film/showFilm.jsp";
		rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

}
