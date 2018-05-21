package bankersproject;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RecoveryWindow extends JFrame {

	private JPanel contentPane;

	public RecoveryWindow(Banker b) {
		setTitle("Deadlock Recovery");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton btnKillAllProcesses = new JButton("Kill All Processes");
		btnKillAllProcesses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnKillAllProcesses.setFont(new Font("Courier New", Font.PLAIN, 14));
		panel.add(btnKillAllProcesses);
		
		JButton btnPreemptResources = new JButton("PREMPT RESOURCES");
		btnPreemptResources.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPreemptResources.setFont(new Font("Courier New", Font.PLAIN, 14));
		panel.add(btnPreemptResources);
		setVisible(true);
	}

}
