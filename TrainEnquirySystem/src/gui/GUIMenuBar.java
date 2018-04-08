package gui;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GUIMenuBar {
	
	private JMenuBar menuBar = null;
	private JMenu file = null;
	private JMenu help = null;
	private JMenuItem setApiKey = null;
	private JMenuItem exit = null;
	private JMenuItem aboutUs = null;
	public GUIMenuBar(JFrame frame) {
		menuBar = new JMenuBar();
		file = new JMenu("File");
		file.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		help = new JMenu("Help");
		help.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		menuBar.add(file);
		menuBar.add(help);
		setApiKey = new JMenuItem("Change Api Key");
		setApiKey.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		exit = new JMenuItem("Exit");
		exit.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		exit.addActionListener((ae)->{
			System.exit(0);
		});
		setApiKey.addActionListener((ae)->{
			new ChangeApiDialog(frame).show();
		});
		aboutUs = new JMenuItem("About Us");
		aboutUs.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		help.add(aboutUs);
		file.add(setApiKey);
		file.add(exit);
		aboutUs.addActionListener((ae) -> {
			new AboutDialog(frame).show();
		});
	}
	
	public JMenuBar getMenuBar() {
		return menuBar;
	}
}
