package Boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
public class CustomerRegister extends JFrame {

    private JPanel contentPane;
    private JTextField username;
    private JTextField pNum;
    private JTextField Email;
    private JPasswordField pwd;
    private JPasswordField confirm;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerRegister frame = new CustomerRegister();
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
    public CustomerRegister() {
        setTitle("Customer Regster");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 331);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        //contentPane布局
        JPanel pan_C = new JPanel();
        contentPane.add(pan_C, BorderLayout.CENTER);
        pan_C.setLayout(null);
        //中部的panel
        JLabel lbl_Username = new JLabel("Username");
        lbl_Username.setBounds(40, 5, 72, 18);
        pan_C.add(lbl_Username);
        username = new JTextField();
        username.setBounds(160, 2, 200, 24);
        pan_C.add(username);
        username.setColumns(10);
        //用户名标签和文本区
        JLabel lbl_PhoneNum = new JLabel("Phone num");
        lbl_PhoneNum.setBounds(40, 35, 72, 18);
        pan_C.add(lbl_PhoneNum);
        pNum = new JTextField();
        pNum.setBounds(160, 32, 200, 24);
        pan_C.add(pNum);
        pNum.setColumns(10);
        //电话号码标签和文本区
        JLabel lbl_Email = new JLabel("Email");
        lbl_Email.setBounds(40, 65, 72, 18);
        pan_C.add(lbl_Email);
        Email = new JTextField();
        Email.setBounds(160, 62, 200, 24);
        pan_C.add(Email);
        Email.setColumns(10);
        //email标签和文本区
        JLabel lbl_pwd = new JLabel("Password");
        lbl_pwd.setBounds(40, 95, 72, 18);
        pan_C.add(lbl_pwd);
        pwd = new JPasswordField();
        pwd.setBounds(160, 92, 200, 24);
        pan_C.add(pwd);
        //密码标签和文本区
        JLabel lbl_Confirm = new JLabel("Confirm");
        lbl_Confirm.setBounds(40, 125, 72, 18);
        pan_C.add(lbl_Confirm);
        confirm = new JPasswordField();
        confirm.setBounds(160, 122, 200, 24);
        pan_C.add(confirm);
        //确认密码标签和文本区
        JLabel remind = new JLabel("");
        remind.setForeground(Color.RED);
        remind.setBounds(71, 159, 289, 18);
        pan_C.add(remind);
        //提示标签，用于注册条件不符合时进行提醒
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(52, 190, 113, 27);
        btnSubmit.addActionListener(this::btnSubmitActionPerformed);
        pan_C.add(btnSubmit);
        //提交按钮，保存信息并进入登录界面
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(242, 190, 113, 27);
        btnBack.addActionListener(this::btnBackActionPerformed);
        pan_C.add(btnBack);
        //back按钮回到主界面
        JPanel pan_N = new JPanel();
        contentPane.add(pan_N, BorderLayout.NORTH);
        //上部的panel
        JLabel label1 = new JLabel("Welcome to Register");
        label1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        pan_N.add(label1);
        label1.setBackground(new Color(240, 240, 240));
    }
    private void btnSubmitActionPerformed(ActionEvent evt) {
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
}
