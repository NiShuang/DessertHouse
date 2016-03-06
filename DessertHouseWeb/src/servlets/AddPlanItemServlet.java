package servlets;

import java.io.IOException;
import java.sql.Date;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PlanItemService;

/**
 * Servlet implementation class AddPlanItemServlet
 */
@WebServlet("/AddPlanItemServlet")
public class AddPlanItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB PlanItemService planItemService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlanItemServlet() {
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
		int commodity_id = Integer.parseInt(request.getParameter("commodity"));
		double price = Double.parseDouble(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int store_id = Integer.parseInt(request.getParameter("store"));
		Date date =  java.sql.Date.valueOf(request.getParameter("date"));
		planItemService.add(store_id, commodity_id,date, price,quantity);
		context.getRequestDispatcher("/ShowPlanServlet?store="+store_id+"&date="+date).forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
