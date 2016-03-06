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

import action.ReserveListBean;
import action.StoreListBean;
import model.Member;
import service.MemberService;
import service.ReserveService;

/**
 * Servlet implementation class QueryReserve
 */
@WebServlet("/QueryReserveServlet")
public class QueryReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB MemberService memberService;
	@EJB ReserveService reserveService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryReserveServlet() {
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
		String member_id = request.getParameter("id");
		Member member = memberService.find(member_id);
		if(member==null){
			request.setAttribute("result", 0);
			context.getRequestDispatcher("/clerk/queryMember.jsp").forward(request, response);
		}
		else{
			List result = reserveService.findToPayByMember(member_id);
			ReserveListBean reserveList = new ReserveListBean();
			reserveList.setReserveList(result);
			request.setAttribute("reserveList", reserveList);
			request.setAttribute("name", member.getName());
			context.getRequestDispatcher("/clerk/reserve.jsp").forward(request, response);
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
