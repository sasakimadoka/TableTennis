package servlet;
import java.io.IOException;
import java.util.ArrayList;

import beans.User;
import beans.Tour;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.GetPlayerController;

public class GoGameRegistServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doPost(request,response);
	}


	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		GetPlayerController control=new GetPlayerController();

		//登録した全てのアクターをlistに渡す
		ArrayList<User> list = control.GetList();
		ArrayList<Tour> list2 = control.GetList2();
		//取得したlistをlistと名付けjspに受け渡せる形にする
		session.setAttribute("list", list);
		session.setAttribute("list2", list2);

		//System.out.println(list2.get(0).getTourName());
		//System.out.println(list.get(0).getUserId());
		//
		response.sendRedirect("/TableTennis/jsp/role1/gameRegist.jsp");
	}
}
