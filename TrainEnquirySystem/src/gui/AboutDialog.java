package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutDialog {

	private JDialog aboutDialog = null;
	private JPanel panel = null;
	private JPanel headerPanel = null;
	private JLabel projectLabel = null;
	private JLabel versionLabel = null;
	private JLabel createLabel = null;
	private JLabel nameLabel = null;
	private JLabel sunnyLabel=null;
	private JLabel priyaLabel=null;
	private JButton ok = null;

	public AboutDialog(JFrame frame) {

		aboutDialog = new JDialog(frame);
		headerPanel = new JPanel();

		aboutDialog.setSize(420, 300);
		aboutDialog.setTitle("About us");
		// aboutDialog.setResizable(false);
		aboutDialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		aboutDialog.setLayout(new GridBagLayout());
		aboutDialog.setBackground(Color.WHITE);

		GridBagConstraints panelGbc = new GridBagConstraints();

		panelGbc.gridx = 0;
		panelGbc.gridy = 0;
		panelGbc.weighty = 0;
		projectLabel = new JLabel("TRAIN ENQUIRY SYSTEM");
		projectLabel.setBackground(Color.WHITE);
		projectLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
		projectLabel.setForeground(Color.RED);
		headerPanel.add(projectLabel);
		aboutDialog.add(headerPanel, panelGbc);
		aboutDialog.setBackground(Color.WHITE);

		// adding ok button
		ok = new JButton("OK");
		panelGbc.gridy = 12;
		panelGbc.weighty = 0.10;
		panelGbc.fill = GridBagConstraints.HORIZONTAL;
		aboutDialog.add(ok, panelGbc);

		// adding data panel
		panelGbc.gridy = 1;
		panelGbc.weighty = 0.90;
		panel = new JPanel();
		// panel.setBackground(Color.WHITE);
		panel.setLayout(new GridBagLayout());
		// panel.setBackground(Color.WHITE);
		aboutDialog.add(panel, panelGbc);

		// adding version label
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.25;
		versionLabel = new JLabel(" ( Version 1.1 ) ");
		versionLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		panel.add(versionLabel, gbc);

		// adding create label

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0.25;
		createLabel = new JLabel("Created By -");
		createLabel.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
		createLabel.setForeground(Color.MAGENTA);
		panel.add(createLabel, gbc);

		// adding name label

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.weightx = 0.25;
		nameLabel = new JLabel("Sunny Mishra   and   Priya Aditya");
		nameLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		nameLabel.setForeground(Color.BLUE);
		panel.add(nameLabel, gbc);

		// adding sunny id label

		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.weightx = 0.25;
		sunnyLabel = new JLabel("Sunny : mishrasunny174@gmail.com ");
		sunnyLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		sunnyLabel.setForeground(Color.BLACK);
		panel.add(sunnyLabel, gbc);

		// adding priya id  label

		gbc.gridx = 0;
		gbc.gridy = 10;
		gbc.weightx = 0.25;
		priyaLabel = new JLabel("Priya : priyaaditya2207@gmail.com ");
		priyaLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		priyaLabel.setForeground(Color.BLACK);
		panel.add(priyaLabel, gbc);

		ok.addActionListener((ae) -> {
			aboutDialog.setVisible(false);
		});
		
	}

	public void show() {
		aboutDialog.setVisible(true);
	}

}
