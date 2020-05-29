package Boundary;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout.Alignment;

public class Begin extends JFrame{
    private static final long serialVersionUID = 1L;
    JPanel contentPane;
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Begin frame = new Begin();
                    frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame
     */
    public Begin(){
        setTitle("Restaurants System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,701,545);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.inactiveCaptionBorder);
        contentPane.setForeground(SystemColor.activeCaption);
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);

        /*
        Welcome To Restaurant
         */
        JLabel WelcomeToRestaurant = new JLabel("Welcome to restaurant!");
        WelcomeToRestaurant.setFont(new Font("Times New Roman", Font.BOLD, 40));

        /*
        Choose Service
         */
        JLabel ChooseService = new JLabel("Please choose the service:");
        ChooseService.setFont(new Font("Times New Roman", Font.BOLD, 18));

        /*
        StaffLoginIn
         */
        JButton btnStaffLoginIn = new JButton("Staff Login In");
        btnStaffLoginIn.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        btnStaffLoginIn.setBackground(new Color(255, 255, 255));
        btnStaffLoginIn.addActionListener(this::btnStaffLoginInActionPerformed);
        /*
        view.CustomerLoginIn
         */
        JButton btnCustomerLoginIn = new JButton("Customer Login In");
        btnCustomerLoginIn.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        btnCustomerLoginIn.setBackground(new Color(255, 255, 255));
        btnCustomerLoginIn.addActionListener(this::btnCustomerLoginInActionPerformed);

        /*
        view.CustomerRegister
         */
        JButton btnCustomerRegister = new JButton("Customer Register");
        btnCustomerRegister.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        btnCustomerRegister.setBackground(new Color(255,255,255));
        btnCustomerRegister.addActionListener(this::btnCustomerRegisterActionPerformed);

        /*
        Exit
         */
        JButton btnExit = new JButton("Exit");
        btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnExit.setBackground(new Color(255, 255, 255));
        btnExit.addActionListener(this::btnExitActionPerformed);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(ChooseService)
        			.addContainerGap(220, Short.MAX_VALUE))
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap(144, Short.MAX_VALUE)
        			.addComponent(WelcomeToRestaurant)
        			.addGap(127))
        		.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
        			.addGap(232)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addComponent(btnCustomerRegister)
        					.addContainerGap())
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
        						.addComponent(btnCustomerLoginIn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
        						.addComponent(btnStaffLoginIn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
        					.addGap(228))))
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap(565, Short.MAX_VALUE)
        			.addComponent(btnExit)
        			.addGap(51))
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGap(42)
        			.addComponent(WelcomeToRestaurant)
        			.addGap(18)
        			.addComponent(ChooseService)
        			.addGap(26)
        			.addComponent(btnStaffLoginIn)
        			.addGap(18)
        			.addComponent(btnCustomerLoginIn)
        			.addGap(18)
        			.addComponent(btnCustomerRegister)
        			.addGap(127)
        			.addComponent(btnExit)
        			.addGap(35))
        );
        contentPane.setLayout(gl_contentPane);
    }

    private void btnCustomerRegisterActionPerformed(ActionEvent actionEvent) {
        this.dispose();
    	EventQueue.invokeLater(() -> {
            CustomerRegister customerRegister = new CustomerRegister();
            customerRegister.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
            customerRegister.setVisible(true);
        });
    }


    private void btnCustomerLoginInActionPerformed(ActionEvent evt) {
        this.dispose();
        EventQueue.invokeLater(() -> {
            CustomerLoginIn customerLoginIn = new CustomerLoginIn();
            customerLoginIn.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
            customerLoginIn.setVisible(true);
        });
    }

    private void btnStaffLoginInActionPerformed(ActionEvent evt) {
        this.dispose();
        EventQueue.invokeLater(() -> {
            StaffLoginIn staffLoginIn = new StaffLoginIn();
            staffLoginIn.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
            staffLoginIn.setVisible(true);
        });
    }

    private void btnExitActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

}
