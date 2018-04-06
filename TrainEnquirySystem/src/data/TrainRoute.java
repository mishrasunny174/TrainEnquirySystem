package data;

public class TrainRoute {
	private int no;
	private int day;
	private Station station;
	private boolean has_arrived;
	private boolean has_departed;
	private int distance;
	private String scharr;
	private String schdep;
	private String actarr;
	private String actdep;
	private String scharr_date;
	private String actarr_date;
	private int latemin;
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public boolean isHas_arrived() {
		return has_arrived;
	}

	public void setHas_arrived(boolean has_arrived) {
		this.has_arrived = has_arrived;
	}

	public boolean isHas_departed() {
		return has_departed;
	}

	public void setHas_departed(boolean has_departed) {
		this.has_departed = has_departed;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getScharr() {
		return scharr;
	}

	public void setScharr(String scharr) {
		this.scharr = scharr;
	}

	public String getSchdep() {
		return schdep;
	}

	public void setSchdep(String schdep) {
		this.schdep = schdep;
	}

	public String getActarr() {
		return actarr;
	}

	public void setActarr(String actarr) {
		this.actarr = actarr;
	}

	public String getActdep() {
		return actdep;
	}

	public void setActdep(String actdep) {
		this.actdep = actdep;
	}

	public String getScharr_date() {
		return scharr_date;
	}

	public void setScharr_date(String scharr_date) {
		this.scharr_date = scharr_date;
	}

	public String getActarr_date() {
		return actarr_date;
	}

	public void setActarr_date(String actarr_date) {
		this.actarr_date = actarr_date;
	}

	public int getLatemin() {
		return latemin;
	}

	public void setLatemin(int latemin) {
		this.latemin = latemin;
	}
}
