package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User;
import utility.DriverAccessor;

public class LoginDAO extends DriverAccessor {

	public User certifyUser(String id, Connection connection) {

		try {

			// SQLコマンド
			String sql = "select * from users where user_id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();

			User user = new User();
			while (rs.next()) {
				user.setUserId(rs.getString("user_id"));
				user.setUserPassword(rs.getString("user_password"));
				user.setUserRole(rs.getInt("user_role"));
				user.setUserActivate(rs.getInt("user_activate"));
			}
			stmt.close();
			rs.close();


			return user;
		} catch (SQLException e) {

			// エラーが発生した場合、エラーの原因を出力する
			//idが存在しない場合ここに来る
			e.printStackTrace();

			return null;

		} finally {
		}
	}
}