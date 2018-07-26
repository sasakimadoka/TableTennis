package servlet;
import java.io.IOException;
import java.util.ArrayList;

import beans.Tour;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.GetTourController;

public class GoTourSelectServlet extends HttpServlet{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doPost(request,response);
	}


	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		HttpSession session2 = request.getSession();
		String userId=request.getParameter("userId");
		System.out.println(userId);
		GetTourController control=new GetTourController();

		//登録した全てのアクターをlistに渡す
		ArrayList<Tour> list = control.GetList();
		//取得したlistをlistと名付けjspに受け渡せる形にする
		session.setAttribute("list", list);
		session2.setAttribute("userId", userId);

		//System.out.println(list2.get(0).getTourName());
		//System.out.println(list.get(0).getUserId());
		//
		response.sendRedirect("/TableTennis/jsp/role2/tourSelect.jsp");
	}
}
