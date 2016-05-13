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
	No good: <a href="UsrUploader">try another one?</a> 
	</td>
<td>
	 or : <a href="Account?set_img=<%=upimg.getFileName()%>">looks good!</a> (attach this one to your profile)   <br /><br />
</td>
</tr>
<tr>
<td>
	<img src="DisplayImage" alt="<%=upimg.getFileName()%>" />
<br /><br />
</td>

</tr>
</table>


<div style=" display: inline; float:right; position:fixed: top: 30px; right:90px; height: 300px; width: 100px; background-color:#cecece;">&nbsp;</div>


</body>
</html>