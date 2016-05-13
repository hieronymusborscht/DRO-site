package jto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jto.obj.PostgresConnector;

/**
 * Servlet implementation class ImageManager
 */
@WebServlet("/ImageManager")
public class ImageManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		jto.obj.ImageLibrary imglib = (jto.obj.ImageLibrary)request.getSession().getAttribute("imagelib");
		if(imglib==null){
			imglib = new jto.obj.ImageLibrary();
		}
		if( (request.getParameter("load_from")!=null) && (request.getParameter("load_from").length()>0 )){ 
			imglib.setLoad_from(Integer.parseInt(request.getParameter("load_from")));
		}
		
		java.util.ArrayList<UploadedImage> theUpImages = jto.obj.PostgresConnector.loadThumbsArray(imglib.getTheUpImages(), 9, imglib.getLoad_from());
  
        imglib.setTheUpImages(theUpImages);
		request.getSession().setAttribute("imagelib", imglib);
		request.getRequestDispatcher("imageslibrary.jsp").forward(request, response);
	}
	
	
	
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
