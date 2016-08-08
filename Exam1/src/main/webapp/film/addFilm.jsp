<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.hand.service.*"%>
<%@ page import="com.hand.dao.*"%>
<%@ page import="com.hand.dao.impl.*"%>
<%@ page import="com.hand.util.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="<%=request.getContextPath()%>/AddFilmServlet" method="post">
	    <div>
		<table border="1" align="center">
			<tr align="center">
				
				<td width="20%" align="center">Title</td>
				<td width="50%" align="center">Description</td>
				<td width="10%" align="center">Language</td>
			</tr>
			<tr align="center">
			
				<td width="10%" align="center"><input type="text" name="title" /></td>
				<td width="50%" align="center"><input type="text" name="description" /></td>
				<td width="38%" align="center">
			<%
				LanguageDao ld = new LanguageDaoImpl();
				Connection conn = null;
				ResultSet rs = null ;
				try {
		 				conn = ConnectionFactory.getInstance().makeConnection();
		 				conn.setAutoCommit(false);
		 				rs =  ld.get(conn);
				} catch (SQLException e) {
					e.printStackTrace();
   				}
    
				while(rs.next()){ %>
					<%= rs.getString("name") %><input type="checkbox" name="languages" value="<%= rs.getString("name") %>" /><br/> 
			  <% } %>
				</td>
			</tr>
		</table>
			
		</div>
		<div align="center">
				<br/><br/>
				<input type="submit" value="submit" />
		</div>
		</form>

	</div>
</body>
</html>