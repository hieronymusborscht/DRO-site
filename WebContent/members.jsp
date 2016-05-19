<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%
    jto.usr.NewUser the_user = (jto.usr.NewUser)request.getSession().getAttribute("userbean");
    
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin</title>
<link rel="stylesheet" type="text/css" href="admin_style.css">
</head>
<body>
<table>
<tr>
	<td class="theading"  style="text-align:left;" >
		<img src="images/icons/cms-logo-dedede.png" width="130" height="65" />
		<a href="Admin">return to admin</a>
		<br /><br />
		
		</td>
</tr>
<!--  tr><td class="theading"  style="text-align:right;" ></td></tr  -->
<tr>
		<td >
		<br /><br />
	

		<br /><br />
		</td>
	
	</tr>
</table>

</body>
</html>