package jto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jto.obj.PostgresConnector;

import java.sql.*;

/**
 * Servlet implementation class DisplayImage
 */
@WebServlet("/DisplayImage")
public class DisplayImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayImage() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	boolean load_thumb = false;
    	int image_id = 0;
    	if( (request.getParameter("i")!=null) && (request.getParameter("i").length()>0 )){	
    		try{
    			image_id = Integer.parseInt(request.getParameter("i"));    			
    		}catch(Exception e){
    			System.out.println("error "+e);
    		}
	    }
    	if( (request.getParameter("t")!=null) && (request.getParameter("t").length()>0 )){	
    		if(request.getParameter("t").equals("t")){
    			load_thumb = true;
    		}
    	}
     
        jto.UploadedImage ui = jto.obj.PostgresConnector.loadImage(image_id, load_thumb);
           
        response.setContentType(ui.getContentType());
        response.setContentLength(ui.getLength());
        response.getOutputStream().write(ui.getThedata());
        response.getOutputStream().flush();
        response.getOutputStream().close(); 
 
    }
    
    
    
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
