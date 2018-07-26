package control;

import java.sql.Connection;
import java.sql.Date;

import beans.Tour;
import dao.TourRegistDAO;

public class TourRegistController {

	private Connection connection = null;

	//コンストラクタ：クラスを初期化するためのメソッド
	public  TourRegistController(){
	}

	public String Regist(String tourName,String startDate,String finalDate,String tourPlace){


		Date StartDate= Date.valueOf(startDate);
		Date FinalDate= Date.valueOf(finalDate);

		Tour tour = new Tour();
		tour.setTourName(tourName);
		tour.setStartDate(StartDate);
		tour.setFinalDate(FinalDate);
		tour.setTourPlace(tourPlace);


		TourRegistDAO dao = new TourRegistDAO();
		this.connection = dao.createConnection();

		String answer = dao.Regist(tour, this.connection);

		dao.closeConnection(this.connection);

		this.connection = null;

		return answer;
	}
}
