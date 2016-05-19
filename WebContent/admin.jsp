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
		<td >
		<br /><br />
		<!--
		 	<a href="ImgUploadManager">upload image</a> <img src="images/icons/image-ffffff.png" width="29" height="23" /><br /><br />
			<a href="ContentManager?flush=t">manage content</a> <img src="images/icons/newcontent-ffffff.png" width="31" height="26" /><br /><br />
			<a href="PagesManager">pages</a> <img src="images/icons/pages-ffffff.png" width="31" height="26" /><br /><br />
		-->	
			<a href="Account">Account</a> <img src="images/icons/user-ffffff.png" width="30" height="26" /><br /><br />
			<a href="Members">Members</a> <img src="images/icons/members-ffffff.png" width="30" height="26" /><br /><br />
			<a href="#">Articles</a> <img src="images/icons/newcontent-ffffff.png"  width="30" height="26" /><br /><br />
			<a href="#">Listings</a> <img src="images/icons/listing-ffffff.png"  width="30" height="26" /><br /><br />
			<a href="#">Photos</a>  <img src="images/icons/image-ffffff.png"  width="30" height="26" /><br /><br />
		<br /><br />
		</td>
		<td class="theading" width="80" style="text-align:center;" >
		<img src="images/icons/cms-logo-dedede.png" width="130" height="65" />
		<textarea rows="20" cols="15"  style="background:#ffffff; background-image: url('images/icons/beer-logo.png');  background-repeat: no-repeat;
   
    background-position: bottom;" ></textarea>
		<br /><br />
		
		</td>
	</tr>
</table>

</body>
</html>