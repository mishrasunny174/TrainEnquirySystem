package data;

public class LiveRunningData {
	private int response_code;
	private int debit;
	private String position;
	private Train train;
	private TrainRoute[] route;
	private Station current_station;
	private String start_date;

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public Station getCurrent_station() {
		return current_station;
	}

	public void setCurrent_station(Station current_station) {
		this.current_station = current_station;
	}

	public int getResponse_code() {
		return response_code;
	}

	public void setResponse_code(int response_code) {
		this.response_code = response_code;
	}

	public int getDebit() {
		return debit;
	}

	public void setDebit(int debit) {
		this.debit = debit;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public TrainRoute[] getRoute() {
		return route;
	}

	public void setRoute(TrainRoute[] route) {
		this.route = route;
	}

}
