package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Invitation;
import service.InitationService;
import service.impl.InitationServiceImpl;

/**
 * Servlet implementation class FindByTitle
 */
@WebServlet("/FindByTitle")
public class FindByTitle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InitationService ins=new InitationServiceImpl();    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindByTitle() {
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
		String title=req.getParameter("title");
		//调用业务层中的方法
		List<Invitation> list=new ArrayList<Invitation>();
		if (title==null || "".equals(title)) {
			 list=ins.getInvList();
		}else {
			
			 list=ins.findyByTitle(title);
		}
		req.getSession().setAttribute("list",list);
		resp.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
