package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import gui.TrainBetweenStationsTab;
import gui.TrainDetailsDialog;

public class TrainBetweenStationsMouseAdapter extends MouseAdapter {
	
	private TrainBetweenStationsTab tab;
	
	public TrainBetweenStationsMouseAdapter(TrainBetweenStationsTab tab) {
		this.tab = tab;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		new TrainDetailsDialog(tab.getParent(),tab.getData().getTrains()[tab.getTrainList().getSelectedIndex()]).show();
	}
}
