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
New Job Postings<br /><br />
<table>
<tr>
		<td >
		<br /><br />
		
	
	 	work_type_id integer not null,
  work_type character varying(256) not null default '',
  description text,
  estimated_cost money not null,
  date_posted date,
  special_equipment text,
  how_many_positions integer not null default '0',
  user_id integer not null,
  ep_id integer not null,
	
	
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