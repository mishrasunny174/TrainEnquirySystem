package data;

public class TrainBetweenStationsData {
	private int debit;
	private int total;
	private int response_code;
	private Train[] trains;
	public int getDebit() {
		return debit;
	}
	public void setDebit(int debit) {
		this.debit = debit;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getResponse_code() {
		return response_code;
	}
	public void setResponse_code(int response_code) {
		this.response_code = response_code;
	}
	public Train[] getTrains() {
		return trains;
	}
	public void setTrains(Train[] trains) {
		this.trains = trains;
	}
	
	
}
