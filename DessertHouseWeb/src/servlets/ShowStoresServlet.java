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

import action.StoreListBean;
import service.StoreService;

/**
 * Servlet implementation class ShowStoresServlet
 */
@WebServlet("/ShowStoresServlet")
public class ShowStoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB StoreService storeService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowStoresServlet() {
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
		List result = storeService.findAll();
		StoreListBean storeList = new StoreListBean();
		storeList.setStoreList(result);
		request.setAttribute("storeList", storeList);
		context.getRequestDispatcher("/admin/storeManage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
