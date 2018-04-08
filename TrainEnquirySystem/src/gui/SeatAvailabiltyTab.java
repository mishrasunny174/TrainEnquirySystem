package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SeatAvailabiltyTab {
	private JFrame parent;
	private JPanel panel;
	private String apikey;

	public SeatAvailabiltyTab(JFrame parent,String apikey) {
		this.apikey = apikey;
		this.parent = parent;
	}

	public JFrame getParent() {
		return parent;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public String getApikey() {
		return apikey;
	}
}
