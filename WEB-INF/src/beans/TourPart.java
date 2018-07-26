package beans;

public class TourPart {

	private String partId = "null";
	private int tourId = 0;

	public TourPart(){
		super();
	}

	public TourPart(String partId,int tourId){
		super();
		this.partId = partId;
		this.tourId = tourId;
	}

	public String getPartId() {
		return partId;
	}

	public void setPartId(String partId) {
		this.partId = partId;
	}

	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}


}
