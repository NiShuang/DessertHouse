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

import action.PaymentRecordListBean;
import service.RechargeService;

/**
 * Servlet implementation class CheckPaymentRecordServlet
 */
@WebServlet("/CheckPaymentRecordServlet")
public class CheckPaymentRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB RechargeService rechargeService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckPaymentRecordServlet() {
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
		List result = rechargeService.getPaymentRecord(id);
		PaymentRecordListBean paymentRecordList = new PaymentRecordListBean();
		paymentRecordList.setPaymentRecordList(result);
		request.setAttribute("paymentRecordList", paymentRecordList);
		request.setAttribute("id", id);
		context.getRequestDispatcher("/clerk/paymentRecord.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
