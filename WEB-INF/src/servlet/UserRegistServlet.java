package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.UserRegistController;

public class UserRegistServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

		//文字コードの設定
		request.setCharacterEncoding("UTF-8");

		//getParameterの引数はjspのnameの中身と同じ
		String userId=request.getParameter("id");
		String userName=request.getParameter("name");
		String userPassword=request.getParameter("password");
		String userRole=request.getParameter("userRole");
		String errorType = "";

		int num = Integer.parseInt(userRole);


		System.out.println(userId);
		System.out.println(userName);
		System.out.println(userPassword);
		System.out.println(userRole);



		if(userId.equals("")||userName.equals("")) {
			errorType = "未入力の欄があります";
		} else if(userId.length()>12 ||userId.length()<5 || userName.length()>30) {
			errorType = "文字数制限に沿っていません";
		} else if(!(userId.matches("^[0-9a-zA-Z]+$"))) {
			errorType = "Idは半角英数字で入力してください";
		}
		String answer = null;



		if(errorType.equals("")) {
			//UserRegistControllerのRegistメソッドへ
			UserRegistController control =new UserRegistController();
			answer = control.Regist(userName,userId,userPassword,num);
			if(answer.equals("no")) {
				request.setAttribute("answer",answer);
				getServletContext().getRequestDispatcher("/jsp/admin/userRegist.jsp").forward(request, response);
			} else {
				request.setAttribute("answer",answer);
				getServletContext().getRequestDispatcher("/jsp/admin/mypage.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("answer",errorType);
			getServletContext().getRequestDispatcher("/jsp/admin/userRegist.jsp").forward(request, response);
		}

	}
}

