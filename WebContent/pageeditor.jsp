<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:scriptlet> 
 
rg.obj.MenuState menu = (rg.obj.MenuState)session.getAttribute("menuobject");
  
</jsp:scriptlet>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="admin_style.css">
<title>Page Editor Thing</title>
</head>
<body>
<% 

%>
	<table >
		<tr class="theading">
			<td style="vertical-align:bottom;padding:0px 0px 3px 0px;" >
				&nbsp;<label><a href="AdminManager">back to admin</a></label> <img src="images/icons/admin-s-dedede.png" width="20" height="15" /> 
				&nbsp;<label><a href="PagesManager">Back to Pages</a></label> <img src="images/icons/pages-s-dedede.png" width="20" height="15" />
			</td><td>
				<span style="float:right;"> <img src="images/icons/royalty-dedede.png" width="130" height="65" /></span>
				<br /><br />
			</td>
		</tr>
			<form method="post" action="PageEditor" >
		<tr>
			<td>Page Title</td>
			<td style="text-align:right;"><input size="35" type="text" id="ptitle" name="ptitle" value="<%=menu.getCurrentMenuItem().getTitle()%>" /></td>
		</tr>
		<tr>
			<td>Page Label</td>
			<td style="text-align:right;"><input size="35" type="text" id="plabel" name="plabel" value="<%=menu.getCurrentMenuItem().getLabel()%>" /></td>
		</tr>
		<tr>
			<td>Page Descr</td>
			<td style="text-align:right;"><textarea id="pdesc" name="pdesc" rows="2" onblur="doEnableButton()" cols="30"><%=menu.getCurrentMenuItem().getDescr()%></textarea></td>
		</tr>
		<tr>
			<td>Heading 1</td>
			<td style="text-align:right;"><input size="35" type="text" id="ph1" name="ph1"  onblur="doEnableButton()" value="<%=menu.getCurrentMenuItem().getH1()%>" /></td>
		</tr>
		
		
		<tr>
		
		</tr>
		
		<tr>
			
			<td colspan="2"><input type="submit" value="update" /></td>
		</tr>
			</form>
	</table>

</body>
</html>