package bankersproject;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;

public class AnimationWindow extends JFrame {

	private JPanel contentPane;

	public AnimationWindow(String E) {
		setTitle("Execution");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		JScrollPane sp = new JScrollPane(contentPane);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(sp);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblExecution = new JLabel(E);
		lblExecution.setForeground(Color.WHITE);
		lblExecution.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblExecution.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblExecution);

		setVisible(true);
	}

}
