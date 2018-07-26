package control;

import java.sql.Connection;
import java.util.ArrayList;

import beans.User;
import dao.LoginDAO;

public class LoginController { //1
	private Connection connection = null;

	public User certifyUser(String id, String password) {//2
		LoginDAO dao = new LoginDAO();
		this.connection = dao.createConnection();
		User user = dao.certifyUser(id, this.connection);

		if (user == null) {//3
			this.connection = null;
			return null;
		}//3
		else if(user.getUserPassword()== password){ //idもパスもあってる場合 4
			return user;
		} //4
		return user;
	}//2
}//1
