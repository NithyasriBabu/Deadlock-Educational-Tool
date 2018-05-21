package bankersproject;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

public class RequestWindow extends JFrame {

	private JPanel outerPanel,contentPane;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JTextField textField_1;
	private JButton btnRequest;
	private JLabel lblR;
	
	public RequestWindow(Banker b) {
		setTitle("Safe State - Request for New Resource");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 595, 333);
		
		BorderLayout BL = new BorderLayout();
		outerPanel = new JPanel();
		outerPanel.setBackground(Color.DARK_GRAY);
		outerPanel.setLayout(BL);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{260, 31, 86, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{20, 0, 20, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblResourceRequestedFor = new JLabel("Resource Requested for Process number");
		lblResourceRequestedFor.setHorizontalAlignment(SwingConstants.CENTER);
		lblResourceRequestedFor.setForeground(Color.WHITE);
		lblResourceRequestedFor.setFont(new Font("Courier New", Font.PLAIN, 14));
		GridBagConstraints gbc_lblResourceRequestedFor = new GridBagConstraints();
		gbc_lblResourceRequestedFor.insets = new Insets(0, 0, 5, 5);
		gbc_lblResourceRequestedFor.gridwidth = 2;
		gbc_lblResourceRequestedFor.gridx = 0;
		gbc_lblResourceRequestedFor.gridy = 0;
		contentPane.add(lblResourceRequestedFor, gbc_lblResourceRequestedFor);
		
		textField = new JTextField();
		textField.setFont(new Font("Courier New", Font.PLAIN, 14));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTHWEST;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("Resource Instances Requested");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Courier New", Font.PLAIN, 14));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JPanel j = new JPanel();
		j.setBackground(Color.DARK_GRAY);
		j.setForeground(Color.WHITE);
		JScrollPane sp = new JScrollPane(j);
		lblR = new JLabel("RESULT");
		lblR.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblR.setForeground(Color.WHITE);
		lblR.setBackground(Color.DARK_GRAY);
		lblR.setHorizontalAlignment(SwingConstants.CENTER);
		j.add(lblR);
			
		btnRequest = new JButton("REQUEST");
		btnRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					int tempP = Integer.parseInt(textField.getText());
					if(tempP >= b.p)
						new FailureDialog("Process Not Found. Enter Values from 0 to "+ b.p+ " only");
					Scanner read = new Scanner(textField_1.getText());
					int[] newRes = new int[b.r];
					int i=0;
					while (read.hasNextInt()) {
						newRes[i++] = (read.nextInt());
					}
					read.close();
					b.Request(tempP,newRes);
					lblR.setText(b.R);
				}
				catch(Throwable e) {
					new FailureDialog("Invalid Input in Text Fields. Try Again");
				}
			}
		});
		btnRequest.setFont(new Font("Courier New", Font.PLAIN, 14));
		GridBagConstraints gbc_btnRequest = new GridBagConstraints();
		gbc_btnRequest.insets = new Insets(0, 0, 5, 0);
		gbc_btnRequest.gridx = 4;
		gbc_btnRequest.gridy = 1;
		contentPane.add(btnRequest, gbc_btnRequest);
		
		outerPanel.add(contentPane,BorderLayout.NORTH);
		outerPanel.add(sp,BorderLayout.CENTER);
		setContentPane(outerPanel);
		
		setVisible(true);
	}

}
