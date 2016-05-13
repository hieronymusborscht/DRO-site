<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    rg.obj.MemberList mem_list = (rg.obj.MemberList)request.getSession().getAttribute("memberlist");
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Members Admin</title>
<link rel="stylesheet" type="text/css" href="admin_style.css">
<script type="text/javascript" >
function doVisUpdate(){
	var str_buf = "";
	var chk_arr =  document.getElementsByName("vis");
	for(var i=0;i< chk_arr.length; i++){
	    if(chk_arr[i].checked){
	    	str_buf+=chk_arr[i].value+";";
	    }
	} 
	showCustomer(str_buf);
	//alert(str_buf);
}

function showCustomer(str) {
	  var xhttp;    
	  if (str == "") {
	    // do nothing if empty string
	    return;
	  }
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (xhttp.readyState == 4 && xhttp.status == 200) {
	      //document.getElementById("txtHint").innerHTML = xhttp.responseText;
	    }
	  };
	  xhttp.open("GET", "UpdateMembers?mems_vis="+str, true);
	  xhttp.send();
	}




</script>

</head>
<body>
<table>
	<tr>
	<%java.util.ArrayList<rg.usr.Member> mems_lst =  mem_list.getMembers(); %>
		<td>&nbsp;<label><a href="AdminManager">back to admin</a></label>
			<img src="images/icons/admin-s-ffffff.png" width="20" height="15" />  </td><td rowspan="2" class="theading" width="80" ><img src="images/icons/royalty-dedede.png" width="130" height="65" /></td>
	    </tr>
		<td>
		<table style="width:200px; border-style:none; margin:0px; padding:0px;">
		<tr><td>Name</td><td>Visibility</td></tr>
		<%
		
		rg.usr.Member mem;
		for(int i = 0; i< mems_lst.size(); i++){
			mem = mems_lst.get(i);
			out.print("<tr>");
			out.print("<td>");
			out.print(mem.getFirst_name());
			out.print("</td>");
			out.print("<td>");
			out.print(rg.util.ObjectStacker.visibleCheckbox("vis", mem.getId(), mem.getVisible()));
			out.print("</td>");
			out.print("</tr>");
		}
		%>
		</table>
		</td>
	
</table>
</body>
</html>