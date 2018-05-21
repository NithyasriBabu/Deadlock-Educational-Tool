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
import javax.swing.SwingConstants;

public class Credits extends JDialog {

	private final JPanel contentPanel = new JPanel();
			
	public Credits() {
		setTitle("Credits");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.ORANGE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblDevelopedAndTested = new JLabel("Developed and Tested By:");
			lblDevelopedAndTested.setHorizontalAlignment(SwingConstants.CENTER);
			lblDevelopedAndTested.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblDevelopedAndTested.setBounds(10, 11, 229, 40);
			contentPanel.add(lblDevelopedAndTested);
		}
		{
			JLabel lblNithyasriBabu = new JLabel("Nithyasri Babu");
			lblNithyasriBabu.setHorizontalAlignment(SwingConstants.LEFT);
			lblNithyasriBabu.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblNithyasriBabu.setBounds(111, 62, 128, 20);
			contentPanel.add(lblNithyasriBabu);
		}
		{
			JLabel lblNeeraj = new JLabel("Neeraj Vashistha");
			lblNeeraj.setHorizontalAlignment(SwingConstants.LEFT);
			lblNeeraj.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblNeeraj.setBounds(111, 93, 128, 20);
			contentPanel.add(lblNeeraj);
		}
		{
			JLabel lblOjaswiKhase = new JLabel("Ojaswi Khase");
			lblOjaswiKhase.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblOjaswiKhase.setHorizontalAlignment(SwingConstants.LEFT);
			lblOjaswiKhase.setBounds(111, 124, 128, 20);
			contentPanel.add(lblOjaswiKhase);
		}
		
		JLabel lblPhanindraKancharala = new JLabel("Phanindra Kancharala");
		lblPhanindraKancharala.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPhanindraKancharala.setBounds(111, 155, 165, 14);
		contentPanel.add(lblPhanindraKancharala);
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
