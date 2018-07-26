package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.GameRegistController;

public class GameRegistServlet extends HttpServlet{

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

		//文字コードの設定
		request.setCharacterEncoding("UTF-8");

		//getParameterの引数はjspのnameの中身と同じ
		String userId1=request.getParameter("userId1");
		String userId2=request.getParameter("userId2");
		String tourId=request.getParameter("tourId");
		String setPoint=request.getParameter("setpoint");
		String gamePoint=request.getParameter("gamepoint");
		String data=request.getParameter("data");
		String gameDate=request.getParameter("gamedate");

			//UserRegistControllerのRegistメソッドへ
			GameRegistController control =new GameRegistController();
			String answer = control.Regist(userId1,userId2,tourId,setPoint,gamePoint,data,gameDate);
			if(answer.equals("no")) {
				request.setAttribute("answer",answer);
				getServletContext().getRequestDispatcher("/jsp/role1/gameRegist.jsp").forward(request, response);
			} else {
				request.setAttribute("answer",answer);
				getServletContext().getRequestDispatcher("/jsp/role1/mypage.jsp").forward(request, response);
			}

	}
}

