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

import model.Member;
import model.PlanItem;
import service.ConsumeRecordService;
import service.MemberService;
import service.PlanItemService;

/**
 * Servlet implementation class SellServlet
 */
@WebServlet("/SellServlet")
public class SellServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB ConsumeRecordService consumeRecordService;
	@EJB PlanItemService planItemService;
	@EJB MemberService memberService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellServlet() {
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
		if(session==null||session.getAttribute("clerkId")==null){
			context.getRequestDispatcher("/common/specialLogin.jsp").forward(request, response);
		}
		else{
			String clerk = (String) session.getAttribute("clerkId");
			int planItem_id = Integer.parseInt(request.getParameter("id"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			String member = request.getParameter("member");
			if(member.equals("")){
				member = "0000000";
				consumeRecordService.add(member,clerk,planItem_id , quantity,1.0);
				context.getRequestDispatcher("/clerk/sellSucceed.jsp").forward(request, response);
			}
			else{
				if(memberService.find(member)==null){			
				PlanItem planItem = planItemService.find(planItem_id);
				request.setAttribute("planItem", planItem);
				request.setAttribute("result", 0);
				context.getRequestDispatcher("/clerk/sell.jsp").forward(request, response);
				}
				else{
					Member myMember = memberService.find(member);
					if(myMember.getIs_active()!=1){
						PlanItem planItem = planItemService.find(planItem_id);
						request.setAttribute("result", -2);
						request.setAttribute("planItem", planItem);
						context.getRequestDispatcher("/clerk/sell.jsp").forward(request, response);
					}
					else{
						double discount = memberService.getDiscount(member);
						boolean result = consumeRecordService.add(member,clerk,planItem_id , quantity,discount);
						
						if(!result){
							PlanItem planItem = planItemService.find(planItem_id);
							request.setAttribute("result", -1);
							request.setAttribute("planItem", planItem);
							context.getRequestDispatcher("/clerk/sell.jsp").forward(request, response);
						}
						else{
							double price = Double.parseDouble(String.valueOf(request.getParameter("price")));
							double totalPrice = price*quantity;
							int point = memberService.getPoint(member, totalPrice);
							request.setAttribute("point", point);
							context.getRequestDispatcher("/clerk/sellSucceed.jsp").forward(request, response);
						}
					}
				}
			}
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
