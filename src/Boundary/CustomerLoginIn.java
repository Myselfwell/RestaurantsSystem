package Boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CustomerLoginIn extends JFrame {

    private JPanel contentPane;
    private JTextField username;
    private JPasswordField pwd;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerLoginIn frame = new CustomerLoginIn();
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
    public CustomerLoginIn() {
        setTitle("Customer Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 341);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        //设置frame
        JPanel panel_N = new JPanel();
        contentPane.add(panel_N, BorderLayout.NORTH);
        //设置上部panel
        JLabel lblNewLabel = new JLabel("Welcome to Login");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        panel_N.add(lblNewLabel);
        //设置上部panel中的label
        JPanel panel_C = new JPanel();
        contentPane.add(panel_C, BorderLayout.CENTER);
        panel_C.setLayout(null);
        //设置中部的panel
        JLabel lbl_Username = new JLabel("Username");
        lbl_Username.setFont(new Font("SimSun", Font.PLAIN, 15));
        lbl_Username.setBounds(54, 26, 72, 18);
        panel_C.add(lbl_Username);
        username = new JTextField();
        username.setBounds(140, 23, 200, 24);
        panel_C.add(username);
        username.setColumns(10);
        //用户名标签和文本区
        JLabel lbl_Password = new JLabel("Password");
        lbl_Password.setBounds(54, 73, 72, 18);
        panel_C.add(lbl_Password);
        pwd = new JPasswordField();
        pwd.setBounds(140, 70, 200, 24);
        panel_C.add(pwd);
        //密码标签和文本区
        JLabel remind = new JLabel("");
        remind.setForeground(Color.RED);
        remind.setBounds(54, 118, 310, 24);
        panel_C.add(remind);
        //提示标签，用于登录失败时进行提醒
        JButton btnLogin = new JButton("Log in");
        btnLogin.setBounds(68, 169, 113, 27);
        btnLogin.addActionListener(this::btnLoginInActionPerformed);
        panel_C.add(btnLogin);
        //登录按钮
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(this::btnBackActionPerformed);
        btnBack.setBounds(230, 169, 113, 27);
        panel_C.add(btnBack);
        //返回按钮
        JPanel panel_S = new JPanel();
        contentPane.add(panel_S, BorderLayout.SOUTH);
        panel_S.setLayout(new BorderLayout(0, 0));
        JButton btnSkip = new JButton("Skip");
        btnSkip.addActionListener(this::btnSkipActionPerformed);
        btnSkip.setFont(new Font("Times New Roman", Font.PLAIN, 7));
        panel_S.add(btnSkip, BorderLayout.EAST);
        //退出按钮
    }
    private void btnLoginInActionPerformed(ActionEvent evt) {
        this.dispose();
        EventQueue.invokeLater(() -> {
            CustomerOrder customerOrder = new CustomerOrder();
            customerOrder.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
            customerOrder.setVisible(true);
        });
    }
    private void btnBackActionPerformed(ActionEvent evt) {
        this.dispose();
        EventQueue.invokeLater(() -> {
            Begin begin = new Begin();
            begin.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
            begin.setVisible(true);
        });
    }
    private void btnSkipActionPerformed(ActionEvent evt) {
        this.dispose();
        EventQueue.invokeLater(() -> {
            CustomerOrder customerOrder = new CustomerOrder();
            customerOrder.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
            customerOrder.setVisible(true);
        });
    }
}
