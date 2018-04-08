package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FairEnquiryTab {
	private JFrame parent;
	private JPanel panel;
	private String apikey;
	private JLabel sourceLabel;
	private JTextField sourceText;
	private JLabel destLabel;
	private JTextField destText;
	private JLabel dateLabel;
	private JTextField dateText;
	private JLabel ageLabel;
	private JTextField ageText;
	private JLabel classLabel;
	private JTextField classText;
	private JLabel quotaLabel;
	private JTextField quotaText;
	private JButton statusButton;


	public FairEnquiryTab(JFrame parent, String apikey) {
		this.apikey = apikey;
		this.parent = parent;
		panel = new JPanel();
		sourceLabel=new JLabel("Source : ");
		sourceText=new JTextField(10);
		destLabel=new JLabel("Destination : ");
		destText=new JTextField(10);
		dateLabel=new JLabel("Date : ");
		dateText=new JTextField(10);
		ageLabel=new JLabel("Age : ");
		ageText=new JTextField(10);
		classLabel=new JLabel("Class Code : ");
		classText=new JTextField(10);
		quotaLabel=new JLabel("Quota : ");
		quotaText=new JTextField(10);
		statusButton=new JButton("Show Status");
		
	
		
		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		// Grid Bag constraint to set layout of panel
		GridBagConstraints panelGbc = new GridBagConstraints();
		panelGbc.weightx=0.20; //constant for whole program
		panelGbc.weighty=0.20;
		
		//font to be used for everything
		Font fairfont = new Font(Font.SANS_SERIF, Font.BOLD, 20);

		// source Label configuration
		sourceLabel.setFont(fairfont);
		panelGbc.gridx=0;
		panelGbc.gridy=0;
		panel.add(sourceLabel,panelGbc);
		
		//separator vertical
		panelGbc.gridx++;
		panelGbc.fill=GridBagConstraints.VERTICAL;
		panelGbc.weightx=0.10;
		panel.add(new JSeparator(SwingConstants.VERTICAL),panelGbc);
		panelGbc.fill=0;
		panelGbc.weightx=0.20;
		
		//source input configuration
		sourceText.setFont(fairfont);
		panelGbc.gridx++;
		panel.add(sourceText,panelGbc);
		
		//separator horizontal
		panelGbc.gridy++;
		panelGbc.gridx=0;
		panelGbc.gridwidth=3;
		panelGbc.weighty=0.0;
		panelGbc.fill=GridBagConstraints.HORIZONTAL;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL),panelGbc);
		panelGbc.gridwidth=1;
		panelGbc.fill=0;
		panelGbc.weighty=0.20;
		panelGbc.gridy++;
		
		// dest label configuration
		destLabel.setFont(fairfont);
		panelGbc.gridx=0;
		panel.add(destLabel,panelGbc);
		
		//separator vertical
		panelGbc.gridx++;
		panelGbc.fill=GridBagConstraints.VERTICAL;
		panelGbc.weightx=0.10;
		panel.add(new JSeparator(SwingConstants.VERTICAL),panelGbc);
		panelGbc.fill=0;
		panelGbc.weightx=0.20;
		
		//dest input configuration
		destText.setFont(fairfont);
		panelGbc.gridx++;
		panel.add(destText,panelGbc);
		
		//separator horizontal
		panelGbc.gridy++;
		panelGbc.gridx=0;
		panelGbc.gridwidth=3;
		panelGbc.weighty=0.0;
		panelGbc.fill=GridBagConstraints.HORIZONTAL;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL),panelGbc);
		panelGbc.gridwidth=1;
		panelGbc.fill=0;
		panelGbc.weighty=0.20;
		panelGbc.gridy++;

		
		// date label configuration
		dateLabel.setFont(fairfont);
		panelGbc.gridx=0;
		panel.add(dateLabel,panelGbc);
		
		//separator vertical
		panelGbc.gridx++;
		panelGbc.fill=GridBagConstraints.VERTICAL;
		panelGbc.weightx=0.10;
		panel.add(new JSeparator(SwingConstants.VERTICAL),panelGbc);
		panelGbc.fill=0;
		panelGbc.weightx=0.20;
		
		//date input configuration
		dateText.setFont(fairfont);
		panelGbc.gridx++;
		panel.add(dateText,panelGbc);
		
		//separator horizontal
		panelGbc.gridy++;
		panelGbc.gridx=0;
		panelGbc.gridwidth=3;
		panelGbc.weighty=0.0;
		panelGbc.fill=GridBagConstraints.HORIZONTAL;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL),panelGbc);
		panelGbc.gridwidth=1;
		panelGbc.fill=0;
		panelGbc.weighty=0.20;
		panelGbc.gridy++;

		
		// age label configuration
		ageLabel.setFont(fairfont);
		panelGbc.gridx=0;
		panel.add(ageLabel,panelGbc);
				
		//separator vertical
		panelGbc.gridx++;
		panelGbc.fill=GridBagConstraints.VERTICAL;
		panelGbc.weightx=0.10;
		panel.add(new JSeparator(SwingConstants.VERTICAL),panelGbc);
		panelGbc.fill=0;
		panelGbc.weightx=0.20;
				
		//age input configuration
		ageText.setFont(fairfont);
		panelGbc.gridx++;
		panel.add(ageText,panelGbc);
				
		//separator horizontal
		panelGbc.gridy++;
		panelGbc.gridx=0;
		panelGbc.gridwidth=3;
		panelGbc.weighty=0.0;
		panelGbc.fill=GridBagConstraints.HORIZONTAL;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL),panelGbc);
		panelGbc.gridwidth=1;
		panelGbc.fill=0;
		panelGbc.weighty=0.20;
		panelGbc.gridy++;




		// class code label configuration
		classLabel.setFont(fairfont);
		panelGbc.gridx=0;
		panel.add(classLabel,panelGbc);
		
		//separator vertical
		panelGbc.gridx++;
		panelGbc.fill=GridBagConstraints.VERTICAL;
		panelGbc.weightx=0.10;
		panel.add(new JSeparator(SwingConstants.VERTICAL),panelGbc);
		panelGbc.fill=0;
		panelGbc.weightx=0.20;
		
		//class input configuration
		classText.setFont(fairfont);
		panelGbc.gridx++;
		panel.add(classText,panelGbc);
		
		//separator horizontal
		panelGbc.gridy++;
		panelGbc.gridx=0;
		panelGbc.gridwidth=3;
		panelGbc.weighty=0.0;
		panelGbc.fill=GridBagConstraints.HORIZONTAL;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL),panelGbc);
		panelGbc.gridwidth=1;
		panelGbc.fill=0;
		panelGbc.weighty=0.20;
		panelGbc.gridy++;

        
		// quota label configuration
		quotaLabel.setFont(fairfont);
		panelGbc.gridx=0;
		panel.add(quotaLabel,panelGbc);
		
		//separator vertical
		panelGbc.gridx++;
		panelGbc.fill=GridBagConstraints.VERTICAL;
		panelGbc.weightx=0.10;
		panel.add(new JSeparator(SwingConstants.VERTICAL),panelGbc);
		panelGbc.fill=0;
		panelGbc.weightx=0.20;
		
		//quota input configuration
		quotaText.setFont(fairfont);
		panelGbc.gridx++;
		panel.add(quotaText,panelGbc);
		
		//separator horizontal
		panelGbc.gridy++;
		panelGbc.gridx=0;
		panelGbc.gridwidth=3;
		panelGbc.weighty=0.0;
		panelGbc.fill=GridBagConstraints.HORIZONTAL;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL),panelGbc);
		panelGbc.gridwidth=1;
		panelGbc.fill=0;
		panelGbc.weighty=0.20;
		panelGbc.gridy++;


		// Status Button Configuration
		panelGbc.gridx=0;
		panelGbc.gridwidth=3;
		panelGbc.fill=GridBagConstraints.HORIZONTAL;
		statusButton.setFont(fairfont);
		panel.add(statusButton,panelGbc);
		panelGbc.gridwidth=1;
		panelGbc.fill=0;
				
		//separator horizontal
		panelGbc.gridy++;
		panelGbc.gridx=0;
		panelGbc.gridwidth=3;
		panelGbc.weighty=0.0;
		panelGbc.fill=GridBagConstraints.HORIZONTAL;
		panel.add(new JSeparator(SwingConstants.HORIZONTAL),panelGbc);
		panelGbc.gridwidth=1;
		panelGbc.fill=0;
		panelGbc.weighty=0.20;
		panelGbc.gridy++;

	}

	public JFrame getParent() {
		return parent;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public String getApikey() {
		return apikey;
	}

}
