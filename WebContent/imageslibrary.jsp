<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="admin_style.css">
<%
rg.obj.ImageLibrary imglib = (rg.obj.ImageLibrary)request.getSession().getAttribute("imagelib");
int arrSze = imglib.getArraySize();

%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Images Library</title>
</head>
<body>
<table>
 
 
 
 <tr class="theading">
 <td  style="vertical-align:bottom;" colspan="2">
 <label><a href="ImgUploadManager">upload another image</a></label> <img src="images/icons/image-dedede.png" width="29" height="23" /><br />
				<label><a  href="AdminManager">back to admin</a></label>
				<img src="images/icons/admin-dedede.png" width="35" height="26" />
				
				<% if (arrSze>0){
					out.println("<label><a href=\"ImageManager?load_from=");
					out.print(imglib.prevIndex());
					out.print("\">older <<</a></label>");
					
					out.println("&nbsp; &nbsp; <label><a href=\"ImageManager?load_from=");
					out.print(imglib.nextIndex());
					out.print("\">newer >></a></label>");
				}
				%>
				&nbsp;&nbsp;<label><a href="ImageManager?load_from=0">newest</a></label>
				
				</td><td>
				<img style="float:right;" src="images/icons/royalty-dedede.png" width="130" height="65" />
		</td>
		</tr>
 
 
 </tr>
 <%
 int counter=0;
 int limit = 2;
 for(int i=0; i<arrSze; i++){
	 
	 if(counter>limit){
	  counter=0;
	 }
	 if(counter==0){
		 
		 out.print("<tr>");
	 }
	 out.print("<td><a href=\"ImgContentManager?i=");
	 
	 out.print(imglib.getOneUpImage(i).getId());
	 out.println("\">");
	 out.print(" <img src=\"DisplayThumb?i=");
	 out.print(i);
	 out.print("\" width=\"150\"  /></a>");
	 out.print("</td>");
	 counter++;	
	 if(counter>limit){
	 		out.print("</tr>");
	 } 
 }
 %>
 </table>
 

</body>
</html>