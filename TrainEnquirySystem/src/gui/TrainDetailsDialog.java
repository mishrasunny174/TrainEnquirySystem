package gui;

import java.awt.Color;
import java.awt.Dimension;
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

import data.Days;
import data.Train;

public class TrainDetailsDialog {
	private JDialog dialogMain;
	private JLabel name;
	private JTextArea nameData;
	private JLabel code;
	private JTextArea codeData;
	private JLabel sourceStation;
	private JTextArea sourceStationData;
	private JLabel destStation;
	private JTextArea destStationData;
	private JLabel sourceDepartureTime;
	private JTextArea sourceDepartureTimeData;
	private JLabel destArrivalTime;
	private JTextArea destArrivalTimeData;
	private JLabel travelTime;
	private JTextArea travelTimeData;
	private JLabel runningDays;
	private JTextArea runningDaysData;
	private JButton okay;
	private Train train;
	private JPanel dialog;
	
	public TrainDetailsDialog(JFrame parent,Train train) {
		this.dialogMain = new JDialog(parent,"Train Details");
		dialogMain.setLocation(508, 235);
		this.train=train;
		dialog = new JPanel();
		name = new JLabel("Name");
		nameData = new JTextArea(1,20);
		nameData.setEditable(false);
		code = new JLabel("Train Number");
		codeData = new JTextArea(1,20);
		codeData.setEditable(false);
		sourceStation = new JLabel("Source");
		sourceStationData = new JTextArea(1,20);
		sourceStationData.setEditable(false);
		destStation = new JLabel("Destination");
		destStationData = new JTextArea(1,20);
		destStationData.setEditable(false);
		sourceDepartureTime = new JLabel("Source Departure Time");
		sourceDepartureTimeData = new JTextArea(1,20);
		sourceDepartureTimeData.setEditable(false);
		destArrivalTime = new JLabel("Destination Arrival Time");
		destArrivalTimeData = new JTextArea(1,20);
		destArrivalTimeData.setEditable(false);
		travelTime = new JLabel("Travel Time");
		travelTimeData = new JTextArea(1,20);
		travelTimeData.setEditable(false);
		runningDays = new JLabel("Running Days");
		runningDaysData = new JTextArea(1,20);
		runningDaysData.setEditable(false);
		okay = new JButton("OK");
	}
	
	public void show() {
		//configuring dialog
		dialogMain.setSize(new Dimension(400,400));
		dialogMain.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		dialogMain.add(dialog);
		dialog.setLayout(new GridBagLayout());
		dialog.setBackground(Color.WHITE);
		dialog.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		GridBagConstraints gbc = new GridBagConstraints();

		//will be default
		gbc.weightx=0.20;
		gbc.weighty=0.20;
		//for most
		
		//adding name label
		gbc.gridx=0;
		gbc.gridy=0;
		dialog.add(name,gbc);
		
		//adding vertical separator
		gbc.gridx++;
		gbc.fill=GridBagConstraints.VERTICAL;
		gbc.weightx=0.10;
		dialog.add(new JSeparator(SwingConstants.VERTICAL), gbc);
		gbc.weightx=0.20;
		gbc.fill=0;
		
		//adding name data
		gbc.gridx++;
		nameData.setText(train.getName());
		dialog.add(nameData, gbc);
		
		//adding horizontal separator
		gbc.gridy++;
		gbc.gridx=0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=3;
		gbc.weighty=0.10;
		dialog.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);
		gbc.gridy++;
		gbc.fill = 0;
		gbc.gridwidth=1;
		gbc.weighty=0.20;
		
		//adding code label
		gbc.gridx=0;
		dialog.add(code,gbc);
		
		//adding vertical separator
		gbc.gridx++;
		gbc.fill=GridBagConstraints.VERTICAL;
		gbc.weightx=0.10;
		dialog.add(new JSeparator(SwingConstants.VERTICAL), gbc);
		gbc.weightx=0.20;
		gbc.fill=0;
		
		//adding code data
		gbc.gridx++;
		codeData.setText(train.getNumber());
		dialog.add(codeData, gbc);
		
		//adding horizontal separator
		gbc.gridy++;
		gbc.gridx=0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=3;
		gbc.weighty=0.10;
		dialog.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);
		gbc.gridy++;
		gbc.fill = 0;
		gbc.gridwidth=1;
		gbc.weighty=0.20;
		
		//adding sourceStation label
		gbc.gridx=0;
		dialog.add(sourceStation,gbc);
		
		//adding vertical separator
		gbc.gridx++;
		gbc.fill=GridBagConstraints.VERTICAL;
		gbc.weightx=0.10;
		dialog.add(new JSeparator(SwingConstants.VERTICAL), gbc);
		gbc.weightx=0.20;
		gbc.fill=0;
		
		//adding source Station data
		gbc.gridx++;
		sourceStationData.setText(train.getFrom_station().getName());
		dialog.add(sourceStationData, gbc);
		
		//adding horizontal separator
		gbc.gridy++;
		gbc.gridx=0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=3;
		gbc.weighty=0.10;
		dialog.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);
		gbc.gridy++;
		gbc.fill = 0;
		gbc.gridwidth=1;
		gbc.weighty=0.20;
		
		//adding destStation label
		gbc.gridx=0;
		dialog.add(destStation,gbc);
		
		//adding vertical separator
		gbc.gridx++;
		gbc.fill=GridBagConstraints.VERTICAL;
		gbc.weightx=0.10;
		dialog.add(new JSeparator(SwingConstants.VERTICAL), gbc);
		gbc.weightx=0.20;
		gbc.fill=0;
		
		//adding destStationData data
		gbc.gridx++;
		destStationData.setText(train.getTo_station().getName());
		dialog.add(destStationData, gbc);
		
		//adding horizontal separator
		gbc.gridy++;
		gbc.gridx=0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=3;
		gbc.weighty=0.10;
		dialog.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);
		gbc.gridy++;
		gbc.fill = 0;
		gbc.gridwidth=1;
		gbc.weighty=0.20;
		
		
		//adding source departure time label
		gbc.gridx=0;
		dialog.add(sourceDepartureTime,gbc);
		
		//adding vertical separator
		gbc.gridx++;
		gbc.fill=GridBagConstraints.VERTICAL;
		gbc.weightx=0.10;
		dialog.add(new JSeparator(SwingConstants.VERTICAL), gbc);
		gbc.weightx=0.20;
		gbc.fill=0;
		
		//adding code data
		gbc.gridx++;
		sourceDepartureTimeData.setText(train.getSrc_departure_time());
		dialog.add(sourceDepartureTimeData, gbc);
		
		//adding horizontal separator
		gbc.gridy++;
		gbc.gridx=0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=3;
		gbc.weighty=0.10;
		dialog.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);
		gbc.gridy++;
		gbc.fill = 0;
		gbc.gridwidth=1;
		gbc.weighty=0.20;

		//adding destination arrival Time label
		gbc.gridx=0;
		dialog.add(destArrivalTime,gbc);
		
		//adding vertical separator
		gbc.gridx++;
		gbc.fill=GridBagConstraints.VERTICAL;
		gbc.weightx=0.10;
		dialog.add(new JSeparator(SwingConstants.VERTICAL), gbc);
		gbc.weightx=0.20;
		gbc.fill=0;
		
		//adding destination arrival time data
		gbc.gridx++;
		destArrivalTimeData.setText(train.getDest_arrival_time());
		dialog.add(destArrivalTimeData, gbc);
		
		//adding horizontal separator
		gbc.gridy++;
		gbc.gridx=0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=3;
		gbc.weighty=0.10;
		dialog.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);
		gbc.gridy++;
		gbc.fill = 0;
		gbc.gridwidth=1;
		gbc.weighty=0.20;
		
		//adding travel Time label
		gbc.gridx=0;
		dialog.add(travelTime,gbc);
		
		//adding vertical separator
		gbc.gridx++;
		gbc.fill=GridBagConstraints.VERTICAL;
		gbc.weightx=0.10;
		dialog.add(new JSeparator(SwingConstants.VERTICAL), gbc);
		gbc.weightx=0.20;
		gbc.fill=0;
		
		//adding destination arrival time data
		gbc.gridx++;
		travelTimeData.setText(train.getTravel_time());
		dialog.add(travelTimeData, gbc);
		
		//adding horizontal separator
		gbc.gridy++;
		gbc.gridx=0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=3;
		gbc.weighty=0.10;
		dialog.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);
		gbc.gridy++;
		gbc.fill = 0;
		gbc.gridwidth=1;
		gbc.weighty=0.20;
		
		//adding running days label
		gbc.gridx=0;
		dialog.add(runningDays,gbc);
		
		//adding vertical separator
		gbc.gridx++;
		gbc.fill=GridBagConstraints.VERTICAL;
		gbc.weightx=0.10;
		dialog.add(new JSeparator(SwingConstants.VERTICAL), gbc);
		gbc.weightx=0.20;
		gbc.fill=0;
		
		//adding running days data
		gbc.gridx++;
		StringBuffer days = new StringBuffer();
		for(Days day : train.getDays()) {
			days.append(day.getCode()+" ");
		}
		runningDaysData.setText(days.toString());
		dialog.add(runningDaysData, gbc);
		
		//adding horizontal separator
		gbc.gridy++;
		gbc.gridx=0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=3;
		gbc.weighty=0.10;
		dialog.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);
		gbc.gridy++;
		gbc.fill = 0;
		gbc.gridwidth=1;
		gbc.weighty=0.20;
		
		//adding okay button
		gbc.gridx=0;
		gbc.gridwidth=3;
		okay.addActionListener((ae)->{
			dialogMain.setVisible(false);
		});
		gbc.fill=GridBagConstraints.HORIZONTAL;
		dialog.add(okay, gbc);
		
		//making dialog visible
		dialogMain.setVisible(true);
	}
}
