package control;

import java.sql.Connection;
import java.sql.Date;
import java.util.Random;

import beans.Game;
import dao.GameRegistDAO;

public class GameRegistController {

	private Connection connection = null;

	//コンストラクタ：クラスを初期化するためのメソッド
	public  GameRegistController(){
	}

	public String Regist(String userId1,String userId2,String tourId,String setPoint,String gamePoint,String data,String gameDate){

		Date GameDate= Date.valueOf(gameDate);

		int i = Integer.parseInt(tourId);


		Game game = new Game();
		game.setUserId1(userId1);
		game.setUserId2(userId2);
		game.setTourId(i);
		game.setSetPoint(setPoint);
		game.setGamePoint(gamePoint);
		game.setData(data);
		game.setGameDate(GameDate);

		GameRegistDAO dao = new GameRegistDAO();
		this.connection = dao.createConnection();

		String answer = dao.Regist(game, this.connection);

		dao.closeConnection(this.connection);

		this.connection = null;

		return answer;
	}
}
