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

import model.PlanItem;
import service.MemberService;
import service.PlanItemService;

/**
 * Servlet implementation class ReserveServlet
 */
@WebServlet("/ShowOneReserveServlet")
public class ShowOneReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB PlanItemService planItemService;
	@EJB MemberService memberService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOneReserveServlet() {
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
			String member = (String) session.getAttribute("id");
			double discount = memberService.getDiscount(member);
			int id = Integer.parseInt(request.getParameter("id"));
			PlanItem planItem = planItemService.find(id);
			request.setAttribute("planItem", planItem);
			request.setAttribute("discount", discount);
			context.getRequestDispatcher("/customer/reserve.jsp").forward(request, response);
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
