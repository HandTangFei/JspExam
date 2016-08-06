package com.hand.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.entity.Customer;
import com.hand.service.CheckCustomerService;

public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CheckCustomerService cku = new CheckCustomerService();   
	
    public CheckServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		RequestDispatcher rd = null;
		String forward = null;
		
		if(userName == null){
			request.setAttribute("msg", "用户名为空！");
			rd = request.getRequestDispatcher("/login/error.jsp");
			rd.forward(request,response);
		}else{
			Customer customer = new Customer();
			customer.setFirst_name(userName);
			boolean bool = cku.check(customer);
			if(bool){
				forward = "/login/success.jsp";
			}else{
				request.setAttribute("msg", "用户名输入错误，请重新输入！");
				forward = "/login/error.jsp";
			}
			rd = request.getRequestDispatcher(forward);
			rd.forward(request, response);
		}
	}

}
