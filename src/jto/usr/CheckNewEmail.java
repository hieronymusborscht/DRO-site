package jto.usr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jto.obj.PostgresConnector;

/**
 * Servlet implementation class CheckNewEmail
 */
@WebServlet("/CheckNewEmail")
public class CheckNewEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckNewEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		jto.usr.NewUser the_user = (jto.usr.NewUser)request.getSession().getAttribute("userbean");
		if(the_user==null){
			the_user = new jto.usr.NewUser();
		}
		the_user.resetMessage();
		
		
		String s = "&nbsp;";
		if( (request.getParameter("eml")!=null) && (request.getParameter("eml").length()>0 )){
			s = request.getParameter("eml");
			
			if(!PostgresConnector.checkEmailInUse(s)){
				the_user.setEmail_available(true);
				s = "email: <span style=\"color:green;\">"+s+"</span> available";
			}else{
				the_user.setEmail_available(false);
				s = "email: <span style=\"color:red;\">"+s+"</span> is already in use";
			}
		}
		request.getSession().setAttribute("userbean", the_user);
		response.getWriter().append(s);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
