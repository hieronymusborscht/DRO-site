package jto.usr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean tos_agreed = false;
		boolean inserted =false;
		
		jto.usr.NewUser the_user = (jto.usr.NewUser)request.getSession().getAttribute("userbean");
		if(the_user==null){
			the_user = new jto.usr.NewUser();
		}
		
		if( (request.getParameter("first_name")!=null) && (request.getParameter("first_name").length()>0 )){
			the_user.setFirst_name(request.getParameter("first_name"));
		}
		if( (request.getParameter("last_name")!=null) && (request.getParameter("last_name").length()>0 )){
			the_user.setLast_name(request.getParameter("last_name"));
		}
		if( (request.getParameter("mem_email")!=null) && (request.getParameter("mem_email").length()>0 )){
			the_user.setEmail(request.getParameter("mem_email"));
		}
		if( (request.getParameter("mem_pass_a")!=null) && (request.getParameter("mem_pass_a").length()>0 )){
			the_user.setPass_a(request.getParameter("mem_pass_a"));
		}
	
		if( (request.getParameter("submit")!=null) && (request.getParameter("submit").length()>0 )){
	
				inserted = the_user.createNewUser();
				System.out.println("create new user : ["+inserted+"]");
	
		}
		
		
		request.getSession().setAttribute("userbean", the_user);
		if(inserted){
			request.getRequestDispatcher("Login").forward(request, response);
		}else{
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
