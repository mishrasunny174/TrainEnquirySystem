package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import data.ApiKey;

public class GUI {

	private JFrame frame = null;
	private JPanel panel = null;
	private JPanel headpanel = null;
	private JLabel imageTrain = null;
	private JLabel headlabel = null;
	private JLabel imageRail = null;
	private JTabbedPane functionTabs = null;

	public GUI(String title) {
		frame = new JFrame(title);
		panel = new JPanel();
		headpanel = new JPanel();
		imageTrain = new JLabel();
		headlabel = new JLabel(" National Train Enquiry System ");
		imageRail = new JLabel();
		functionTabs = new JTabbedPane();
	}

	public void init() {

		// setting frame properties
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setSize(new Dimension(1366, 768));
		frame.setMinimumSize(new Dimension(1366, 768));
		frame.setLayout(new GridLayout(1, 1));
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon("appdata\\icon.png").getImage());
		frame.setJMenuBar(new GUIMenuBar(frame).getMenuBar());
		// configuring and adding components to head panel
		headpanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		imageTrain.setIcon(new ImageIcon("appdata\\train.jpg"));
		headpanel.add(imageTrain, gbc);
		gbc.gridx = 1;
		gbc.weighty = 2;
		Font mainfont = new Font(Font.SANS_SERIF, Font.BOLD, 60);
		headlabel.setFont(mainfont);
		headlabel.setForeground(Color.red);
		headlabel.setBackground(Color.WHITE);
		headpanel.add(headlabel, gbc);
		gbc.gridx = 2;
		imageRail.setIcon(new ImageIcon("appdata\\rail.jpg"));
		imageRail.setBackground(Color.WHITE);
		headpanel.add(imageRail, gbc);
		headpanel.setBackground(Color.WHITE);
		headpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		// configuring functionTabs and adding components to it
		functionTabs.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 23));
		try {
			String apikey = new ApiKey().getApiKey();
			// adding tabs to main GUI
			functionTabs.addTab("Live train status ", new RunningStatusTab(frame, apikey).getPanel());
			functionTabs.addTab("Train between stations ", new TrainBetweenStationsTab(frame, apikey).getPanel());
			functionTabs.addTab("PNR status ", new PnrStatusTab(frame, apikey).getPanel());
			functionTabs.addTab("Seat availabilty ", new SeatAvailabiltyTab(frame, apikey).getPanel());
			functionTabs.addTab("Fair enquiry ", new FairEnquiryTab(frame, apikey).getPanel());
			functionTabs.addTab("Search Trains", new TrainSearchTab(frame, apikey).getPanel());
			functionTabs.addTab("Station Search", new StationSearchTab(frame, apikey).getPanel());
		} catch (IOException e) {
			new FatalErrorDialogBox(frame, "[Fatal ERROR] appdata folder not found").show();
		}

		// configuring main panel and adding components to it
		panel.setLayout(new GridBagLayout());
		GridBagConstraints panelGbc = new GridBagConstraints();
		panelGbc.gridx = 0;
		panelGbc.gridy = 0;
		panelGbc.weighty = 0.10;
		panel.add(headpanel, panelGbc);
		panelGbc.fill = GridBagConstraints.BOTH;
		panelGbc.gridx = 0;
		panelGbc.gridy = 1;
		panelGbc.weighty = 0.90;
		panel.add(functionTabs, panelGbc);

		// configuring and adding main panel to frame
		panel.setBackground(Color.WHITE);
		frame.add(panel);
	}

	public void run() {
		frame.setVisible(true);
	}

}
