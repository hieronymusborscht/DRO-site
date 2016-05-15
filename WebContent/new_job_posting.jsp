<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
    jto.ctr.JobPostingState job_posting_state = (jto.ctr.JobPostingState)request.getSession().getAttribute("poting_state");
    jto.ent.JobPosting jp = job_posting_state.getTemp_posting();
 %>
<!-- [7] Contractor Dashboard -->    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Job Posting</title>
<link rel="stylesheet" type="text/css" href="admin_style.css">
</head>
<body>

<h1>New Job Posting</h1>
<table>
<tr>
		<td >
		<br /><br />
<!--  	 	
  description text,
  estimated_cost money not null,
  date_posted date,
  special_equipment text,
  how_many_positions integer not null default '0',
  user_id integer not null,
  ep_id integer not null,
	-->
	<form method="post" action="NewJobPosting">
	
	<label for="wt_id">Work Type</label><select  id="wt_id" name="wt_id">
	<%=job_posting_state.getWorkTypeOptions()%>
	</select><br />
	
	<label for="description">Description</label><textarea id="dscription" name="description" rows="5" cols="50"><%=jp.getDescription() %></textarea><br />
	<label for="estimated_cost">Estimated Cost</label><input type="text" id="estimated_cost" name="estimated_cost" value="<%=jp.getEstimated_cost()%>" /><br />
	<label for="special_equipment">Special Equipment</label><textarea id="special_equipment" name="special_equipment" rows="5" cols="50"><%=jp.getSpecial_equipment() %></textarea><br />
	<label for="how_many_positions">How Many Positions</label><input type="text" id="how_many_positions" name="how_many_positions" value="<%=jp.getHow_many_positions() %>" /><br />
	<input type="submit" id="enter" name="enter" value="enter" />
	</form>
	
	<br /><br />
		</td>
		<td class="theading" width="80"  >
		<img src="images/dro-logo-dedede.png" width="130" height="65" />
		<br /><br />
		
		</td>
	</tr>
</table>

</body>
</html>