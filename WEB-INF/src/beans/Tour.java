package beans;

import java.sql.Date;

public class Tour {
	private String tourId = null;
	private String tourName = null;
	private Date startDate = null;
	private Date finalDate = null;
	private String tourPlace = null;
	private String registerId = null;

	public Tour() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public Tour(String tourId, String tourName,Date startDate,Date finalDate, String tourPlace,String registerId) {
		super();
		this.tourId = tourId;
		this.tourName = tourName;
		this.startDate = startDate;
		this.finalDate = finalDate;
		this.tourPlace = tourPlace;
	}
	public String getTourId() {
		return tourId;
	}
	public void setTourId(String tourId) {
		this.tourId = tourId;
	}
	public String getTourName() {
		return tourName;
	}
	public void setTourName(String tourName) {
		this.tourName = tourName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}
	public String getTourPlace() {
		return tourPlace;
	}
	public void setTourPlace(String tourPlace) {
		this.tourPlace = tourPlace;
	}
	public String getRegisterId() {
		return registerId;
	}
	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}
}