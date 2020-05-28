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
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class StaffModifyMenu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private String name;
	private String price;

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
		
		JButton btnChangePrice = new JButton("Change Price");
		btnChangePrice.setBounds(415, 193, 158, 42);
		contentPane.add(btnChangePrice);
		btnChangePrice.addActionListener(this::btnChangePricePerformed);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(this::btnBackActionPerformed);
		btnBack.setBounds(415, 245, 158, 42);
		contentPane.add(btnBack);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(this::btnExitActionPerformed);
		btnExit.setBounds(415, 297, 158, 42);
		contentPane.add(btnExit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("");
		panel_1.setBounds(415, 21, 158, 58);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("name");
		lblNewLabel_1.setBounds(67, 0, 26, 29);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(10, 27, 138, 21);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(415, 89, 158, 58);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("New Price");
		lblNewLabel_1_1.setBounds(57, 10, 58, 15);
		panel_1_1.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(14, 27, 134, 21);
		textField_1.setColumns(10);
		panel_1_1.add(textField_1);
	}

	private void btnBackActionPerformed(ActionEvent actionEvent) {
		this.dispose();
		EventQueue.invokeLater(()->{
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

	private void btnExitActionPerformed(ActionEvent actionEvent) {
		System.exit(0);
	}

	private void btnChangePricePerformed(ActionEvent actionEvent){
		name = textField.getText();
		price = textField_1.getText();
	}
}
