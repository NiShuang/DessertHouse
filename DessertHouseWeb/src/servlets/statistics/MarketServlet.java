package servlets.statistics;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.PlanItemListBean;
import action.StoreListBean;
import model.PlanItem;
import model.Store;
import service.PlanItemService;
import service.StoreService;

/**
 * Servlet implementation class MarketServlet
 */
@WebServlet("/MarketServlet")
public class MarketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB PlanItemService planItemService;
	@EJB StoreService storeService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarketServlet() {
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
	
		List result1 = storeService.findAll();
		StoreListBean storeList = new StoreListBean();
		storeList.setStoreList(result1);
		int store = storeList.getStoreList(0).getId();
		
		if(request.getParameter("store")!=null){
			store = Integer.parseInt(request.getParameter("store"));
		}

		List result = planItemService.marketStatistics(store);
		String hot = planItemService.getHot(store);


		request.setAttribute("result", result);
		request.setAttribute("storeList", storeList);
		request.setAttribute("store_id", store);
		request.setAttribute("hot", hot);
		context.getRequestDispatcher("/manager/marketCondition.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
