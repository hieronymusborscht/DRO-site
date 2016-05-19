<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%  
jto.UploadedImage upimg = (jto.UploadedImage)session.getAttribute("uploadedimg");  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>upload</title>

<link rel="stylesheet" type="text/css" href="admin_style.css">
</head>
<body>
<table>
<tr class="theading">
<td>
	uploaded: <%=upimg.getFileName() %><br />
	cont.type: <%=upimg.getContentType()%><br />
	size: <%=upimg.getSizeKiloBytes()%> Kb 
</td>
<td>
<img style="float:right;" src="images/icons/royalty-dedede.png" width="130" height="65" />
</td>	
	</tr><tr>
<td >
	<a href="ImgUploadManager">upload another image</a><img src="images/icons/image-ffffff.png" width="29" height="23" />
	</td>
<td>
	 <a href="AdminManager">return to admin</a> <img src="images/icons/admin-ffffff.png" width="35" height="26" />   <br /><br />
</td>
</tr>
<tr>
<td>
	<img src="DisplayImage?t=t" alt="<%=upimg.getFileName()%>" />
<br /><br />
</td>

</tr>
</table>


<div style=" display: inline; float:right; position:fixed: top: 30px; right:90px; height: 300px; width: 100px; background-color:#cecece;">&nbsp;</div>


</body>
</html>