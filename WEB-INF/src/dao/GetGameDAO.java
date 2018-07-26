package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utility.DriverAccessor;
import beans.Game;


public class GetGameDAO extends DriverAccessor {

	public ArrayList<Game> GetGameList(String userId,Connection connection){

		try{
			String sql="select * from games where user_id1 = ? or user_id2 = ?";

			//preなんとかするとsql文が完成する

			System.out.println("おk");

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,userId);
			stmt.setString(2,userId);
			ResultSet rs=stmt.executeQuery();

			//rsはまんまtable情報

			ArrayList<Game> list = new ArrayList<Game>();


			//登録されている問題の数だけ繰り返す
			while(rs.next())
			{
				Game game = new Game();
				game.setGameId(rs.getInt("game_id"));
				game.setUserId1(rs.getString("user_id1"));
				game.setUserId2(rs.getString("user_id2"));
				game.setSetPoint(rs.getString("set_point"));
				game.setGamePoint(rs.getString("game_point"));
				game.setData(rs.getString("data"));
				game.setGameDate(rs.getDate("game_date"));
				game.setTourId(rs.getInt("tour_id"));
				list.add(game);
			}






			stmt.close();
			rs.close();

			return list;

		}catch(SQLException e){

			e.printStackTrace();

			return null;

		}finally{
		}
	}
}