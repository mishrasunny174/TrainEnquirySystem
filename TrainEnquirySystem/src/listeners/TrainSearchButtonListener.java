package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.SwingWorker;

import api.EmptyArgumentsException;
import api.TrainSearch;
import data.Train;
import data.TrainSearchData;
import gui.ErrorDialogBox;
import gui.SearchingDialog;
import gui.TrainSearchTab;

public class TrainSearchButtonListener implements ActionListener {

	private SwingWorker<Void, Void> downloader;
	private TrainSearchData data;
	private TrainSearchTab tab;

	public TrainSearchButtonListener(TrainSearchTab tab) {
		this.tab = tab;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SearchingDialog searching = new SearchingDialog(null);
		searching.show();
		downloader = new SwingWorker<Void, Void>() {

			private boolean isInputFieldsEmpty = false;

			@Override
			protected Void doInBackground() throws Exception {
				try {
					data = TrainSearch.getTrains(tab.getTrainName(), tab.getApikey());
				} catch (EmptyArgumentsException e) {
					isInputFieldsEmpty = true;
				}
				return null;
			}

			@Override
			protected void done() {
				searching.hide();
				if (data != null) {
					switch (data.getResponse_code()) {
					case 200:
						Vector<String> datalist = new Vector<>();
						if( data.getTrains().length == 0)
							datalist.add("0 Results for this query");
						for (Train train : data.getTrains()) {
							datalist.add(train.getNumber()+" : " +train.getName());
						}
						tab.getTrainsList().setListData(datalist);
						break;
					case 210:
						new ErrorDialogBox(tab.getParent(), "Train doesn�t run on the date queried.").show();
						break;
					case 211:
						new ErrorDialogBox(tab.getParent(), "Train doesn�t have journey class queried.").show();
						break;
					case 220:
						new ErrorDialogBox(tab.getParent(), "Flushed PNR.").show();
						break;
					case 221:
						new ErrorDialogBox(tab.getParent(), "Invalid PNR.").show();
						break;
					case 230:
						new ErrorDialogBox(tab.getParent(), "Invalid Input").show();
						break;
					case 404:
						new ErrorDialogBox(tab.getParent(), "Data is not avaialable for this query").show();
						break;
					case 405:
						new ErrorDialogBox(tab.getParent(), "Unable to reach server").show();
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
				} else if (isInputFieldsEmpty) {
					new ErrorDialogBox(tab.getParent(), "Input fields are empty").show();
				} else {
					new ErrorDialogBox(tab.getParent(), "Unable to connect to server").show();
				}
			}

		};
		downloader.execute();
	}

}
