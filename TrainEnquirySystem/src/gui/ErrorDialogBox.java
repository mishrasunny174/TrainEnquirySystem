package gui;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ErrorDialogBox {
	private JDialog errorDialog = null;
	private JLabel errorLabel = null;
	private JPanel labelPanel = null;
	private JButton ok = null;
	private JPanel buttonPanel = null;
	
	public ErrorDialogBox(String message) {
		//configuring errorDialog
		errorDialog = new JDialog();
		errorDialog.setTitle("ERROR");
		errorDialog.setSize(new Dimension(400, 400));
		errorDialog.setLayout(new GridLayout(2, 1));
		errorDialog.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		
		errorLabel = new JLabel(message);
		errorLabel.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
		labelPanel.add(errorLabel);
		errorDialog.add(labelPanel);
		ok = new JButton("OK");
		ok.addActionListener((ae) -> {
			errorDialog.setVisible(false);
		});
		buttonPanel.add(ok);
		errorDialog.add(buttonPanel);
		
	}
	
	public void show() {
		errorDialog.setVisible(true);
	}
}
