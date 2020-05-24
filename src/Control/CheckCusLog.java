package Control;

import Boundary.CustomerLoginIn;
import Boundary.CustomerRegister;
import Data.User;
import Data.UserList;

import java.util.*;

public class CheckCusLog {

    private User user;

    List<User> userList = UserList.getUserList();

    ArrayList<String> content;//从用户登录gui的field中读取的数据
    List<String> userInfo = new ArrayList <String>();//存储该用户所有信息

    public List<String> isAccount(String account){//检查account是否在csv中
        boolean isAccount = user.findUserNum(account);
        if(isAccount){
            userInfo = user.findUser(content.get(0));//根据用户名找到的用户其他信息
            isPwd(content.get(1),userInfo);
            return userInfo;
        }else
            isAccount(content.get(0));
        return null;
    }

    public boolean isPwd(String pwd,List<String> userInfo){//检查密码是否正确
        if(userInfo.get(1).equals(pwd))//密码正确则返回所有信息
            return true;
        else
            return false;
    }

    public List<String> returnUserInfo(){

        return userInfo;
    }

}
