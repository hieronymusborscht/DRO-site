<%@page import="rg.obj.MenuItem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="rg.obj.PageContentItem"%>
<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="admin_style.css" >

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%  
rg.obj.MenuState menu = (rg.obj.MenuState)session.getAttribute("menuobject");
%>
<title>Edit Content Item</title>


</head>
<body>



<form method="post" action="ContentEditManager" >
<table >

	<tr class="theading">
		<td colspan="2" style="vertical-align:bottom;" >
			<br />	
			<label><a href="AdminManager">back to admin</a></label>
			<img src="images/icons/admin-s-dedede.png" width="20" height="15" />&nbsp;&nbsp;&nbsp;&nbsp Edit Content: [<%=menu.getContentItemForEdit().getId()%>]
		</td>
		<td>
			<img style="float:right;" src="images/icons/royalty-dedede.png" width="130" height="65" />
		</td>
	</tr>
	
	<tr>
	
	<td  colspan="3" style=" padding-top:00px; padding-right:0px; padding-bottom:0px; padding-left:10px;"  >
		<input type="text" name="cid" id="cid" value="<%= menu.getContentItemForEdit().getId()%>" size="4" readonly="readonly" /><label for="cid">Content id</label>  
		
		<label for="cpi">Add to page:</label> 
		<select name="cpi" id="cpi">
		<option value="" > none </option>
		<% 
		ArrayList<MenuItem> menArr = menu.getMenuArray();
		
		if(menArr!=null){
			MenuItem mi;
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
	
		
		<br />
		<label for="ctitle">Title:</label> <input type="text" name="ctitle" id="ctitle" value="<%=menu.getContentItemForEdit().getTitle() %>" size="45"  />  
		
		<input type="checkbox" name="ctitle_visible" id="ctitle_visible" value="one"
		<%   if(menu.getContentItemForEdit().getTitle_visible()){
		out.println(" checked=\"checked\" ");
		}
		%>
		/><label for="ctitle_visible">Title visible</label> <br />
		
		<label for="ctitle_url">URL:</label> <input type="text" name="ctitle_url" id="ctitle_url" value="<%=menu.getContentItemForEdit().getTitle_url() %>" size="45"  />
		<input type="checkbox" name="has_title_url" id="has_title_url" value="one"
		<%   if(menu.getContentItemForEdit().getHas_title_url()){
		out.println(" checked=\"checked\" ");
		}
		%>
		/><label for="has_title_url">link active</label>
		
		
		
		
		 
	</td>
	
	</tr><tr>
	<td colspan="2" style="padding-right:0px; ">
		<textarea name="cbody" id="cbody" rows="8" cols="40"><%out.println(menu.getContentItemForEdit().getBody()); %></textarea>
	</td>
	<td>
	
	<label>Pages Used:</label><br /><br />
		<%
		java.util.ArrayList<rg.obj.PageContentItem> pcia = menu.getPageConnectorArray();
		rg.obj.PageContentItem pci;
		for(int i=0; i<pcia.size(); i++){
			pci = pcia.get(i);
		
			out.print("<label>[");
			out.print(pci.getPc_location());
			out.print("] ");
			out.print("<a href=\"LayoutManager?p=");
			
			
			
			try{
				out.print(URLEncoder.encode(pci.getPage_label(), "UTF-8"));
			}catch(UnsupportedEncodingException e){
					System.out.println(e);
			}
			
			
			out.print("\" >");
			out.print(pci.getPage_label());
			out.print("&nbsp;<a href=\"Deassigner?delcpi=");
			out.print(pci.getPc_id());
			out.print("&cid=");
			out.print(pci.getC_id());
			out.print("\"><img src=\"images/icons/trash-s-ffffff.png\" width=\"17\" height=\"15\" alt=\"remove from page\" /></a></label><br />\n");
		}
	%>
	
	
	</td>
	</tr>
	<tr>
	<td colspan="2">
		<input type="submit" name="update" id="update" value="update" />
	</td>
	<td>&nbsp; </td>
</tr>

</table>
</form>
</body>
</html>