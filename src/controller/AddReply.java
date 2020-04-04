package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Reply;
import service.ReplyService;
import service.impl.ReplyServiceImpl;

/**
 * Servlet implementation class AddReply
 */
@WebServlet("/AddReply")
public class AddReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReplyService rs=new ReplyServiceImpl();       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//字符编码
		req.setCharacterEncoding("UTF-8");
		//获得页面数据
		int inviId=Integer.parseInt(req.getParameter("inviId"));
		String content=req.getParameter("content");
		String author=req.getParameter("author");
		Reply r=new Reply(inviId,content,author,new Date());
		boolean isOk = rs.saveReply(r);
		if (isOk) {
			System.out.println(isOk);
			resp.sendRedirect("LookReply?inviId="+inviId);
		} else {
			resp.sendRedirect("addReply.jsp");
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
