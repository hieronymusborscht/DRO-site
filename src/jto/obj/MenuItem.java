package jto.obj;

public class MenuItem {
	
	int id;
	String type;
	String label;
	String title;
	String h1;
	String descr;
	int refid;
	int sortOrder;
	int category;
	boolean visible;
	
	public MenuItem(){
		
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append(id);
		sb.append("] [");
		sb.append(type);
		sb.append("] ");
		return sb.toString();
	}

	public int getId(){ return id; }
	public String getType(){return type;}
	public String getLabel(){ return label; }
	public String getTitle(){ return title;}
	public String getH1(){if(h1==null){h1="";}return h1;}
	public String getDescr(){return descr;}
	public int getRefid(){ return refid; }
	public int getSortOrder(){return sortOrder;}
	public int getCategory(){return category;}
	public boolean getVisible(){return visible;}
	public void setId(int i){ id=i; }
	public void setType(String s){ type=s;}
	public void setLabel(String s){ label=s; }
	public void setTitle(String s){ title=s;}
	public void setH1(String s){h1=s;}
	public void setDescr(String s){descr=s;}
	public void setRefid(int s){ refid=s; }
	public void setSortOrder(int i){sortOrder=i;}
	public void setCategory(int i){category=i;}
	public void setVisible(boolean b){ visible=b;}
}
