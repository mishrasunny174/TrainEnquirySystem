package gui;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SearchingDialog {
	
	private JDialog dialog;
	
	public SearchingDialog(JFrame parent) {
		dialog = new JDialog(parent, "Searching");
		dialog.setSize(new Dimension(350, 250));
		dialog.add(new JLabel(new ImageIcon("appdata\\search.gif")));
		dialog.setLocation(508, 235);
	}
	
	public void show() {
		dialog.setVisible(true);
	}
	
	public void hide() {
		dialog.setVisible(false);
	}
}
