package com.hand.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.entity.Film;
import com.hand.service.AddLanguageService;

/**
 * Servlet implementation class AddFilmServlet
 */
public class AddFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AddLanguageService als = new AddLanguageService();
	private Film film = new Film();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFilmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		String forward = null;
		
		short i =1;
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		System.out.println(title);
		System.out.println(description);
		
		film.setTitle(title);
		film.setDescription(description);
		
		
		String skills = "";
		String[] skillArr = request.getParameterValues("languages");
		if(skillArr != null && skillArr.length >0){
			for(String skill : skillArr){
				System.out.println(skill);
				skills = skills + skill + " ";
				if(skill.equals("English")){i = 1;
				}else if(skill.equals("French")){ i=2;			
				}else if(skill.equals("German")){i=3;
				}else if(skill.equals("Italian")){i=4;
				}else if(skill.equals("Japanese")){i=5;
				}else if(skill.equals("Mandarin")){i=6;}
				break;
			}
		}

		film.setLanguage_id(i);
		
		boolean bool = als.SaveLanguages(film);
		if(bool){
			forward = "/film/addFilm.jsp";
		}else{
			forward = "/index.jsp";
		}
		
		
//		request.setAttribute("languageSet", rs);
		rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
		
	}

}
