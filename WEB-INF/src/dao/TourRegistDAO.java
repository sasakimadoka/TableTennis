package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Tour;
import beans.TourPart;
import utility.DriverAccessor;


public class TourRegistDAO extends DriverAccessor{


	private Connection connection = null;
	public  TourRegistDAO(){
	}
		public String Regist(Tour tour,Connection connection){

			try{

				String sql = "insert into tours (tour_name,start_date,final_date,tour_place) values(?,?,?,?);";
			    PreparedStatement stmt = connection.prepareStatement(sql);

			    stmt.setString(1,tour.getTourName());
				stmt.setDate(2,tour.getStartDate());
				stmt.setDate(3,tour.getFinalDate());
				stmt.setString(4,tour.getTourPlace());

				stmt.executeUpdate();

				stmt.close();
				return "yes";

			}catch(SQLException e){

				e.printStackTrace();
				return "no";
			} finally {
		}
	}
public String Part(TourPart tourPart,Connection connection){

	try{

		String sql = "insert into tour_parts (tour_id,part_id) values(?,?);";
	    PreparedStatement stmt = connection.prepareStatement(sql);

		System.out.println("確認");
		System.out.println(tourPart.getPartId());
		System.out.println(tourPart.getPartId());
		System.out.println("確認");


	    stmt.setInt(1,tourPart.getTourId());
		stmt.setString(2,tourPart.getPartId());

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
