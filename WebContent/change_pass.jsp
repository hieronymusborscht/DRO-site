<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
jto.usr.NewUser the_user = (jto.usr.NewUser)request.getSession().getAttribute("userbean");
 %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function comparePasswords(){
		
		
		var mssg ="";
		var old_pass = document.getElementById("old_pass").value;
		var new_pass_a = document.getElementById("new_pass_a").value;
		var new_pass_b = document.getElementById("new_pass_b").value;
		if(new_pass_a.length>4){
			
			var old_note = document.getElementById("old_pass_note");
			var note = document.getElementById("new_pass_a_note");
			
			
			if(old_pass.length<2){ 
				while (old_note.firstChild) { old_note.removeChild(old_note.firstChild);}
				old_note.appendChild(document.createTextNode("<-- do this one too"));
			}
			
		
			while (note.firstChild) { note.removeChild(note.firstChild);}
			
			if(new_pass_a==new_pass_b){
				note.appendChild(document.createTextNode("they match"));
				note.style.color="black";
				
				if(old_pass.length>0){
					var button = document.getElementById("update");
		    		  button.disabled = false;
		    		  button.style.backgroundColor="#7FFFD4";
					
				}
				
				
			}else{
				note.appendChild(document.createTextNode("they dont match"));
				note.style.color="red";
			}
		}
	}
	

	
	
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="admin_style.css">
<title>Change Password</title>
</head>
<body>


<form method="post" action="ChangePass">
<table>
<tr>
<td colspan="2">Select a new password</td><td>&nbsp;</td>
</tr>
<tr>
<td>old password</td><td><input type="text" id="old_pass" name="old_pass" value="" /></td><td><span id="old_pass_note">&nbsp;</span></td>
</tr>
<tr>

<td>New Password</td><td><input type="text" id="new_pass_a" name="new_pass_a" value="" /></td><td><span id="new_pass_a_note">&nbsp;</span></td>
</tr>

<tr>

<td>Confirm New Password</td><td><input type="text" id="new_pass_b" name="new_pass_b" value="" onkeyup="comparePasswords()" /></td><td><span id="new_pass_b_note">&nbsp;</span></td>
</tr>
<tr>
<td>&nbsp;</td><td><input type="submit" id="update" name="update" value="update"  disabled="disabled" /></td><td>&nbsp;</td>
</tr>
</table>
</form>
</body>
</html>