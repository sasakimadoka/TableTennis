package servlet;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.GetActorController;

public class ActorServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doPost(request,response);
	}


	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		GetActorController control=new GetActorController();

		//登録した全てのアクターをlistに渡す
		ArrayList list = control.GetList();

		//取得したlistをlistと名付けjspに受け渡せる形にする
		session.setAttribute("list", list);
		//
		response.sendRedirect("/TableTennis/jsp/admin/changeActorSelect.jsp");
	}
}
