package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Reply;
import service.InitationService;
import service.ReplyService;
import service.impl.InitationServiceImpl;
import service.impl.ReplyServiceImpl;

/**
 * Servlet implementation class LookReply
 */
@WebServlet("/LookReply")
public class LookReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReplyService rs=new ReplyServiceImpl();    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LookReply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//字符编码
		req.setCharacterEncoding("UTF-8");
		int inviId=Integer.parseInt(req.getParameter("inviId"));
		//保存到Session中
		req.getSession().setAttribute("inviId",inviId);
		
		List<Reply> rlist=rs.getReplyList(inviId); 
		// 将这个集合保存到作用域中
		req.getSession().setAttribute("rlist", rlist);
		// 页面跳转
		resp.sendRedirect("replyDetials.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
