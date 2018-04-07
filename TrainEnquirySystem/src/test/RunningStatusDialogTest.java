package test;

import javax.swing.SwingUtilities;

import data.TrainRoute;
import gui.RunningStatusDialog;

public class RunningStatusDialogTest {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new RunningStatusDialog(new TrainRoute(),"Hello").show();
		});
	}
}
