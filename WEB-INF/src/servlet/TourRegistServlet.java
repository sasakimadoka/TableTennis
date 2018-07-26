package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.TourRegistController;

public class TourRegistServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

		//文字コードの設定
		request.setCharacterEncoding("UTF-8");

		//getParameterの引数はjspのnameの中身と同じ
		String tourName=request.getParameter("name");
		String startDate=request.getParameter("startdate");
		String finalDate=request.getParameter("finaldate");
		String tourPlace=request.getParameter("place");
		String errorType = "";


		System.out.println(startDate);





		String answer;
			TourRegistController control =new TourRegistController();
			answer = control.Regist(tourName,startDate,finalDate,tourPlace);
			if(answer.equals("no")) {
				request.setAttribute("answer",answer);
				getServletContext().getRequestDispatcher("/jsp/role1/tourRegist.jsp").forward(request, response);
			} else {
				request.setAttribute("answer",answer);
				getServletContext().getRequestDispatcher("/jsp/role1/mypage.jsp").forward(request, response);
			}
	}
}

