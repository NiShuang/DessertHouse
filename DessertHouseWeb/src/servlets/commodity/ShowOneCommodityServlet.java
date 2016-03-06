package servlets.commodity;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Commodity;
import model.Store;
import service.CommodityService;

/**
 * Servlet implementation class ShowOneCommodityServlet
 */
@WebServlet("/ShowOneCommodityServlet")
public class ShowOneCommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB CommodityService commodityService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOneCommodityServlet() {
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
		Commodity commodity = commodityService.find(id);
		request.setAttribute("commodity", commodity);
		context.getRequestDispatcher("/clerk/modifyCommodity.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
