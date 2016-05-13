<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<jsp:scriptlet> 
rg.obj.MenuState menu = (rg.obj.MenuState)session.getAttribute("menuobject");
</jsp:scriptlet>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="admin_style.css">
<script type="text/javascript" >
function doEnableButton(){
	  var ptitle = document.getElementById("ptitle");
	  var plabel = document.getElementById("plabel");
	  var pdesc = document.getElementById("pdesc");
	  var ph1 = document.getElementById("ph1");
	  if(ptitle.value.length>0  && plabel.value.length && pdesc.value.length && ph1.value.length){
		  var button = document.getElementById("psubmit");
		  button.disabled = false;
		  button.style.backgroundColor="#7FFFD4";
	  }
}


</script>




<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create New Page</title>
</head>
<body>


	<table  style="width:450px;">
		<tr class="theading">
			<td style="vertical-align:bottom;" >
				<label><a href="AdminManager">back to admin</a></label> <img src="images/icons/admin-s-dedede.png" width="20" height="15" />
			</td>
			<td>
				<span style="float:right;"> <img src="images/icons/royalty-dedede.png" width="130" height="65" /></span>
				<br /><br />
			</td>
		</tr>
		
			<form method="post" action="NewPageMan" >
		<tr>
			<td>Page Title</td>
			<td style="text-align:right;"><input size="35" type="text" id="ptitle" name="ptitle" onblur="doEnableButton()" value="" /></td>
		</tr>
		<tr>
			<td>Page Label</td>
			<td style="text-align:right;"><input size="35" type="text" id="plabel" name="plabel" onblur="doEnableButton()" value="" /></td>
		</tr>
		<tr>
			<td>Page Descr  </td>
			<td style="text-align:right;"><textarea id="pdesc" name="pdesc" rows="2" onblur="doEnableButton()" cols="30"></textarea></td>
		</tr>
		<tr>
			<td >Heading 1</td>
			<td style="text-align:right;"><input size="35" type="text" id="ph1" name="ph1"  onblur="doEnableButton()" value="" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" id="psubmit" value="create" disabled="disabled" /></td>
		</tr>
		
		
		
		
			</form>
	</table>
</body>
</html>