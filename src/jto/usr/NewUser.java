package jto.usr;





import java.sql.PreparedStatement;
import java.sql.SQLException;


public class NewUser extends Member{

	//private String pass;
	//private String pass_hash;
	private boolean failed_login;
	
	/** public constructor */
	public NewUser(){
		setId(0);
		setLogged_in(false);
		failed_login=false;
	}
	public void setLogged_in(boolean logged_in) {
		this.logged_in = logged_in;
		if(!logged_in){
			failed_login=true;
		}
	}
	
	public boolean getFailed_login(){
		return failed_login;
	}
	public void setFailed_login(boolean is_true){
		failed_login = is_true;
	}
	

	public String getAcctTypeOptions(){
		String[] acct_types = {"basic","Employer","Contractor"};
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<acct_types.length; i++){
			sb.append("<option ");
			sb.append(" value=\"");
			sb.append(acct_types[i]);
			sb.append("\" ");
			if(acct_type.equals(acct_types[i])){
				sb.append(" selected=\"selected\" ");
			}
			sb.append(">");
			sb.append(acct_types[i]);
			sb.append("</option>\n");
		}
		return sb.toString();
	}
	
	
	

		
	//public String
	

	
	public void LogOut(){
		setLogged_in(false);
		setId(0);
		setEmail("");
		setFirst_name("");
		setLast_name("");
		pass_a_hash="";
	}
	public void updateUser(){
		
		
		System.out.print("first_name==null "); System.out.println(first_name==null);
		System.out.print("last_name==null ");System.out.println(last_name==null);
		System.out.print("email==null ");System.out.println(email==null);
		System.out.print("phone==null ");System.out.println(phone==null);
		System.out.print("acct_type==null ");System.out.println(acct_type==null);
		System.out.print("description==null ");System.out.println(description==null);
			
		if(first_name!=null && last_name!=null && email!=null && acct_type!=null && description!=null && phone!=null && id>0 ){
			//stry{
				
				//String s = "update users set first_name=?, last_name=?, email=?,phone=?, role=?, description=? where id=?";		
				//java.sql.Connection connection = jto.obj.PostgresConnector.getConnection();
				
				jto.obj.PostgresConnector.updateUser(this);
				
				//PreparedStatement prepStmt = connection.prepareStatement(s);
				//prepStmt.setString(1, first_name);
				//prepStmt.setString(2, last_name); 
				//prepStmt.setString(3, email);
				//prepStmt.setString(4, phone);
				//prepStmt.setString(5, acct_type);
				//prepStmt.setString(6, description); 
				//prepStmt.setInt(7, id);
				
				//prepStmt.execute();
				
				//connection.close();
			//}catch(SQLException e){	System.out.println(e);}
		}  // stuff was null
	}
	
	
	public boolean changePassword(String old_pass, String new_pass){
		boolean is = false;
		setPass_a(new_pass);
		is = jto.obj.PostgresConnector.updatePassword(getEmail(), old_pass,  getPass_a_hash());	
		return is;
	}
	public boolean resetPassword(String email){
		boolean is = false;
		
		System.out.println("resetPassword called");
		setPass_a(jto.util.RandomThing.getString(8));
		is = jto.obj.PostgresConnector.resetPassword(getEmail(),  getPass_a_hash());
		
		
		return is;
	}
	
	
	
	
	


	public boolean createNewUser(){
		boolean is = false;
		message= new StringBuffer();
		pass_a=null;
		if(!email_available){
			message.append("<span style=\"color:red\">Sign-up failed. Chosen email address is already in use</span><br />");
			return is;
		}
		if(first_name==null || first_name.length()==0){
			message.append("<span style=\"color:red\">Sign-up failed. First Name is blank</span><br />");
			return is;
		}
		if(last_name==null || last_name.length()==0){
			message.append("<span style=\"color:red\">Sign-up failed. Last Name is blank</span><br />");
			return is;
		}
		if(email==null || email.length()==0){
			message.append("<span style=\"color:red\">Sign-up failed. Email is blank</span><br />");
			return is;
		}
		if(pass_a_hash==null || pass_a_hash.length()==0){
			message.append("<span style=\"color:red\">Sign-up failed. Password is blank</span><br />");
			return is;
		}
		try{
			java.sql.Connection connection = jto.obj.PostgresConnector.getConnection();
			PreparedStatement prepStmt = connection.prepareStatement("insert into users (first_name,last_name,email,pass_hash,datecreated) values (?,?,?,?,now())");		
			prepStmt.setString(1, first_name);
			prepStmt.setString(2, last_name);
			prepStmt.setString(3, email);
			prepStmt.setString(4, pass_a_hash);
			prepStmt.execute();
			is=true;
			//connection.commit();
			connection.close();
		}catch(SQLException e){
			is=false;
			System.out.println(e);
		}
		return is;
	}
	public void setPass(String s ){
		pass_a=s;
	}
	public String getPass(){
		String s = "";
		if(pass_a!=null){
			s=pass_a;
		}
		return s +"&nbsp;<a href=\"Login\">return to login</a>";
	}

	public boolean isLogged_in() {
		return logged_in;
	}


	

}
