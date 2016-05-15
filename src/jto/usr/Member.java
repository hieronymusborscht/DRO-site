package jto.usr;

public class Member {

	protected StringBuffer message;
	protected int id;
	protected boolean logged_in;
	protected boolean email_available;
	protected String first_name;
	protected String last_name;
	protected String email;
	protected String phone;
	protected String pass_a;
	protected String pass_a_hash;
	protected String acct_type;
	protected int img_id;
	protected boolean visible;


	protected String areas_serviced[];
	protected String description;

	protected String salesforce_id;
	protected java.util.HashMap<String, String> areas_map;
	
	
	public Member(){message = new StringBuffer();}
	
	
	public String getAcct_type() {return acct_type; }
	/*private String getAcct_type_opt(){
		return "<option value=\"+acct_type+\" selected=\"selected\" >"+acct_type+"</option>";	
	}*/
	
	public void setVisible(boolean t){
		visible=t;
	}
	public boolean getVisible(){
		return visible;
	}
	public void setAcct_type(String s) {
		acct_type = s;
	}

	public void setFirst_name(String s) {
		first_name = s;
	}
	public void setLast_name(String s) {
		last_name = s;
	}
	public void setEmail(String s) {
		email = s;
	}
	public void setPhone(String s) {
		phone = s;
	}
	protected void setPass_a(String s) {
		pass_a=s;
		setPass_a_hash(s);
	}
	private void setPass_a_hash(String s) {
		try{
			pass_a_hash = jto.util.PasswordHash.createHash(s);
		}catch(Exception e){e.printStackTrace();}
	}

	

	
	public void setDescription(String s){
		description = s;
	}


	public void resetMessage(){
		message= new StringBuffer();
	}
	public void setId(int i ){
		id=i;
	}
	public int getImg_id(){
		return img_id;
	}
	public void setImg_id(int i){
		img_id=i;
	}
	public String getDescription(){
		if(description==null){ description="";}
		return description;
	}
	public void setEmail_available(boolean b){
		email_available = b;
	}
	public String getMessage(){
		return message.toString();
	}
	public String getFirst_name() {
		if(first_name==null){return "";}else{
		return first_name;
		}
	}
	public String getLast_name() {
		if(last_name==null){ return "";}else{
		return last_name;
		}
	}
	public String getEmail() {
		if(email==null){return "";}else{
			return email;
		}
	}
	public String getPhone() {
		if(phone==null){return "";}else{
			return phone;
		}
	}
	public int getId(){
		return id;
	}
	public String getPass_a_hash(){
		return pass_a_hash;
	}

}
