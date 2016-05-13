<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    rg.sch.SearchBean search_obj = (rg.sch.SearchBean)request.getSession().getAttribute("searchbean");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Search Interface</title>
<style>
body{
background-color:#ffd727; 
font-family: sans-serif;
font-size: .85em;
}
.tw{ 
width:155px;
 margin:0px;
 padding:0px; 
 border-style:none; 
 background-color:#fff;
 background: rgba(255, 255, 255, 0.6)
}
.tw td, .tw tr {padding:0px; margin:0px;}
div{
width: 170px;
height:300px;
overflow:auto;
padding:0px;
margin:0px;
}
label { font-size: .75em;}
</style>

<script type="text/javascript">
<%
//	function checkboxes(){
//		var keeper = "";
//		for (var i = 0; i < document.searchform.area.length; i++ ) {
//		    if (document.searchform.area[i].checked){
//		    	if(keeper.length>1){keeper = keeper+",";}
//		        keeper = keeper+" "+ document.searchform.area[i].value;
//		    }
//		}
//		document.getElementById("results").innerHTML = keeper;
//	}
/*

function checkbox() {
		  var xhttp;    
		  var keeper = "&a=";
			for (var i = 0; i < document.searchform.area.length; i++ ) {
			    if (document.searchform.area[i].checked){
			    	if(keeper.length>3){keeper = keeper+",";}
			        keeper = keeper + document.searchform.area[i].value;
			    }
		   }		  
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (xhttp.readyState == 4 && xhttp.status == 200) { 
		      document.getElementById("results").innerHTML = xhttp.responseText;
		    }
		  };
		  xhttp.open("GET", "SearchHandler?t=1"+keeper, true);
		  xhttp.send();
		}


*/
%>
	

	eval(function(p,a,c,k,e,r){e=function(c){return c.toString(a)};if(!''.replace(/^/,String)){while(c--)r[e(c)]=k[c]||e(c);k=[function(e){return r[e]}];e=function(){return'\\w+'};c=1};while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p}('9 j(){5 a;5 b="&a=";d(5 i=0;i<2.6.7.c;i++){8(2.6.7[i].f){8(b.c>3){b=b+","}b=b+2.6.7[i].g}}a=h x();a.k=9(){8(a.l==4&&a.m==n){2.o("p").q=a.r}};a.s("u","v?t=1"+b,w);a.e()}',34,34,'||document|||var|searchform|area|if|function|||length|for|send|checked|value|new||checkbox|onreadystatechange|readyState|status|200|getElementById|results|innerHTML|responseText|open||GET|SearchHandler|true|XMLHttpRequest'.split('|'),0,{}))
	

		
</script>



</head>
<body><table><tr><td>
<div>
<form method="post" action="SearchExample" name="searchform"  >
<%= search_obj.getAreas()%>
</form>
</div>
</td><td>
what?
<span id="results">&nbsp;results show up here&nbsp;</span>
</td></tr>
</table>
</body>
</html>