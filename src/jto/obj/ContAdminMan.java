package jto.obj;

import java.util.ArrayList;

public class ContAdminMan {
	
	boolean isloggedin;
	private ArrayList<jto.obj.ContentItem> contentArray;
 
	public ContAdminMan(){
		 isloggedin=false;
		 contentArray = new ArrayList<jto.obj.ContentItem>();
	}
	public ArrayList<jto.obj.ContentItem> getContentArray(){
		return contentArray;
	}
	public void setFullContent(ArrayList<jto.obj.ContentItem> arr){
		contentArray = arr;
	}
	//=========== BEGIN ContentEditManager (servlet) methods 
	public boolean selectContentItemForEdit(String cont_id){
		boolean success=false;
		ContentItem ci;
		int cid=Integer.parseInt(cont_id);
		for(int i=0; i<contentArray.size(); i++){
			ci = contentArray.get(i);
			if(ci.getId()==cid){			
				success=true;
				break;
			}
		}
		return success;
	}
	
	
}
