package gui;

import java.awt.Font;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GUIMenuBar {
	
	private JMenuBar menuBar = null;
	private JMenu file;
	private JMenu about;
	private JMenuItem setApiKey = null;
	private JMenuItem exit = null;
	
	public GUIMenuBar() {
		menuBar = new JMenuBar();
		file = new JMenu("File");
		file.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		about = new JMenu("About Us");
		about.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		menuBar.add(file);
		menuBar.add(about);
		setApiKey = new JMenuItem("Change Api Key");
		setApiKey.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		exit = new JMenuItem("Exit");
		exit.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		exit.addActionListener((ae)->{
			System.exit(0);
		});
		setApiKey.addActionListener((ae)->{
			new ChangeApiDialog().show();
		});
		file.add(setApiKey);
		file.add(exit);
	}
	
	public JMenuBar getMenuBar() {
		return menuBar;
	}
}
