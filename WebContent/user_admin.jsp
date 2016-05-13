<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    jto.usr.NewUser the_user = (jto.usr.NewUser)request.getSession().getAttribute("userbean");
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="admin_style.css">
<title>Insert title here</title>
<script type="text/javascript">

	function checkboxes(){
		var keeper = "";
	
		for (var i = 0; i < document.mainform.area.length; i++ ) {
		    if (document.mainform.area[i].checked){
		    	if(keeper.length>1){keeper = keeper+",";}
		        keeper = keeper+" "+ document.mainform.area[i].value;
		    }
		}
		document.getElementById("areas_serviced").innerHTML = keeper;
	}
	//the_user.getAreasTranslatorRegex()
	
	
	
	
	
</script>




</head>
<body>
<style>
 .container {


   height: 290px; 
   
   overflow: auto; 
   padding:0px; margin: 0px;

}
div{ margin:0px;} 
table{ padding:0px; }
</style>

<form method="post" id="mainform" name="mainform" action="Account" >





<style> td {border-style:solid;}</style>

<table width="700" style="width:700px;">
<tr style="background-color:#dab100;">

	<td colspan="4">
		<span>
			<label><a href="Admin">back to admin</a></label> 
			<img src="images/icons/admin-s-dab100.png" width="20" height="15" />
		</span>
		<span style="float:right;">
			<a href="Login?lo=t">logout</a>
		</span>   
	</td>
</tr>
<tr>
	<td> First Name</td>
	<td width="140">
		<input type="text" id="first_name" name="first_name" value="<%=the_user.getFirst_name() %>" />
	</td>
	<td colspan="2" rowspan="6" style="margin:0px;padding:0px;width:250px;">
		<a href="UsrUploader">upload your picture</a><br />
		<img src="DisplayImage?i=<%=the_user.getImg_id()%>" 
		alt="your picture" 
		style="width:250px;margin:0px;padding:0px;border-style:solid;float:right;" />
	</td>
 
</tr>
<tr>
	<td>Last Name </td>
	<td ><input type="text" id="last_name" name="last_name" value="<%=the_user.getLast_name() %>" /></td>
</tr>
<tr>
	<td>Email  </td>
	<td > <input type="text" id="email" name="email" value="<%=the_user.getEmail() %>" /></td>
</tr>
<tr>
	<td>phone  </td>
	<td > <input type="text" id="phone" name="phone" value="<%=the_user.getPhone() %>" /></td>
</tr>
<tr>
	<td>Password  *****  </td>
	<td><a href="ChangePass">Change Password</a></td>


</tr>
<tr>
	<td>Account Type</td>
	<td ><input id="acct_type" name="acct_type" readonly="readonly" value="<%=the_user.getAcct_type()%>" /></td>
	
</tr>

<tr>
	<td><input type="submit" id="submit" name="submit" value="update" /> </td>
	<td colspan="3"><label for="description">description</label><textarea rows="3" cols="40" id="description" name="description" rows="3" ><%=the_user.getDescription()%></textarea></td>
	
</tr>
		

</table>
</form>

</body>
</html>