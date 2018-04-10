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

import data.SeatAvailabilityData;

public class SeatAvailabiltyDialog {

	private JDialog seatDialog = null;
	private JPanel panel = null;
	private JPanel headerPanel = null;
	private JLabel headerLabel = null;
	private JLabel classLabel = null;
	private JTextArea classArea = null;
	private JLabel trainLabel = null;
	private JTextArea trainArea = null;
	private JLabel sourceLabel = null;
	private JTextArea sourceArea = null;
	private JLabel destLabel = null;
	private JTextArea destArea = null;
	private JLabel dateLabel = null;
	private JTextArea dateArea = null;
	private JLabel quotaLabel = null;
	private JTextArea quotaArea = null;
	private JLabel availabiltyLabel = null;
	private JTextArea availabiltyArea = null;
	private JButton ok = null;

	public SeatAvailabiltyDialog(JFrame parent, SeatAvailabilityData data) {
		
		seatDialog = new JDialog(parent);
		seatDialog.setTitle("seat availabilty");
		seatDialog.setSize(420, 300);
		seatDialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		seatDialog.setLayout(new GridBagLayout());
		seatDialog.setBackground(Color.WHITE);
		seatDialog.setLocation(508, 235);

		// configuring status
		GridBagConstraints seatGbc = new GridBagConstraints();
		seatGbc.gridx = 0;
		seatGbc.gridy = 0;
		seatGbc.weighty = 0;
		headerPanel = new JPanel();
		headerLabel = new JLabel("SEAT AVAILABILTY");
		headerLabel.setBackground(Color.WHITE);
		headerLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
		headerLabel.setForeground(Color.RED);
		headerPanel.add(headerLabel);
		seatDialog.add(headerPanel, seatGbc);
		seatDialog.setBackground(Color.WHITE);

		// adding data panel
		seatGbc.gridy = 1;
		seatGbc.weighty = 0.90;
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panel.setBackground(Color.WHITE);
		seatDialog.add(panel, seatGbc);

		// adding ok button
		ok = new JButton("OK");
		seatGbc.gridy = 2;
		seatGbc.weighty = 0.10;
		seatGbc.fill = GridBagConstraints.HORIZONTAL;
		seatDialog.add(ok, seatGbc);

		// journey class and journey class area configuration
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.25;
		classLabel = new JLabel("Journey Class ");
		panel.add(classLabel, gbc);
		gbc.gridx = 1;
		gbc.weightx = 0.10;
		gbc.fill = GridBagConstraints.VERTICAL;
		panel.add(new JSeparator(SwingConstants.VERTICAL), gbc);
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridx = 2;
		classArea = new JTextArea(1, 20);
		classArea.setEditable(false);
		panel.add(classArea, gbc);
		gbc.gridy = 2;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 3;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);

		// train name and train name area configuration
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridwidth = 1;
		trainLabel = new JLabel("Train Name ");
		panel.add(trainLabel, gbc);
		gbc.gridx = 1;
		gbc.weightx = 0.10;
		gbc.fill = GridBagConstraints.VERTICAL;
		panel.add(new JSeparator(SwingConstants.VERTICAL), gbc);
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridx = 2;
		trainArea = new JTextArea(1, 20);
		trainArea.setEditable(false);
		panel.add(trainArea, gbc);
		gbc.gridy = 4;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 3;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);

		// source and source area configuration
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridwidth = 1;
		sourceLabel = new JLabel(" Source ");
		panel.add(sourceLabel, gbc);
		gbc.gridx = 1;
		gbc.weightx = 0.10;
		gbc.fill = GridBagConstraints.VERTICAL;
		panel.add(new JSeparator(SwingConstants.VERTICAL), gbc);
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridx = 2;
		sourceArea = new JTextArea(1, 20);
		sourceArea.setEditable(false);
		panel.add(sourceArea, gbc);
		gbc.gridy = 6;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 3;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);

		// destination and destination area configuration
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridwidth = 1;
		destLabel = new JLabel(" Destination ");
		panel.add(destLabel, gbc);
		gbc.gridx = 1;
		gbc.weightx = 0.10;
		gbc.fill = GridBagConstraints.VERTICAL;
		panel.add(new JSeparator(SwingConstants.VERTICAL), gbc);
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridx = 2;
		destArea = new JTextArea(1, 20);
		destArea.setEditable(false);
		panel.add(destArea, gbc);
		gbc.gridy = 8;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 3;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);

		// date and date area configuration
		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridwidth = 1;
		dateLabel = new JLabel(" Date Of Journey ");
		panel.add(dateLabel, gbc);
		gbc.gridx = 1;
		gbc.weightx = 0.10;
		gbc.fill = GridBagConstraints.VERTICAL;
		panel.add(new JSeparator(SwingConstants.VERTICAL), gbc);
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridx = 2;
		dateArea = new JTextArea(1, 20);
		dateArea.setEditable(false);
		panel.add(dateArea, gbc);
		gbc.gridy = 10;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 3;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);

		// quota and quota area configuration
		gbc.gridx = 0;
		gbc.gridy = 11;
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridwidth = 1;
		quotaLabel = new JLabel("Quota ");
		panel.add(quotaLabel, gbc);
		gbc.gridx = 1;
		gbc.weightx = 0.10;
		gbc.fill = GridBagConstraints.VERTICAL;
		panel.add(new JSeparator(SwingConstants.VERTICAL), gbc);
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridx = 2;
		quotaArea = new JTextArea(1, 20);
		quotaArea.setEditable(false);
		panel.add(quotaArea, gbc);
		gbc.gridy = 12;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 3;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);
		
		
		// availabilty and availabilty area configuration
		gbc.gridx = 0;
		gbc.gridy = 13;
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridwidth = 1;
		availabiltyLabel = new JLabel("Seats Available ");
		panel.add(availabiltyLabel, gbc);
		gbc.gridx = 1;
		gbc.weightx = 0.10;
		gbc.fill = GridBagConstraints.VERTICAL;
		panel.add(new JSeparator(SwingConstants.VERTICAL), gbc);
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridx = 2;
		availabiltyArea = new JTextArea(1, 20);
		availabiltyArea.setEditable(false);
		panel.add(availabiltyArea, gbc);
		gbc.gridy = 14;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 3;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);
		
		//adding data to fields
		classArea.setText(data.getJourney_class().getCode());
		trainArea.setText(data.getTrain().getName());
		sourceArea.setText(data.getFrom_station().getName());
		destArea.setText(data.getTo_station().getName());
		quotaArea.setText(data.getQuota().getCode());
		dateArea.setText(data.getAvailability()[0].getDate());
		availabiltyArea.setText(data.getAvailability()[0].getStatus());
		
		//adding listener to ok button
		ok.addActionListener((ae)->{
			seatDialog.setVisible(false);
		});

	}

	

		public void show() {
			seatDialog.setVisible(true);
			
		}

	
     

	
}

