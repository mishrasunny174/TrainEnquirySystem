package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrainBetweenStationsTab {

	private JPanel panel = null;
	private JFrame parent = null;
	private String apikey = null;

	public TrainBetweenStationsTab(JFrame parent, String apikey) {
		this.parent = parent;
		this.apikey = apikey;
		panel = new JPanel();
	}

	public JPanel getPanel() {
		return panel;
	}
}
