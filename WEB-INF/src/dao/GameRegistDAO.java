package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Game;
import utility.DriverAccessor;


public class GameRegistDAO extends DriverAccessor{


	private Connection connection = null;
	public  GameRegistDAO(){
	}
		public String Regist(Game game,Connection connection){

			try{

				String sql = "insert into games (user_id1,user_id2,tour_id,set_point,game_point,data,game_date) values(?,?,?,?,?,?,?);";
			    PreparedStatement stmt = connection.prepareStatement(sql);

			    stmt.setString(1,game.getUserId1());
				stmt.setString(2,game.getUserId2());
				stmt.setInt(3,game.getTourId());
				stmt.setString(4,game.getSetPoint());
				stmt.setString(5,game.getGamePoint());
				stmt.setString(6,game.getData());
				stmt.setDate(7,game.getGameDate());

				stmt.executeUpdate();

				stmt.close();
				return "yes";

			}catch(SQLException e){

				e.printStackTrace();
				return "no";
			} finally {
		}
	}
}
