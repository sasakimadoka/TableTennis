package control;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Random;

import beans.Game;
import beans.Tour;
import beans.TourPart;
import dao.PlayerSearchDAO;


public class PlayerSelectController  {

	private Connection connection = null;

	//コンストラクタ：クラスを初期化するためのメソッド
	public  PlayerSelectController(){
	}

	public ArrayList<Game> Regist(String userId,String tourId){


		int num = Integer.parseInt(tourId);

		TourPart tourPart = new TourPart();

		tourPart.setPartId(userId);
		tourPart.setTourId(num);

		System.out.println("PlayerSelectController");
		System.out.println(tourPart.getPartId());
		System.out.println(tourPart.getTourId());

		PlayerSearchDAO dao = new PlayerSearchDAO();
		this.connection = dao.createConnection();

		ArrayList<Game> list = dao.Part(tourPart, this.connection);

		dao.closeConnection(this.connection);

		this.connection = null;

		return list;
	}
}
