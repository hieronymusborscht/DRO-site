package jto.obj;

public class PageContentItem {


	int page_id;  // pid
	int pc_id; 
	int pc_cid;
	int pc_uid;
	int c_id;
	String page_label;
	String cont_title;
	int pc_location;
	//int pc_sortorder;
	//from pagecontent, page where page.id=pagecontent.pid and cid=1
	
	
	public PageContentItem(){}
	

	public int getPage_id(){return page_id;}  // pid
	public int getPc_id(){return pc_id;} 
	public int getPc_cid(){ return pc_cid; }
	public int getPc_uid(){return pc_uid; }
	public int getC_id(){return c_id; }
	public String getPage_label(){return page_label;}
	public String getCont_title(){return cont_title;}
	public int getPc_location(){return pc_location;}
	
	/*
	public String getSummary(){
		StringBuffer sb = new StringBuffer();
		sb.append("pid: [");
		sb.append(page_id);
		sb.append
		
		
		return sb.toString();
	}
	*/
	
	public void setPage_id(int i){page_id=i;};  // pid
	public void setPc_id(int i){pc_id=i;}
	public void setPc_cid(int i){pc_cid=i;}
	public void setPc_uid(int i){pc_uid=i;}
	public void setC_id(int i){c_id=i;}
	public void setPage_label(String s){page_label=s;}
	public void setCont_title(String s){cont_title=s;}
	public void setPc_location(int i){pc_location=i;}
	
	
}
