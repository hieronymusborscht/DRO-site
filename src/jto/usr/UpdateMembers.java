package jto.usr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateMembers
 */
@WebServlet("/UpdateMembers")
public class UpdateMembers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMembers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		jto.obj.MemberList mem_list = (jto.obj.MemberList)request.getSession().getAttribute("memberlist");
		
		if(mem_list!=null){
		
			if( (request.getParameter("mems_vis")!=null) && (request.getParameter("mems_vis").length()>0 )){
				String s = request.getParameter("mems_vis");
				String[] s_arr = s.split(";");
				//jto.obj.PostgresConnector.setMemberVisibility(mem_list.setTheseMemsVisible(s_arr), s_arr);
				/*for(int i=0; i<s_arr.length; i++ ){
					System.out.println("["+s_arr[i]+"]");
				}*/
			}
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
