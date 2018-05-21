package bankersproject;

import java.lang.String;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.Font;

public class IllustrationWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnContinue;
	
	public File file;
	public Banker b;
	public String inputFilePath;
	private JLabel lblChooseInputFile;
	private JLabel lblFollowFormatProvided;

	public IllustrationWindow() {
		setTitle("Execute Banker's Algorithm");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(50, 50, 550, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblChooseInputFile = new JLabel("Choose Input File from Computer");
		lblChooseInputFile.setForeground(Color.WHITE);
		lblChooseInputFile.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_lblChooseInputFile = new GridBagConstraints();
		gbc_lblChooseInputFile.insets = new Insets(0, 0, 5, 5);
		gbc_lblChooseInputFile.gridx = 0;
		gbc_lblChooseInputFile.gridy = 0;
		contentPane.add(lblChooseInputFile, gbc_lblChooseInputFile);
		
		lblFollowFormatProvided = new JLabel("Follow format provided in MainWindow Menu -> About");
		lblFollowFormatProvided.setForeground(Color.WHITE);
		lblFollowFormatProvided.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_lblFollowFormatProvided = new GridBagConstraints();
		gbc_lblFollowFormatProvided.insets = new Insets(0, 0, 5, 5);
		gbc_lblFollowFormatProvided.gridx = 0;
		gbc_lblFollowFormatProvided.gridy = 1;
		contentPane.add(lblFollowFormatProvided, gbc_lblFollowFormatProvided);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 3;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		btnContinue = new JButton("Get Input");
		btnContinue.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                b = new Banker();
                b.inputFile = file;
                String output = b.getInput(file);
                if(output.equals("Success"))
                {
                	new ExampleWindow(b,output);
                	dispose();
                }
                else
                	new FailureDialog(output);
			}
		});
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileFilter txtfilter = new FileNameExtensionFilter("Only Txt or CSV", "txt", "csv");
				JFileChooser fc = new JFileChooser();
				fc.setFileFilter(txtfilter);
	            int returnVal = fc.showOpenDialog(IllustrationWindow.this);
	            if (returnVal == JFileChooser.APPROVE_OPTION) {
	                file = fc.getSelectedFile();
	                textField.setText(file.getAbsolutePath());
	                inputFilePath = textField.getText();
	            }
			}
		});
		GridBagConstraints gbc_btnBrowse = new GridBagConstraints();
		gbc_btnBrowse.insets = new Insets(0, 0, 5, 0);
		gbc_btnBrowse.gridx = 1;
		gbc_btnBrowse.gridy = 3;
		contentPane.add(btnBrowse, gbc_btnBrowse);
		GridBagConstraints gbc_btnContinue = new GridBagConstraints();
		gbc_btnContinue.gridx = 1;
		gbc_btnContinue.gridy = 5;
		contentPane.add(btnContinue, gbc_btnContinue);
		setVisible(true);
	}
}