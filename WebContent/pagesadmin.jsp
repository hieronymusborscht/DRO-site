<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.UnsupportedEncodingException" %>
<%@ page import="java.net.URLEncoder" %>

<jsp:scriptlet> 
//rg.obj.ContAdminMan cam = (rg.obj.ContAdminMan)session.getAttribute("contadmin");
rg.obj.MenuState menu = (rg.obj.MenuState)session.getAttribute("menuobject");
  
</jsp:scriptlet>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="admin_style.css">
<title>Pages Admin</title>
</head>
<body>
<% 
java.util.ArrayList<rg.obj.MenuItem> menuArray = menu.getMenuArray();
java.util.ArrayList<rg.obj.PageContentItem> pcis = menu.getPageConnectorArray();
%>
<table>
<tr class="theading"><td style="vertical-align:bottom;" >
<a><strong>Pages</strong></a>
&nbsp; &nbsp; &nbsp; <label>
<a href="AdminManager">back to admin</a></label> <img src="images/icons/admin-s-dedede.png" width="20" height="15" />
</td><td>
<span style="float:right;"> <img src="images/icons/royalty-dedede.png" width="130" height="65" /></span>
<br /><br />
</td></tr>
<tr>
<td colspan="2">
	<%
	rg.obj.PageContentItem pci =null;
	rg.obj.MenuItem mi =null;
	out.println("menu size : " +menuArray.size());
	out.println("</td></tr><tr>");
	for(int i=0; i< menuArray.size(); i++){
		int k=0;
		mi = menuArray.get(i);
		out.println("<td>");
		out.print("<label><a href=\"LayoutManager?p=");
		try{
			out.print(URLEncoder.encode(mi.getLabel(), "UTF-8"));
		}catch(UnsupportedEncodingException e){
				System.out.println(e);
		}
		out.print("\">");
		out.print("<img src=\"images/icons/notepad-s-ffffff.png\" width=\"16\" height=\"16\" />");
		out.print("</a></label>&nbsp;");
		out.print(mi.getLabel());
		out.print("&nbsp; &nbsp;");
		out.print("<a href=\"");
		out.print("PageEditor?pid=");
		out.print(mi.getId());
		out.print("\">");
		out.print("<img src=\"images/icons/wrench-s-ffffff.png\" width=\"17\" height=\"17\"  />");
		out.print("</a>       ");
		out.print(" &nbsp; &nbsp; &nbsp; <a href=\"PagesManager?p_up=");
		out.print(mi.getId());
		out.print("\"><img src=\"images/icons/to-top-s-fff.png\" width=\"16\" height=\"15\"  /></a>");
		out.println("</td>");
		out.print("<td>");
			for(int j=0; j< pcis.size(); j++){
				pci = pcis.get(j);
				if(pci.getPage_id()==mi.getId()){
					k++;
				}		
			}
		out.print(k);
		out.print(" content items");
		out.println("</td></tr>");
		}
%>
<tr><td colspan="2">&nbsp; <a href="NewPageMan">add page</a> </td></tr>
</table>
</body>
</html>