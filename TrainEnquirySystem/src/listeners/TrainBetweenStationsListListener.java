package listeners;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import data.Train;
import gui.TrainBetweenStationsTab;
import gui.TrainDetailsDialog;

public class TrainBetweenStationsListListener implements ListSelectionListener {

	private TrainBetweenStationsTab tab;

	public TrainBetweenStationsListListener(TrainBetweenStationsTab tab) {
		this.tab = tab;
	}

	@Override
	public void valueChanged(ListSelectionEvent le) {
		Train train = tab.getData().getTrains()[tab.getTrainList().getSelectedIndex()];
		new TrainDetailsDialog(tab.getParent(), train).show();
	}

}
