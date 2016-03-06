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

import action.ClerkListBean;
import action.StoreListBean;
import service.ClerkService;
import service.StoreService;

/**
 * Servlet implementation class ShowClerksServlet
 */
@WebServlet("/ShowClerksServlet")
public class ShowClerksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB ClerkService clerkService;
	@EJB StoreService storeService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowClerksServlet() {
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
		List result = clerkService.findAll();
		ClerkListBean clerkList = new ClerkListBean();
		clerkList.setClerkList(result);
		request.setAttribute("clerkList", clerkList);
		List result1 = storeService.findAll();
		StoreListBean storeList = new StoreListBean();
		storeList.setStoreList(result1);
		request.setAttribute("storeList", storeList);
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
