package jto;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewUserManager
 */
@WebServlet("/NewUserManager")
public class NewUserManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		if( (request.getParameter("first_name")!=null) && (request.getParameter("first_name").length()>0 )){ 
			//request.getParameter("first_name")
		}
		if( (request.getParameter("last_name")!=null) && (request.getParameter("last_name").length()>0 )){ 
			//request.getParameter("last_name")
		}
		if( (request.getParameter("mem_email")!=null) && (request.getParameter("mem_email").length()>0 )){ 
			//request.getParameter("mem_email")
		}
		if( (request.getParameter("mem_pass_a")!=null) && (request.getParameter("mem_pass_a").length()>0 )){ 
			//request.getParameter("mem_pass_a")
		}

		request.getRequestDispatcher("new_user_signup.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
