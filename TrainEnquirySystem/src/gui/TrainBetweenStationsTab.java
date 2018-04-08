package gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import data.TrainBetweenStationsData;
import listeners.TrainBetweenStationStatusButtonListener;

public class TrainBetweenStationsTab {

	private JFrame parent = null;
	private String apikey = null;
	private JPanel panel = null;
	private JLabel sourceLabel=null;
	private JTextField sourceText=null;
	private JLabel destLabel=null;
	private JTextField destText=null;
	private JLabel dateLabel=null;
	private JTextField dateText=null;
	private JButton statusButton=null;
	private JList<String> trainList = null;
	private JLabel nameLabel=null;
	private TrainBetweenStationsData data;

	public TrainBetweenStationsTab(JFrame parent, String apikey) {
		this.parent=parent;
		this.apikey=apikey;
		panel = new JPanel();
		trainList = new JList<>();
		this.apikey=apikey;
		sourceLabel=new JLabel("From : ");
		sourceText=new JTextField(10);
		destLabel=new JLabel("To : ");
		destText=new JTextField(10);
		dateLabel=new JLabel("Date : ");
		dateText=new JTextField(10);
		statusButton=new JButton("Search");
		nameLabel=new JLabel("Train Between Stations");
		
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints panelGbc=new GridBagConstraints();
		
		Font panelFont=new Font(Font.SANS_SERIF,Font.BOLD,20);
		
		
		
		// adding source label
		panelGbc.weightx=0.5;
		panelGbc.gridx=1;
		panelGbc.gridy=0;
		sourceLabel.setFont(panelFont);
		panel.add(sourceLabel,panelGbc);
		
		// adding source text field
		panelGbc.weightx=0.5;
		panelGbc.gridx=2;
		panelGbc.gridy=0;
		sourceText.setFont(panelFont);
		panel.add(sourceText,panelGbc);
		
		// adding separator
		panelGbc.weightx=0.25;
		panelGbc.gridx=3;
		panelGbc.gridy=0;
		
		panelGbc.fill = GridBagConstraints.VERTICAL;
		panelGbc.gridheight=1;
		panel.add(new JSeparator(SwingConstants.VERTICAL),panelGbc);
		
		// adding destination label
		panelGbc.weightx=0.5;
		panelGbc.gridx=4;
		panelGbc.gridy=0;
		destLabel.setFont(panelFont);
		panel.add(destLabel,panelGbc);
		
		// adding destination text field
		panelGbc.weightx=0.5;
		panelGbc.gridx=5;
		panelGbc.gridy=0;
		destText.setFont(panelFont);
		panel.add(destText,panelGbc);
		
		// adding separator
		panelGbc.weightx=0.25;
		panelGbc.gridx=6;
		panelGbc.gridy=0;
		
		panelGbc.fill = GridBagConstraints.VERTICAL;
		panelGbc.gridheight=1;
		panel.add(new JSeparator(SwingConstants.VERTICAL),panelGbc);
		
		
		// adding date label
		
		panelGbc.weightx=0.5;
		panelGbc.gridx=7;
		panelGbc.gridy=0;
		dateLabel.setFont(panelFont);
		panel.add(dateLabel,panelGbc);
		
		//adding date text field
		panelGbc.weightx=0.5;
		panelGbc.gridx=8;
		panelGbc.gridy=0;
		dateText.setFont(panelFont);
		panel.add(dateText,panelGbc);
		
		
		// adding separator
		panelGbc.weightx=0.25;
		panelGbc.gridx=9;
		panelGbc.gridy=0;
		
		panelGbc.fill = GridBagConstraints.VERTICAL;
		panelGbc.gridheight=1;
		panel.add(new JSeparator(SwingConstants.VERTICAL),panelGbc);
		
		
		//adding status button
		panelGbc.weightx=0.5;
		panelGbc.gridx=10;
		panelGbc.gridy=0;
		statusButton.setFont(panelFont);
		panel.add(statusButton,panelGbc);
		statusButton.addActionListener(new TrainBetweenStationStatusButtonListener(this));
		
		
		// adding horizontal separator
		panelGbc.weightx=0.25;
		panelGbc.gridx=0;
		panelGbc.gridy=1;
		
		panelGbc.fill = GridBagConstraints.HORIZONTAL;
		panelGbc.gridwidth=12;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL),panelGbc);
		
		
		//adding label train between stations
		
		panelGbc.gridx=5;
		panelGbc.gridy=3;
		panelGbc.weightx=2;
		panelGbc.gridwidth=16;
		panelGbc.weighty=0;
		panelGbc.fill=GridBagConstraints.HORIZONTAL;
		nameLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
		panel.add(nameLabel,panelGbc);
	
		// adding horizontal separator
		panelGbc.weightx=0.25;
		panelGbc.gridx=0;
		panelGbc.gridy=4;
		panelGbc.fill = GridBagConstraints.HORIZONTAL;
		panelGbc.gridwidth=12;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL),panelGbc);
	
		
		// adding trainlist
		panelGbc.gridx=0;
		panelGbc.gridy=5;
		panelGbc.gridwidth = 12;
		panelGbc.gridheight=2;
		panelGbc.weighty=0.10;
		panelGbc.weightx=0;
		panelGbc.fill=GridBagConstraints.BOTH;
		String[] dataList = {"Please Search For Trains"};
		trainList.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
 		trainList.setListData(dataList);
		panel.add(trainList,panelGbc);
		
	}

	public JPanel getPanel() {
		return panel;
	}

	public JFrame getParent() {
		return parent;
	}


	public String getApikey() {
		return apikey;
	}
	
	public String getSource() {
		return sourceText.getText();
	}
	
	public String getDestination() {
		return destText.getText();
	}
	
	public String getDate() {
		return dateText.getText();
	}
	
	public JList<String> getTrainList(){
		return trainList;
	}

	public TrainBetweenStationsData getData() {
		return data;
	}

	public void setData(TrainBetweenStationsData data) {
		this.data = data;
	}
	
}
