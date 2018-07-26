package servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import control.LoginController;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String password = request.getParameter("password");

		LoginController manager = new LoginController();

		User user = new User();

		if(id.isEmpty() || id.length() > 12 || !(password.matches("[0-9a-zA-Z]+")) || password.isEmpty() || password.length() < 4 || password.length() > 12 || !(password.matches("[0-9a-zA-Z]+"))) {
			user = null;
		} else {
		user = manager.certifyUser(id, password);
		}

		HttpSession session = request.getSession();

		if (user == null) {
			request.setAttribute("error", "IDとパスワードが正しくありません");
			getServletContext().getRequestDispatcher("/jsp/loginPage.jsp").forward(request, response);
		} else if (user.getUserActivate() == 0) {
			request.setAttribute("accountError", "このユーザーは使用可否です");
			getServletContext().getRequestDispatcher("/jsp/loginPage.jsp").forward(request, response);
		} else {

			session.setAttribute("user", user);//セッションにユーザーを保存
			String Id = user.getUserId();
			String Name = user.getUserName();

			if(user.getUserRole()==0){
				request.setAttribute("userid",Id);
				request.setAttribute("username",Name);
				RequestDispatcher dispatch = request.getRequestDispatcher("/jsp/admin/mypage.jsp");
				dispatch.forward(request, response);
			}else if(user.getUserRole()==1){
				request.setAttribute("userid",Id);
				request.setAttribute("username",Name);
				RequestDispatcher dispatch = request.getRequestDispatcher("/jsp/role1/mypage.jsp");
				dispatch.forward(request, response);
			}else if(user.getUserRole()==2){
				request.setAttribute("userid",Id);
				request.setAttribute("username",Name);
				RequestDispatcher dispatch = request.getRequestDispatcher("/jsp/role2/mypage.jsp");
				dispatch.forward(request, response);
			}else{
				request.setAttribute("error", "ユーザーロールの不具合です");
				getServletContext().getRequestDispatcher("/jsp/common/loginPage.jsp").forward(request, response);
			}
		}
	}
}
