package control;

import java.sql.Connection;
import java.util.ArrayList;

import beans.Game;
import dao.GetGameDAO;

public class WatchGameController {

	private Connection connection = null;

	public WatchGameController() {
	}
	public ArrayList<Game> GetList(String userId) {

		GetGameDAO dao = new GetGameDAO();

		this.connection = dao.createConnection();
		ArrayList<Game> list = dao.GetGameList(userId,this.connection);

		dao.closeConnection(this.connection);

		//System.out.println(list.get(0).getUserId());


		this.connection = null;

		return list;
	}
}