package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserService;
import task.Execute;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB UserService userService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(!Execute.isStart){
			Execute exe = new Execute();
			try {
				exe.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Execute.isStart = true;
		}
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		ServletContext context= getServletContext();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int result = userService.login(username, password);
		HttpSession session = request.getSession(false);
		if(result==1){
			if(session==null){
				session = request.getSession(true);
			}
			session.setAttribute("id", username);
			context.getRequestDispatcher("/ShowMenuServlet").forward(request, response);
		}
		else if(result==2){
			if(session==null){
				session = request.getSession(true);
			}
			session.setAttribute("clerkId", username);
			context.getRequestDispatcher("/ShowClerkMenuServlet").forward(request, response);
		}
		else if(result==3){
			context.getRequestDispatcher("/ShowPlanServlet").forward(request, response);
		}
		else if(result==4){
			context.getRequestDispatcher("/ShowStoresServlet").forward(request, response);
		}
		else if(result==5){
			context.getRequestDispatcher("/ShowPlanSubmitedServlet").forward(request, response);
		}
		else if(result==0||result==-1){
			request.setAttribute("result",result);
			context.getRequestDispatcher("/common/login.jsp").forward(request, response);
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
