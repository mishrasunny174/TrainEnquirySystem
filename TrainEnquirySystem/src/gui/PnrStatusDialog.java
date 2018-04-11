package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import data.PNRStatusData;
import data.Passeneger;

public class PnrStatusDialog {

	private JDialog pnrDialog = null;
	private JPanel panel = null;
	private JPanel headerPanel = null;
	private JLabel headerLabel = null;
	private JLabel classLabel = null;
	private JTextArea classArea = null;
	private JLabel passengerLabel = null;
	private JTextArea passengerArea = null;
	private JLabel sourceLabel = null;
	private JTextArea sourceArea = null;
	private JLabel destLabel = null;
	private JTextArea destArea = null;
	private JLabel dateLabel = null;
	private JTextArea dateArea = null;
	private JLabel reservationLabel = null;
	private JTextArea reservationArea = null;
	private JLabel passengerlistLabel = null;
	private JList<String> passengerList = null;
	private JScrollPane passengersListScrollPane;
	private JButton ok = null;

	public PnrStatusDialog(JFrame parent, PNRStatusData data) {
		pnrDialog = new JDialog(parent);
		pnrDialog.setTitle("PNR Status");
		pnrDialog.setSize(420, 300);
		pnrDialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		pnrDialog.setAlwaysOnTop(true);
		pnrDialog.setLayout(new GridBagLayout());
		pnrDialog.setBackground(Color.WHITE);
		pnrDialog.setLocation(508, 235);

		// configuring status
		GridBagConstraints pnrGbc = new GridBagConstraints();
		pnrGbc.gridx = 0;
		pnrGbc.gridy = 0;
		pnrGbc.weighty = 0;
		headerPanel = new JPanel();
		headerLabel = new JLabel("PNR STATUS");
		headerLabel.setBackground(Color.WHITE);
		headerLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
		headerLabel.setForeground(Color.RED);
		headerPanel.add(headerLabel);
		pnrDialog.add(headerPanel, pnrGbc);
		pnrDialog.setBackground(Color.WHITE);

		// adding data panel
		pnrGbc.gridy = 1;
		pnrGbc.weighty = 0.90;
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panel.setBackground(Color.WHITE);
		pnrDialog.add(panel, pnrGbc);

		// adding ok button
		ok = new JButton("OK");
		ok.addActionListener((ae)->{
			pnrDialog.setVisible(false);
		});
		pnrGbc.gridy = 2;
		pnrGbc.weighty = 0.10;
		pnrGbc.fill = GridBagConstraints.HORIZONTAL;
		pnrDialog.add(ok, pnrGbc);

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

		// total passengers and total passengers area configuration
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridwidth = 1;
		passengerLabel = new JLabel("Total Passengers");
		panel.add(passengerLabel, gbc);
		gbc.gridx = 1;
		gbc.weightx = 0.10;
		gbc.fill = GridBagConstraints.VERTICAL;
		panel.add(new JSeparator(SwingConstants.VERTICAL), gbc);
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridx = 2;
		passengerArea = new JTextArea(1, 20);
		passengerArea.setEditable(false);
		panel.add(passengerArea, gbc);
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

		// reservation upto and reservation upto area configuration
		gbc.gridx = 0;
		gbc.gridy = 11;
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridwidth = 1;
		reservationLabel = new JLabel(" Reservation Upto ");
		panel.add(reservationLabel, gbc);
		gbc.gridx = 1;
		gbc.weightx = 0.10;
		gbc.fill = GridBagConstraints.VERTICAL;
		panel.add(new JSeparator(SwingConstants.VERTICAL), gbc);
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridx = 2;
		reservationArea = new JTextArea(1, 20);
		reservationArea.setEditable(false);
		panel.add(reservationArea, gbc);
		gbc.gridy = 12;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 3;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);

		// passenger list label configuration
		gbc.gridx = 0;
		gbc.gridy = 13;
		gbc.weightx = 0.25;
		gbc.fill = 0;
		gbc.gridwidth = 1;
		passengerlistLabel = new JLabel("    Passengers Reservation Status");
		passengerlistLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		panel.add(passengerlistLabel, gbc);
		gbc.gridy = 14;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = 3;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);

		// passenger list label
		gbc.gridx = 0;
		gbc.gridy = 15;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		passengerList = new JList<>();
		passengersListScrollPane = new JScrollPane(passengerList);
		panel.add(passengersListScrollPane, gbc);

		classArea.setText(data.getJourney_class().getCode());
		passengerArea.setText(data.getTotal_passengers() + "");
		sourceArea.setText(data.getFrom_station().getName());
		destArea.setText(data.getTo_station().getName());
		dateArea.setText(data.getDoj());
		reservationArea.setText(data.getReservation_upto().getName());
		Vector<String> passengers = new Vector<>();
		for (Passeneger passeneger : data.getPassengers()) {
			passengers.add(passeneger.getNo() + " : " + passeneger.getBooking_status());
		}
		passengerList.setListData(passengers);

	}

	public void show() {
		pnrDialog.setVisible(true);
	}

}
