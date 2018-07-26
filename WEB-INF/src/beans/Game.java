package beans;

import java.sql.Date;

public class Game {
	private int gameId = 0;
	private String userId1 = null;
	private String userId2 = null;
	private int tourId = 0;
	private String setPoint = null;
	private String gamePoint = null;
	private String data = null;
	private Date gameDate = null;

	public Game() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public Game(int gameId ,String userId1, String userId2,int tourId, String setPoint,String gamePoint,String data,Date gameDate){
		super();
		this.gameId = gameId;
		this.userId1 = userId1;
		this.userId2 = userId2;
		this.tourId = tourId;
		this.setPoint = setPoint;
		this.gamePoint = gamePoint;
		this.data = data;
		this.gameDate = gameDate;
	}

	public int getTourId() {
		return tourId;
	}
	public void setTourId(int tourId) {
		this.tourId = tourId;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public String getUserId1() {
		return userId1;
	}
	public void setUserId1(String userId1) {
		this.userId1 = userId1;
	}
	public String getUserId2() {
		return userId2;
	}
	public void setUserId2(String userId2) {
		this.userId2 = userId2;
	}
	public String getSetPoint() {
		return setPoint;
	}
	public void setSetPoint(String setPoint) {
		this.setPoint = setPoint;
	}
	public String getGamePoint() {
		return gamePoint;
	}
	public void setGamePoint(String gamePoint) {
		this.gamePoint = gamePoint;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Date getGameDate() {
		return gameDate;
	}
	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}

}