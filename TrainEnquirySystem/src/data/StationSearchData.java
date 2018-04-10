package data;

public class StationSearchData {
	private int response_code;
	private int debit;
	private Station[] stations;

	public int getResponse_code() {
		return response_code;
	}

	public void setResponse_code(int respone_code) {
		this.response_code = respone_code;
	}

	public int getDebit() {
		return debit;
	}

	public void setDebit(int debit) {
		this.debit = debit;
	}

	public Station[] getStations() {
		return stations;
	}

	public void setStations(Station[] stations) {
		this.stations = stations;
	}

}
