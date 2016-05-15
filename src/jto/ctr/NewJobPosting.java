package jto.ctr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewJobPosting
 */
@WebServlet("/NewJobPosting")
public class NewJobPosting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewJobPosting() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		jto.usr.NewUser the_user = (jto.usr.NewUser)request.getSession().getAttribute("userbean");
		if(the_user==null){the_user = new jto.usr.NewUser(); }
		
		jto.ctr.JobPostingState job_posting_state = (jto.ctr.JobPostingState)request.getSession().getAttribute("poting_state");
		if(job_posting_state==null){job_posting_state = new jto.ctr.JobPostingState(); }
		
		
		
		
		
		request.getSession().setAttribute("poting_state", job_posting_state);
		request.getSession().setAttribute("userbean", the_user);
		if(the_user.isLogged_in()){
			request.getRequestDispatcher("new_job_posting.jsp").forward(request, response);
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
