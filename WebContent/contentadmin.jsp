<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="admin_style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Content Administration</title>
</head>
<body>
<table>
	<tr class="theading">
		<td style="vertical-align:bottom;" ><br />
			<label><a href="ContentManager?newcont=t">New Content Item</a></label>
			<img src="images/icons/newcontent-s-dedede.png" width="20" height="17" />
			&nbsp; &nbsp; &nbsp; 
			
			<label><a href="AdminManager">back to admin</a></label>
			<img src="images/icons/admin-s-dedede.png" width="20" height="15" />
		</td><td colspan="2">
			<img style="float:right;" src="images/icons/royalty-dedede.png" width="130" height="65" />
		</td>
	</tr>
	
	<tr>
	<td></td><td></td><td></td>
	

	</tr>
	
<%  
rg.obj.ContAdminMan cam = (rg.obj.ContAdminMan)session.getAttribute("contadmin");	
java.util.ArrayList<rg.obj.ContentItem> ca =  cam.getContentArray();

rg.obj.ContentItem ci;
if(ca!=null){
	
	for(int i=0; i<ca.size(); i++){
		ci=ca.get(i);
		out.print("<tr>");
		out.print("<td style=\"font-size:.80em;\" colspan=\"2\">");
		
		out.print("<p >[");
		out.print(ci.getId());
		out.println("]&nbsp;&nbsp;<strong>");
		out.print(ci.getTitle());
		out.println("</strong>&nbsp;&nbsp;&nbsp;&nbsp;");
		out.println(ci.getDate());
		out.print("</p>");
		if(ci.getBody().length()>70){
			out.println(ci.getBody().substring(0,145));
		}else{
			out.println(ci.getBody());
		}
		
		out.print("... ");
		out.print("</td><td style=\"text-align:left; padding-left7px;\">");
		out.println("<label><a href=\"ContentEditManager?lfe="+ci.getId()+"\">");
		//out.print( "<img src=\"images/icons/wrench-s-ffffff.png\" width=\"17\" height=\"17\" />");
		out.print("<img src=\"images/icons/notepad-s-ffffff.png\" width=\"16\" height=\"16\" />");
		out.print("edit</a></label>" );
		out.print( "<br /><br />");
		out.print("<label><a href=\"");
		out.print("ContentManager?del=");
		out.print(ci.getId());
		out.print("\"><img src=\"images/icons/trash-s-ffffff.png\" width=\"17\" height=\"15\" />delete</a></label>");
		
		out.print("<br />");
		out.print("</td></tr>\n");
	}
	out.println("<tr><td colspan=\"3\">&nbsp;</td></tr>");
	out.println("</table>");

}else{
	out.println("<table><tr><td>");
	out.println("<br /><br />it was null!<br /><br />");
	out.println("</td></tr></table>");
}

%>


<form method="post" action="ContentManager" >


</form>

</body>
</html>