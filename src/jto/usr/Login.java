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
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		jto.usr.NewUser the_user = (jto.usr.NewUser)request.getSession().getAttribute("userbean");
		if(the_user==null){the_user = new jto.usr.NewUser(); }
		
		if( (request.getParameter("lo")!=null) && (request.getParameter("lo").length()>0 )){
			the_user.LogOut();
		}
		
		if( (request.getParameter("email")!=null) && (request.getParameter("email").length()>0 )){
			the_user.setEmail(request.getParameter("email"));
		}
		if( (request.getParameter("password")!=null) && (request.getParameter("password").length()>0 )){
			the_user.setPass(request.getParameter("password"));
		}
		if( (request.getParameter("login")!=null) && (request.getParameter("login").length()>0 )){
			the_user.tryLogin();
		}
		
		request.getSession().setAttribute("userbean", the_user);
		if(the_user.isLogged_in()){
			request.getRequestDispatcher("Admin").forward(request, response);
		}else{
			request.getRequestDispatcher("login.jsp").forward(request, response);
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
