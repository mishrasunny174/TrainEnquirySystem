package data;

public class SeatAvailabilityData {
	private int debit;
	private int response_code;
	private Availability[] availability;
	private Station from_station;
	private Station to_station;
	private JourneyClass journey_class;
	private Quota quota;
	private Train train;

	public int getDebit() {
		return debit;
	}

	public void setDebit(int debit) {
		this.debit = debit;
	}

	public int getResponse_code() {
		return response_code;
	}

	public void setResponse_code(int response_code) {
		this.response_code = response_code;
	}

	public Availability[] getAvailability() {
		return availability;
	}

	public void setAvailability(Availability[] availability) {
		this.availability = availability;
	}

	public Station getFrom_station() {
		return from_station;
	}

	public void setFrom_station(Station from_station) {
		this.from_station = from_station;
	}

	public Station getTo_station() {
		return to_station;
	}

	public void setTo_station(Station to_station) {
		this.to_station = to_station;
	}

	public JourneyClass getJourney_class() {
		return journey_class;
	}

	public void setJourney_class(JourneyClass journey_class) {
		this.journey_class = journey_class;
	}

	public Quota getQuota() {
		return quota;
	}

	public void setQuota(Quota quota) {
		this.quota = quota;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

}
