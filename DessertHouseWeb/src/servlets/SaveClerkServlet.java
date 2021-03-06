package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ClerkService;

/**
 * Servlet implementation class SaveClerkServlet
 */
@WebServlet("/SaveClerkServlet")
public class SaveClerkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB ClerkService clerkService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveClerkServlet() {
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
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String telephone = request.getParameter("telephone");
		int store = Integer.parseInt(request.getParameter("store"));
		clerkService.update(id,name, store, telephone);
		context.getRequestDispatcher("/ShowClerksServlet").forward(request, response);	
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
