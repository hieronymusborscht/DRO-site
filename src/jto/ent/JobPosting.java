package jto.ent;

public class JobPosting {
	
	
	/*
	 * 
  jp_id serial PRIMARY KEY NOT NULL,
  work_type_id integer not null,
  work_type character varying(256) not null default '',
  description text,
  estimated_cost money not null,
  date_posted date,
  special_equipent text,
  how_many_positions integer not null default '0',
  user_id integer not null,
  ep_id integer not null,
  visible boolean default 'false'
	 * 
	 */

	
	  private int jp_id;
	  private int work_type_id;
	  private String work_type;
	  private float estimated_cost;
	  private java.util.Date date_posted;
	  private String special_equipment;
	  private int how_many_positions;
	  private int user_id;
	  private int ep_id;
	  private boolean visible;
	
	  
	  public JobPosting(int jp_id,
	  int work_type_id,
	  String work_type,
	  float estimated_cost,
	  java.util.Date date_posted,
	  String special_equipment,
	  int how_many_positions,
	  int user_id,
	  int ep_id,
	  boolean visible){
		  
		  this.jp_id = jp_id;
		  this.work_type_id = work_type_id;
		  this.work_type = work_type;
		  this.estimated_cost = estimated_cost;
		  this.date_posted = date_posted;
		  this.special_equipment = special_equipment;
		  this.how_many_positions = how_many_positions;
		  this.user_id =  user_id;
		  this.ep_id = ep_id;
		  this.visible = visible;
		  
		  
	  }


	public int getJp_id() {
		return jp_id;
	}


	public int getWork_type_id() {
		return work_type_id;
	}


	public String getWork_type() {
		return work_type;
	}


	public float getEstimated_cost() {
		return estimated_cost;
	}


	public java.util.Date getDate_posted() {
		return date_posted;
	}


	public String getSpecial_equipment() {
		return special_equipment;
	}


	public int getHow_many_positions() {
		return how_many_positions;
	}


	public int getUser_id() {
		return user_id;
	}


	public int getEp_id() {
		return ep_id;
	}


	public boolean isVisible() {
		return visible;
	}


	public void setJp_id(int jp_id) {
		this.jp_id = jp_id;
	}


	public void setWork_type_id(int work_type_id) {
		this.work_type_id = work_type_id;
	}


	public void setWork_type(String work_type) {
		this.work_type = work_type;
	}


	public void setEstimated_cost(float estimated_cost) {
		this.estimated_cost = estimated_cost;
	}


	public void setDate_posted(java.util.Date date_posted) {
		this.date_posted = date_posted;
	}


	public void setSpecial_equipment(String special_equipment) {
		this.special_equipment = special_equipment;
	}


	public void setHow_many_positions(int how_many_positions) {
		this.how_many_positions = how_many_positions;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public void setEp_id(int ep_id) {
		this.ep_id = ep_id;
	}


	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	  
	public boolean readyToCreate(){
		boolean is = true;
		  if(is && work_type_id<1 ){ is = false; System.out.println(" readytocreate FAIL work_type_id");}
		  if(is && (work_type==null || work_type.length()==1)){ is = false;  System.out.println(" readytocreate FAIL work_type"); }
		  if(is && estimated_cost<1 ){ is = false;  System.out.println(" readytocreate FAIL estimated_cost");}
		  if(is && date_posted==null){ is = false; 	System.out.println(" readytocreate FAIL date_posted");}
		  if(is && (special_equipment==null || special_equipment.length()==0)){ is = false;System.out.println(" readytocreate FAIL special_equipment"); }
		  if(is && how_many_positions<1){ is = false; System.out.println(" readytocreate FAIL how_many_positions");}
		  if(is && user_id<1){ is = false; System.out.println(" readytocreate FAIL user_id"); }
		  if(is && ep_id<1){ is = false; System.out.println(" readytocreate FAIL ep_id"); }
		return is;
	}
	
	public boolean createJobPosting(){
		boolean is = false;
		if(readyToCreate()){
			is = jto.obj.PostgresConnector.createJobPosting(this);
		}
		return is;
	}
	
}
