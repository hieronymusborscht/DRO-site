package jto.ent;

public class WorkType {
	
	public WorkType(){}
	
	public WorkType(int wt_id,String wt_name,String wt_description){
		setWt_id(wt_id);
		setWt_name(wt_name);
		setWt_description(wt_description);
	}
	
	//select wt_id,wt_name,wt_description from work_type
	
	private int wt_id;
	private String wt_name;
	private String wt_description;
	
	public int getWt_id() {return wt_id;}
	public String getWt_name() {	return wt_name;}
	public String getWt_description() {	return wt_description;}
	
	public void setWt_id(int wt_id) {	this.wt_id = wt_id;}
	public void setWt_name(String wt_name) {	this.wt_name = wt_name;}
	public void setWt_description(String wt_description) {	this.wt_description = wt_description;}

}
