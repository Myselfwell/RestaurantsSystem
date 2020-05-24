package Control;

import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Boundary.CustomerRegister;
import Data.User;
import Data.UserList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CheckRegister {
    private User user;
    List<User> userList = UserList.getUserList();
    private  String saccount;
    private List<String> newUser = new ArrayList <String>();//用于储存新用户所有信息

    ArrayList<String> content;//从用户注册gui的field中读取的数据

    public String assignAccount(){//系统随机分配8位数字作为loyalty number，应该把所有变量都返回回来，并且添加到list中
        while (true) {
            int account = (int) ((Math.random() * 9 + 1) * 10000000);
            saccount = String.valueOf(account);
            if (!user.findUserNum(saccount)) {//判断是否存在相同帐号，若不存在，则返回生成的帐号
                break;
            }
        }
        return saccount;
    }

    public boolean isPhone(String phone){//验证是否为（中国）手机号，若是返回true
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        boolean isMatch;
        if(phone.length()!=11){
            return false;
        }
        else{
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            isMatch = m.matches();
            if(!isMatch)
                return false;
            else {
                return true;
            }
        }
    }

    public boolean isEmail(String email){//验证邮箱格式
        String regex = "^\\w+((-\\w+)|(\\.\\w+))*@\\w+(\\.\\w{2,3}){1,3}$";
        Pattern p = Pattern.compile(regex);
        Matcher m=p.matcher(email);
        if(m.matches()){
            return true;
        }else
            return false;
    }

    public boolean isPwd(char[] pwd){//验证密码格式，8-16位，必须同时包含数字字母
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
        String s=String .valueOf(pwd);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        if(m.matches()){
            return true;
        }else
            return false;
    }

    public boolean reCheck(char[] pwd, char[] repwd){//再次输入密码
        if(!pwd.equals(repwd))
            return false;
        return true;
    }

    public boolean isName(String name){//判读姓名格式,无空格即可
        Pattern pattern = Pattern.compile("[0-9a-zA-Z\\u4E00-\\u9FA5]+");
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches()) {
            return true;
        }
        else
            return false;
    }
    public void saveData(String s){//需要将newUser这个list存入UserList
        User nuser = new User(s);
        userList.add(nuser);
        UserList.exportCsv(new File("UserList.csv"), UserList.setUserList(userList));//存入csv
    }
}
