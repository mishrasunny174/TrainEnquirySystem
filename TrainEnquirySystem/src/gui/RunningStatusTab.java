package gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import data.LiveRunningData;
import listerners.LiveStatusSearchButtonListener;
import listerners.ShowStatusButtonListenerRunningStatus;

public class RunningStatusTab {

	private JPanel panel = null;
	private JPanel trainPanel = null;
	private JLabel trainNumber = null;
	private JTextField trainNumberInput = null;
	private JPanel datePanel = null;
	private JLabel date = null;
	private JTextField dateInput = null;
	private JButton search = null;
	private JPanel searchPanel = null;
	private JLabel stationLabel = null;
	private JButton statusButton = null;
	private JComboBox<String> stationSelector = null;
	private String apikey = null;
	private LiveRunningData data = null;
	private JFrame parent;
	
	public RunningStatusTab(JFrame parent,String apikey) {
		this.setParent(parent);
		this.apikey = apikey;
		panel = new JPanel();
		trainPanel = new JPanel();
		datePanel = new JPanel();
		searchPanel = new JPanel();
		stationSelector = new JComboBox<>();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints panelGbc = new GridBagConstraints();

		// train panel configuration
		Font trainfont = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		trainNumber = new JLabel("Train Number: ");
		trainNumber.setFont(trainfont);
		trainNumberInput = new JTextField(25);
		trainNumberInput.setFont(trainfont);
		trainPanel.add(trainNumber);
		trainPanel.add(trainNumberInput);

		// adding train panel to main panel
		panelGbc.gridx = 0;
		panelGbc.gridy = 0;
		panelGbc.fill = GridBagConstraints.HORIZONTAL;
		panelGbc.weightx = 0.10;
		panelGbc.weighty = 0.10;
		panel.add(trainPanel, panelGbc);

		// date panel configuration
		date = new JLabel("Date: ");
		dateInput = new JTextField(25);
		datePanel.add(date);
		date.setFont(trainfont);
		datePanel.add(dateInput);
		dateInput.setFont(trainfont);

		// adding date panel to panel
		panelGbc.gridx = 2;
		panelGbc.weightx = 0.10;
		panelGbc.weighty = 0.10;
		panel.add(datePanel, panelGbc);

		// search panel configuration
		searchPanel.setLayout(new GridBagLayout());
		GridBagConstraints searchPanelGbc = new GridBagConstraints();
		searchPanelGbc.gridx = 0;
		searchPanelGbc.gridy = 0;
		searchPanelGbc.fill = GridBagConstraints.HORIZONTAL;
		searchPanelGbc.gridwidth = 1;
		searchPanelGbc.weightx = 1;
		search = new JButton("Search");
		search.addActionListener(new LiveStatusSearchButtonListener(this));
		search.setFont(trainfont);
		searchPanel.add(search, searchPanelGbc);

		// adding search panel
		panelGbc.gridx = 4;
		panelGbc.fill = 0;
		panelGbc.gridwidth = 1;
		panelGbc.weightx = 0.30;
		panelGbc.weighty = 0.10;
		panel.add(searchPanel, panelGbc);

		// adding separator
		panelGbc.gridx = 0;
		panelGbc.gridy = 1;
		panelGbc.weighty = 0.05;
		panelGbc.gridwidth = 5;
		panelGbc.fill = GridBagConstraints.HORIZONTAL;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL), panelGbc);

		stationLabel = new JLabel("Select Station:");
		stationLabel.setFont(trainfont);
		panelGbc.gridx = 0;
		panelGbc.gridy = 2;
		panelGbc.weightx = 0;
		panelGbc.weighty = 0;
		panelGbc.gridwidth = 1;
		panelGbc.fill = 0;
		panel.add(stationLabel, panelGbc);

		stationSelector.addItem("Please Search A Train First");
		stationSelector.setFont(trainfont);
		panelGbc.gridx = 1;
		panelGbc.gridy = 2;
		panelGbc.weightx = 0.80;
		panelGbc.weighty = 0.10;
		panelGbc.gridwidth = 3;
		panelGbc.fill = GridBagConstraints.HORIZONTAL;
		panel.add(stationSelector, panelGbc);

		statusButton = new JButton("Show Status");
		statusButton.setFont(trainfont);
		statusButton.setEnabled(false);
		panelGbc.gridx = 4;
		panelGbc.gridy = 2;
		panelGbc.weightx = 0.10;
		panelGbc.weighty = 0.10;
		panelGbc.gridwidth = 1;
		panelGbc.fill = 0;
		statusButton.addActionListener(new ShowStatusButtonListenerRunningStatus(this));
		panel.add(statusButton, panelGbc);

	}

	public JPanel getPanel() {
		return panel;
	}

	public String getApiKey() {
		return apikey;
	}

	public String getTrain() {
		return trainNumberInput.getText();
	}

	public String getDate() {
		return dateInput.getText();
	}

	public void setLiveRunningStatusData(LiveRunningData data) {
		this.data = data;
	}

	public JComboBox<String> getStationSelector() {
		return stationSelector;
	}
	
	public LiveRunningData getData() {
		return data;
	}

	public void activateGetStatusButton() {
		statusButton.setEnabled(true);	
	}

	public JFrame getParent() {
		return parent;
	}

	public void setParent(JFrame parent) {
		this.parent = parent;
	}

}
