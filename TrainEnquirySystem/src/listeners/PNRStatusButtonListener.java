package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import api.EmptyArgumentsException;
import api.PNRStatus;
import api.UnableToConnectToServerException;
import data.PNRStatusData;
import gui.ErrorDialogBox;
import gui.PnrStatusDialog;
import gui.PnrStatusTab;

public class PNRStatusButtonListener implements ActionListener {

	private PnrStatusTab tab;
	
	public PNRStatusButtonListener(PnrStatusTab tab) {
		this.tab=tab;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			PNRStatusData data = null;
			data = PNRStatus.getPNRStatus(tab.getPnr(), tab.getApikey());
			switch (data.getResponse_code()) {
			case 200:
				new PnrStatusDialog(tab.getParent(),data).show();;
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
				new ErrorDialogBox(tab.getParent(), "Date chosen for the query is not valid for the chosen parameters.")
						.show();
				break;
			case 404:
				new ErrorDialogBox(tab.getParent(), "Data couldn’t be loaded on our servers. No data available.")
						.show();
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
