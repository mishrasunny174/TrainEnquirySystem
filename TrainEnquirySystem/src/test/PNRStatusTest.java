package test;

import api.PNRStatus;
import data.PNRStatusData;

public class PNRStatusTest {

	public static void main(String[] args) throws Exception {
		PNRStatusData data = PNRStatus.getPNRStatus("2344404403", "jlwle3i10u");
		if(data.getResponse_code()==200)
			System.out.println(data.getPassengers()[0].getBooking_status());
	}

}
