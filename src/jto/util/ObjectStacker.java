package jto.util;

import java.util.ArrayList;

public class ObjectStacker {
	
	
	public static ArrayList<jto.obj.MenuItem> reOrderMenu(ArrayList<jto.obj.MenuItem> menu, String to_top_s){
		int to_top = Integer.parseInt(to_top_s);
		
		ArrayList<jto.obj.MenuItem> reordered_menu = new ArrayList<jto.obj.MenuItem>();
		jto.obj.MenuItem mi =null;
		
		//first pass
		for(int i=0; i<menu.size(); i++){
			mi = menu.get(i);
			if(mi.getId()==to_top){
				mi.setSortOrder(0);
				reordered_menu.add(mi);
				menu.remove(i);
			}
		}
		// second pass
		for(int i=0; i<menu.size(); i++){
			mi = menu.get(i);
			mi.setSortOrder(i+1);
			reordered_menu.add(mi);
			System.out.println(mi.getSortOrder());
		}
		
		
		
		
		return reordered_menu;
	}
	
	public static String visibleCheckbox(String input_name, int value, boolean is_checked){
		StringBuffer sb = new StringBuffer();
		sb.append("<input onchange=\"doVisUpdate()\" type=\"checkbox\" id=\"");
		sb.append(input_name);
		sb.append("\" value=\"");
		sb.append(value);
		sb.append("\" name=\"");
		sb.append(input_name);
		sb.append("\" ");
		if(is_checked){
			
			sb.append(" checked=\"checked\" ");
		}
		
		sb.append(" />");
		
		return sb.toString();
	}
	
	
	
	

}
