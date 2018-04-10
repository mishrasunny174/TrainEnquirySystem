package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingWorker;

import api.EmptyArgumentsException;
import api.LiveRunningStatus;
import data.LiveRunningData;
import data.TrainRoute;
import gui.ErrorDialogBox;
import gui.RunningStatusTab;
import gui.SearchingDialog;

public class LiveStatusSearchButtonListener implements ActionListener {

	private RunningStatusTab tab = null;
	private SwingWorker<Void, Void> downloader;
	private LiveRunningData data;

	public LiveStatusSearchButtonListener(RunningStatusTab tab) {
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
					data = LiveRunningStatus.getLiveRunningStatus(tab.getTrain(), tab.getDate(), tab.getApiKey());
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
						tab.setLiveRunningStatusData(data);
						tab.getStationSelector().removeAllItems();
						for (TrainRoute route : data.getRoute()) {
							tab.getStationSelector().addItem(route.getStation().getName());
						}
						tab.activateGetStatusButton();
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
