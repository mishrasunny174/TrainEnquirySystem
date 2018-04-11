package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChangedSuccesfullyDialog {

	private JDialog dialog;
	private JLabel changedSuccesfully;
	private JLabel restartApp;
	private JPanel changedPanel;
	private JPanel restartPanel;
	private JButton ok;
	
	public ChangedSuccesfullyDialog(JFrame frame) {
		dialog = new JDialog(frame,"Changed Successfully");
		changedSuccesfully = new JLabel("API Key changed successfully");
		restartApp = new JLabel("Please Restart this app");
		changedPanel = new JPanel();
		restartPanel = new JPanel();
		ok = new JButton("OK");
	}
	
	public void show() {
		dialog.setSize(new Dimension(400, 300));
		dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		dialog.setAlwaysOnTop(true);
		changedSuccesfully.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
		restartApp.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
		changedPanel.add(changedSuccesfully);
		restartPanel.add(restartApp);
		dialog.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.20;
		gbc.weighty = 0.20;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		dialog.add(changedPanel,gbc);
		gbc.gridy++;
		dialog.add(restartPanel, gbc);
		gbc.gridy++;
		ok.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
		ok.addActionListener((ae) -> {
			dialog.setVisible(false);
		});
		dialog.add(ok, gbc);
		dialog.setVisible(true);
	}

}
