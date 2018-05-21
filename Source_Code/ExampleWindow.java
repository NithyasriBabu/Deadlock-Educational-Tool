package bankersproject;

import java.awt.Color;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Font;

public class ExampleWindow extends JFrame {
	
	public String PN, Available, Allocated, Maximum, Need;
	
	public ExampleWindow(Banker b,String output) {
		getContentPane().setBackground(Color.DARK_GRAY);
		setTitle("Executing Bankers Algorithm with Given Input Values");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 75, 600, 400);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel NorthPanel = new JPanel();
		NorthPanel.setForeground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) NorthPanel.getLayout();
		flowLayout_1.setHgap(30);
		NorthPanel.setBackground(Color.DARK_GRAY);
		
		PN = "<html>Number of Processes = " + b.p + "<br> Number of Resources = " + b.r + "</html>";
		JLabel lblNewLabel = new JLabel(PN);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NorthPanel.add(lblNewLabel);
		
		Available = "<html> Available Per Resource <br>" + b.printAvail(b.Avail) + "</html>";
		JLabel lblAvail = new JLabel(Available);
		lblAvail.setForeground(Color.WHITE);
		lblAvail.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblAvail.setHorizontalAlignment(SwingConstants.CENTER);
		NorthPanel.add(lblAvail);
		
		getContentPane().add(NorthPanel, BorderLayout.NORTH);
		
		JPanel CenterPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) CenterPanel.getLayout();
		flowLayout.setHgap(30);
		CenterPanel.setBackground(Color.DARK_GRAY);
		
		Allocated = "<html> Allocated Per Process <br>" + b.print(b.Alloc) + "</html>";
		JLabel lblAlloc = new JLabel(Allocated);
		lblAlloc.setForeground(Color.WHITE);
		lblAlloc.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblAlloc.setHorizontalAlignment(SwingConstants.CENTER);
		CenterPanel.add(lblAlloc);
		
		Maximum = "<html> Maximum Per Process <br>" + b.print(b.Max) + "</html>";
		JLabel lblMax = new JLabel(Maximum);
		lblMax.setForeground(Color.WHITE);
		lblMax.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblMax.setHorizontalAlignment(SwingConstants.CENTER);
		CenterPanel.add(lblMax);
		
		Need = "<html> Need Per Process <br>" + b.print(b.Need) + "</html>";
		JLabel lblNeed = new JLabel(Need);
		lblNeed.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNeed.setForeground(Color.WHITE);
		lblNeed.setHorizontalAlignment(SwingConstants.CENTER);
		CenterPanel.add(lblNeed);
				
		getContentPane().add(CenterPanel, BorderLayout.CENTER);
		
		JPanel ButtonsPanel = new JPanel();
		ButtonsPanel.setBackground(Color.DARK_GRAY);
		
		JButton btnNext = new JButton("EXECUTE SAFETY ALGORITHM");
		btnNext.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SafetyWin(b);
			}
		});
		ButtonsPanel.add(btnNext);
		
		getContentPane().add(ButtonsPanel, BorderLayout.SOUTH);
				
		setVisible(true);
	}
}