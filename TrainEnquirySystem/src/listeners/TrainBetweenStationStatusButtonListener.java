package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import api.EmptyArgumentsException;
import api.TrainBetweenStations;
import api.UnableToConnectToServerException;
import data.Train;
import data.TrainBetweenStationsData;
import gui.ErrorDialogBox;
import gui.TrainBetweenStationsTab;

public class TrainBetweenStationStatusButtonListener implements ActionListener {

	private TrainBetweenStationsTab tab;

	public TrainBetweenStationStatusButtonListener(TrainBetweenStationsTab tab) {
		this.tab = tab;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			TrainBetweenStationsData data = null;
			data = TrainBetweenStations.getTrainsBetweenStations(tab.getSource(), tab.getDestination(), tab.getDate(),
					tab.getApikey());
			switch (data.getResponse_code()) {
			case 200:
				tab.setData(data);
				tab.setNameLabel(data.getTrains()[0].getFrom_station().getName()+" to "+data.getTrains()[0].getTo_station().getName());
				Vector<String> trains = new Vector<>();
				for (Train train : data.getTrains()) {
					trains.addElement(train.getName());
				}
				tab.getTrainList().setListData(trains);
				tab.getTrainList().addKeyListener(new TrainBetweenStationKeyListener(tab));
				break;
			case 210:
				new ErrorDialogBox(tab.getParent(), "Train doesn’t run on the date queried.").show();
				break;
			case 211:
				new ErrorDialogBox(tab.getParent(), "Train doesn’t have journey class queried.").show();
				break;
			case 220:
				new ErrorDialogBox(tab.getParent(), "Flushed PNR.").show();
				break;
			case 221:
				new ErrorDialogBox(tab.getParent(), "Invalid PNR.").show();
				break;
			case 230:
				new ErrorDialogBox(tab.getParent(), "Date chosen for the query is not valid for the chosen parameters.").show();
				break;
			case 404:
				new ErrorDialogBox(tab.getParent(), "Data couldn’t be loaded on our servers. No data available.").show();
				break;
			case 405:
				new ErrorDialogBox(tab.getParent(),
						"Data couldn’t be loaded on our servers. Request couldn’t go through.").show();
				break;
			case 500:
				new ErrorDialogBox(tab.getParent(), "Unauthorized API Key, Please change apikey from file menu").show();
				break;
			case 501:
				new ErrorDialogBox(tab.getParent(), "Account Expired, Please change apikey from file menu").show();
				break;
			case 502:
				new ErrorDialogBox(tab.getParent(), "Invalid arguments passed.").show();
			}
		} catch (UnableToConnectToServerException e) {
			new ErrorDialogBox(tab.getParent(), e.getMessage()).show();
		} catch (EmptyArgumentsException e) {
			new ErrorDialogBox(tab.getParent(), e.getMessage()).show();
		} catch (NullPointerException e) {
			new ErrorDialogBox(tab.getParent(), "Fatal error: Unable to read data from server");
		}

	}

}
