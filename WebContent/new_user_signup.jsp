<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New User Signup</title>
<link rel="stylesheet" type="text/css" href="admin_style.css">


<script>
function showCustomer(str) {
  var xhttp;    
  if (str == "") {
    document.getElementById("txtHint").innerHTML = "<br />";
    return;
  }
  xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (xhttp.readyState == 4 && xhttp.status == 200) {
      document.getElementById("txtHint").innerHTML = xhttp.responseText;
    }
  };
  xhttp.open("GET", "CheckNewUserEmail?eml="+str, true);
  xhttp.send();
}
function checkPWLength(){
	
	var fnamefield = document.getElementById("first_name");
	var passfield = document.getElementById("mem_pass_a");
	if(passfield.value.length<5 && passfield.value.length>0){ 
		var fname="";
		if(fnamefield.value!=null && fnamefield.value.length>0){
			fname = ", "+fnamefield.value;
		}
		document.getElementById("txtHint").innerHTML = "<span style=\"color:red;font-size:9;\">That password sucks"+fname+"</span>";
	}else{
		document.getElementById("txtHint").innerHTML = "<br />";
	}
}
function checkPWMatch(){
	var passfielda = document.getElementById("mem_pass_a");
	var passfieldb = document.getElementById("mem_pass_b");
	
		if(passfieldb.value.localeCompare(passfielda.value)){
		
			document.getElementById("txtHint").innerHTML = "<span style=\"color:red;\">passwords do not match</span>";
		}else{
			document.getElementById("txtHint").innerHTML = "<br />";
		}
	
}

</script>


</head>
<body>
<style>
td { border-style:none;}

</style>

<table>
	<tr>
		<td colspan="2">New User Sign-Up<br />
		
		<div id="txtHint"><br /></div>
		
		</td>
		<td class="theading" width="80" rowspan="8"><img src="images/icons/royalty-dedede.png" width="130" height="65" /></td>
	</tr><tr>
		<td ><label>First Name</label>  
		</td><td><input type="text" id="first_name" name="first_name" /><br /></td>
	</tr><tr>
		<td><label>Last Name</label> </td>
		<td><input type="text" id="last_name" name="last_name" /></td>
	</tr><tr>
		<td><label>Email</label> </td>
		<td><input type="text" id="mem_email" name="mem_email" onblur="showCustomer(this.value)" /></td>
	</tr><tr>
		<td><label>Password</label> </td>
		<td><input type="text" id="mem_pass_a"  onblur="checkPWLength()" name="mem_pass_a" /></td>

	</tr><tr>
		<td><label>Password confirm</label> </td>
		<td><input type="text" id="mem_pass_b" onblur="checkPWMatch()" name="mem_pass_b" /></td>
	
	
	</tr><tr>
		<td><label>Terms of Service</label></td>
		<td>&nbsp;<label>Please Read and Agree to the T.O.S.</label></td>
	</tr>
	<tr>
		<td>&nbsp;<a href="Login">Login</a></td>
		<td>&nbsp;</td>
	</tr>
</table>

</body>
</html>