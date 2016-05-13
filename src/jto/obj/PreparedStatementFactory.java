package jto.obj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementFactory {

	
	
	protected static PreparedStatement doLoadMenu(Connection connection, boolean load_invisible) throws SQLException{
		StringBuffer sb = new StringBuffer();
		sb.append("select id, parentid,label,title, visible,sortorder from page");
		if(load_invisible){
			sb.append(" where visible='true'");
		}
		sb.append(" order by sortorder");	
		PreparedStatement prepStmt = connection.prepareStatement(sb.toString());
		return prepStmt;
	}
	protected static PreparedStatement doLoadSingleContent(Connection connection, int cont_id) throws SQLException{
		String updatestatement= "select content.id as cid,  content.title as title, content.body as body,content.visible,content.datecreated  from content where content.id=?";
		PreparedStatement prepStmt = connection.prepareStatement(updatestatement);		
		prepStmt.setInt(1, cont_id);
		return prepStmt;
	}
	/*
	protected static PreparedStatement doLoadPageContent(Connection connection, int page_id) throws SQLException{
		String updatestatement= "select pagecontent.id as pc_id, content.id as cid, content.title as title, content.body as body,content.visible,content.datecreated,  pagecontent.location as location from content, pagecontent where cid=content.id and pid=?";
		PreparedStatement prepStmt = connection.prepareStatement(updatestatement);		
		prepStmt.setInt(1, page_id);
		return prepStmt;
	}*/
	
}



