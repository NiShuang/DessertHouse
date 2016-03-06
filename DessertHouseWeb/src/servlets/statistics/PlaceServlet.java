package servlets.statistics;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;

/**
 * Servlet implementation class PlaceServlet
 */
@WebServlet("/PlaceServlet")
public class PlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB MemberService memberService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceServlet() {
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
		List place = memberService.placeStatistics();

        request.setAttribute("place", place);
		context.getRequestDispatcher("/manager/placeStatistics.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
