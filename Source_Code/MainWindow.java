package bankersproject;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;

public class MainWindow {

	private JFrame frmEducationalToolFor;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmEducationalToolFor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public MainWindow() {
		initialize();
	}

	private void initialize() {
		frmEducationalToolFor = new JFrame();
		frmEducationalToolFor.setTitle("Educational Tool for Deadlock");
		frmEducationalToolFor.getContentPane().setBackground(Color.DARK_GRAY);
		frmEducationalToolFor.setBounds(50, 50, 750, 500);
		frmEducationalToolFor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEducationalToolFor.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblDeadlockDetection = new JLabel("Deadlock Detection, Prevention & Recovery");
		lblDeadlockDetection.setForeground(Color.WHITE);
		lblDeadlockDetection.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeadlockDetection.setFont(new Font("Times New Roman", Font.BOLD, 29));
		frmEducationalToolFor.getContentPane().add(lblDeadlockDetection, BorderLayout.NORTH);
		
		DisplayContent dc = new DisplayContent();
				
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tabbedPane.setForeground(Color.BLUE);
		tabbedPane.setBackground(Color.BLACK);
		frmEducationalToolFor.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		JScrollPane sp = new JScrollPane(panel);
		panel.setBackground(Color.DARK_GRAY);
		JLabel lblIntro = new JLabel(dc.IntroContent);
		lblIntro.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblIntro.setForeground(Color.WHITE);
		panel.add(lblIntro);
		tabbedPane.addTab("1. Introduction", null, sp, null);
		
		JPanel panel_1 = new JPanel();
		JScrollPane sp1 = new JScrollPane(panel_1);
		panel_1.setBackground(Color.DARK_GRAY);
		JLabel lblCond = new JLabel(dc.Conditions);
		lblCond.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblCond.setForeground(Color.WHITE);
		panel_1.add(lblCond);
		tabbedPane.addTab("2. Conditions & Handling", null,sp1, null);
		
		JPanel panel_2 = new JPanel();
		JScrollPane sp2 = new JScrollPane(panel_2);
		panel_2.setBackground(Color.DARK_GRAY);
		JLabel lblBanker = new JLabel(dc.Banker);
		lblBanker.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblBanker.setForeground(Color.WHITE);
		panel_2.add(lblBanker);
		JButton btnExecute = new JButton("EXECUTE BANKERS ALGORITHM");
		btnExecute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new IllustrationWindow();
			}
		});
		panel_2.add(btnExecute);
		tabbedPane.addTab("3. Banker's Algorithm", null, sp2, null);
		
		JPanel panel_3 = new JPanel();
		JScrollPane sp3 = new JScrollPane(panel_3);
		panel_3.setBackground(Color.DARK_GRAY);
		JLabel lblSafety = new JLabel(dc.Safety);
		lblSafety.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblSafety.setForeground(Color.WHITE);
		panel_3.add(lblSafety);
		tabbedPane.addTab("4. Safety Algorithm", null, sp3, null);
		
		JPanel panel_4 = new JPanel();
		JScrollPane sp4 = new JScrollPane(panel_4);
		panel_4.setBackground(Color.DARK_GRAY);
		JLabel lblRequest = new JLabel(dc.Request);
		lblRequest.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblRequest.setForeground(Color.WHITE);
		panel_4.add(lblRequest);
		tabbedPane.addTab("5. Resource Request Algorithm", null, sp4, null);
		
		JPanel panel_5 = new JPanel();
		JScrollPane sp5 = new JScrollPane(panel_5);
		panel_5.setBackground(Color.DARK_GRAY);
		JLabel lblRecovery = new JLabel(dc.Recovery);
		lblRecovery.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblRecovery.setForeground(Color.WHITE);
		panel_5.add(lblRecovery);
		tabbedPane.addTab("6. Deadlock Recovery", null, sp5, null);
		
		JMenuBar menuBar = new JMenuBar();
		frmEducationalToolFor.setJMenuBar(menuBar);
		
		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		JMenuItem mntmIllustration = new JMenuItem("Execute Banker's Algorithm");
		mntmIllustration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IllustrationWindow();
			}
		});
		mnOptions.add(mntmIllustration);
		
		JMenuItem mntmRecovery = new JMenuItem("Deadlock Recovery");
		mnOptions.add(mntmRecovery);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmInputFormatFor = new JMenuItem("Input Format For Bankers Algorithm");
		mntmInputFormatFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Format();
			}
		});
		mnAbout.add(mntmInputFormatFor);
		
		JMenuItem mntmCredits = new JMenuItem("Credits");
		mntmCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Credits();
			}
		});
		mnAbout.add(mntmCredits);
	}
}
