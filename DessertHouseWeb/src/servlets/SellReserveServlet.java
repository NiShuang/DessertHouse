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

import model.Reserve;
import service.MemberService;
import service.PlanItemService;
import service.ReserveService;

/**
 * Servlet implementation class SellReserveServlet
 */
@WebServlet("/SellReserveServlet")
public class SellReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB ReserveService reserveService;
	@EJB MemberService memberService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellReserveServlet() {
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
		if(session==null||session.getAttribute("clerkId")==null){
			context.getRequestDispatcher("/common/specialLogin.jsp").forward(request, response);
		}
		else{
			String clerk = (String) session.getAttribute("clerkId");
			int id = Integer.parseInt(request.getParameter("id"));
			String member = request.getParameter("member");
			reserveService.sellReserve(id,clerk);
			Reserve reserve = reserveService.find(id);
			double total_price = reserve.getPrice()*reserve.getQuantity();
			int point = memberService.getPoint(member, total_price);
			request.setAttribute("point", point);
			context.getRequestDispatcher("/QueryReserveServlet?id="+member).forward(request, response);	
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
