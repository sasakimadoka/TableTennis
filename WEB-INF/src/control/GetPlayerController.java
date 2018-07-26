package control;

import java.sql.Connection;
import java.util.ArrayList;

import beans.User;
import beans.Tour;
import dao.GetActorDAO;

public class GetPlayerController {

	private Connection connection = null;

	public GetPlayerController() {
	}
	public ArrayList<User> GetList() {

		GetActorDAO dao = new GetActorDAO();

		this.connection = dao.createConnection();
		ArrayList<User> list = dao.GetPlayer(this.connection);

		dao.closeConnection(this.connection);

		//System.out.println(list.get(0).getUserId());


		this.connection = null;

		return list;
	}

	public ArrayList<Tour> GetList2() {

		GetActorDAO dao = new GetActorDAO();

		this.connection = dao.createConnection();
		ArrayList<Tour> list2 = dao.GetTour(this.connection);

		dao.closeConnection(this.connection);

		//System.out.println(list2.get(0).getTourName());

		this.connection = null;

		return list2;
	}
}

