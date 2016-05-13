package jto.usr;

import java.io.ByteArrayInputStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

/**
 * Servlet implementation class UsrUploadReceiver
 */
@WebServlet("/UsrUploadReceiver")
public class UsrUploadReceiver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsrUploadReceiver() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		jto.usr.NewUser the_user = (jto.usr.NewUser)request.getSession().getAttribute("userbean");
		if(the_user==null){the_user = new jto.usr.NewUser(); }
		
		
		int sizeofthumb = 0;
		//int main_width = 400;
		int thumb_width=250;
		jto.UploadedImage upimg = (jto.UploadedImage)request.getSession().getAttribute("uploadedimg");
		if(upimg==null){
			upimg = new jto.UploadedImage();
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
						
						
						FileInputStream fin1 = (FileInputStream)fileItem.getInputStream();
						jto.obj.Resizzler r = new jto.obj.Resizzler();
			
						byte[] thumbimage  = r.resizeImageAsJPG(IOUtils.toByteArray(fin1), thumb_width);   
						sizeofthumb = thumbimage.length;
						ByteArrayInputStream thumb_in = new ByteArrayInputStream(thumbimage);
					
						/*
						System.out.println(thumb_in==null);
						System.out.println(fileItem.getName());
						System.out.println(fileItem.getContentType());
						System.out.println(thumb_width);
						System.out.println(sizeofthumb);
						System.out.println(the_user.getId());
						*/
						
						jto.obj.PostgresConnector.saveBytesToDatabase(thumb_in, fileItem.getName(), fileItem.getContentType(), thumb_width, sizeofthumb, the_user.getId());
							
						fin1.close();	
						
                    }catch(Exception e){
                    	sb.append("uplading went koo-koo "+e +"<br />");
                    }
					upimg.setFileName(fileItem.getName());
					upimg.setContentType(fileItem.getContentType());
					upimg.setSizeBytes(sizeofthumb);
				}
			}		
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("uploadedimg", upimg);
		request.getRequestDispatcher("usr_upl_response.jsp").forward(request, response);
	}

}
