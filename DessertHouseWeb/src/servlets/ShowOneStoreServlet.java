package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Store;
import service.StoreService;

/**
 * Servlet implementation class ShowOneStoreServlet
 */
@WebServlet("/ShowOneStoreServlet")
public class ShowOneStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB StoreService storeService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOneStoreServlet() {
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
		request.setAttribute("store", store);
		context.getRequestDispatcher("/admin/modifyStore.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
