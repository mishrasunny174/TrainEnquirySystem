package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingWorker;

import api.EmptyArgumentsException;
import api.PNRStatus;
import data.PNRStatusData;
import gui.ErrorDialogBox;
import gui.PnrStatusDialog;
import gui.PnrStatusTab;
import gui.SearchingDialog;

public class PNRStatusButtonListener implements ActionListener {

	private PnrStatusTab tab;
	private PNRStatusData data;
	private SwingWorker<Void, Void> downloader;
	public PNRStatusButtonListener(PnrStatusTab tab) {
		this.tab=tab;
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
					data = PNRStatus.getPNRStatus(tab.getPnr(), tab.getApikey());
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
						new PnrStatusDialog(tab.getParent(), data).show();
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
						new ErrorDialogBox(tab.getParent(), "Invalid  Input.").show();
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
