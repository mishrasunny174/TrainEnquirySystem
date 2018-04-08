package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import data.LiveRunningData;
import listeners.LiveStatusSearchButtonListener;
import listeners.ShowStatusButtonListenerRunningStatus;

public class RunningStatusTab {

	private JPanel panel = null;
	private JLabel trainNumber = null;
	private JTextField trainNumberInput = null;
	private JLabel date = null;
	private JTextField dateInput = null;
	private JButton search = null;
	private JLabel stationLabel = null;
	private JButton statusButton = null;
	private JComboBox<String> stationSelector = null;
	private String apikey = null;
	private LiveRunningData data = null;
	private JFrame parent;

	public RunningStatusTab(JFrame parent, String apikey) {
		// panel configuration
		this.parent = parent;
		this.apikey = apikey;
		panel = new JPanel();
		stationSelector = new JComboBox<>();
		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		// Grid Bag constraint to set layout of panel
		GridBagConstraints panelGbc = new GridBagConstraints();
		panelGbc.weightx=0.20; //constant for whole program
		panelGbc.weighty=0.20;
		
		//font to be used for everything
		Font trainfont = new Font(Font.SANS_SERIF, Font.BOLD, 20);

		// train Number Label configuration
		trainNumber = new JLabel("Train Number");
		trainNumber.setFont(trainfont);
		panelGbc.gridx=0;
		panelGbc.gridy=0;
		panel.add(trainNumber,panelGbc);
		
		//separator vertical
		panelGbc.gridx++;
		panelGbc.fill=GridBagConstraints.VERTICAL;
		panelGbc.weightx=0.10;
		panel.add(new JSeparator(SwingConstants.VERTICAL),panelGbc);
		panelGbc.fill=0;
		panelGbc.weightx=0.20;
		
		//train number input configuration
		trainNumberInput = new JTextField(25);
		trainNumberInput.setFont(trainfont);
		panelGbc.gridx++;
		panel.add(trainNumberInput,panelGbc);
		
		//separator horizontal
		panelGbc.gridy++;
		panelGbc.gridx=0;
		panelGbc.gridwidth=3;
		panelGbc.weighty=0.0;
		panelGbc.fill=GridBagConstraints.HORIZONTAL;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL),panelGbc);
		panelGbc.gridwidth=1;
		panelGbc.fill=0;
		panelGbc.weighty=0.20;
		panelGbc.gridy++;
		
		// date label configuration
		date = new JLabel("Date");
		date.setFont(trainfont);
		panelGbc.gridx=0;
		panel.add(date,panelGbc);
		
		//separator vertical
		panelGbc.gridx++;
		panelGbc.fill=GridBagConstraints.VERTICAL;
		panelGbc.weightx=0.10;
		panel.add(new JSeparator(SwingConstants.VERTICAL),panelGbc);
		panelGbc.fill=0;
		panelGbc.weightx=0.20;
		
		//date input configuration
		dateInput = new JTextField(25);
		dateInput.setFont(trainfont);
		panelGbc.gridx++;
		panel.add(dateInput,panelGbc);
		
		//separator horizontal
		panelGbc.gridy++;
		panelGbc.gridx=0;
		panelGbc.gridwidth=3;
		panelGbc.weighty=0.0;
		panelGbc.fill=GridBagConstraints.HORIZONTAL;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL),panelGbc);
		panelGbc.gridwidth=1;
		panelGbc.fill=0;
		panelGbc.weighty=0.20;
		panelGbc.gridy++;

		// Search Button Configuration
		panelGbc.gridx=0;
		panelGbc.gridwidth=3;
		panelGbc.fill=GridBagConstraints.HORIZONTAL;
		search = new JButton("Search Trains");
		search.addActionListener(new LiveStatusSearchButtonListener(this));
		search.setFont(trainfont);
		panel.add(search,panelGbc);
		panelGbc.gridwidth=1;
		panelGbc.fill=0;
		
		//separator horizontal
		panelGbc.gridy++;
		panelGbc.gridx=0;
		panelGbc.gridwidth=3;
		panelGbc.weighty=0.0;
		panelGbc.fill=GridBagConstraints.HORIZONTAL;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL),panelGbc);
		panelGbc.gridwidth=1;
		panelGbc.fill=0;
		panelGbc.weighty=0.20;
		panelGbc.gridy++;

		// station selection label configuration
		stationLabel = new JLabel("Select Station:");
		stationLabel.setFont(trainfont);
		panelGbc.gridx=0;
		panel.add(stationLabel,panelGbc);

		//separator vertical
		panelGbc.gridx++;
		panelGbc.fill=GridBagConstraints.VERTICAL;
		panelGbc.weightx=0.10;
		panel.add(new JSeparator(SwingConstants.VERTICAL),panelGbc);
		panelGbc.fill=0;
		panelGbc.weightx=0.20;
		
		// station selector configuration
		stationSelector.addItem("Please Search A Train First");
		stationSelector.setFont(trainfont);
		panelGbc.gridx++;
		panel.add(stationSelector,panelGbc);
		
		//separator horizontal
		panelGbc.gridy++;
		panelGbc.gridx=0;
		panelGbc.gridwidth=3;
		panelGbc.weighty=0.0;
		panelGbc.fill=GridBagConstraints.HORIZONTAL;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL),panelGbc);
		panelGbc.gridwidth=1;
		panelGbc.fill=0;
		panelGbc.weighty=0.20;
		panelGbc.gridy++;

		// show status button configuration
		statusButton = new JButton("Show Status");
		statusButton.setFont(trainfont);
		statusButton.setEnabled(false);
		statusButton.addActionListener(new ShowStatusButtonListenerRunningStatus(this));
		panelGbc.gridx=0;
		panelGbc.gridwidth=3;
		panelGbc.fill=GridBagConstraints.HORIZONTAL;
		panel.add(statusButton,panelGbc);

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
