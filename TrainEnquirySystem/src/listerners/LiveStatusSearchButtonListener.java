package listerners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import api.EmptyArgumentsException;
import api.LiveRunningStatus;
import api.UnableToConnectToServerException;
import data.LiveRunningData;
import data.TrainRoute;
import gui.ErrorDialogBox;
import gui.RunningStatusTab;

public class LiveStatusSearchButtonListener implements ActionListener {

	private RunningStatusTab tab = null;
	private JFrame parent;
	public LiveStatusSearchButtonListener(JFrame parent,RunningStatusTab tab) {
		this.parent = parent;
		this.tab = tab;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			LiveRunningData data = null;
			data = LiveRunningStatus.getLiveRunningStatus(tab.getTrain(), tab.getDate(), tab.getApiKey());
			tab.setLiveRunningStatusData(data);
			switch(data.getResponse_code()) {
			case 200:
				tab.getStationSelector().removeAllItems();
				for(TrainRoute route : data.getRoute()) {
					tab.getStationSelector().addItem(route.getStation().getName());
				}
				tab.activateGetStatusButton();
				break;
			case 210:
				new ErrorDialogBox(parent,"Train doesn’t run on the date queried.").show();
				break;
			case 211:
				new ErrorDialogBox(parent,"Train doesn’t have journey class queried.").show();
				break;
			case 220:
				new ErrorDialogBox(parent,"Flushed PNR.").show();
				break;
			case 221:
				new ErrorDialogBox(parent,"Invalid PNR.").show();
				break;
			case 230:
				new ErrorDialogBox(parent,"Date chosen for the query is not valid for the chosen parameters.").show();
				break;
			case 404:
				new ErrorDialogBox(parent,"Data couldn’t be loaded on our servers. No data available.").show();
				break;
			case 405:
				new ErrorDialogBox(parent,"Data couldn’t be loaded on our servers. Request couldn’t go through.").show();
				break;
			case 500:
				new ErrorDialogBox(parent,"Unauthorized API Key, Please change apikey from file menu").show();
				break;
			case 501:
				new ErrorDialogBox(parent,"Account Expired, Please change apikey from file menu").show();
				break;
			case 502:
				new ErrorDialogBox(parent,"Invalid arguments passed.").show();
			}
		} catch (UnableToConnectToServerException e) {
			new ErrorDialogBox(parent,e.getMessage()).show();
		} catch (EmptyArgumentsException e) {
			new ErrorDialogBox(parent, e.getMessage()).show();
		}
	}

}
