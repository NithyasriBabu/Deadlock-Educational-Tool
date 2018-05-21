package bankersproject;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExplainationWindow extends JFrame {

	private JPanel contentPane;

	public ExplainationWindow() {
		setForeground(Color.PINK);
		setBackground(Color.WHITE);
		setTitle("Theory of Deadlocks");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.PINK);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTextPane textPane = new JTextPane();
		contentPane.add(textPane, BorderLayout.CENTER);
		
		JScrollBar scrollBar = new JScrollBar();
		contentPane.add(scrollBar, BorderLayout.EAST);
		
		JLabel lblDeadlocks = new JLabel("Deadlocks");
		lblDeadlocks.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblDeadlocks.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDeadlocks, BorderLayout.NORTH);
		
		JButton btnOk = new JButton("CLOSE");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnOk, BorderLayout.SOUTH);
		
		setVisible(true);
	}
}
