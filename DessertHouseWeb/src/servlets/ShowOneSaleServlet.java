package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PlanItem;
import service.PlanItemService;

/**
 * Servlet implementation class ShowOneSaleServlet
 */
@WebServlet("/ShowOneSaleServlet")
public class ShowOneSaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB PlanItemService planItemService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOneSaleServlet() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		PlanItem planItem = planItemService.find(id);
		request.setAttribute("planItem", planItem);
		context.getRequestDispatcher("/clerk/sell.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
