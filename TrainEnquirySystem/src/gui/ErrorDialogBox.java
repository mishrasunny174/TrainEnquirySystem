package gui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ErrorDialogBox {
	private JDialog errorDialog = null;
	private JLabel errorMessageArea = null;
	private JPanel labelPanel = null;
	private JButton ok = null;
	private JPanel buttonPanel = null;
	
	public ErrorDialogBox(JFrame parent,String message) {
		//configuring errorDialog
		errorDialog = new JDialog(parent);
		errorDialog.setBackground(Color.WHITE);
		errorDialog.setLocation(508, 235);
		errorMessageArea = new JLabel(message);
		errorMessageArea.setBackground(Color.WHITE);
		labelPanel = new JPanel();
		buttonPanel = new JPanel();
		labelPanel.setBackground(Color.WHITE);
		buttonPanel.setBackground(Color.WHITE);
		errorDialog.setTitle("ERROR");
		errorDialog.setSize(new Dimension(500, 150));
		errorDialog.setLayout(new GridLayout(2, 1));
		errorDialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		//System.out.println(message);
		
		errorMessageArea.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
		labelPanel.add(errorMessageArea);
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
