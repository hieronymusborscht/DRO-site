package jto.obj;

public class ContentItem {
	
	
	
	
	private int id;
	private int pagecontent_id;
	private String title; 
	private String body;
	private boolean visible;
	private String date;
	private String title_url;
	private boolean has_title_url;
	private boolean title_visible;
	private int page_id;
	
	
	private int position;
	
	
	public ContentItem(){
		id=0;
		title=null; 
		body=null;
		visible=true;
		date="1970-01-01";
		title_url="http://royalty.ca";
		has_title_url=false;
		position=0;
		title_visible=false;
		pagecontent_id =0;
	}
	
	
	public String renderGeneralArea(boolean is_admin, MenuItem mi){
		is_admin=true;
		StringBuffer sb = new StringBuffer();
		sb.append("<li>");
		if(is_admin){
			sb.append(AdminControls.getContentLayoutControls(id,mi.getLabel(),pagecontent_id));
		}
		sb.append("<span class=\"time\">");
		sb.append(date);
		sb.append("</span>");
		if(title_visible){
			sb.append("<h4>");
			if(has_title_url){
				sb.append("<a href=\"");
				sb.append(title_url);
				sb.append("\">");
			}
			sb.append(title);
			if(has_title_url){
				sb.append("</a>");
			}
			sb.append("</h4>");
		}
		sb.append("<p>");
		sb.append(body);
		sb.append("<p></li>");
		return sb.toString();
		
	}
	public String render(boolean is_admin){
		boolean do_title_url = (title_visible && has_title_url && title_url!=null && title_url.length()>8);
		StringBuffer sb = new StringBuffer();
		if(title_visible && title.length()>0){
			sb.append("<h3>");
				if(do_title_url){
					sb.append("<a href=\"");
					sb.append(title_url);
					sb.append("\">");
				}
				sb.append(title);
				if(do_title_url){
					sb.append("</a>");
				}
			sb.append("</h3>");
		}
		sb.append("<p>");
		sb.append(body);
		sb.append("</p>");
		return sb.toString();
	}
	public int getId(){return id;} 
	public String getTitle(){ 	return title;	} 
	public String getBody(){return body; }
	public boolean getVisible(){return visible;}
	public String getDate(){return date; }
	public int getPosition(){return position; }
	public String getTitle_url(){return title_url;}
	public int getPagecontent_id(){return pagecontent_id;}
	public int getPage_id(){return page_id;}
	public boolean getHas_title_url(){return has_title_url;}
	public boolean getTitle_visible(){return title_visible;}
	public void setId(int i){id = i;} 
	public void setTitle(String s){title=s;} 
	public void setBody(String s){body=s; }
	public void setVisible(boolean b){visible=b;}
	public void setDate(String s){date=s; }
	public void setPosition(int i){ position=i;}
	public void setTitle_url(String s){title_url=s;}
	public void setHas_title_url(boolean b){has_title_url=b;}
	public void setTitle_visible(boolean b){title_visible=b;}
	public void setPagecontent_id(int i){pagecontent_id=i;}
	public void setPage_id(int i){page_id=i;}
}
