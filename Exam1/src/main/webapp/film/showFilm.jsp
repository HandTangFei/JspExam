<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>
<%@ page import="com.hand.service.*"%>
<%@ page import="com.hand.dao.*"%>
<%@ page import="com.hand.dao.impl.*"%>
<%@ page import="com.hand.util.*"%>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电影信息</title>
</head>
<body>
<%
	String msg = request.getParameter("msg");
	out.println(msg+"<br/><br/>");
%>

	<%
		FilmDao filmDao = new FilmDaoImpl();
		Connection conn = null;
		ResultSet resultSet = null;

		conn = ConnectionFactory.getInstance().makeConnection();
		conn.setAutoCommit(false);
		resultSet = filmDao.get(conn);

		ShowFilmService sfs = new ShowFilmService();
		ResultSet rs = resultSet;
	%>
	<table border="1" align="center">
		<tr align="center">
			<td width="10%" align="center">Film ID</td>
			<td width="20%" align="center">Title</td>
			<td width="50%" align="center">Description</td>
			<td width="10%" align="center">Language</td>
			<td width="10%" align="center">Delete</td>
		</tr>
		<%
			while (rs.next()) {
		%>
		<tr>
			<td align="center"><%=rs.getInt("film_id")%></td>
			<td align="center"><%=rs.getString("title")%></td>
			<td align="center"><%=rs.getString("description")%></td>
			<td align="center"><%=rs.getString("name")%></td>
			<td align="center">
				<form
					action="<%=request.getContextPath()%>/DeleteFilmServlet?id=<%=rs.getInt("film_id")%>"
					method="post">
					<input type="hidden" /> <input type="submit" value="Delete" />
				</form>
			</td>
		</tr>
		<%
			}
		%>
	</table>


</body>
</html>