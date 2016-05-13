package jto.obj;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class AdminControls {
	
	
	
	public static String getContentLayoutControls(int cont_id, String label,int pcid){
		
		StringBuffer sb = new StringBuffer();
		sb.append("<div style=\"font-size:0.75em;background-color:#dedede; border-style:solid; border-width:thin; width:300px; \">");
		//sb.append("content-level controls here");
		sb.append("<table><tr><td>");
		
		sb.append("<form method=\"post\" action=\"LayoutManager\"  >");
		sb.append("<input type=\"hidden\" id=\"cid\" name=\"cid\" value=\"");
		sb.append(cont_id);
		sb.append("\" />\n");
		sb.append("<label for=\"cont_mv\">move to: </label><select name=\"cont_mv\" id=\"cont_mv\" >\n");
		sb.append("	<option value=\"0\">position 0</option>\n");
		sb.append("	<option value=\"1\">position 1</option>\n");
		sb.append("	<option value=\"2\">position 2</option>\n");
		sb.append("	<option value=\"3\">position 3</option>\n");
		sb.append("	<option value=\"4\">position 4</option>\n");
		sb.append("	<option value=\"5\">position 5</option>\n");
		sb.append("	<option value=\"6\">position 6</option>\n");
		sb.append("	<option value=\"7\">position 7</option>\n");
		sb.append("	<option value=\"8\">position 8</option>\n");
		sb.append("</select>\n");
		sb.append("<input type=\"submit\" value=\"go!\" />\n");
		sb.append("</form>\n");
		
		sb.append("</td><td>");
		
		sb.append("<a href=\"ContentEditManager?lfe=");
		sb.append(cont_id);
		sb.append("\">edit</a>");
		
		sb.append("</td><td><a href=\"Deassigner?delcpi=");
		//sb.append(cont_id);
		sb.append(pcid);
		sb.append("&p=");
		
		
		try{
			sb.append(URLEncoder.encode(label, "UTF-8"));
		}catch(UnsupportedEncodingException e){
				System.out.println(e);
		}
		
		sb.append("\">remove</a></td></tr></table>");
		
		sb.append("</div>");
		return sb.toString();
	}
	
	public static String getContentLayoutControlsFat(int cont_id, String label, int pcid){
		
		StringBuffer sb = new StringBuffer();
		sb.append("<div style=\"font-size:0.75em;background-color:#dedede; border-style:solid; border-width:thin; width:220px; \">");
		//sb.append("content-level controls here");
		sb.append("<table><tr><td colspan=\"2\">");
		
		sb.append("<form method=\"post\" action=\"LayoutManager\"  >");
		sb.append("<input type=\"hidden\" id=\"cid\" name=\"cid\" value=\"");
		sb.append(cont_id);
		sb.append("\" />\n");
		sb.append("<label for=\"cont_mv\">move to: </label><select name=\"cont_mv\" id=\"cont_mv\" >\n");
		sb.append("	<option value=\"1\">position 1</option>\n");
		sb.append("	<option value=\"2\">position 2</option>\n");
		sb.append("	<option value=\"3\">position 3</option>\n");
		sb.append("	<option value=\"4\">position 4</option>\n");
		sb.append("	<option value=\"5\">position 5</option>\n");
		sb.append("	<option value=\"6\">position 6</option>\n");
		sb.append("	<option value=\"7\">position 7</option>\n");
		sb.append("	<option value=\"8\">position 8</option>\n");
		sb.append("</select>\n");
		sb.append("<input type=\"submit\" value=\"go!\" />\n");
		sb.append("</form>\n");
		
		sb.append("</td></tr><tr><td>");
		
		sb.append("<a href=\"ContentEditManager?lfe=");
		sb.append(cont_id);
		sb.append("\">edit</a>");
		
		sb.append("</td><td><a href=\"Deassigner?delcpi=");
		sb.append(pcid);
		sb.append("&p=");
		
		
		try{
			sb.append(URLEncoder.encode(label, "UTF-8"));
		}catch(UnsupportedEncodingException e){
				System.out.println(e);
		}
		
		sb.append("\">remove</a></td></tr></table>");
		
		sb.append("</div>");
		return sb.toString();
	}
	
	
	

	public static String noContentControl(){
		StringBuffer sb = new StringBuffer();
		sb.append("<div style=\"font-size:0.75em;background-color:#dedede; border-style:solid; border-width:thin; width:350px; \">");
		sb.append("<table><tr><td><img src=\"images/icons/bomb-dedede.png\" width=\"25\" height=\"25\" />");
		sb.append("No content currently on this page</td><td style=\"padding-left:30px; vertical-align:bottom;\">");
		sb.append("&nbsp;&nbsp;&nbsp; <a href=\"LayoutManager?newcont=t");
		sb.append("\">let's add some!</a>");
		sb.append("</td></tr></table></div>");
		return sb.toString();
	}
	
	
}
