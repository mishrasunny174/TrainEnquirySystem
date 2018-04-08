package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import data.TrainRoute;

public class RunningStatusDialog {
	private JPanel headerPanel = null;
	private JLabel headerLabel = null;
	private JDialog stationDialog = null;
	private JLabel station = null;
	private JTextArea stationData = null;
	private JLabel code = null;
	private JTextArea codeData = null;
	private JLabel scheduledArrival = null;
	private JTextArea scheduledArrivalData = null;
	private JLabel scheduledDeparture = null;
	private JTextArea scheduledDepartureData = null;
	private JLabel actualArrival = null;
	private JTextArea actualArrivalData = null;
	private JLabel actualDeparture = null;
	private JTextArea actualDepartureData = null;
	private JLabel late = null;
	private JTextArea lateData = null;
	private JLabel currentPosition = null;
	private JTextArea currentPositionData = null;
	private JPanel panel = null;
	private JButton ok = null;

	public RunningStatusDialog(JFrame parent,TrainRoute route, String position) {
		stationDialog = new JDialog(parent);
		stationDialog.setTitle("Running Status");
		stationDialog.setSize(420, 300);
		stationDialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		stationDialog.setLayout(new GridBagLayout());

		// configuring status
		GridBagConstraints stationPanelGbc = new GridBagConstraints();
		stationPanelGbc.gridx = 0;
		stationPanelGbc.gridy = 0;
		stationPanelGbc.weighty = 0;
		headerPanel = new JPanel();
		headerPanel.setBackground(Color.WHITE);
		headerLabel = new JLabel("Running Status");
		headerLabel.setBackground(Color.WHITE);
		headerLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
		headerLabel.setForeground(Color.RED);
		headerPanel.add(headerLabel);
		stationDialog.add(headerPanel, stationPanelGbc);
		stationDialog.setBackground(Color.WHITE);

		// adding data panel
		stationPanelGbc.gridy = 1;
		stationPanelGbc.weighty = 0.90;
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		stationDialog.add(panel, stationPanelGbc);

		// adding ok button
		ok = new JButton("OK");
		ok.addActionListener((ae) -> {
			stationDialog.setVisible(false);
		});
		stationPanelGbc.gridy = 2;
		stationPanelGbc.weighty = 0.10;
		stationPanelGbc.fill = GridBagConstraints.HORIZONTAL;
		stationDialog.add(ok, stationPanelGbc);

		// station code and station code data configuration
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.25;
		station = new JLabel("Station Name");
		panel.add(station, gbc);
		gbc.gridx = 1;
		gbc.weightx = 0.10;
		gbc.fill = GridBagConstraints.VERTICAL;
		panel.add(new JSeparator(SwingConstants.VERTICAL), gbc);
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridx = 2;
		stationData = new JTextArea(1, 20);
		stationData.setEditable(false);
		stationData.setText(route.getStation().getName());
		panel.add(stationData, gbc);
		gbc.gridy = 2;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 3;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);

		// stationCode and stationCode data configuration
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridwidth = 1;
		code = new JLabel("Station Code");
		panel.add(code, gbc);
		gbc.gridx = 1;
		gbc.weightx = 0.10;
		gbc.fill = GridBagConstraints.VERTICAL;
		panel.add(new JSeparator(SwingConstants.VERTICAL), gbc);
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridx = 2;
		codeData = new JTextArea(1, 20);
		codeData.setEditable(false);
		codeData.setText(route.getStation().getCode());
		panel.add(codeData, gbc);
		gbc.gridy = 4;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 3;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);

		// scheduled arrival and scheduled arrival data configuration
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridwidth = 1;
		scheduledArrival = new JLabel("Scheduled Arrival");
		panel.add(scheduledArrival, gbc);
		gbc.gridx = 1;
		gbc.weightx = 0.10;
		gbc.fill = GridBagConstraints.VERTICAL;
		panel.add(new JSeparator(SwingConstants.VERTICAL), gbc);
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridx = 2;
		scheduledArrivalData = new JTextArea(1, 20);
		scheduledArrivalData.setEditable(false);
		scheduledArrivalData.setText(route.getScharr());
		panel.add(scheduledArrivalData, gbc);
		gbc.gridy = 6;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 3;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);

		// scheduled departure and scheduled departure data configuration
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridwidth = 1;
		scheduledDeparture = new JLabel("Scheduled Departure");
		panel.add(scheduledDeparture, gbc);
		gbc.gridx = 1;
		gbc.weightx = 0.10;
		gbc.fill = GridBagConstraints.VERTICAL;
		panel.add(new JSeparator(SwingConstants.VERTICAL), gbc);
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridx = 2;
		scheduledDepartureData = new JTextArea(1, 20);
		scheduledDepartureData.setEditable(false);
		scheduledDepartureData.setText(route.getSchdep());
		panel.add(scheduledDepartureData, gbc);
		gbc.gridy = 8;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 3;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);

		// actual arrival and actual arrival data configuration
		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridwidth = 1;
		actualArrival = new JLabel("Expected Arrival");
		panel.add(actualArrival, gbc);
		gbc.gridx = 1;
		gbc.weightx = 0.10;
		gbc.fill = GridBagConstraints.VERTICAL;
		panel.add(new JSeparator(SwingConstants.VERTICAL), gbc);
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridx = 2;
		actualArrivalData = new JTextArea(1, 20);
		actualArrivalData.setEditable(false);
		actualArrivalData.setText(route.getActarr());
		panel.add(actualArrivalData, gbc);
		gbc.gridy = 10;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 3;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);

		// actual departure and actual departure data configuration
		gbc.gridx = 0;
		gbc.gridy = 11;
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridwidth = 1;
		actualDeparture = new JLabel("Expected departure");
		panel.add(actualDeparture, gbc);
		gbc.gridx = 1;
		gbc.weightx = 0.10;
		gbc.fill = GridBagConstraints.VERTICAL;
		panel.add(new JSeparator(SwingConstants.VERTICAL), gbc);
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridx = 2;
		actualDepartureData = new JTextArea(1, 20);
		actualDepartureData.setEditable(false);
		actualDepartureData.setText(route.getActdep());
		panel.add(actualDepartureData, gbc);
		gbc.gridy = 12;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 3;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);

		// late and late data configuration
		gbc.gridx = 0;
		gbc.gridy = 13;
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridwidth = 1;
		late = new JLabel("Delay");
		panel.add(late, gbc);
		gbc.gridx = 1;
		gbc.weightx = 0.10;
		gbc.fill = GridBagConstraints.VERTICAL;
		panel.add(new JSeparator(SwingConstants.VERTICAL), gbc);
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridx = 2;
		lateData = new JTextArea(1, 20);
		lateData.setEditable(false);
		lateData.setText("" + route.getLatemin());
		panel.add(lateData, gbc);
		gbc.gridy = 14;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 3;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);

		// current status and currentStatus data configuration
		gbc.gridx = 0;
		gbc.gridy = 15;
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridwidth = 2;
		gbc.gridwidth = 1;
		currentPosition = new JLabel("Current Position");
		panel.add(currentPosition, gbc);
		gbc.gridx = 1;
		gbc.weightx = 0.10;
		gbc.fill = GridBagConstraints.VERTICAL;
		panel.add(new JSeparator(SwingConstants.VERTICAL), gbc);
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridx = 2;
		currentPositionData = new JTextArea(2, 20);
		currentPositionData.setEditable(false);
		currentPositionData.setText(position);
		panel.add(currentPositionData, gbc);

	}

	public void show() {
		stationDialog.setVisible(true);
	}
}
