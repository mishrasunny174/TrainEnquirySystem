package gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import listeners.StationSearchButtonListener;

public class StationSearchTab {

	private JFrame parent = null;
	private String apikey = null;
	private JPanel panel = null;
	private JLabel stationNameLabel = null;
	private JTextField stationNameText = null;
	private JButton searchButton = null;
	private JList<String> stationCodeList = null;
	private JLabel nameLabel = null;
	private JScrollPane stationCodeListPane;
	private JPanel nameLabelPanel;

	public StationSearchTab(JFrame parent, String apikey) {
		this.parent = parent;
		this.apikey = apikey;
		panel = new JPanel();
		stationCodeList = new JList<>();
		stationNameLabel = new JLabel("Station Name : ");
		stationNameText = new JTextField(15);
		searchButton = new JButton("Search");
		nameLabel = new JLabel("Results");
		nameLabelPanel = new JPanel();

		panel.setLayout(new GridBagLayout());
		GridBagConstraints panelGbc = new GridBagConstraints();

		Font panelFont = new Font(Font.SANS_SERIF, Font.BOLD, 25);

		// adding Train Name label
		panelGbc.weightx = 0.5;
		panelGbc.gridx = 1;
		panelGbc.gridy = 0;
		stationNameLabel.setFont(panelFont);
		panel.add(stationNameLabel, panelGbc);

		// adding Train name text field
		panelGbc.weightx = 0.5;
		panelGbc.gridx = 2;
		panelGbc.gridy = 0;
		stationNameText.setFont(panelFont);
		panel.add(stationNameText, panelGbc);

		// adding separator
		panelGbc.weightx = 0.25;
		panelGbc.gridx = 3;
		panelGbc.gridy = 0;

		panelGbc.fill = GridBagConstraints.VERTICAL;
		panelGbc.gridheight = 1;
		panel.add(new JSeparator(SwingConstants.VERTICAL), panelGbc);

		// adding search button
		panelGbc.weightx = 0.5;
		panelGbc.gridx = 4;
		panelGbc.gridy = 0;
		searchButton.setFont(panelFont);
		panel.add(searchButton, panelGbc);

		// adding horizontal separator
		panelGbc.weightx = 0.25;
		panelGbc.gridx = 0;
		panelGbc.gridy = 1;

		panelGbc.fill = GridBagConstraints.HORIZONTAL;
		panelGbc.gridwidth = 12;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL), panelGbc);

		// adding label results

		panelGbc.gridx = 0;
		panelGbc.gridy = 3;
		panelGbc.weightx = 2;
		panelGbc.gridwidth = 16;
		panelGbc.weighty = 0;
		panelGbc.fill = GridBagConstraints.HORIZONTAL;
		nameLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		nameLabelPanel.add(nameLabel);
		panel.add(nameLabelPanel, panelGbc);

		// adding horizontal separator
		panelGbc.weightx = 0.25;
		panelGbc.gridx = 0;
		panelGbc.gridy = 4;
		panelGbc.fill = GridBagConstraints.HORIZONTAL;
		panelGbc.gridwidth = 12;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL), panelGbc);

		// adding trainlist
		panelGbc.gridx = 0;
		panelGbc.gridy = 5;
		panelGbc.gridwidth = 12;
		panelGbc.gridheight = 2;
		panelGbc.weighty = 0.10;
		panelGbc.weightx = 0;
		panelGbc.fill = GridBagConstraints.BOTH;
		String[] dataList = { "Please Search For Station Codes" };
		stationCodeList.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		stationCodeList.setListData(dataList);
		stationCodeListPane = new JScrollPane(stationCodeList);
		panel.add(stationCodeListPane, panelGbc);

		// adding listener to button
		searchButton.addActionListener(new StationSearchButtonListener(this));

	}

	public JPanel getPanel() {
		return panel;
	}

	public String getStationName() {
		return stationNameText.getText();
	}

	public String getApikey() {
		return apikey;
	}

	public JFrame getParent() {
		return parent;
	}

	public JList<String> getStationList() {
		return stationCodeList;
	}

}
