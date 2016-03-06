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
import javax.servlet.http.HttpSession;

import action.ConsumeRecordListBean;
import service.ConsumeRecordService;

/**
 * Servlet implementation class ShowConsumeRecordServlet
 */
@WebServlet("/ShowConsumeRecordServlet")
public class ShowConsumeRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB ConsumeRecordService consumeRecordService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowConsumeRecordServlet() {
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
			List result = consumeRecordService.findByMember(id);
			ConsumeRecordListBean consumeRecordList = new ConsumeRecordListBean();
			consumeRecordList.setConsumeRecordList(result);
			request.setAttribute("consumeRecordList", consumeRecordList);
			context.getRequestDispatcher("/customer/consumeRecord.jsp").forward(request, response);
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
