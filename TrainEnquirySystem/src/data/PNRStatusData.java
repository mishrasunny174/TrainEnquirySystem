package data;

public class PNRStatusData {
	
	private String pnr;
	private JourneyClass journey_class;
	private Passeneger[] passengers;
	private Station to_station;
	private Station reservation_upto;
	private Train train;
	private int total_passengers;
	private int debit;
	public int getDebit() {
		return debit;
	}
	public void setDebit(int debit) {
		this.debit = debit;
	}
	private int response_code;
	private Station from_station;
	private Station boarding_point;
	private boolean chart_prepared;
	private String doj;
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public JourneyClass getJourney_class() {
		return journey_class;
	}
	public void setJourney_class(JourneyClass journey_class) {
		this.journey_class = journey_class;
	}
	public Passeneger[] getPassengers() {
		return passengers;
	}
	public void setPassengers(Passeneger[] passengers) {
		this.passengers = passengers;
	}
	public Station getTo_station() {
		return to_station;
	}
	public void setTo_station(Station to_station) {
		this.to_station = to_station;
	}
	public Station getReservation_upto() {
		return reservation_upto;
	}
	public void setReservation_upto(Station reservation_upto) {
		this.reservation_upto = reservation_upto;
	}
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}
	public int getTotal_passengers() {
		return total_passengers;
	}
	public void setTotal_passengers(int total_passengers) {
		this.total_passengers = total_passengers;
	}
	public int getResponse_code() {
		return response_code;
	}
	public void setResponse_code(int response_code) {
		this.response_code = response_code;
	}
	public Station getFrom_station() {
		return from_station;
	}
	public void setFrom_station(Station from_station) {
		this.from_station = from_station;
	}
	public Station getBoarding_point() {
		return boarding_point;
	}
	public void setBoarding_point(Station boarding_point) {
		this.boarding_point = boarding_point;
	}
	public boolean isChart_prepared() {
		return chart_prepared;
	}
	public void setChart_prepared(boolean chart_prepared) {
		this.chart_prepared = chart_prepared;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	
	
	
}
