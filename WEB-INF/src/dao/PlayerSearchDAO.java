package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utility.DriverAccessor;

import beans.Game;
import beans.TourPart;


public class PlayerSearchDAO extends DriverAccessor {

	public ArrayList<Game> Part(TourPart tourPart,Connection connection){

		try{
			String sql="select * from games where tour_id = ? and user_id1 = ? or user_id2 = ?";

			System.out.println("PlayerSearchDAO");
			System.out.println(tourPart.getPartId());
			System.out.println(tourPart.getTourId());

			//preなんとかするとsql文が完成する
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1,tourPart.getTourId());
			stmt.setString(2,tourPart.getPartId());
			stmt.setString(3,tourPart.getPartId());
			ResultSet rs=stmt.executeQuery();

			//rsはまんまtable情報

			ArrayList list = new ArrayList();


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

			if(list.isEmpty()==true)
			{
				System.out.println("トゥルーやんけ");
			}
			else{
				System.out.println("ノットトゥルーやんけ");
			}

			return list;

		}catch(SQLException e){

			e.printStackTrace();

			System.out.println("まさかのここね");
			return null;

		}finally{
		}
	}
}