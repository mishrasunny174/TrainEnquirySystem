package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.LiveRunningData;

public class RunningStatusTab {

	private JPanel panel = null;
	private JLabel trainNumber = null;
	private JTextField trainNumberInput = null;
	private JLabel date = null;
	private JTextField dateInput = null;
	private JButton search = null;
	private JPanel searchPanel = null;
	private String apiKey = null;
	private LiveRunningData data = null;
	private JComboBox<String> stationList = null;

	public RunningStatusTab(String apiKey) {
		this.apiKey = apiKey;
		panel = new JPanel();

		// configuring components of searchPanel and adding them to search panel
		trainNumber = new JLabel("Train Number: ");
		trainNumberInput = new JTextField(10);
		searchPanel = new JPanel();
		searchPanel.setLayout(new GridBagLayout());
		date = new JLabel("Date: ");
		dateInput = new JTextField(10);
		search = new JButton("Search");
		GridBagConstraints searchPanelGbc = new GridBagConstraints();
		searchPanelGbc.gridy = 0;
		searchPanelGbc.gridx = 0;
		searchPanelGbc.gridwidth = 3;
		searchPanelGbc.fill = GridBagConstraints.HORIZONTAL;
		searchPanel.add(trainNumber, searchPanelGbc);
		searchPanelGbc.gridx = 4;
		searchPanel.add(trainNumberInput, searchPanelGbc);
		searchPanel.add(date);
		searchPanel.add(dateInput);
		searchPanel.add(search);

		// configuring panel components and adding them to panel
		panel.setLayout(new GridBagLayout());
		GridBagConstraints panelGbc = new GridBagConstraints();
		panelGbc.gridx = 0;
		panelGbc.gridy = 0;
		panelGbc.fill = GridBagConstraints.HORIZONTAL;
		panelGbc.weightx = 1;
		panel.add(searchPanel, panelGbc);
	}

	public JPanel getPanel() {
		return panel;
	}

	public String getTrain() {
		return trainNumber.getText();
	}
	
	public String getDate() {
		return date.getText();
	}

	public String getApiKey() {
		return apiKey;
	}
	
	public void setLiveRunningStatusData(LiveRunningData data) {
		this.data = data;
	}
}