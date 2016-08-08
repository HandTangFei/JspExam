package com.hand.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.dao.LanguageDao;
import com.hand.dao.impl.LanguageDaoImpl;
import com.hand.service.GetLanguageService;
public class GetLanguageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LanguageDao ld = new LanguageDaoImpl();
	
	private Set<String> rs = new TreeSet<String>() ;
	
    public GetLanguageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		String forward = null;
		GetLanguageService gls = new GetLanguageService();
		
		rs = gls.GetLanguages();
		
//		try {
//			Connection conn = ConnectionFactory.getInstance().makeConnection();
//			conn.setAutoCommit(false);
//			rs =  ld.get(conn);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
			
		Iterator<String> iterator = rs.iterator(); 
		try {
			while(iterator.hasNext()){
//				System.out.println(rs.getString("name"));
				System.out.println(iterator.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		forward = "/film/addFilm.jsp";
		
		request.setAttribute("languageSet", rs);
		rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
		
		
	
	}

}
