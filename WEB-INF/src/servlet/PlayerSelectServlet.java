package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Game;
import control.PlayerSelectController;

public class PlayerSelectServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

		//文字コードの設定
		request.setCharacterEncoding("UTF-8");

		HttpSession session2 = request.getSession();
		String userId = (String)session2.getAttribute("userId");

		//getParameterの引数はjspのnameの中身と同じ
		String tourId=request.getParameter("tourId");

		System.out.println("PlayerSelectServlet");
		System.out.println(userId);
		System.out.println(tourId);



		PlayerSelectController control =new PlayerSelectController();
		ArrayList<Game> list = control.Regist(userId,tourId);

			if(list.isEmpty()==true) {

				System.out.println("PlayerSelectServletでEmpty");

				request.setAttribute("answer","データがありませんでした");
				getServletContext().getRequestDispatcher("/jsp/role2/tourGameSelect.jsp").forward(request, response);
			} else {
				System.out.println("PlayerSelectServletでNotEmpty");
				request.setAttribute("list",list);
				getServletContext().getRequestDispatcher("/jsp/role2/playerSelect.jsp").forward(request, response);
			}
	}
}

