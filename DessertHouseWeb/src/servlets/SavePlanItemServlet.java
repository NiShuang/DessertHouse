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
 * Servlet implementation class SavePlanItemServlet
 */
@WebServlet("/SavePlanItemServlet")
public class SavePlanItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB PlanItemService planItemService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SavePlanItemServlet() {
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
		Date date =  java.sql.Date.valueOf(request.getParameter("date"));
		int id = Integer.parseInt(request.getParameter("id"));
		int store = Integer.parseInt(request.getParameter("store"));
		int commodity = Integer.parseInt(request.getParameter("commodity"));
		double price = Double.parseDouble(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		planItemService.update(id, price, quantity);;
		context.getRequestDispatcher("/ShowPlanServlet?store="+store+"&date="+date).forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
