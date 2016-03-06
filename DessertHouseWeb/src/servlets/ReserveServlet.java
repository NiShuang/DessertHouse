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

import service.ConsumeRecordService;
import service.PlanItemService;
import service.ReserveService;
import model.PlanItem;

/**
 * Servlet implementation class ReserveServlet
 */
@WebServlet("/ReserveServlet")
public class ReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB ReserveService reserveService;
	@EJB PlanItemService planItemService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveServlet() {
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
			int planItem_id = Integer.parseInt(request.getParameter("id"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			double discount = Double.parseDouble(request.getParameter("discount"));
			boolean result = reserveService.add(id,planItem_id , quantity,discount);
			if(!result){
				PlanItem planItem = planItemService.find(planItem_id);
				request.setAttribute("result", -1);
				request.setAttribute("planItem", planItem);
				context.getRequestDispatcher("/customer/reserve.jsp").forward(request, response);
			}
			else{			
				context.getRequestDispatcher("/customer/reserveSucceed.jsp").forward(request, response);
			}

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
