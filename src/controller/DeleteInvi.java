package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.InitationService;
import service.impl.InitationServiceImpl;

/**
 * Servlet implementation class DeleteInvi
 */
@WebServlet("/DeleteInvi")
public class DeleteInvi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private InitationService ins=new InitationServiceImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteInvi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		req.setCharacterEncoding("UTF-8");
		//获取页面数据
		int inviId=Integer.parseInt(req.getParameter("inviId"));
		//获得业务层删除指定id的方法
		boolean isOk = ins.deleteInviById(inviId);
		if(isOk) {
			resp.sendRedirect("InviList");
		}else {
			resp.sendRedirect("index.jsp");
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
