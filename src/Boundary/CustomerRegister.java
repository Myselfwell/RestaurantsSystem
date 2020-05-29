package Boundary;

import Control.CheckRegister;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
public class CustomerRegister extends JFrame {

    private JPanel contentPane;
    private JTextField Fname;
    private JTextField pNum;
    private JTextField Email;
    private JPasswordField pwd;
    private JPasswordField confirm;
    private JTextField Surname;
    private JLabel remind;
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
        setTitle("Customer Register");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 512, 374);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        //contentPane布局
        JPanel pan_C = new JPanel();
        contentPane.add(pan_C, BorderLayout.CENTER);
        pan_C.setLayout(null);
        //中部的panel
        JLabel lbl_Fname = new JLabel("First name");
        lbl_Fname.setBounds(40, 13, 106, 18);
        pan_C.add(lbl_Fname);
        Fname = new JTextField();
        Fname.setBounds(160, 10, 200, 24);
        pan_C.add(Fname);
        Fname.setColumns(10);
        //用户名标签和文本区
        JLabel lbl_PhoneNum = new JLabel("Phone num");
        lbl_PhoneNum.setBounds(40, 73, 72, 18);
        pan_C.add(lbl_PhoneNum);
        pNum = new JTextField();
        pNum.setBounds(160, 70, 200, 24);
        pan_C.add(pNum);
        pNum.setColumns(10);
        //电话号码标签和文本区
        JLabel lbl_Email = new JLabel("Email");
        lbl_Email.setBounds(40, 103, 72, 18);
        pan_C.add(lbl_Email);
        Email = new JTextField();
        Email.setBounds(160, 100, 200, 24);
        pan_C.add(Email);
        Email.setColumns(10);
        //email标签和文本区
        JLabel lbl_pwd = new JLabel("Password");
        lbl_pwd.setBounds(40, 133, 72, 18);
        pan_C.add(lbl_pwd);
        pwd = new JPasswordField();
        pwd.setBounds(160, 130, 200, 24);
        pan_C.add(pwd);
        //密码标签和文本区
        JLabel lbl_Confirm = new JLabel("Confirm");
        lbl_Confirm.setBounds(40, 163, 72, 18);
        pan_C.add(lbl_Confirm);
        confirm = new JPasswordField();
        confirm.setBounds(160, 160, 200, 24);
        pan_C.add(confirm);
        //确认密码标签和文本区
        remind = new JLabel("");
        remind.setForeground(Color.RED);
        remind.setBounds(71, 185, 350, 18);
        pan_C.add(remind);
        //提示标签，用于注册条件不符合时进行提醒
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(55, 210, 113, 27);
        btnSubmit.addActionListener(this::btnSubmitActionPerformed);
        pan_C.add(btnSubmit);
        //提交按钮，保存信息并进入登录界面
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(247, 210, 113, 27);
        btnBack.addActionListener(this::btnBackActionPerformed);
        pan_C.add(btnBack);

        JLabel lbl_Surname = new JLabel("Surname");
        lbl_Surname.setBounds(40, 43, 72, 18);
        pan_C.add(lbl_Surname);

        Surname = new JTextField();
        Surname.setBounds(160, 40, 200, 24);
        pan_C.add(Surname);
        Surname.setColumns(10);
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
        CheckRegister checkRegister=new CheckRegister();
        if (!checkRegister.isPwd(pwd.getPassword()))
            remind.setText("Password format error, please re-enter.");
        else if(!checkRegister.reCheck(pwd.getPassword(),confirm.getPassword()))
            remind.setText("The two passwords do not match, please re-enter.");
        else if (!checkRegister.isName(Fname.getText()))
            remind.setText("Your first name is not in the correct format. Please re-enter it");
        else if (!checkRegister.isName(Surname.getText()))
            remind.setText("Your surname is not in the correct format. Please re-enter it");
        else if (!checkRegister.isEmail(Email.getText()))
            remind.setText("Your e-mail is not in the correct format. Please re-enter it");
        else if (!checkRegister.isPhone(pNum.getText()))
            remind.setText("Your phone is not in the correct format. Please re-enter it");
        else {
            String LoyaltyNum=checkRegister.assignAccount();
            String s = LoyaltyNum;s += ",";//loyalty number
            s += new String(pwd.getPassword());s += ",";//pwd
            s += Fname.getText();s += ",";//first name
            s += Surname.getText();;s += ",";//sur name
            s += Email.getText();;s += ",";//email
            s += pNum.getText();s += ",";//phone
            s += "false,";//isAdmin
            s += Integer.toString(0);		//Vs
            System.out.println(s);
            checkRegister.saveData(s);
            this.dispose();
            EventQueue.invokeLater(() -> {
                ShowLoyaltyNum showLoyaltyNum = new ShowLoyaltyNum(LoyaltyNum);
                showLoyaltyNum.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
                showLoyaltyNum.setVisible(true);
            });
        }
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
