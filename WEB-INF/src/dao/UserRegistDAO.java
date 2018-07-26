package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User;
import utility.DriverAccessor;


public class UserRegistDAO extends DriverAccessor{


	private Connection connection = null;
	public  UserRegistDAO(){
	}
		public String Regist(User user,Connection connection){

			try{

				String sql = "insert into users (user_id,user_role,user_name,user_password,user_activate) values(?,?,?,?,1);";
			    PreparedStatement stmt = connection.prepareStatement(sql);

			    stmt.setString(1,user.getUserId());
				stmt.setInt(2,user.getUserRole());
				stmt.setString(3,user.getUserName());
				stmt.setString(4,user.getUserPassword());

				stmt.executeUpdate();

				stmt.close();
				return "yes";

			}catch(SQLException e){

				e.printStackTrace();
				return "no";
			} finally {
			}
		}

		//既に同じidがあるかチェックする
		public int IdJudge(User user, Connection connection) {

			try{

			// SQLコマンド
			String sqlJudge = "select * from users_information where user_id = ? ";
			// SQLコマンドの実行
			PreparedStatement stmtJudge = connection.prepareStatement(sqlJudge);
			stmtJudge.setString(1,"shop" + user.getUserId());
			ResultSet rs=stmtJudge.executeQuery();
			int count = 0;
			if(rs.next()){
				count++;
			}
			stmtJudge.close();
			rs.close();
			return count;

		} catch (SQLException e) {
			// エラーが発生した場合、エラーの原因を出力する
			e.printStackTrace();
			return 0;
		} finally {
		}
	}
}
