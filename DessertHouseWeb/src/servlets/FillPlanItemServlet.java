package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommodityListBean;
import service.CommodityService;

/**
 * Servlet implementation class FillPlanItemServlet
 */
@WebServlet("/FillPlanItemServlet")
public class FillPlanItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB CommodityService commodityService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FillPlanItemServlet() {
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
		List result = commodityService.findAll();
		CommodityListBean commodityList = new CommodityListBean();
		commodityList.setCommodityList(result);
		request.setAttribute("commodityList", commodityList);
		
		String store = request.getParameter("store");
		String date = request.getParameter("date");
		request.setAttribute("store_id", store);
		request.setAttribute("date", date);
		context.getRequestDispatcher("/clerk/addPlanItem.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
