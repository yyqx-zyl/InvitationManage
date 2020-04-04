package controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Invitation;
import entity.Pager;
import service.InitationService;
import service.impl.InitationServiceImpl;

/**
 * Servlet implementation class InviList
 */
@WebServlet("/InviList")
public class InviList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private InitationService ins=new InitationServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InviList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageIndex=request.getParameter("pageIndex");
		int currpage=1;
		//分页对象
		Pager pg=new Pager();
		//数据总条数
		int totalCount=ins.getCount();
		pg.setTotalCount(totalCount);
		if (pageIndex==null || "".equals(pageIndex)) {
			currpage=1;
		}else {
			int num=Integer.parseInt(pageIndex);
			if (num<=0) {
				currpage=1;
			}else if (num>pg.getTotalPages()) {
				currpage=pg.getTotalPages();
			}else {
				currpage=num;
			}
		}
		pg.setCurrPage(currpage);
		int from=(currpage-1)*pg.getPageSize();
		List pageLists=ins.getPageLists(from, pg.getPageSize());
		
		pg.setPageLists(pageLists);
		request.getSession().setAttribute("pg",pg);
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
