package data;

public class Train {
	private String number;
	private String name;
	private JourneyClass[] classes;
	private Days[] days;
	
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

}
