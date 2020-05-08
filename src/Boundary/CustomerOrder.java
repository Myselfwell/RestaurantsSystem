package Boundary;

import Entity.Dish;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerOrder extends JFrame {

    private JPanel contentPane;
    private JPanel contentPane2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerOrder frame = new CustomerOrder();
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
    public CustomerOrder() {

        setTitle("Welcome xxx!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 638, 709);
        contentPane = new JPanel();
        contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        //主页面
        JPanel panel_N = new JPanel();
        panel_N.setBorder(new LineBorder(new Color(0, 0, 0)));
        contentPane.add(panel_N, BorderLayout.NORTH);
        panel_N.setLayout(new BorderLayout(0, 0));
        //上部的pane
        JButton btnBack = new JButton("Back");
        btnBack.setHorizontalAlignment(SwingConstants.LEFT);
        panel_N.add(btnBack, BorderLayout.WEST);
        //返回键
        JLabel lblStamp = new JLabel("stamps:");
        lblStamp.setHorizontalAlignment(SwingConstants.RIGHT);
        panel_N.add(lblStamp, BorderLayout.CENTER);

        JLabel lblStampNum = new JLabel("0");
        panel_N.add(lblStampNum, BorderLayout.EAST);
        //用户的虚拟邮票信息
        JPanel panel_S = new JPanel();
        contentPane.add(panel_S, BorderLayout.SOUTH);
        panel_S.setLayout(new BorderLayout(0, 0));
        //下部的pane
        JLabel lblTotal = new JLabel("Total");
        lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
        panel_S.add(lblTotal, BorderLayout.WEST);
        //消费的总价格信息
        JButton btnCheck = new JButton("Check");
        panel_S.add(btnCheck, BorderLayout.EAST);

        JLabel lbl_Total_Price = new JLabel("0");
        lbl_Total_Price.setHorizontalAlignment(SwingConstants.CENTER);
        panel_S.add(lbl_Total_Price, BorderLayout.CENTER);
        //查看已点的菜的信息
        JPanel panel_C = new JPanel();
        contentPane.add(panel_C, BorderLayout.CENTER);
        panel_C.setLayout(new GridLayout(0, 1, 0, 0));
        //中部的pane
        JPanel panel_Menu = new JPanel();
        panel_Menu.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_C.add(panel_Menu);
        panel_Menu.setLayout(new GridLayout(10, 0, 0, 0));
        //菜单pane
        JLabel lbl_SingleDish = new JLabel("Single Dish  \u00A39.99");
        lbl_SingleDish.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_Menu.add(lbl_SingleDish);
        //single dish的label
        JPanel panel_Soup = new JPanel();
        panel_Soup.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_Menu.add(panel_Soup);
        panel_Soup.setLayout(new GridLayout(0, 4, 0, 0));
        //选汤的pane
        JLabel lbl_Soup = new JLabel("Soup");
        lbl_Soup.setBackground(new Color(0, 0, 0));
        lbl_Soup.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_Soup.add(lbl_Soup);
        //soup的label
        JRadioButton rdbtn_Soup1 = new JRadioButton("Tonkotsu");
        rdbtn_Soup1.setActionCommand("Tonkotsu");
        //rdbtn_Soup1.setSelected(true);
        panel_Soup.add(rdbtn_Soup1);
        //第一种汤
        JRadioButton rdbtn_Soup2 = new JRadioButton("Shoyu");
        rdbtn_Soup2.setActionCommand("Shoyu");
        rdbtn_Soup2.setSelected(true);
        panel_Soup.add(rdbtn_Soup2);
        //第二种汤
        JRadioButton rdbtn_Soup3 = new JRadioButton("Shio");
        rdbtn_Soup3.setActionCommand("Shio");
        panel_Soup.add(rdbtn_Soup3);
        //第三种汤
        ButtonGroup group1=new ButtonGroup();
        group1.add(rdbtn_Soup1);
        group1.add(rdbtn_Soup2);
        group1.add(rdbtn_Soup3);
        //设置单选

        JPanel panel_Noodles = new JPanel();
        panel_Noodles.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_Menu.add(panel_Noodles);
        panel_Noodles.setLayout(new GridLayout(0, 4, 0, 0));
        //选面的pane
        JLabel lbl_Noodles = new JLabel("Noodles");
        lbl_Noodles.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_Noodles.add(lbl_Noodles);
        //面的label
        JRadioButton rdbtn_Noodles1 = new JRadioButton("Soft");
        rdbtn_Noodles1.setActionCommand("Soft");
        rdbtn_Noodles1.setSelected(true);
        panel_Noodles.add(rdbtn_Noodles1);
        //第一种面
        JRadioButton rdbtn_Noodles2 = new JRadioButton("Medium");
        rdbtn_Noodles2.setActionCommand("Medium");
        panel_Noodles.add(rdbtn_Noodles2);
        //第二种面
        JRadioButton rdbtn_Noodles3 = new JRadioButton("Firm");
        rdbtn_Noodles3.setActionCommand("Firm");
        panel_Noodles.add(rdbtn_Noodles3);
        //第三种面
        ButtonGroup group2=new ButtonGroup();
        group2.add(rdbtn_Noodles1);
        group2.add(rdbtn_Noodles2);
        group2.add(rdbtn_Noodles3);
        //设置单选

        JPanel panel_Spring = new JPanel();
        panel_Spring.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_Menu.add(panel_Spring);
        panel_Spring.setLayout(new GridLayout(0, 4, 0, 0));
        //选面的pane
        JLabel lbl_Spring = new JLabel("Spring onion");
        lbl_Spring.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_Spring.add(lbl_Spring);
        //面的label
        JRadioButton rdbtn_Spring1 = new JRadioButton("No please");
        rdbtn_Spring1.setActionCommand("No");
        rdbtn_Spring1.setSelected(true);
        panel_Spring.add(rdbtn_Spring1);
        //第一种面
        JRadioButton rdbtn_Spring2 = new JRadioButton(" A little");
        rdbtn_Spring2.setActionCommand("Little");
        panel_Spring.add(rdbtn_Spring2);
        //第二种面
        JRadioButton rdbtn_Spring3 = new JRadioButton("A lot!");
        rdbtn_Spring3.setActionCommand("Lot");
        panel_Spring.add(rdbtn_Spring3);
        //第三种面
        ButtonGroup group3=new ButtonGroup();
        group3.add(rdbtn_Spring1);
        group3.add(rdbtn_Spring2);
        group3.add(rdbtn_Spring3);
        //设置单选

        JPanel panel_adds = new JPanel();
        panel_adds.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_Menu.add(panel_adds);
        panel_adds.setLayout(new GridLayout(0, 4, 0, 0));
        //附加品
        JLabel lbl_Adds = new JLabel("Adds");
        panel_adds.add(lbl_Adds);
        lbl_Adds.setBorder(BorderFactory.createLineBorder(Color.black));
        //label
        JCheckBox chckbx_Nori = new JCheckBox("Nori");
        panel_adds.add(chckbx_Nori);
        //紫菜
        JCheckBox chckbx_Chashu = new JCheckBox("Chashu");
        panel_adds.add(chckbx_Chashu);
        //chashu
        JCheckBox chckbx_Egg = new JCheckBox("Boiled egg");
        panel_adds.add(chckbx_Egg);
        //蛋
        JPanel panel_Spiciness = new JPanel();
        panel_Spiciness.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_Menu.add(panel_Spiciness);
        panel_Spiciness.setLayout(new GridLayout(0, 7, 0, 0));
        //辣度pane
        JLabel lbl_Spiciness = new JLabel("Spiciness");
        lbl_Spiciness.setBackground(Color.RED);
        lbl_Spiciness.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_Spiciness.add(lbl_Spiciness);
        //辣度label
        JRadioButton rdbtn_Spiciness0 = new JRadioButton("0(No)");
        rdbtn_Spiciness0.setActionCommand("0");
        rdbtn_Spiciness0.setSelected(true);
        panel_Spiciness.add(rdbtn_Spiciness0);
        //no
        JRadioButton rdbtn_Spiciness1 = new JRadioButton("1");
        rdbtn_Spiciness1.setActionCommand("1");
        panel_Spiciness.add(rdbtn_Spiciness1);
        //1
        JRadioButton rdbtn_Spiciness2 = new JRadioButton("2");
        rdbtn_Spiciness2.setActionCommand("2");
        panel_Spiciness.add(rdbtn_Spiciness2);
        //2
        JRadioButton rdbtn_Spiciness3 = new JRadioButton("3");
        rdbtn_Spiciness3.setActionCommand("3");
        panel_Spiciness.add(rdbtn_Spiciness3);
        //3
        JRadioButton rdbtn_Spiciness4 = new JRadioButton("4");
        rdbtn_Spiciness4.setActionCommand("4");
        panel_Spiciness.add(rdbtn_Spiciness4);
        //4
        JRadioButton rdbtn_Spiciness5 = new JRadioButton("5(Max)");
        rdbtn_Spiciness5.setActionCommand("5");
        panel_Spiciness.add(rdbtn_Spiciness5);
        //max
        ButtonGroup group4=new ButtonGroup();
        group4.add(rdbtn_Spiciness0);
        group4.add(rdbtn_Spiciness1);
        group4.add(rdbtn_Spiciness2);
        group4.add(rdbtn_Spiciness3);
        group4.add(rdbtn_Spiciness4);
        group4.add(rdbtn_Spiciness5);
        //设置单选
        JLabel lbl_Addson = new JLabel("Adds on");
        panel_Menu.add(lbl_Addson);
        //adds on label
        JPanel panel_addson1 = new JPanel();
        panel_addson1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_Menu.add(panel_addson1);
        panel_addson1.setLayout(new GridLayout(0, 2, 0, 0));
        //第一个adds on面板
        JPanel panel_Nori = new JPanel();
        panel_Nori.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_addson1.add(panel_Nori);
        //Nori面板
        JLabel lbl_XrNori = new JLabel("Extra Nori(\u00A31 )");
        panel_Nori.add(lbl_XrNori);
        JLabel lbl_NoriNum = new JLabel("0");
        //Nori Num
        JButton btnAdd1 = new JButton("+1");
        btnAdd1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int num=Integer.parseInt(lbl_NoriNum.getText());
                num++;
                lbl_NoriNum.setText(String.valueOf(num));
            }
        });
        panel_Nori.add(btnAdd1);
        //+1 button
        panel_Nori.add(lbl_NoriNum);
        //add label
        JButton btn_Reduce1 = new JButton("-1");
        btn_Reduce1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int num=Integer.parseInt(lbl_NoriNum.getText());
                if(num>0)
                    num--;
                lbl_NoriNum.setText(String.valueOf(num));
            }
        });
        panel_Nori.add(btn_Reduce1);
        //-1 button
        JPanel panel_egg = new JPanel();
        panel_egg.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_addson1.add(panel_egg);
        //Extra boiled egg
        JLabel lbl_egg = new JLabel("Extra boiled egg(\u00A31 )");
        panel_egg.add(lbl_egg);
        //Extra boiled egg label
        JButton btn_Add2 = new JButton("+1");
        JLabel lbl_EggNum = new JLabel("0");
        btn_Add2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int num=Integer.parseInt(lbl_EggNum.getText());
                num++;
                lbl_EggNum.setText(String.valueOf(num));
            }
        });
        panel_egg.add(btn_Add2);
        //+1 button
        panel_egg.add(lbl_EggNum);
        //鸡蛋的数量
        JButton btn_Reduce2 = new JButton("-1");
        btn_Reduce2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int num=Integer.parseInt(lbl_EggNum.getText());
                if(num>0)
                    num--;
                lbl_EggNum.setText(String.valueOf(num));
            }
        });
        panel_egg.add(btn_Reduce2);
        //-1 button

        JPanel panel_addson2 = new JPanel();
        panel_addson2.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_Menu.add(panel_addson2);
        panel_addson2.setLayout(new GridLayout(0, 2, 0, 0));
        //第二个adds on面板
        JPanel panel_Bamboo = new JPanel();
        panel_Bamboo.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_addson2.add(panel_Bamboo);
        //竹子面板
        JLabel lbl_Bamboo = new JLabel("Bamboo shoots(\u00A31)");
        panel_Bamboo.add(lbl_Bamboo);
        //竹子标签
        JLabel lbl_BambooNum = new JLabel("0");
        JButton btnAdd3 = new JButton("+1");
        btnAdd3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int num=Integer.parseInt(lbl_BambooNum.getText());
                num++;
                lbl_BambooNum.setText(String.valueOf(num));
            }
        });
        panel_Bamboo.add(btnAdd3);
        //+1 button
        panel_Bamboo.add(lbl_BambooNum);
        //竹子的数量
        JButton btn_reduce3 = new JButton("-1");
        btn_reduce3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int num=Integer.parseInt(lbl_BambooNum.getText());
                if(num>0)
                    num--;
                lbl_BambooNum.setText(String.valueOf(num));
            }
        });
        panel_Bamboo.add(btn_reduce3);
        //-1button

        JPanel panel_Chashu = new JPanel();
        panel_Chashu.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_addson2.add(panel_Chashu);
        panel_Chashu.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        //chashu面板
        JLabel lbl_Chashu = new JLabel("Extra Chashu(\u00A32)");
        panel_Chashu.add(lbl_Chashu);
        //chashu标签
        JLabel lbl_ChashuNum = new JLabel("0");
        JButton btn_Add4 = new JButton("+1");
        btn_Add4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int num=Integer.parseInt(lbl_ChashuNum.getText());
                num++;
                lbl_ChashuNum.setText(String.valueOf(num));
            }
        });
        panel_Chashu.add(btn_Add4);
        //+1 button

        panel_Chashu.add(lbl_ChashuNum);
        //chashu Num
        JButton btn_redece4 = new JButton("-1");
        btn_redece4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int num=Integer.parseInt(lbl_ChashuNum.getText());
                if(num>0)
                    num--;
                lbl_ChashuNum.setText(String.valueOf(num));

            }});
        panel_Chashu.add(btn_redece4);
        JPanel panel = new JPanel();
        panel_Menu.add(panel);
        panel.setLayout(new BorderLayout(0, 0));
        //-1 button
        JButton btn_OK = new JButton("OK");
        panel.add(btn_OK, BorderLayout.EAST);
        //选择结束按钮
        JLabel lbl_Remind = new JLabel("");
        lbl_Remind.setForeground(Color.RED);
        panel.add(lbl_Remind, BorderLayout.CENTER);
        //提醒的label
        JPanel panel_Info = new JPanel();
        panel_Info.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_Info.setLayout(new GridLayout(10,1));
        btn_OK.addActionListener(new ShowABowl(panel_Info,new Dish(group1.getSelection().getActionCommand(),
                group2.getSelection().getActionCommand(),group3.getSelection().getActionCommand(),
                chckbx_Nori.isSelected(),chckbx_Chashu.isSelected(),chckbx_Egg.isSelected(),
                Integer.parseInt(group4.getSelection().getActionCommand()),
                Integer.parseInt(lbl_NoriNum.getText()),Integer.parseInt(lbl_EggNum.getText()),
                Integer.parseInt(lbl_BambooNum.getText()),Integer.parseInt(lbl_ChashuNum.getText()))));
        JScrollPane sp=new JScrollPane(panel_Info);
        panel_C.add(sp);
    }

}
class ShowABowl implements ActionListener{ //展示一碗面
    private JPanel where;
    private Dish dish;
    public ShowABowl(JPanel where, Dish dish){
        this.where=where;
        this.dish=dish;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        where.add(new ANoodle(where,dish));
        where.validate();
    }
}
class Deleitem implements ActionListener{
    private ANoodle anoodle;
    private JPanel parent;
    public Deleitem(ANoodle anoodle,JPanel parent){
        this.parent=parent;
        this.anoodle=anoodle;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        parent.remove(anoodle.parePanel);
        parent.revalidate();
        parent.repaint();
    }
}
class ANoodle extends JPanel{
    JButton delebutton=new JButton("Delete");
    JPanel parePanel=this;
    JPanel parent;
    Dish dish;
    public ANoodle(JPanel parent,Dish dish){
        this.dish=dish;
        this.parent=parent;
        this.add(new JLabel(dish.getSoup()+"   "+dish.getNoodles()+"  "+"  onion  "+dish.getOnion()
                +"  Nori: "+dish.isOrigNori()+"Chashu   "+dish.isChashu()
                +"  BoiledEgg: "+dish.isBoiledEgg()+"  Spiciness: "+dish.getSpiciness()
                +"  exNori: "+dish.getExNori()+"  exEgg: "+dish.getExEgg()
                +"  exBamboo: "+dish.getExBamboo()+"  exChashu: "+dish.getExChashu()),BorderLayout.CENTER);
        this.add(delebutton,BorderLayout.EAST);
        delebutton.addActionListener(new Deleitem(this,parent));
    }
}
