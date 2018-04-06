package test;

import api.TrainBetweenStations;
import data.Train;
import data.TrainBetweenStationsData;

public class TrainBetweenStationTest {

	public static void main(String[] args) throws Exception {
		TrainBetweenStationsData data = TrainBetweenStations.getTrainsBetweenStations("etw", "ndls", "07-04-2018", "jlwle3i10u");
		for(Train train : data.getTrains()) {
			System.out.println("total: "+data.getTotal());
			System.out.println(train.getName());
		}
	}

}
