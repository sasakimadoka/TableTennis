package control;

import java.sql.Connection;
import java.util.Random;

import beans.TourPart;
import dao.TourRegistDAO;


public class TourPartRegistController  {

	private Connection connection = null;

	//コンストラクタ：クラスを初期化するためのメソッド
	public  TourPartRegistController(){
	}

	public String Regist(String userId,String tourId){


		int num = Integer.parseInt(tourId);

		TourPart tourPart = new TourPart();
		tourPart.setPartId(userId);
		tourPart.setTourId(num);


		TourRegistDAO dao = new TourRegistDAO();
		this.connection = dao.createConnection();

		String answer = dao.Part(tourPart, this.connection);

		dao.closeConnection(this.connection);

		this.connection = null;

		return answer;
	}
}
