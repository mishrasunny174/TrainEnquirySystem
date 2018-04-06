package test;

import api.TrainFair;
import data.TrainFairEnquiryData;

public class TrainFairEnquiryTest {
	public static void main(String[] args) throws Exception {
		TrainFairEnquiryData data = TrainFair.getFairData("12555", "gkp", "ndls", "18", "SL", "PT", "07-04-2018",
				"jlwle3i10u");
		System.out.println(data.getFare());
	}
}
