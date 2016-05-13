package jto;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayImage
 */
@WebServlet("/DisplayThumb")
public class DisplayThumb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayThumb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	jto.obj.ImageLibrary imglib = (jto.obj.ImageLibrary)request.getSession().getAttribute("imagelib");
    	int img_id = 0;
    	if( (request.getParameter("i")!=null) && (request.getParameter("i").length()>0 )){
    		img_id = Integer.parseInt(request.getParameter("i"));
    		System.out.println("thumb image = "+img_id);
    	}
    
       // byte[] here = imglib.getBytes();
       // byte[] here = thethumbnails.get(0);
        //byte[] here = imglib.getOneThumb(0);
        
        jto.UploadedImage ui = imglib.getOneUpImage(img_id);
        
        byte[] here = ui.getThedata();
        
        response.setContentType("image/jpeg");
        response.setContentLength(here.length);
        response.getOutputStream().write(here);
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
