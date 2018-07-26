package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utility.DriverAccessor;
import beans.User;
import beans.Tour;


public class GetActorDAO extends DriverAccessor {

	public ArrayList GetList(Connection connection){

		try{
			String sql="select * from users";

			//preなんとかするとsql文が完成する
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();

			//rsはまんまtable情報

			ArrayList list = new ArrayList();


			//登録されている問題の数だけ繰り返す
			while(rs.next())
			{
				User user = new User();
				user.setUserId(rs.getString("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setUserRole(rs.getInt("user_role"));
				user.setUserPassword(rs.getString("user_password"));
				user.setUserActivate(rs.getInt("user_activate"));
				list.add(user);
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
		public ArrayList GetPlayer(Connection connection){

			try{
				String sql="select * from users where user_role = 2";

				//preなんとかするとsql文が完成する
				PreparedStatement stmt = connection.prepareStatement(sql);
				ResultSet rs=stmt.executeQuery();

				//rsはまんまtable情報

				ArrayList list = new ArrayList();


				//登録されている問題の数だけ繰り返す
				while(rs.next())
				{
					User user = new User();
					user.setUserId(rs.getString("user_id"));
					user.setUserName(rs.getString("user_name"));
					user.setUserRole(rs.getInt("user_role"));
					user.setUserPassword(rs.getString("user_password"));
					user.setUserActivate(rs.getInt("user_activate"));
					list.add(user);
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
			public ArrayList<Tour> GetTour(Connection connection){

				try{
					String sql="select * from tours";

					//preなんとかするとsql文が完成する
					PreparedStatement stmt = connection.prepareStatement(sql);
					ResultSet rs=stmt.executeQuery();

					//rsはまんまtable情報

					ArrayList list2 = new ArrayList();


					//登録されている問題の数だけ繰り返す
					while(rs.next())
					{
						Tour tour = new Tour();
						tour.setTourId(rs.getString("tour_id"));
						tour.setTourName(rs.getString("tour_name"));
						tour.setStartDate(rs.getDate("start_date"));
						tour.setFinalDate(rs.getDate("final_date"));
						tour.setTourPlace(rs.getString("tour_place"));
						list2.add(tour);
					}

					stmt.close();
					rs.close();
					return list2;

				}catch(SQLException e){

					e.printStackTrace();

					return null;

				}finally{
				}


		}
}