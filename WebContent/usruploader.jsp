
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="admin_style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Image</title>

      <script type="text/javascript">
      
      function doThing(){
    	  var filefield = document.getElementById("file1");
    	  if(filefield.value.length>0){
    		  var button = document.getElementById("upl");
    		  button.disabled = false;
    		  button.style.backgroundColor="#7FFFD4";
    	  }
      }
    
        </script>

</head>
<body>

	<table>
	
		<tr class="theading">
		<td  style="vertical-align:bottom;"  >
				Upload your picture
				<!--  label><a href="ImageManager">Image Gallery</a ></label>
				<img src="images/icons/gallery-s-dedede.png" width="20" height="16" /><br />
		
				<label><a  href="AdminManager">Back to Admin</a></label>
				<img src="images/icons/admin-s-dedede.png" width="20" height="15" / --> 
				</td><td>
				<img style="float:right;" src="images/icons/royalty-dedede.png" width="130" height="65" />
		</td>
		</tr>
		<tr>
			<td>
			<br /><br />
				<form name="form1" id="form1" action="UsrUploadReceiver" method="post" enctype="multipart/form-data">
				<input type="hidden" name="hiddenfield1" value="ok">
				Files to upload:
				<br/>
				<input type="file" id="file1" size="50" onchange="doThing()" name="file1">

				<br/>
				<input type="submit" id="upl" disabled="disabled" value="Upload">
				</form>
				
				<br /><br />
			</td>
			<td>
		
			<span style="float:right; padding:5px;"><img src="images/icons/upload-120.png" width="120" height="120" /> </span></td>		
		</tr>
	</table>
	
	

	
	
</body>
</html>