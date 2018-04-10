package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.SwingWorker;

import api.EmptyArgumentsException;
import api.TrainBetweenStations;
import data.Train;
import data.TrainBetweenStationsData;
import gui.ErrorDialogBox;
import gui.SearchingDialog;
import gui.TrainBetweenStationsTab;

public class TrainBetweenStationStatusButtonListener implements ActionListener {

	private TrainBetweenStationsTab tab;
	private SwingWorker<Void, Void> downloader;
	private TrainBetweenStationsData data;

	public TrainBetweenStationStatusButtonListener(TrainBetweenStationsTab tab) {
		this.tab = tab;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		SearchingDialog searching = new SearchingDialog(tab.getParent());
		searching.show();
		downloader = new SwingWorker<Void, Void>() {

			private boolean isInputFieldEmpty = false;
			
			@Override
			protected Void doInBackground() throws Exception {
				try {
					data = TrainBetweenStations.getTrainsBetweenStations(tab.getSource(), tab.getDestination(), tab.getDate(), tab.getApikey());
				} catch (EmptyArgumentsException e) {
					isInputFieldEmpty = true;
				}
				return null;
			}

			@Override
			protected void done() {
				searching.hide();
				if (data != null) {
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
						new ErrorDialogBox(tab.getParent(),
								"Date chosen for the query is not valid for the chosen parameters.").show();
						break;
					case 404:
						new ErrorDialogBox(tab.getParent(),
								"Data couldn’t be loaded on our servers. No data available.").show();
						break;
					case 405:
						new ErrorDialogBox(tab.getParent(),
								"Data couldn’t be loaded on our servers. Request couldn’t go through.").show();
						break;
					case 500:
						new ErrorDialogBox(tab.getParent(), "Unauthorized API Key, Please change apikey from file menu")
								.show();
						break;
					case 501:
						new ErrorDialogBox(tab.getParent(), "Account Expired, Please change apikey from file menu")
								.show();
						break;
					case 502:
						new ErrorDialogBox(tab.getParent(), "Invalid arguments passed.").show();
					}
				} else if(isInputFieldEmpty) {
					new ErrorDialogBox(tab.getParent(), "Input fields are empty").show();
				} else {
					new ErrorDialogBox(tab.getParent(), "Unable to connect to server").show();
				}
			}

		};
		downloader.execute();

	}

}
