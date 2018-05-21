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
import java.awt.Font;

public class Specifications extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public Specifications() {
		setTitle("Specifications of Program");
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.ORANGE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblProgramPrerequisites = new JLabel("Program Prerequisites :");
			lblProgramPrerequisites.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
			lblProgramPrerequisites.setBounds(10, 11, 147, 20);
			contentPanel.add(lblProgramPrerequisites);
		}
		{
			JLabel lblHardwareSoftware = new JLabel("Hardware & Software Requirements :");
			lblHardwareSoftware.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
			lblHardwareSoftware.setBounds(10, 112, 238, 20);
			contentPanel.add(lblHardwareSoftware);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
