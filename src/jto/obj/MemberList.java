package jto.obj;

import jto.usr.Member;

public class MemberList {

	
	
	java.util.ArrayList<Member> members;
	

	
	public int[] setTheseMemsVisible(String[] mems_ids){
		int[] visible_ids= new int[mems_ids.length];
		int remains = members.size()-visible_ids.length;
		int[] nonvisible_ids =new int[remains];
		int nonvisible_index = 0;
		for(int i = 0; i<visible_ids.length; i++){ 
			visible_ids[i] = Integer.parseInt(mems_ids[i]); 
		}
		jto.usr.Member mem = null; 
		for(int i=0; i<members.size(); i++){
			members.get(i).setVisible(false); 
			for(int j = 0; j<visible_ids.length; j++){	
				if(members.get(i).getId()==visible_ids[j]){
					members.get(i).setVisible(true);
				} 
			}
			/* these ones get returned as not visible */
			if(!members.get(i).getVisible()){
				nonvisible_ids[nonvisible_index]=members.get(i).getId(); 
				nonvisible_index++;
			}
		}
		//reportArray(nonvisible_ids);
		return nonvisible_ids;
	}
	public void reportArray(int[] ids){
		for(int i=0; i<ids.length; i++){
			System.out.print(" ["+ids[i]+"]");
		}
	}
	
	
	
	public MemberList(){
		members = new java.util.ArrayList<Member>();
	}
	
	public void setMembers(java.util.ArrayList<Member> list){
		members=list;
	}
	public java.util.ArrayList<Member> getMembers(){
		return members;
	}
	public boolean isLoaded(){
		boolean is = false;
		if(members!=null && members.size()>0){
			is=true;
		}
		return is;
	}
	
}
