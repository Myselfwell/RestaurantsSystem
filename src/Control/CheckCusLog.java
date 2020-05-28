package Control;

import java.util.*;

public class CheckCusLog {

    List<String> userInfo = new ArrayList <String>();//存储该用户所有信息

    public List<String> isAccount(String account){//检查account是否在csv中
        if (account==null){
            return null;
        }
        boolean isAccount = User.findUserNum(account);
        if(isAccount){
            userInfo = User.findUser(account);//根据用户名找到的用户其他信息
            return userInfo;
        }else
            return null;
    }

    public boolean isPwd(String pwd,List<String> userInfo){//检查密码是否正确
        if(userInfo.get(1).equals(pwd))//密码正确则返回所有信息
            return true;
        else
            return false;
    }

    public boolean isStaff(List<String> userInfo){
        if(userInfo.get(6).equals("false")){
            System.out.println(userInfo.get(6));
            return false;
        }
        else{
            System.out.println(userInfo.get(6));
            return true;
        }
    }

    public List<String> returnUserInfo(){

        return userInfo;
    }

}
