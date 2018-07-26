package control;

import java.sql.Connection;
import java.util.ArrayList;

import beans.User;
import beans.Tour;
import dao.GetActorDAO;

public class GetTourController {

	private Connection connection = null;

	public GetTourController() {
	}
	public ArrayList<Tour> GetList() {

		GetActorDAO dao = new GetActorDAO();

		this.connection = dao.createConnection();
		ArrayList<Tour> list = dao.GetTour(this.connection);

		dao.closeConnection(this.connection);

		//System.out.println(list.get(0).getUserId());


		this.connection = null;

		return list;
	}

}