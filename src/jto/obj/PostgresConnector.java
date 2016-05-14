package jto.obj;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import jto.UploadedImage;
import jto.util.TableSetupUtil;


public class PostgresConnector {
	
	
	private static java.sql.Connection connection;
	

	private static PostgresConnector pgc = new PostgresConnector( );
	
	private PostgresConnector(){ }
	
	public static PostgresConnector getInstance( ) {      return pgc;}
	
	public static java.sql.Connection getConnection(){ 
		try {
			if(connection==null || connection.isClosed()){ connection=init();}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return connection;
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
	/*
	
	public static java.util.ArrayList<jto.usr.Member> loadMembers(){
		java.util.ArrayList<jto.usr.Member> members = new java.util.ArrayList<jto.usr.Member>();
		try{
			connection = getConnection();
			String updatestatement= "select id, img_id,first_name,last_name, email, role, areas_serviced, description, salesforce_id,datecreated, visible  from users where role in ('admin','basic')";
			PreparedStatement prepStmt = connection.prepareStatement(updatestatement);		
		
			ResultSet rs = prepStmt.executeQuery();
			while(rs.next()){
				jto.usr.Member m= new jto.usr.Member();	
				m.setId(rs.getInt("id")); 
				m.setImg_id(rs.getInt("img_id"));
				m.setFirst_name(rs.getString("first_name"));
				m.setLast_name(rs.getString("last_name")); 
				m.setEmail(rs.getString("email")); 
				m.setAcct_type(rs.getString("role"));
				m.setAreas_serviced(rs.getString("areas_serviced"));
				m.setDescription(rs.getString("description"));
				m.setSalesforce_id(rs.getString("salesforce_id"));
				//rs.getString("datecreated");
				m.setVisible(rs.getBoolean("visible"));
				members.add(m);	
			}
			connection.close();
		}catch(SQLException e){
			System.out.println("DataConnector.checkEmailInUse: "+e );
		}
		return members;
	}*/
	

	
	public static boolean checkEmailInUse(String email){
		boolean found=false;
		try{
			connection = getConnection();
			String updatestatement= "select first_name, last_name, email from users where email=? limit 1";
			PreparedStatement prepStmt = connection.prepareStatement(updatestatement);		
			prepStmt.setString(1, email);
			ResultSet rs = prepStmt.executeQuery();
			while(rs.next()){
					found=true;
					System.out.println("checkEmailInUse found email "+email);
			}
			connection.close();
		}catch(SQLException e){
			System.out.println("DataConnector.checkEmailInUse: "+e );
		}
	return found;
	}
	
	
	
	public static java.util.ArrayList<UploadedImage> loadThumbsArray(java.util.ArrayList<UploadedImage> theImages, int howmany, int load_from){		
		java.util.ArrayList<UploadedImage> theUpImages = new java.util.ArrayList<UploadedImage>();
        try {
            Connection  con =  PostgresConnector.init();
            PreparedStatement ps = null;
            if(load_from>0){
            	ps = con.prepareStatement("SELECT id,filename, thumb_data as data, type FROM images where id<? order by id desc limit ?");	
            	//System.out.println("SELECT id,filename, thumb_data as data, type FROM images where id<"+load_from+" order by id desc limit "+howmany);
            	ps.setInt(1, load_from);
            	ps.setInt(2, howmany);
            }else{
            	ps = con.prepareStatement("SELECT id,filename, thumb_data as data, type FROM images order by id desc limit ?");
            	//System.out.println("SELECT id,filename, thumb_data as data, type FROM images order by id desc limit "+howmany);
            	ps.setInt(1, howmany);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	UploadedImage ui = new UploadedImage();
            	ui.setThedata(rs.getBytes("data"));
            	ui.setId(rs.getInt("id"));
            	theUpImages.add(ui);
            }
            if(theUpImages.size()==0){
            	//System.out.println(" loadThumbsArray returned null ");
            	theUpImages = theImages;
            }
            
            rs.close();
            ps.close();
        } catch (Exception e) {
        	System.out.println(e);
        }
		return theUpImages;
	}
	





	private static java.sql.Connection init(){
		java.sql.Connection connection = null;

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {	
			connection = DriverManager.getConnection(
					/*
					"jdbc:postgresql://aa1w2fh7xu35vbl.cngclcqagnfu.us-west-2.rds.amazonaws.com:5432/ebdb?user=rgrsiteuser&password=shadrach99"
					);
						*/
			//System.out.println("this is a test");
					
					"jdbc:postgresql://127.0.0.1:5432/testDataOne", 
					"postgres",
					"Saturn5"
					);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		if (connection == null) {
			System.out.println("Failed to make connection!\n");
		}
		return connection;
	}


	

	
	
	
	
	
	public static byte [] ImageToByte(File file) throws FileNotFoundException{
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);      
                System.out.println("read " + readNum + " bytes,");
            }
        } catch (IOException ex) {
        }
        byte[] bytes = bos.toByteArray();
     return bytes; 
    }
	public void saveImageToDatabase(FileInputStream fin, String filename, String filetype, int length){
		try{
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO images (filename,type, imgdata )VALUES (?, ?, ?)");
			ps.setString(1, filename);
			ps.setString(2, filetype);
			ps.setBinaryStream(3, fin, length);
			ps.executeUpdate();
			ps.close();
			fin.close();
			connection.close();
		}catch(Exception e){}
	}
	public static void saveBytesToDatabase(ByteArrayInputStream bin, String filename, String filetype,int width, int length,int user_id){
		//System.out.println("saveBytesToDatabase");
		
		try{
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO images (filename,type,width, imgdata, user_id )VALUES (?, ?,?, ?,?)");
			ps.setString(1, filename);
			ps.setString(2, filetype);
			ps.setString(3, ""+width);
			ps.setBinaryStream(4, bin, length);
			ps.setInt(5, user_id);
			ps.executeUpdate();
			ps.close();
			bin.close();
			
			
			
			connection.close();
		}catch(Exception e){}
	}
	public static void saveBothToDatabase(FileInputStream fin, ByteArrayInputStream thumbimage, String filename, String filetype, int mainlength, int thumblength, int width,  int thumb_width){
		try{
			Connection connection = init();										//    1       2      3           4              
			PreparedStatement ps = connection.prepareStatement("INSERT INTO images (filename, type, imgdata, thumb_data, t_width )VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, filename);
			ps.setString(2, filetype);
			ps.setBinaryStream(3, fin,  mainlength);
			ps.setBinaryStream(4, thumbimage,  thumblength);
			ps.setInt(5, thumb_width);
			ps.executeUpdate();
			ps.close();
			thumbimage.close();
			fin.close();
			connection.close();
		}catch(Exception e){
			System.out.println("saveboth blew up "+e);
		}
	}
	public static void resizeBothToDatabase(ByteArrayInputStream fin, ByteArrayInputStream thumbimage, String filename, String filetype, int mainlength, int thumblength, int width,  int thumb_width){
		try{
			Connection connection = init();										//    1       2      3           4              
			PreparedStatement ps = connection.prepareStatement("INSERT INTO images (filename, type, imgdata, thumb_data,width, t_width )VALUES (?, ?, ?, ?, ?, ?)");
			ps.setString(1, filename);
			ps.setString(2, filetype);
			ps.setBinaryStream(3, fin,  mainlength);
			ps.setBinaryStream(4, thumbimage,  thumblength);
			ps.setInt(5, width);
			ps.setInt(6, thumb_width);
			ps.executeUpdate();
			ps.close();
			thumbimage.close();
			fin.close();
			connection.close();
		}catch(Exception e){
			System.out.println("resizeboth blew up "+e);
		}
	}

	
	public static int setUsrImg(int user_id, String image_name){
		int image_id=0;
		//select id from images where filename='vbourget1.jpeg' and user_id=1 order by id desc limit 1
				try{
					//int image_id=0;
					connection = getConnection();
					PreparedStatement prepStmt = connection.prepareStatement("select id from images where filename=? and user_id=? order by id desc limit 1");
					PreparedStatement prepStmt1 = connection.prepareStatement("update users set img_id=? where id=?");
					prepStmt.setString(1, image_name);
					prepStmt.setInt(2, user_id);
					prepStmt1.setInt(2, user_id);
					ResultSet rs = prepStmt.executeQuery();
					while(rs.next()){
						image_id=rs.getInt("id");
					}
					prepStmt1.setInt(1, image_id);
					prepStmt1.execute();
					//connection.commit();
					connection.close();
				}catch(SQLException e){
					System.out.println("PostgresConnector.SetUserImg "+e);
				}
				return image_id;
	}
	
	
	
	public static jto.UploadedImage loadImage(int image_id, boolean is_thumb){
		jto.UploadedImage ul=null;
		try{
			StringBuffer sb = new StringBuffer();
			Connection connection = init();
			PreparedStatement prepStmt = null;
			sb.append("SELECT id, filename, ");
			if(is_thumb){
				sb.append("thumb_data as imgdata");
			}else if(!is_thumb){
				sb.append("imgdata");
			}
			sb.append(", t_width, type FROM images");
			if(image_id>0){
				sb.append(" WHERE id=?");
			}else if(image_id<1){
				sb.append(" order by id desc");
			}
			sb.append(" limit 1");
			//System.out.println(sb.toString());
			prepStmt = connection.prepareStatement(sb.toString());	
			if(image_id>0){
				prepStmt.setInt(1, image_id);
			}
			ResultSet rs = prepStmt.executeQuery();
			while(rs.next()){
				ul = new jto.UploadedImage();
				ul.setId(rs.getInt("id"));
				ul.setFileName(rs.getString("filename"));
				ul.setThedata(rs.getBytes("imgdata"));
				ul.setWidth(rs.getInt("t_width"));
				ul.setContentType(rs.getString("type"));
				//imagesArray.add(ul);
			}
			connection.close();
		}catch(SQLException e){
			System.out.println("makeContentPage "+e);
		}
		return ul;
	}
	
	
	public static void updateUser(jto.usr.NewUser user){
		
		try{
			
			String s = "update users set first_name=?, last_name=?, email=?,phone=?, role=?, description=? where id=?";		
			java.sql.Connection connection = jto.obj.PostgresConnector.getConnection();
			
			
			
			PreparedStatement prepStmt = connection.prepareStatement(s);
			prepStmt.setString(1, user.getFirst_name());
			prepStmt.setString(2, user.getLast_name()); 
			prepStmt.setString(3, user.getEmail());
			prepStmt.setString(4, user.getPhone());
			prepStmt.setString(5, user.getAcct_type());
			prepStmt.setString(6, user.getDescription()); 
			prepStmt.setInt(7, user.getId());
			
			prepStmt.execute();
			
			connection.close();
		}catch(SQLException e){
			System.out.println(e);
		}
	}
	
	
	public static jto.usr.NewUser tryLogin(String email, String pass){
		jto.usr.NewUser user = new jto.usr.NewUser();
		
		try{
			connection = getConnection();
	
			PreparedStatement prepStmt = connection.prepareStatement("select id, first_name, last_name, email,phone, role,  description,  pass_hash, img_id from users where email=?");
			prepStmt.setString(1, email);
			ResultSet rs = prepStmt.executeQuery();
			while(rs.next()){
				//System.out.println("record found");
				user.setFirst_name(rs.getString("first_name"));
				user.setLast_name(rs.getString("last_name"));
				user.setImg_id(rs.getInt("img_id"));
				if(pass!=null){
					user.setLogged_in(jto.util.PasswordHash.validatePassword(pass, rs.getString("pass_hash")));
				}
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setId(rs.getInt("id"));
				user.setAcct_type(rs.getString("role")); 			
				user.setDescription(rs.getString("description")); 
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public static boolean updatePassword(String email, String old_pass, String new_pass_hash){
		boolean is_true = false;
		try{
			connection = getConnection();
			PreparedStatement prepStmt = connection.prepareStatement("select id, first_name, last_name, email,phone, role,  description,  pass_hash, img_id from users where email=?");
			prepStmt.setString(1, email);
			ResultSet rs = prepStmt.executeQuery();
			while(rs.next()){
				if(old_pass!=null){
					is_true = jto.util.PasswordHash.validatePassword(old_pass, rs.getString("pass_hash"));
					//System.out.println("A is_true"+is_true);
				}
			}
			if(is_true){
				//System.out.println("B is_true"+is_true);
				prepStmt = connection.prepareStatement("update users set pass_hash=? where email=?");
				prepStmt.setString(1, new_pass_hash);
				prepStmt.setString(2, email);
				prepStmt.execute();
				//System.out.println("C is_true"+is_true);
				//System.out.println("password update statement result ["+is_true+"]");
				//System.out.println("update users set pass_hash=? where email=?");
				//System.out.println(new_pass_hash);
				//System.out.println(email);
			}
		}catch(SQLException e){
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		//System.out.println("about to return is_true"+is_true);
		return is_true;
	}
	
	
	
	
}