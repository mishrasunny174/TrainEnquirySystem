package gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AboutApiDialog {

	private JDialog dialog;
	private JTextArea text;
	private JButton ok;
	private JScrollPane textPanel;

	public AboutApiDialog(JFrame frame) {
		dialog = new JDialog(frame, "About API");
		dialog.setSize(400, 200);
		dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		dialog.setLayout(new GridBagLayout());
		dialog.setLocation(508, 235);
		text = new JTextArea(5, 30);
		textPanel = new JScrollPane(text);
		ok = new JButton("OK");
		ok.addActionListener((ae) -> {
			dialog.setVisible(false);
		});
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		String data = "You can get a new APIKey from https://railwayapi.com by creating a free or paid account there, then you can just add it"
				+ " here in this application to use this application!";
		text.setEditable(false);
		text.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		text.setText(data);

		// adding components to dialog
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.20;
		gbc.weighty = 0.20;
		gbc.fill = GridBagConstraints.BOTH;
		dialog.add(textPanel,gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridy++;
		gbc.weighty = 0;
		dialog.add(ok, gbc);
		dialog.setVisible(true);
	}

	public void show() {

	}

}
