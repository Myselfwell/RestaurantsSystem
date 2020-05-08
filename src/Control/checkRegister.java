package Control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import Data.UserList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Entity.*;

//检验用户注册格式
public class checkRegister {

    public static String assignAccount(ArrayList<String> allAcc){//系统随机分配6位数字作为用户名(existed是所有用户的account)
        int account ;
        String saccount = null;
        for(int j=0;j<100;j++) { //assign bank account
            account = (int) ((Math.random() * 9 + 1) * 100000);//生成随机数
            saccount=String.valueOf(account);//将int转成string
            for(int i=0;i<=allAcc.size()-1;i++){
                if(saccount.equals(allAcc.get(i))){
                    assignAccount(allAcc);
                }
            }
        }
        return saccount;
    }

    public static boolean isPhone(String phone){//验证是否为（中国）手机号
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if(phone.length()!=11){
            System.out.println("The digit of your phone number should be 11.");//位数不对
            return false;
        }else{
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            boolean isMatch = m.matches();

            if(!isMatch){
                System.out.println("Please input the correct number");//格式不对

            }
            return isMatch;
        }
    }

    public static boolean isEmail(String email){//验证邮箱格式
        String regex = "^\\w+((-\\w+)|(\\.\\w+))*@\\w+(\\.\\w{2,3}){1,3}$";
        Pattern p = Pattern.compile(regex);
        Matcher m=p.matcher(email);
        return m.matches();
    }

    public static boolean isPwd(String pwd){//验证密码格式，8-16位，必须同时包含数字字母
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(pwd);
        return m.matches();
    }
    public static boolean recheckPwd(String pwd,String repwd){//再次验证密码(接口为验证通过的密码，重新输入的密码)
        if(pwd.equals(repwd)){
            return true;
        }else
            return false;
    }

    //挑选出csv中的所有用户名信息
    public static ArrayList<String> selectAcc(ArrayList<String> existed){
        ArrayList<String> account = new ArrayList<>();
        for(int i=0;i<=existed.size()-1;){
            account.add(existed.get(i));
            i=i+8;
        }
        return account;
    }

    //测试代码，运行上面所有函数
    public static void main(String[] args){
        ArrayList<String> existed = new ArrayList<>();
        Collections.addAll(existed,"123456","123456","San","Zhang","110@qq.com","13581694911",
                "1","0","87654321","87654321","Si","Li","120@qq.com","18810007905","0","5","654321","654321","Wu",
                "Wang","119@qq.com","18831100601","0","9");//从CSV中读取

        ArrayList<String> allAcc = selectAcc(existed);//获得所有用户的用户名
        String account = assignAccount(allAcc);
        System.out.println(account);

//        int account = assignAccount(existed);
//        System.out.println(account);

//        System.out.println("input phone:");
//        Scanner sc = new Scanner(System.in);
//        String phone = sc.nextLine();
//        System.out.println("input email");
//        String email = new Scanner(System.in).nextLine();
//        boolean isEmail = isEmail(email);
//        System.out.println("input pwd");
//        String pwd = new Scanner(System.in).nextLine();
//        boolean isPwd = isPwd(pwd);
//        boolean isPhone = isPhone(phone);
//
//        if(isPhone){
//            System.out.println("correct phone");
//        }
//        if(isEmail){
//            System.out.println("correct email");
//        }else
//            System.out.println("wrong email");
//        if(isPwd){
//            System.out.println("correct pwd");
//        }else{
//            System.out.println("wrong pwd");
//        }
    }

}
