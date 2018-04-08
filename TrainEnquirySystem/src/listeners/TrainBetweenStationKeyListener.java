package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import data.Train;
import gui.TrainBetweenStationsTab;
import gui.TrainDetailsDialog;

public class TrainBetweenStationKeyListener implements KeyListener {

	private TrainBetweenStationsTab tab;
	
	public TrainBetweenStationKeyListener(TrainBetweenStationsTab tab) {
		this.tab=tab;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar()==KeyEvent.VK_ENTER) {
			Train train = tab.getData().getTrains()[tab.getTrainList().getSelectedIndex()];
			new TrainDetailsDialog(tab.getParent(), train).show();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
