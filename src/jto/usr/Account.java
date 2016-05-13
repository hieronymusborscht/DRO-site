package jto.usr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserAdmin
 */
@WebServlet("/Account")
public class Account extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Account() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean do_update=false;
		
		jto.usr.NewUser the_user = (jto.usr.NewUser)request.getSession().getAttribute("userbean");
		
		if(the_user==null){the_user = new jto.usr.NewUser(); }
		
		
		if( (request.getParameter("first_name")!=null) && (request.getParameter("first_name").length()>0 )){
			the_user.setFirst_name(request.getParameter("first_name")); do_update=true;
		}
		if( (request.getParameter("last_name")!=null) && (request.getParameter("last_name").length()>0 )){
			the_user.setLast_name(request.getParameter("last_name")); do_update=true;
		}
		if( (request.getParameter("email")!=null) && (request.getParameter("email").length()>0 )){
			the_user.setEmail(request.getParameter("email"));do_update=true;
		}
		if( (request.getParameter("phone")!=null) && (request.getParameter("phone").length()>0 )){
			the_user.setPhone(request.getParameter("phone"));do_update=true;
		}
		if( (request.getParameter("acct_type")!=null) && (request.getParameter("acct_type").length()>0)){
			the_user.setAcct_type(request.getParameter("acct_type")); do_update=true;
		}
		if( (request.getParameter("set_img")!=null) && (request.getParameter("set_img").length()>0)){
			//the_user.setImg(request.getParameter("set_img"));
			the_user.setImg_id(jto.obj.PostgresConnector.setUsrImg(the_user.getId(), request.getParameter("set_img")));
		}
		if( (request.getParameter("description")!=null) && (request.getParameter("description").length()>0)){
			the_user.setDescription(request.getParameter("description"));
		}
		
		if( (request.getParameter("area")!=null) && (request.getParameter("area").length()>0)){
			String[] results = request.getParameterValues("area");
			//StringBuffer areas= new StringBuffer();
			//for (int i = 0; i < results.length; i++) {
			//	areas.append(results[i]); 
			//	if(i< results.length-1){
			//		areas.append(",");
			//	}
			//}
			do_update=true;
			the_user.setAreas_serviced_arr(results);
		}
		
		
		if(do_update){
			the_user.updateUser();
		}
		
		request.getSession().setAttribute("userbean", the_user);
		if(the_user.isLogged_in()){
			request.getRequestDispatcher("user_admin.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("Login").forward(request, response);
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
