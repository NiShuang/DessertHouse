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
import service.MemberService;
import service.PlanItemService;
import service.StoreService;

/**
 * Servlet implementation class ShowMenuServlet
 */
@WebServlet("/ShowMenuServlet")
public class ShowMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB PlanItemService planItemService;
	@EJB StoreService storeService;
	@EJB MemberService memberService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMenuServlet() {
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
			int is_active = memberService.find(id).getIs_active();
			List result1 = storeService.findAll();
			StoreListBean storeList = new StoreListBean();
			storeList.setStoreList(result1);
			java.util.Date nDate = new java.util.Date();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        String sDate = sdf.format(nDate);
	        java.sql.Date date = java.sql.Date.valueOf(sDate);
			int store = storeList.getStoreList(0).getId();
			
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
			request.setAttribute("date", date);
			request.setAttribute("state", is_active);
			context.getRequestDispatcher("/customer/order.jsp").forward(request, response);	
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
