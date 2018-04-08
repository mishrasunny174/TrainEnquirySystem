package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrainBetweenStationsTab {

	private JPanel panel = null;
	private JFrame parent = null;
	private String apikey = null;

	public TrainBetweenStationsTab(JFrame parent, String apikey) {
		this.setParent(parent);
		this.setApikey(apikey);
		panel = new JPanel();
	}

	public JPanel getPanel() {
		return panel;
	}

	public JFrame getParent() {
		return parent;
	}

	public void setParent(JFrame parent) {
		this.parent = parent;
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}
}
