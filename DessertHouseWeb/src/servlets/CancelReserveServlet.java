package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ConsumeRecordService;
import service.PlanItemService;
import service.ReserveService;

/**
 * Servlet implementation class CancelReserveServlet
 */
@WebServlet("/CancelReserveServlet")
public class CancelReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB ReserveService reserveService;
	@EJB PlanItemService planItemService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelReserveServlet() {
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
		reserveService.cancel(id);
		context.getRequestDispatcher("/ShowReserveServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
