package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.RunningStatusDialog;
import gui.RunningStatusTab;

public class ShowStatusButtonListenerRunningStatus implements ActionListener {

	private RunningStatusTab tab = null;
	public ShowStatusButtonListenerRunningStatus(RunningStatusTab tab) {
		this.tab=tab;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new RunningStatusDialog(tab.getParent(),tab.getData().getRoute()[tab.getStationSelector().getSelectedIndex()],
				tab.getData().getPosition()).show();
	}

}
