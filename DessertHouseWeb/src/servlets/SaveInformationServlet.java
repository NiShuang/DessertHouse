package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;
import model.User;
import service.MemberService;

/**
 * Servlet implementation class SaveInformationServlet
 */
@WebServlet("/SaveInformationServlet")
public class SaveInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB MemberService memberService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveInformationServlet() {
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
			String name = request.getParameter("name");
			int sex = Integer.parseInt(request.getParameter("sex"));
			String date = request.getParameter("year")+"-"+request.getParameter("month")+"-"+request.getParameter("day");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");   
			java.util.Date Date = null;
			try {
				Date = df.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   
			java.sql.Date birthday= new java.sql.Date(Date.getTime()); 
			String place = request.getParameter("place");
			memberService.modify(id, name, sex, birthday, place);
			context.getRequestDispatcher("/ShowInformationServlet").forward(request, response);
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
