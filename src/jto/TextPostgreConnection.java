package jto;



import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class TextPostgreConnection {
	
	
	private static Connection connection;

	public static void main(String[] args){
		connection = null;
		
		init();
		
	}
	
	
	

	
	
	public static void init() {

		System.out.println("-------- PostgreSQL  JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? Include in your library path!");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		

		try {
//"jdbc:postgresql://hostname:port/dbname","username", "password");
			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/testDataOne", 
					"postgres",
					"Saturn5"
					);

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}

	public static boolean createPages(){
		boolean b = false;
		try{
		Statement st = connection.createStatement();
			b = st.execute("insert into page ('parentid', 'label','title','visible') values ('0','products','products title','true')");
			/*
			rs.getInt("id")));
				mi.setRefid(rs.getString("parentid"));
				mi.setLabel(rs.getString("label"));
				mi.setTitle(rs.getString("title"));
				mi.setVisible(rs.getBoolean("visible"));
			 */
		}catch(Exception e){
			
			System.out.println("createPages "+ e);
		}
		return b;
	}
	
	
}
