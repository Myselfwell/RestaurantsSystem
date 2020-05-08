package Boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StaffModifyMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffModifyMenu frame = new StaffModifyMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StaffModifyMenu() {
		setTitle("ModifyMenu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 354, 378);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Menu");
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(415, 31, 158, 42);
		contentPane.add(btnNewButton);
		
		JButton btnChange = new JButton("Delete");
		btnChange.setBounds(415, 83, 158, 42);
		contentPane.add(btnChange);
		
		JButton btnChangeName = new JButton("Change Name");
		btnChangeName.setBounds(415, 135, 158, 42);
		contentPane.add(btnChangeName);
		
		JButton btnChangePrice = new JButton("Change Price");
		btnChangePrice.setBounds(415, 187, 158, 42);
		contentPane.add(btnChangePrice);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(415, 239, 158, 42);
		btnBack.addActionListener(this::btnBackActionPerformed);
		contentPane.add(btnBack);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(415, 291, 158, 42);
		btnExit.addActionListener(this::btnExitActionPerformed);
		contentPane.add(btnExit);
	}
	private void btnBackActionPerformed(ActionEvent evt) {
		this.dispose();
		EventQueue.invokeLater(() -> {
			StaffOption staffOption = new StaffOption();
			staffOption.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			staffOption.setVisible(true);
		});
	}
	private void btnExitActionPerformed(ActionEvent evt) {
		System.exit(0);
	}
}
