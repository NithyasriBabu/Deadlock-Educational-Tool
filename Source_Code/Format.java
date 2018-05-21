package bankersproject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.lang.String;

public class Format extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	public String s;

	public Format() {
		setTitle("Input Format for Banker's Algorithm");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.ORANGE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblInputFormatFor = new JLabel("Input Format for Banker's Algorithm");
		lblInputFormatFor.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblInputFormatFor.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblInputFormatFor, BorderLayout.NORTH);
		{
			s = "<html>p = Number of Processes<br>r = Number of Resources<br>" +
		"Avail = Initial Available for r processes seperated by spaces in a single line<br>" +
					"Max = Maximum for r resources seperated by spaces for p processes each in 1 line<br>" + 
					"Alloc = Allocated for r resources seperated by spaces for p processes each in 1 line<br></html>";
			JLabel lblNewLabel = new JLabel(s);
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			contentPanel.add(lblNewLabel, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
