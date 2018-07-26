package control;

import java.sql.Connection;
import java.util.ArrayList;

import beans.User;
import dao.GetActorDAO;

public class GetActorController {

	private Connection connection = null;

	public GetActorController() {
	}
	public ArrayList GetList() {

		GetActorDAO dao = new GetActorDAO();

		this.connection = dao.createConnection();
		ArrayList list = dao.GetList(this.connection);

		dao.closeConnection(this.connection);

		this.connection = null;

		return list;
	}
}

