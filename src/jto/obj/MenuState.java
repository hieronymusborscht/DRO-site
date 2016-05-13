package jto.obj;

import java.io.UnsupportedEncodingException;

import java.net.URLEncoder;
import java.util.ArrayList;

public class MenuState {
	
	private jto.obj.MenuItem currentMenuItem;
	private ArrayList<jto.obj.MenuItem> menuArray;
	private ArrayList<jto.obj.ContentItem> contentArray;
	private ArrayList<jto.obj.PageContentItem> pageConnectorArray;
    private boolean is_admin;
    private jto.obj.ContentItem ContentItemForEdit;
    
    
	public MenuState(){
		is_admin=false;
		ContentItemForEdit = new jto.obj.ContentItem();
		currentMenuItem = new jto.obj.MenuItem();
		menuArray = new ArrayList<jto.obj.MenuItem>();
		contentArray = new ArrayList<jto.obj.ContentItem>();
		pageConnectorArray = new ArrayList<jto.obj.PageContentItem>();
	}
	
	
	
	
	public void setHomePage(){
		MenuItem mi = null;
		for(int i=0; i<menuArray.size(); i++){
			mi = menuArray.get(i);
			if(mi.getSortOrder()==0){
				currentMenuItem = mi;
			}
			//mi.getLabel()+ " sort order :" +mi.getSortOrder());
		}
	}
	
	public String getPTitle(){ return currentMenuItem.getTitle(); }
	public void setPTitle(String s){ currentMenuItem.setTitle(s); }
	public void setPH1(String s){ currentMenuItem.setH1(s); }
	
	public void setContentItemForEdit(ContentItem ci){
		ContentItemForEdit= ci;
	}
	
    public jto.obj.ContentItem getContentItemForEdit(){return ContentItemForEdit;}
	public ArrayList<jto.obj.MenuItem> getMenuArray(){ return menuArray; }

	
	
	//public String getH1(){
	//	return currentMenuItem.getH1();
	//}
	
	public String getPH1(){
		StringBuffer sb= new StringBuffer();
			sb.append("<h1>");
			sb.append(currentMenuItem.getH1());
			sb.append("</h1>");
			if(is_admin){
				sb.append("<div style=\"font-size:0.75em;background-color:#dedede; border-style:solid; border-width:thin; width:20px; position:relative; right:-");
				sb.append((currentMenuItem.getH1().length())*19);
				sb.append("px; top: -45px;\"><a href=\"PageEditor?pid=");
				sb.append(currentMenuItem.getId());
				sb.append("\">");
				
				sb.append("<img src=\"images/icons/wrench-s-ffffff.png\" width=\"17\" height=\"17\" />");
				sb.append("</a></div>");
			}
		return sb.toString();
	}
	
	public String getContentAtPosition(int position){
		StringBuffer sb = new StringBuffer();
		boolean found=false;
		ContentItem ci;
		for(int i=0; i<contentArray.size(); i++){
			ci= contentArray.get(i);
			if(ci.getPosition()==position){
				found=true;
				if(is_admin){
					sb.append(AdminControls.getContentLayoutControlsFat(ci.getId(),currentMenuItem.getLabel(),ci.getPagecontent_id()));
				}
				sb.append(ci.render(is_admin));
			}
		}
		if(!found){
			sb.append(defaultContentItem(position));
		}
		return sb.toString();
	}
	
	public String generalAreaContent(){
		boolean found = false;
		StringBuffer sb = new StringBuffer();
		jto.obj.ContentItem ci;
		for(int i=0; i<contentArray.size(); i++){
			ci = contentArray.get(i);
			if(ci.getPosition()==0 && ci.getPage_id()==currentMenuItem.getId()){
				sb.append(ci.renderGeneralArea(is_admin, currentMenuItem));
				
				//sb.append("<li>");
				//if(is_admin){
				//	found=true;
				//	sb.append(AdminControls.getContentLayoutControls(ci.getId(),currentMenuItem.getLabel(),ci.getPagecontent_id()));
				//}
				/*
				sb.append("<span class=\"time\">");
				sb.append(ci.getDate());
				sb.append("</span>");
				
				sb.append("<h4>");
				sb.append(ci.getTitle());
				sb.append("</h4>");
				
				sb.append("<p>");
				sb.append(ci.getBody());
				sb.append("<p>");
				
				sb.append("</li>");
				*/
			}
		}
		
		if(is_admin && !found){
			sb.append(AdminControls.noContentControl());
		}
		return sb.toString();
	}
	
	
	private String defaultContentItem(int position){
		StringBuffer sb = new StringBuffer();
		sb.append("<img src=\"images/earth.jpg\" alt=\"Img\" height=\"204\" width=\"220\" /><!--  Position "); 
		sb.append(position);
		sb.append(" --><h3><a href=\"blog.html\">Category ");
		sb.append(position);
		sb.append("</a></h3><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque nec mi tortor.</p>"); 
		return sb.toString();
	}

	public jto.obj.MenuItem addNewPage(String m_title,String m_label, String m_h1, String m_desc){
		
		jto.obj.MenuItem mi = new jto.obj.MenuItem();
		mi.setTitle(m_title);
		mi.setLabel(m_label);
		mi.setH1(m_h1);
		mi.setDescr(m_desc);
		menuArray.add(mi);
		
		return mi;
	}


	
	public void setAdmin(boolean b){
		is_admin=b;
	}
	public boolean getAdmin(){return is_admin;}
	/**						*/

	public jto.obj.MenuItem getCurrentMenuItem(){return currentMenuItem;}
	public void setCurrentMenuItem(jto.obj.MenuItem item){ currentMenuItem=item; }
	public void setMenu(ArrayList<jto.obj.MenuItem> men){
		if(currentMenuItem==null && men!=null &&  !men.isEmpty()){
			currentMenuItem = men.get(0);
		}
		menuArray=men;
	}
	public int menuLength(){
		if(menuArray==null){
			menuArray = new ArrayList<jto.obj.MenuItem>();
		}
		return menuArray.size();
	}
	public String renderMenu(){
		
		StringBuffer sb = new StringBuffer();
		sb.append("<ul id=\"navigation\">");
		MenuItem mi=null;
		if(is_admin){
			sb.append("<li><a href=\"AdminManager\">back to admin</a></li>");
		}
		for(int i=0; i<menuArray.size(); i++){
			mi = menuArray.get(i);
			if(currentMenuItem.getId()==mi.getId()){
				sb.append("<li class=\"selected\" >");
			}else{
				sb.append("<li>");
			}
			sb.append("<a href=\"Page?p=");
			try{
				sb.append(URLEncoder.encode(mi.getLabel(), "UTF-8"));
			}catch(UnsupportedEncodingException e){
					System.out.println(e);
			}
			sb.append("\">");
			sb.append(mi.getLabel()); 
			sb.append("</a>");
			sb.append("</li>");
		}
		sb.append("</ul>");
		return sb.toString();
	}

	/** sets the current menu item, from the already loaded ArrayList of  */
	public void selectCurrentMenuItem(String s){
		System.out.println("selectCurrentMenuItem : "+s);
		MenuItem mi;
		for(int i=0; i<menuArray.size(); i++){
			mi=menuArray.get(i);
			if(s.equals(mi.getLabel())){
				currentMenuItem = mi;
				//System.out.println("selectCurrentMenuItem FOUND: "+currentMenuItem.getId() +" "+ currentMenuItem.getLabel());
				break;
			}
		}
	}
	public void selectCurrentMenuItem(int p_num){
		
		
		MenuItem mi;
		for(int i=0; i<menuArray.size(); i++){
			mi=menuArray.get(i);
			if(p_num==mi.getId()){
				currentMenuItem = mi;
				//System.out.println("selectCurrentMenuItem FOUND: "+currentMenuItem.getId() +" "+ currentMenuItem.getLabel());
				break;
			}
		}
	}
	
	
	
	
	public void setContentArray( ArrayList<jto.obj.ContentItem> contArr){
		contentArray = contArr;	
	}
	
	public ArrayList<jto.obj.PageContentItem> getPageConnectorArray(){
		return pageConnectorArray;
	}
	public void setPageConnectorArray(ArrayList<jto.obj.PageContentItem> arr){
		pageConnectorArray=arr;
	}
	
	public ArrayList<jto.obj.ContentItem> getContentArray( ){
		return contentArray;	
	}
	
	
	/*public void setMessage(String s){ message=s;}
	public String getMessage(){return message;} */	
	//public ArrayList<rg.obj.MenuItem> getMenu(){ return menuArray; }
}
