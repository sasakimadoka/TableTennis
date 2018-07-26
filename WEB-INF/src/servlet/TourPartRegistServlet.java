package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.TourPartRegistController;

public class TourPartRegistServlet extends HttpServlet{

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

		String answer = null;

		TourPartRegistController control =new TourPartRegistController();
		answer = control.Regist(userId,tourId);



			if(answer.equals("no")) {
				request.setAttribute("answer",answer);
				getServletContext().getRequestDispatcher("/jsp/role2/tourSelect.jsp").forward(request, response);
			} else {
				request.setAttribute("answer",answer);
				getServletContext().getRequestDispatcher("/jsp/role2/mypage.jsp").forward(request, response);
			}
	}
}

