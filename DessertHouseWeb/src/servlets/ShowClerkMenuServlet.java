package servlets;

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
import javax.servlet.http.HttpSession;

import action.PlanItemListBean;
import action.StoreListBean;
import model.PlanItem;
import model.Store;
import service.ClerkService;
import service.PlanItemService;
import service.StoreService;

/**
 * Servlet implementation class ShowClerkMenuServlet
 */
@WebServlet("/ShowClerkMenuServlet")
public class ShowClerkMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB PlanItemService planItemService;
	@EJB StoreService storeService;
	@EJB ClerkService clerkService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowClerkMenuServlet() {
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
			Store theStore = clerkService.find(clerk).getStore();
			int store = theStore.getId();
			String store_name = theStore.getName();
			List result1 = storeService.findAll();
			StoreListBean storeList = new StoreListBean();
			storeList.setStoreList(result1);
			java.util.Date nDate = new java.util.Date();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        String sDate = sdf.format(nDate);
	        java.sql.Date date = java.sql.Date.valueOf(sDate);
			
			if(request.getParameter("store")!=null){
				store = Integer.parseInt(request.getParameter("store"));
			}
			if(request.getParameter("date")!=null){
				date = java.sql.Date.valueOf(request.getParameter("date"));
			}
			List result = new ArrayList();
			for(int i = 0;i<storeList.getStoreList().size();i++){
				Store myStore = storeList.getStoreList(i);
				if(myStore.getId()==store){
					Set<PlanItem> planItems = myStore.getPlanItems();
					for (PlanItem p: planItems) {
						if(p.getDate().equals(date)&&p.getState()==2)
							result.add(p);
					}
					break;
				}
			}
			PlanItemListBean planItemList = new PlanItemListBean();
			planItemList.setPlanItemList(result);
			request.setAttribute("planItemList", planItemList);
			request.setAttribute("storeList", storeList);
			request.setAttribute("store_id", store);
			request.setAttribute("store_name", store_name);
			request.setAttribute("date", date);
			context.getRequestDispatcher("/clerk/order.jsp").forward(request, response);	
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
