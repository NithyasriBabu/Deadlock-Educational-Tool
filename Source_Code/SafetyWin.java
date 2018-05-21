package bankersproject;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class SafetyWin extends JFrame {

	public SafetyWin(Banker b) {
		setTitle("Output for Given Input File");
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(new BorderLayout(0, 0));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 580, 400);
		
		String SafetyOutput = b.Safety();
		
		JLabel lblSafety = new JLabel(SafetyOutput);
		lblSafety.setForeground(Color.WHITE);
		lblSafety.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblSafety.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblSafety, BorderLayout.CENTER);
		
		JPanel Buttons = new JPanel();
		Buttons.setBackground(Color.DARK_GRAY);
		
		JButton btnShowAni = new JButton("SHOW WORKOUT");
		btnShowAni.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnShowAni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AnimationWindow(b.E);
			}
		});
		Buttons.add(btnShowAni);
		
		JButton btnOk = new JButton("NEXT");
		btnOk.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(b.Safe)
					new RequestWindow(b);
				else
					new RecoveryWindow(b);
				dispose();
			}
		});
		Buttons.add(btnOk);
		
		getContentPane().add(Buttons, BorderLayout.SOUTH);

		setVisible(true);
	}

}
