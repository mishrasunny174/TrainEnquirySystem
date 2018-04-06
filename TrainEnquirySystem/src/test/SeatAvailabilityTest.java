package test;

import api.SeatAvailabilty;
import data.Availability;
import data.SeatAvailabilityData;

public class SeatAvailabilityTest {

	public static void main(String[] args) throws Exception {
		SeatAvailabilityData data = SeatAvailabilty.getSeatAvailability("12001", "BPL", "NDLS", "20-04-2018", "CC",
				"GN", "jlwle3i10u");
		for(Availability avail : data.getAvailability()) {
			System.out.println(avail.getDate());
			System.out.println(avail.getStatus());
		}
	}

}
