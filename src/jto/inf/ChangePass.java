package jto.inf;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangePass
 */
@WebServlet("/ChangePass")
public class ChangePass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		jto.usr.NewUser the_user = (jto.usr.NewUser)request.getSession().getAttribute("userbean");
		if(the_user==null){the_user = new jto.usr.NewUser(); }
		boolean success = false;
		//old_pass
		//new_pass_a
		
		if( (request.getParameter("new_pass_a")!=null) && (request.getParameter("new_pass_a").length()>0 )){
			if( (request.getParameter("old_pass")!=null) && (request.getParameter("old_pass").length()>0 )){
				success = the_user.changePassword(request.getParameter("new_pass_a"),request.getParameter("new_pass_a"));
			}
		}
		
		//new_pass_b
		
		
		
		request.getSession().setAttribute("userbean", the_user);
		request.getRequestDispatcher("change_pass.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
