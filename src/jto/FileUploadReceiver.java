package jto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/FileUploadReceiver")
public class FileUploadReceiver extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private static final String UPLOAD_DIRECTORY = "/Users/john/scratch";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadReceiver() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doPost(request, response);
		response.setContentType("text/html");
		response.getWriter().append("no upload to process<br /><br /> go to <a href=\"ImgUploadManager\">upload</a> page");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int main_width = 400;
		int thumb_width=150;
		jto.UploadedImage upimg = (jto.UploadedImage)request.getSession().getAttribute("uploadedimg");
		if(upimg==null){
			upimg = new jto.UploadedImage();
		}
		if( (request.getParameter("resize")!=null) && (request.getParameter("resize").length()>0 )){
			main_width = Integer.parseInt(request.getParameter("resize"));
		}
		StringBuffer sb = new StringBuffer();
		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		if (!isMultipartContent) {
			sb.append("Something has gone even wronger<br/>");
			return;
		}
	
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> fields = upload.parseRequest(request);
			Iterator<FileItem> it = fields.iterator();
			if (!it.hasNext()) {
				sb.append("No fields found<br />");
				return;
			}
			
			while (it.hasNext()) {
				FileItem fileItem = it.next();
				boolean isFormField = fileItem.isFormField();
				if (!isFormField) {		
					try{		
						int size = (int)fileItem.getSize();
						FileInputStream fin = (FileInputStream)fileItem.getInputStream();	
						FileInputStream fin1 = (FileInputStream)fileItem.getInputStream();

						//#################################  Do the resizing here
						jto.obj.Resizzler r = new jto.obj.Resizzler();
			
						byte[] thumbimage  = r.resizeImageAsJPG(IOUtils.toByteArray(fin1), thumb_width);   
						int sizeofthumb = thumbimage.length;
						ByteArrayInputStream thumb_in = new ByteArrayInputStream(thumbimage);
						if(main_width>0){
							
							byte[] mainimage  = r.resizeImageAsJPG(IOUtils.toByteArray(fin), main_width);   
							int sizeofmain = mainimage.length;
							ByteArrayInputStream main_in = new ByteArrayInputStream(mainimage);	
							
							//jto.obj.PostgresConnector pgc = new jto.obj.PostgresConnector();
							jto.obj.PostgresConnector.resizeBothToDatabase(main_in, thumb_in, fileItem.getName(), "image/jpeg", sizeofmain, sizeofthumb, main_width,  thumb_width);	
							fin.close();	
							
						}else{
							// ONLY resize the thumbnail - leave main image at uploaded size
							//jto.obj.PostgresConnector pgc = new jto.obj.PostgresConnector();
							jto.obj.PostgresConnector.saveBothToDatabase(fin, thumb_in, fileItem.getName(), fileItem.getContentType(), size, sizeofthumb, 600,  200);	
	                    	fin.close();						
						}
                    }catch(Exception e){
                    	sb.append("uplading went koo-koo "+e +"<br />");
                    }
					upimg.setFileName(fileItem.getName());
					upimg.setContentType("image/jpeg");
					upimg.setSizeBytes((int)fileItem.getSize());
				}
			}		
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	
		request.getSession().setAttribute("uploadedimg", upimg);
		request.getRequestDispatcher("uploadResponse.jsp").forward(request, response);
	}

	

}
