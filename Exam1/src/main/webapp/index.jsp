<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导航界面</title>

<style type="text/css">
	body{
		color: #000;
		font-size:14px;
		margin: 20px auto;
	}
</style>

</head>

<body>
		<table border = "1" cellspacing="0" cellpadding = "5" bordercolor="silver" align="center">
			<tr>
				<td colspan="2" align="center" bgcolor="#E8E8E8">
			</tr>
			<tr>
				<td><a href = "<%= request.getContextPath() %>/login/login.jsp">进入登录界面</a> </td>
			</tr>
			
			<tr>
				<td>
					<a href="<%= request.getContextPath() %>/film/showFilm.jsp">显示film信息</a>
				 </td>
			</tr>	

			<tr>
				<td><a href = "<%= request.getContextPath() %>/film/addFilm.jsp">添加film信息</a> </td></td>
			</tr>

		</table>
</body>
</html>