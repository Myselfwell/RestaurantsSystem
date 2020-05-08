package Control;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class checkCusLog {
    static int index;

    public static boolean isAccount(String account,ArrayList<String> existed){//检查account是否在csv中，existed需要从csv中读取
        boolean isAccount = false;

        for(int i=0;i<=existed.size()-1;i++){
            if(existed.get(i).equals(account)){
                isAccount = true;
                index=i;
                break;
            }
        }
        return isAccount;
    }

    public static boolean isPwd(String pwd, ArrayList<String> existed){//检查密码是否正确

        boolean isPwd = false;
        if(existed.get(index+1).equals(pwd)){
            isPwd=true;
        }

        return isPwd;
    }

    public static ArrayList<String> getInfo(ArrayList<String> existed){//返回登陆成功的用户的所有信息
        ArrayList<String> userInfo = new ArrayList<>();
        for(int i=0;i<index+8;i++){
            userInfo.add(existed.get(i));
        }
        return userInfo;
    }


    public static void main(String[] args){//测试代码
        ArrayList<String> existed = new ArrayList<>();
        Collections.addAll(existed,"123456","123456","San","Zhang","110@qq.com","13581694911",
                "1","0","87654321","87654321","Si","Li","120@qq.com","18810007905","0","5","654321","654321","Wu",
                "Wang","119@qq.com","18831100601","0","9");//arraylist从CSV中读

        System.out.println("input your account");
        String account = new Scanner(System.in).nextLine();
        if(isAccount(account,existed)){
            System.out.println("right account");
            System.out.println("input your password");
            String pwd = new Scanner(System.in).nextLine();
            if(isPwd(pwd,existed)){
                System.out.println("right pwd");
                ArrayList<String> userInfo = getInfo(existed);
                System.out.println("The user information is :"+userInfo);
            }else{
                System.out.println("Wrong pwd");
            }
        }else
            System.out.println("not exist.");
    }


}
