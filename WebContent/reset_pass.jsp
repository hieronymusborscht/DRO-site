<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
jto.usr.NewUser the_user = (jto.usr.NewUser)request.getSession().getAttribute("userbean");
 %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="admin_style.css">
<title>Reset Password</title>
</head>
<body>
<form method="post" action="ResetPassword">
<table>
<tr>
<td colspan="2">Reset Password &nbsp; <%=the_user.getPass() %></td>
</tr>
<tr>
<td>email address</td><td><input type="text" id="email" name="email" value="john@johntheother.com" /></td>
</tr>
<tr>
<td>&nbsp;</td><td><input type="submit" id="update" name="update" value="reset" /></td>
</tr>
</table>
</form>
</body>
</html>