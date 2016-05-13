<%@ page import="java.sql.*" %>
<%
  // Read RDS connection information from the environment
  java.sql.Connection conn = null;
  String dbName = System.getProperty("RDS_DB_NAME");
  String userName = System.getProperty("RDS_USERNAME");
  String password = System.getProperty("RDS_PASSWORD");
  String hostname = System.getProperty("RDS_HOSTNAME");
  String port = System.getProperty("RDS_PORT");
  String jdbcUrl = "jdbc:postgresql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
  
  StringBuffer sb = new StringBuffer();
    
  out.print("["+dbName +"]<br />");
  out.print("["+userName +"]<br />");
  out.print("["+password +"]<br />");
  out.print("["+hostname +"]<br />");
  out.print("["+port +"]<br />");
  out.print("["+jdbcUrl +"]<br />");
  

  

  /*
  String jdbcUrl = "jdbc:mysql://" + hostname + ":" +
    port + "/" + dbName + "?user=" + userName + "&password=" + password;
  */
  
  // Load the JDBC driver
  try {
    out.println("Loading driver...<br />");
    Class.forName("org.postgresql.Driver");
  	out.println("Driver loaded!");
  } catch (ClassNotFoundException e) {
   sb.append("Cannot find the driver in the classpath! <br />");
   sb.append(e);
   sb.append("<br />");
  }
  

  
%>