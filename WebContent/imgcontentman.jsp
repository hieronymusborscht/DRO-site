<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    rg.obj.ImageLibrary imglib = (rg.obj.ImageLibrary)request.getSession().getAttribute("imagelib");
    rg.obj.MenuState menu = (rg.obj.MenuState)request.getSession().getAttribute("menuobject");

    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="admin_style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Send Image to a Page</title>
</head>
<body>

<%

java.util.ArrayList<rg.obj.MenuItem> menArr = menu.getMenuArray();


%>

<table>
 	<tr class="theading">
 		<td  style="vertical-align:bottom;" colspan="2">
 			<label><a href="ImgUploadManager">upload another image</a></label> <img src="images/icons/image-dedede.png" width="29" height="23" />  &nbsp; <label><a href="ImageManager">Image Gallery</a></label><img src="images/icons/gallery-s-dedede.png" width="20" height="16" /><br />
			<label><a  href="AdminManager">back to admin</a></label>
			<img src="images/icons/admin-dedede.png" width="35" height="26" />
		</td><td>
			<img style="float:right;" src="images/icons/royalty-dedede.png" width="130" height="65" />
		</td>
	</tr>
 	<tr>
 	<td colspan="3">
 	
 	<form method="post" action="SetImageContent?img=<%=imglib.getSingleId() %>" >
 		<label for="cpi">Add to page:</label> 
		<select name="cpi" id="cpi">
		<option value="" > none </option>
		<% 
		
		
		if(menArr!=null){
			rg.obj.MenuItem mi;
			for(int i=0; i<menArr.size(); i++){
				mi=menArr.get(i);
				out.print("<option value=\"");
				out.print(mi.getId());
				out.print("\">");
				out.print(mi.getLabel());
				out.print("</option>\n");
			}
		}
		%>
		</select>
		<input type="submit" name="submit" id="submit" value="go" />
		</form>
 	</td>
 	</tr><tr>
 		<td colspan="3">
 		<%
 		out.println(imglib.getSingleId());
 		
 		if(imglib.getSingleId()>0){
 			out.print("<img src=\"DisplayImage?i=");
 			out.print(imglib.getSingleId());
 			out.print("\" />");
  		}
  		%>
 		</td>
 	</tr>

 </table>



</body>
</html>