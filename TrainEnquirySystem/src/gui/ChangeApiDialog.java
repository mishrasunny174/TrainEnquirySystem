package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ChangeApiDialog {

	private JDialog dialog;
	private JLabel label;
	private JTextField apiKey;
	private JButton button;
	private JPanel labelPanel;

	public ChangeApiDialog() {
		dialog = new JDialog();
		dialog.setTitle("Change Api");
		label = new JLabel("Enter API Key");
		button = new JButton("Change");
		apiKey = new JTextField(20);
		labelPanel = new JPanel();
	}

	public void show() {
		dialog.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		dialog.setSize(new Dimension(400, 300));
		dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty=0.20;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		label.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		label.setAlignmentX(SwingConstants.CENTER);
		labelPanel.add(label);
		dialog.add(labelPanel, gbc);
		gbc.gridy++;
		apiKey.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		dialog.add(apiKey, gbc);
		gbc.gridy++;
		button.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		button.addActionListener((ae)->{
			try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File("res\\apikey.key"),false))){
				if(!apiKey.getText().equals(""))
					writer.write(apiKey.getText());
			} catch (IOException e) {
				System.err.println("[Debug] unable to open api key file");
			}
		});
		dialog.add(button, gbc);
		dialog.setVisible(true);
	}

}
