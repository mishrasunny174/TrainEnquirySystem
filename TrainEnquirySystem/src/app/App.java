package app;

import javax.swing.SwingUtilities;

import gui.GUI;

public class App {

	public static void main(String[] args)

	{
		SwingUtilities.invokeLater(() -> {
			GUI mainframe = new GUI("National Train Enquiry System");
			mainframe.init();
			mainframe.run();
		});
	}
}
