package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.ClerkListBean;
import action.StoreListBean;
import model.Store;
import service.ClerkService;
import service.StoreService;

/**
 * Servlet implementation class ShowClerksByStoreServlet
 */
@WebServlet("/ShowClerksByStoreServlet")
public class ShowClerksByStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB ClerkService clerkService;
	@EJB StoreService storeService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowClerksByStoreServlet() {
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
		Store store = storeService.find(id);
		List result = new ArrayList(store.getClerks());  
//		List result = clerkService.findByStore(id);
		ClerkListBean clerkList = new ClerkListBean();
		clerkList.setClerkList(result);
		request.setAttribute("clerkList", clerkList);
		List result1 = storeService.findAll();
		StoreListBean storeList = new StoreListBean();
		storeList.setStoreList(result1);
		request.setAttribute("storeList", storeList);
		request.setAttribute("store_id", id);
		context.getRequestDispatcher("/admin/clerkManage.jsp").forward(request, response);		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
