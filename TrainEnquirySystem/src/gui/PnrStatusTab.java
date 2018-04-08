package gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PnrStatusTab {

	private JPanel panel = null;
	private JLabel pnrLabel = null;
	private JTextField pnrText = null;
	private JButton statusButton = null;
	private String apikey = null;
	private JFrame parent;

	public PnrStatusTab(JFrame parent, String apikey) {
		this.setParent(parent);
		panel = new JPanel();
		this.setApikey(apikey);
		pnrLabel = new JLabel("PNR Number : ");
		pnrText = new JTextField(10);
		statusButton = new JButton("Show Status");

		panel.setLayout(new GridBagLayout());
		GridBagConstraints panelGbc = new GridBagConstraints();

		// adding pnr no. label

		panelGbc.gridx = 1;
		panelGbc.gridy = 0;
		panelGbc.weightx = 0;
		pnrLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));
		panel.add(pnrLabel, panelGbc);

		/*// adding separator
		panelGbc.weightx = 0;
		panelGbc.gridx = 1;
		panelGbc.gridy = 0;
		panelGbc.fill = GridBagConstraints.VERTICAL;
		panelGbc.gridheight = 1;
		panel.add(new JSeparator(SwingConstants.VERTICAL), panelGbc);
*/
		// adding pnr no. textfield

		panelGbc.gridx = 2;
		panelGbc.gridy = 0;
		panelGbc.gridheight = 1;
		panelGbc.weightx = 0;
		pnrText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		panel.add(pnrText, panelGbc);

		// adding separator
		panelGbc.weightx = 0;
		panelGbc.gridx = 3;
		panelGbc.gridy = 0;
		panelGbc.fill = GridBagConstraints.VERTICAL;
		panelGbc.gridheight = 1;
		panel.add(new JSeparator(SwingConstants.VERTICAL), panelGbc);

		// adding status button

		panelGbc.gridx = 4;
		panelGbc.gridy = 0;
		panelGbc.gridwidth = 1;
		panelGbc.weightx = 0;
		statusButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		panel.add(statusButton, panelGbc);

	}

	public JPanel getPanel() {
		return panel;
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	public JFrame getParent() {
		return parent;
	}

	public void setParent(JFrame parent) {
		this.parent = parent;
	}

}
