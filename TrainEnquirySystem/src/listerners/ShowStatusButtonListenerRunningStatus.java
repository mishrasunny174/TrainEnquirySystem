package listerners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui.RunningStatusDialog;
import gui.RunningStatusTab;

public class ShowStatusButtonListenerRunningStatus implements ActionListener {

	private RunningStatusTab tab = null;
	private JFrame parent;
	public ShowStatusButtonListenerRunningStatus(JFrame parent,RunningStatusTab tab) {
		this.parent = parent;
		this.tab=tab;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new RunningStatusDialog(parent,tab.getData().getRoute()[tab.getStationSelector().getSelectedIndex()],
				tab.getData().getPosition()).show();
	}

}
