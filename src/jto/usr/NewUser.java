package jto.usr;

import java.security.NoSuchAlgorithmException;

import java.security.spec.InvalidKeySpecException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class NewUser extends Member{

	private String pass;
	private String pass_hash;
	
	/** public constructor */
	public NewUser(){
		setId(0);
		setLogged_in(false);

	}
	
	
	
	public String getAreasTranslatorRegex(){
		StringBuffer sb = new StringBuffer();
		Iterator<Entry<String, String>> it = areas_map.entrySet().iterator();
		sb.append("function replace_area(str){\n");
		while (it.hasNext()) {
			HashMap.Entry<String, String> pair = (HashMap.Entry<String, String>)it.next();			
			sb.append("	str= str.replace(/");
			sb.append(pair.getValue());
			sb.append("/,\"");//VCQ
			sb.append(pair.getKey());
			sb.append("\"); \n");
		}
		sb.append(" return str.trim(); \n}");
		return sb.toString();
	}
	
	
	
	public String getAreas_map_pairs(){
		
		StringBuffer sb = new StringBuffer();
		if(areas_map!=null && areas_map.size()>0){
			Iterator<Entry<String, String>> it = areas_map.entrySet().iterator();
			while (it.hasNext()) {
				HashMap.Entry<String, String> pair = (HashMap.Entry<String, String>)it.next();
				sb.append("<tr>\n<td><input type=\"checkbox\" ");
				sb.append(" name=\"area\" value=\""); 
				sb.append(pair.getKey());  // pair.getValue()
				sb.append("\"");
				if(areas_serviced!=null && areas_serviced.length>0){
					for(int j =0; j<areas_serviced.length; j++){
						if(areas_serviced[j].trim().equals(pair.getKey())){
							sb.append(" checked=\"checked\""); 
						}	}
				}
				sb.append(" onchange=\"checkboxes()\" /><label>"); //downtown
				sb.append(pair.getKey());
				sb.append("</label></td>\n</tr>\n");
			}
		}
		return sb.toString();
	}
		
	
	
	
	public String getAreas_map(){
		java.util.AbstractSet<String> aset = (java.util.AbstractSet<String>)areas_map.keySet();
		String[] sarr= aset.toArray(new String[aset.size()]);
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<sarr.length; i++){
			sb.append("<tr><td><input type=\"checkbox\" ");
			sb.append(" name=\"area\" value=\""); //downtown
			sb.append(sarr[i]);
			sb.append("\""); 
			//for(int j =0; j<areas_serviced.length; j++){
				//if(areas_serviced[j].trim().equals(sarr[i].trim())){
				//	sb.append(" checked=\"checked\""); 
				//}
			//}
			sb.append(" onchange=\"checkboxes()\" /><label>"); //downtown
			sb.append(sarr[i]);
			sb.append("</label></td></tr>\n");
		}
		return sb.toString();
	}
		
	//public String
	

	public boolean tryLogin(){
		//System.out.println("trylogin");
		boolean is = false;
		if(email==null || email.length()==0){ 
			//System.out.println("fail on email");
			return is;	
		}
		if(pass==null || pass.length()==0){
		//if(pass_a_hash==null || pass_a_hash.length()==0){ 
			//System.out.println("fail on pass");
			return is;
		}
		try{
			java.sql.Connection connection = jto.obj.PostgresConnector.getConnection();
			PreparedStatement prepStmt = connection.prepareStatement("select id, first_name, last_name, email,phone, role,  description,  pass_hash, img_id from users where email=?");
			prepStmt.setString(1, email);
			//System.out.println("this line reached 111-a");
			ResultSet rs = prepStmt.executeQuery();
			while(rs.next()){
				System.out.println("found record");
				setFirst_name(rs.getString("first_name"));
				setLast_name(rs.getString("last_name"));
				setImg_id(rs.getInt("img_id"));
				if(pass!=null){
					setLogged_in(jto.util.PasswordHash.validatePassword(pass, rs.getString("pass_hash")));
				}
				setEmail(rs.getString("email"));
				setPhone(rs.getString("phone"));
				setId(rs.getInt("id"));
				setAcct_type(rs.getString("role")); 
				//setAreas_serviced(rs.getString("areas_serviced")); 
				setDescription(rs.getString("description")); 
				//rs.getString("salesforce_id");
				
			}
		}catch(SQLException e){
			is=false;
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return is;
	}
	
	public void LogOut(){
		setLogged_in(false);
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
			try{
				System.out.println("this line reached BBB");
				String s = "update users set first_name=?, last_name=?, email=?,phone=?, role=?, description=? where id=?";		
				java.sql.Connection connection = jto.obj.PostgresConnector.getConnection();
				PreparedStatement prepStmt = connection.prepareStatement(s);
				prepStmt.setString(1, first_name);
				prepStmt.setString(2, last_name); 
				prepStmt.setString(3, email);
				prepStmt.setString(4, phone);
				prepStmt.setString(5, acct_type);
				prepStmt.setString(6, description); 
				prepStmt.setInt(7, id);
				
				prepStmt.execute();
				
				connection.close();
			}catch(SQLException e){
				System.out.println(e);
			}
		}  // stuff was null
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
			connection.commit();
			connection.close();
		}catch(SQLException e){
			is=false;
			System.out.println(e);
		}
		return is;
	}
	public void setPass(String s ){
		pass=s;
	}
	

	public boolean isLogged_in() {
		return logged_in;
	}


	

}
