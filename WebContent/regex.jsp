<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%

    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Regex Interface</title>
<style>
body	{ background-color:#ffd727; font-family: sans-serif; font-size: .85em;}
.tw{  width:155px; margin:0px; padding:0px;  border-style:none;  background-color:#fff; background: rgba(255, 255, 255, 0.6); }
.tw td, .tw tr { padding:0px; margin:0px;}
div{ width: 170px; height:300px; overflow:auto; padding:0px; margin:0px; }
label { font-size: .75em;}
</style>

<script type="text/javascript">

	function readinput(){
		var keeper = ""; var upperprice =""; var lowprice = ""; var arearesults=""; var bedresults=""; var bathresults = "";
		keeper+=document.searchform.fred.value.toLowerCase(); 
		var patt0 = /(less than|under|below|no higher than|for|max|max price|maximum price|maximum|up to|as much as|to){1,}[$\s]{0,}[0123456789,]{1,}[$\s]{0,}(k|thousand|mil|m|million|thou|grand){0,}/
		var patt1 = /(more than|above|no less than|at least|min|min price|minimum price|minimum|down to|as low as|from|over){1,}[$\s]{0,}[0123456789,]{1,}[$\s]{0,}(k|thousand|mil|m|million|thou|grand){0,}/
		var patt3 = /[0123456789]{1,}[$\s]{0,}(bed|beds|bedroom){1,}/
		var patt4 = /[0123456789]{1,}[$\s]{0,}(bat|bath|bathrooms){1,}/
		if(keeper.endsWith(' ')){
			upperprice = patt0.exec(keeper);
			lowprice = patt1.exec(keeper);	
			arearesults = matchareas(keeper);
			bedresults = patt3.exec(keeper);
			bathresults = patt4.exec(keeper);
			var qs=match_types(keeper);		
			if(arearesults!=null && arearesults.length>0){		qs+= replace_area(arearesults.toString()); }
			if(upperprice!=null){  	qs+=replacement_upper(upperprice[0]); 	}
			if(lowprice!=null){  	qs+=replacement_lower(lowprice[0]); 	}
			if(bedresults!=null && bedresults.length>0){ 	qs+=replace_bed(bedresults[0]); 	}
			if(bathresults!=null && bathresults.length>0){ 	qs+=replace_bat(bathresults[0]); }
			document.getElementById("results").innerHTML = keeper +"<br /><br />["+qs+"]";
			
			//sendToServer(qs);
		}
	}
	function match_types(str){
		var reg = /(condo|houses|townhouse|loft|land|apartment|apt|house|rancher|duplex|detached|dirt){1,}/  
		var startindex =0;	
		var matches = [];
		var found;
		while(startindex<str.length){
			found = reg.exec(str.substring(startindex));
			if(found!=null){ matches.push(found[0]); startindex+= found.index+1; }else{ startindex=str.length; }
		}
		if(matches!=null && matches.length>0){
			str ="&type="+matches.toString();
			str= str.replace(/(\s){0,}homes/, "detached");
			str= str.replace(/(\s){0,}home/, "detached");
			str= str.replace(/(\s){0,}houses/, "detached");
			str= str.replace(/(\s){0,}house/, "detached");
			str= str.replace(/(\s){0,}rancher/, "detached");
			str= str.replace(/(\s){0,}ranchers/, "detached");
			str= str.replace(/(\s){0,}duplexes/, "townhouse");
			str= str.replace(/(\s){0,}duplexs/, "townhouse");
			str= str.replace(/(\s){0,}duplex/, "townhouse");
			str= str.replace(/(\s){0,}apts/, "apartment");
			str= str.replace(/(\s){0,}apt/, "apartment");
			str= str.replace(/(\s){0,}acreage/, "land");
			str= str.replace(/(\s){0,}acres/, "land");
			str= str.replace(/(\s){0,}dirt/, "land");
			return str;
		}else{
			return "";
		}
		//return str;
	}
	function matchareas(str){
		var reg = /(coquitlam|abbotsford|bowen island|burnaby|burnaby east|east burnaby|burnaby north|north burnaby|burnaby south|south burnaby|chilliwack|cloverdale|coquitlam|islands|gulf|ladner|langley|maple ridge|mission|delta|westminster|surrey|south surrey|surrey south|north vancouver|nvan|north van|east van|east vancouver|e van|e vancouver|evan|vancouver east|van e|vancouver e|west van|w van|w vancouver|vancouver west|w vancouver|pemberton|pitt meadows|coquitlam|moody|richmond|surrey|white rock|squamish|sunshine|coast|tsawwassen){1,}/  
		var startindex =0;	
		var matches = [];
		var found;
		while(startindex<str.length){
			found = reg.exec(str.substring(startindex));
			if(found!=null){
				matches.push(found[0]);
				startindex+= found.index+1;
			}else{
			 startindex=str.length;
			}
		}
		return matches;
	}	
	function replacement_upper(str){
		str= str.replace(/(less than|under|below|no higher than|for|max|max price|maximum price|maximum|up to|as much as|to)/, "");
		str= str.replace(/(\s){0,}million/, "000000");
		str= str.replace(/(\s){0,}mil/, "000000");
		str= str.replace(/(\s){0,}m/, "000000");
		str= str.replace(/(\s){0,}thousand/, "000");
		str= str.replace(/(\s){0,}grand/, "000");
		str= str.replace(/(\s){0,}k/, "000");
		str= str.replace(/(\s){0,}thou/, "000").trim();
		if(str.length>0){
			str="&max="+str;
		}
	return str;
	}
	function replace_bat(str){
		str= str.replace(/(\s){0,}bathrooms/, "");
		str= str.replace(/(\s){0,}baths/, "");
		str= str.replace(/(\s){0,}bath/, "");
		str= str.replace(/(\s){0,}bat/, "").trim();
		if(str.length>0){
			str="&bat="+str;
		}
	return str;
	}
	function replace_bed(str){
		str= str.replace(/(\s){0,}bedrooms/, "");
		str= str.replace(/(\s){0,}beds/, "");
		str= str.replace(/(\s){0,}bed/, "").trim();
		if(str.length>0){
			str="&bed="+str;
		}
	return str;
	}
	function replacement_lower(str){
		str= str.replace(/(more than|above|no less than|at least|min|min price|minimum price|minimum|down to|as low as|over|from)/, "");
		str= str.replace(/(\s){0,}million/, "000000");
		str= str.replace(/(\s){0,}mil/, "000000");
		str= str.replace(/(\s){0,}(m)/, "000000");
		str= str.replace(/(\s){0,}thousand/, "000");
		str= str.replace(/(\s){0,}grand/, "000");
		str= str.replace(/(\s){0,}k/, "000");
		str= str.replace(/(\s){0,}thou/, "000").trim();
		if(str.length>0){
			str="&min="+str;
		}
	return str;
	}
	function replace_area(str){
		str= str.replace(/coquitlam/,"VCQ"); 	
		str= str.replace(/abbotsford/,"F70");
		str= str.replace(/bowen island/,"VBD");		
		str= str.replace(/burnaby East/,"VBE");
		str= str.replace(/burnaby North/,"VBN");
		str= str.replace(/burnaby South/,"VBS");
		str= str.replace(/chilliwack/,"H90");
		str= str.replace(/cloverdale/,"F40");
		str= str.replace(/coquitlam/,"VCQ");
		str= str.replace(/gulf/,"VIS");
		str= str.replace(/ladner/,"VLD");
		str= str.replace(/angley/,"F60");
		str= str.replace(/maple Ridge/,"VMR");
		str= str.replace(/mission/,"F80");
		str= str.replace(/n. delta/,"F10");
		str= str.replace(/n delta/,"F10");
		str= str.replace(/north delta/,"F10");
		str= str.replace(/delta/,"F10");
		str= str.replace(/new westminster/,"VNW");
		str= str.replace(/north surrey/,"F20");
		str= str.replace(/north vancouver/,"VNV");
		str= str.replace(/north van/,"VNV");
		str= str.replace(/n vancouver/,"VNV");
		str= str.replace(/n van/,"VNV");
		str= str.replace(/nvan/,"VNV");
		str= str.replace(/pemberton/,"VPE");
		str= str.replace(/pitt meadows/,"VPI");
		str= str.replace(/port coquitlam/,"VPQ");
		str= str.replace(/port moody/,"VPM");
		str= str.replace(/richmond/,"VRI");
		str= str.replace(/south surrey/,"F50");
		str= str.replace(/white rock/,"F50");
		str= str.replace(/squamish/,"VSQ");
		str= str.replace(/sunshine coast/,"VSC");
		str= str.replace(/surrey/,"F30");
		str= str.replace(/tsawwassen/,"VTW");
		str= str.replace(/vancouver east/,"VVE");
		str= str.replace(/east van/,"VVE");
		str= str.replace(/van east/,"VVE");
		str= str.replace(/east vancouver/,"VVE");
		str= str.replace(/van west/,"VVW");
		str= str.replace(/west van/,"VVW");
		str= str.replace(/west vancouver/,"VVW");
		str =str.replace(/vancouver west/,"VVW").trim();
		if(str.length>0){
			str="&a="+str;
		}
		return str;		
	}
	
	function sendToServer(str) {
		  var xhttp;    
		  if (str == "") {
		    document.getElementById("txtHint").innerHTML = "<br />";
		    return;
		  }
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (xhttp.readyState == 4 && xhttp.status == 200) {
		      document.getElementById("results").innerHTML = xhttp.responseText;
		    }
		  };
		  xhttp.open("GET", "SearchHandler?t=t"+str, true);
		  xhttp.send();
		}
	
</script>
</head>
<body><table><tr><td>

<form method="post" action="SearchExample" name="searchform" onkeyup="readinput()"  >
<textarea name="fred" id="fred"  cols="50"  rows="2"></textarea>
</form>
</td><td>
<span id="results">&nbsp;results show up here&nbsp;</span>
</td></tr>
</table>
</body>
</html>