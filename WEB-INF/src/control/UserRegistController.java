package control;

import java.sql.Connection;
import java.util.Random;

import beans.User;
import dao.UserRegistDAO;

public class UserRegistController {

	private Connection connection = null;

	//コンストラクタ：クラスを初期化するためのメソッド
	public  UserRegistController(){
	}

	public String Regist(String userName,String userId,String userPassword,int userRole){

		User user = new User();
		user.setUserName(userName);
		user.setUserId(userId);
		user.setUserPassword(userPassword);
		user.setUserRole(userRole);


		UserRegistDAO dao = new UserRegistDAO();
		this.connection = dao.createConnection();

		String answer = dao.Regist(user, this.connection);

		dao.closeConnection(this.connection);

		this.connection = null;

		return answer;
	}
}
