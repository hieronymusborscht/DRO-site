package jto.util;

import java.util.ArrayList;
import java.util.Random;

public class TableSetupUtil {
	ArrayList<String> statements;
	
	public TableSetupUtil(){
		
		statements  = new ArrayList<String>();
		statements.add("drop table if exists content");
		statements.add("CREATE TABLE content ( id serial PRIMARY KEY not null,  title character varying(255), body text, visible boolean, userid integer, datecreated date, title_url character varying(255), has_title_url boolean, title_visible boolean)");
		statements.add("drop table if exists images");
		statements.add("CREATE TABLE images (id serial PRIMARY KEY not null,filename character varying(255) NOT NULL,  imgdata bytea, thumb_data bytea, width character varying(8), height character varying(8),t_width character varying(8), t_height character varying(8), type character varying(30))");
		statements.add("Drop table if exists page");
		statements.add("CREATE TABLE page ( id serial PRIMARY KEY not null,  parentid integer, label character varying(80), title character varying(255), visible boolean, sortorder integer, h1 character varying(255), desc character varying(255), categ integer DEFAULT 0)");
		statements.add("insert into page (parentid, label, title, visible, sortorder)  values ('0',	'Products',	'Products','t','1'), ('0',	'Contact Us',	'Contact Us title','t','2'),('0',	'Home', 'Royalty Group','t','0'), ('0',	'Members', 'Royalty Group','t','0')");
		statements.add("drop table if exists pagecontent");
		statements.add("CREATE TABLE pagecontent ( id serial PRIMARY KEY not null, pid integer NOT NULL, cid integer NOT NULL, uid integer NOT NULL, sortorder integer, location integer )");
		statements.add("drop table if exists members");
		statements.add("CREATE TABLE user (id serial PRIMARY KEY not null,img_id int not null default 0, first_name varchar(255) NOT NULL, last_name varchar(255) NOT NULL, email varchar(255) NOT NULL, pass_hash varchar(255) not null,role varchar(15) NOT NULL default 'basic',areas_serviced text, description text, salesforce_id varchar(255),datecreated date)");
		statements.add("drop table if exists users");
		statements.add("CREATE TABLE users (id serial PRIMARY KEY not null,img_id int not null default 0, first_name varchar(255) NOT NULL, last_name varchar(255) NOT NULL, email varchar(255) NOT NULL, pass_hash varchar(255) not null,role varchar(15) NOT NULL default 'basic',areas_serviced text, description text, salesforce_id varchar(255),datecreated date)");
		
	}

	public boolean makeTables(java.sql.Connection conn){
		/*try{
			java.sql.Statement setupStatement = conn.createStatement();
			for(int i=0; i<statements.size(); i++){
				setupStatement.addBatch(statements.get(i));
			}
		    setupStatement.executeBatch();
		    setupStatement.close();
		    conn.close();
		}catch(SQLException e){
			System.out.println("TableSetupUtil makeTables "+e);
		}
		*/
		return false;
	}
	
	public static String LipsumGenerator(){
	String[] paragraph = new String [5];
	
	paragraph[0]= "Sed hendrerit condimentum turpis, vitae aliquet justo ultricies ac. Maecenas erat mauris, mattis quis ligula nec, pellentesque condimentum dui. Pellentesque auctor porta auctor. In eu lacinia libero, vitae tincidunt lectus. Cras faucibus quam quis venenatis cursus. Donec dignissim lobortis mauris in maximus. Morbi mauris urna, placerat non dolor id, tempor commodo ligula. Cras non posuere diam, vel consectetur ipsum. Curabitur lorem nisi, ornare eget libero eget, porttitor mollis massa.";
	paragraph[1]= "Etiam et ipsum pharetra, pharetra diam a, tincidunt magna. Vivamus ultrices hendrerit dapibus. Integer quam ante, elementum non pulvinar quis, blandit in neque. Vestibulum eget hendrerit mi. Pellentesque nec lacus consectetur lorem volutpat sodales at at augue. Pellentesque quis urna sem. Sed gravida, odio nec euismod tristique, ante sem sodales ex, quis facilisis velit velit vel sem. Mauris tempus lectus at massa congue lobortis. Fusce malesuada mauris nec turpis imperdiet, a imperdiet elit varius. Quisque sit amet fringilla lorem. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae.";
	paragraph[2]= "Nulla ornare libero id arcu mattis, ac imperdiet ipsum posuere. Vestibulum tincidunt fermentum lectus, id eleifend metus lacinia nec. Ut vitae mollis justo, eget accumsan quam. Nullam vitae efficitur nisi. Vestibulum metus nisi, sollicitudin non nisl condimentum, lobortis hendrerit purus. Mauris eu sollicitudin sem. Cras in dignissim libero. Sed a lectus elit. Nulla non lorem pretium, vestibulum nunc at, semper arcu. Morbi vehicula lacus et dictum mattis. Quisque in porttitor ligula. Cras blandit elit et sem condimentum, id congue mi tempor. Cras egestas lacinia faucibus. Mauris bibendum, justo id facilisis feugiat, arcu nisl euismod nunc, nec placerat libero orci sit amet quam. Vivamus et facilisis dui. Vestibulum sit amet varius augue.";
	paragraph[3]= "Fusce venenatis dui dolor, sed varius arcu scelerisque ut. Nulla tincidunt urna egestas, cursus risus quis, vehicula nulla. Donec fringilla nisi vel metus ornare iaculis. In rhoncus fermentum lacus, in commodo ligula eleifend ut. Cras non ante quis tortor consectetur semper nec et mi. Nunc ultrices vulputate neque, at condimentum leo efficitur eget. Mauris eget quam id tellus pulvinar dictum nec a nunc. Integer blandit felis vel velit sagittis, et luctus nunc sodales. Cras quis convallis mi. Nullam ultrices posuere condimentum. Vestibulum a leo eget elit aliquet maximus. Curabitur lacinia lectus ante, sit amet volutpat ante rhoncus quis. Donec eget ligula imperdiet, elementum tortor eget, pharetra lectus.";
	paragraph[4]= "Vivamus condimentum rhoncus nulla, eget faucibus sem consequat quis. Ut euismod diam id porttitor suscipit. Vivamus vel mi non diam scelerisque tincidunt. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Cras lacinia dapibus condimentum. Suspendisse vel libero nec velit vestibulum lobortis. Pellentesque quis nulla venenatis, sagittis libero at, tempor tellus. Integer dictum ligula vel elit malesuada volutpat. In ut porttitor tellus, at dictum lacus. Sed finibus ex ut imperdiet sagittis. Nunc pulvinar turpis at purus tristique, id convallis risus bibendum.";
	Random rand = new Random(); 
		
	return paragraph[rand.nextInt(5)];
	}
	
}
