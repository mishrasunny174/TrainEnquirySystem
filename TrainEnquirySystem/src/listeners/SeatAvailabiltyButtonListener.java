package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingWorker;

import api.EmptyArgumentsException;
import api.SeatAvailabilty;
import data.SeatAvailabilityData;
import gui.ErrorDialogBox;
import gui.SearchingDialog;
import gui.SeatAvailabiltyDialog;
import gui.SeatAvailabiltyTab;

public class SeatAvailabiltyButtonListener implements ActionListener {

	private SeatAvailabiltyTab tab;
	private SeatAvailabilityData data;
	private SwingWorker<Void, Void> downloader;

	public SeatAvailabiltyButtonListener(SeatAvailabiltyTab tab) {
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
					data = SeatAvailabilty.getSeatAvailability(tab.getTrain(), tab.getSource(), tab.getDest(),
							tab.getDate(), tab.getClassCode(), tab.getQuota(), tab.getApikey());
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
						new SeatAvailabiltyDialog(tab.getParent(), data).show();
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
						new ErrorDialogBox(tab.getParent(), "Invalid data in fields").show();
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
				} else if (isInputFieldEmpty) {
					new ErrorDialogBox(tab.getParent(), "Input fields are empty").show();
				} else {
					new ErrorDialogBox(tab.getParent(), "Unable to connect to server").show();
				}
			}

		};
		downloader.execute();
	}

}
