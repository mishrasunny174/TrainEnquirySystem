package data;

public class Train {
	private String number;
	private String name;
	private JourneyClass[] classes;
	private Days[] days;
	private Station from_station;
	private Station to_station;
	private String dest_arrival_time;
	private String src_departure_time;
	private String travel_time;
	
	public String getNumber() {
		return number;
	}

	public JourneyClass[] getClasses() {
		return classes;
	}

	public void setClasses(JourneyClass[] classes) {
		this.classes = classes;
	}

	public Days[] getDays() {
		return days;
	}

	public void setDays(Days[] days) {
		this.days = days;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDest_arrival_time() {
		return dest_arrival_time;
	}

	public void setDest_arrival_time(String dest_arrival_time) {
		this.dest_arrival_time = dest_arrival_time;
	}

	public String getSrc_departure_time() {
		return src_departure_time;
	}

	public void setSrc_departure_time(String src_departure_time) {
		this.src_departure_time = src_departure_time;
	}

	public String getTravel_time() {
		return travel_time;
	}

	public void setTravel_time(String travel_time) {
		this.travel_time = travel_time;
	}
	
	

}
