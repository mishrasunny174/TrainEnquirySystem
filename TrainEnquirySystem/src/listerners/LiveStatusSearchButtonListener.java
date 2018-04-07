package listerners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import api.LiveRunningStatus;
import api.UnableToConnectToServerException;
import data.LiveRunningData;
import gui.ErrorDialogBox;
import gui.RunningStatusTab;

public class LiveStatusSearchButtonListener implements ActionListener {

	private RunningStatusTab tab = null;
	
	public LiveStatusSearchButtonListener(RunningStatusTab tab) {
		this.tab = tab;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			LiveRunningData data = null;
			data = LiveRunningStatus.getLiveRunningStatus(tab.getTrain(), tab.getDate(), tab.getApiKey());
			tab.setLiveRunningStatusData(data);
			
		} catch (UnableToConnectToServerException e) {
			new ErrorDialogBox(e.getMessage()).show();
		}
	}

}
