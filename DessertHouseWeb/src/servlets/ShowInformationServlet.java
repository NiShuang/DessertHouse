package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;
import model.User;
import service.MemberService;
import service.UserService;

/**
 * Servlet implementation class ShowInformation
 */
@WebServlet("/ShowInformationServlet")
public class ShowInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB MemberService memberService;
	@EJB UserService userService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowInformationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		ServletContext context= getServletContext();
		HttpSession session = request.getSession(false);
		if(session==null||session.getAttribute("id")==null){
			context.getRequestDispatcher("/common/login.jsp").forward(request, response);
		}
		else{
			String id = (String) session.getAttribute("id");
			Member member = memberService.find(id);
			User user = userService.find(id);
			session.setAttribute("member", member);
			context.getRequestDispatcher("/customer/information.jsp").forward(request, response);
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
