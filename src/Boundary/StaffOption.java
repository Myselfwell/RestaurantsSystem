package Boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StaffOption extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffOption frame = new StaffOption();
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
	public StaffOption() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnModify = new JButton("Modify Menu");
		btnModify.addActionListener(this::btnModifyActionPerformed);
		btnModify.setBounds(130, 54, 168, 48);
		contentPane.add(btnModify);
		
		JButton btnShowBills = new JButton("Show Bills");
		btnShowBills.setBounds(130, 154, 168, 48);
		btnShowBills.addActionListener(this::btnShowActionPerformed);
		contentPane.add(btnShowBills);
	}
	private void btnModifyActionPerformed(ActionEvent evt) {
		this.dispose();
		EventQueue.invokeLater(() -> {
			StaffModifyMenu staffModifyMenu = new StaffModifyMenu();
			staffModifyMenu.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			staffModifyMenu.setVisible(true);
		});
	}
	private void btnShowActionPerformed(ActionEvent evt) {
		this.dispose();
		EventQueue.invokeLater(() -> {
			StaffShowBill staffShowBill = new StaffShowBill();
			staffShowBill.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			staffShowBill.setVisible(true);
		});
	}
}
