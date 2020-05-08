package Data;

import java.util.*;

public class User {
    int menbershipNumber;
    String password;
    String firstName;
    String surname;
    String email;
    String phoneNumnber;
    boolean isAdmin;
    int virtualStamps;

    public User (String s) {
        String[] as = s.split(",");
        this.setMenbershipNumber(Integer.parseInt(as[0]));
        this.setPassword(as[1]);
        this.setFirstName(as[2]);
        this.setSurname(as[3]);
        this.setEmail(as[4]);
        this.setPhoneNumber(as[5]);
        this.setIsAdmin(as[6].equals("true"));
        this.setVirtualStamps(Integer.parseInt(as[7]));
    }

    public static boolean findUserNum (String lNum) {//检测是否存在相同lNum,若存在返回true,反之false
        List<User> userList = UserList.getUserList();//全user list
        if(userList != null && !userList.isEmpty()) {//遍历list
            for(int i = 0; i < userList.size()+1; i++) {
                if(i != 0) {
                    if(lNum.equals(Integer.toString(userList.get(i-1).getMenbershipNumber()))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static List<String> findUser (String lNum){//获得该lNum所有的信息，储存在一个String的ArrayList中，若无对应lNum则返回null
        List<String> user = new ArrayList<String>();
        List<User> userList = UserList.getUserList();//全user list
        if(userList != null && !userList.isEmpty()) {//遍历list
            for(int i = 0; i < userList.size()+1; i++) {
                if(i != 0) {
                    if(lNum.equals(Integer.toString(userList.get(i-1).getMenbershipNumber()))) {
                        user.add(Integer.toString(userList.get(i-1).getMenbershipNumber()));
                        user.add(userList.get(i-1).getPassword());
                        user.add(userList.get(i-1).getFirstName());
                        user.add(userList.get(i-1).getSurname());
                        user.add(userList.get(i-1).getEmail());
                        user.add(userList.get(i-1).getPhoneNumber());
                        if(userList.get(i-1).getIsAdmin()) {
                            user.add("true");
                        }
                        else {
                            user.add("false");
                        }
                        user.add(Integer.toString(userList.get(i-1).getVirtualStamps()));
                        return user;
                    }
                }
            }
        }
        return null;
    }

    public void setMenbershipNumber (int m) {
        this.menbershipNumber = m;
    }

    public void setPassword (String p) {
        this.password = p;
    }

    public void setFirstName (String fN) {
        this.firstName = fN;
    }

    public void setSurname (String s) {
        this.surname = s;
    }

    public void setEmail (String e) {
        this.email = e;
    }

    public void setPhoneNumber (String p) {
        this.phoneNumnber = p;
    }

    public void setIsAdmin (boolean i) {
        this.isAdmin = i;
    }

    public void setVirtualStamps (int v) {
        this.virtualStamps = v;
    }

    public int getMenbershipNumber () {
        return this.menbershipNumber;
    }

    public String getPassword () {
        return this.password;
    }

    public String getFirstName () {
        return this.firstName;
    }

    public String getSurname () {
        return this.surname;
    }

    public String getEmail () {
        return this.email;
    }

    public String getPhoneNumber () {
        return phoneNumnber;
    }


    public boolean getIsAdmin () {
        return this.isAdmin;
    }

    public int getVirtualStamps () {
        return this.virtualStamps;
    }
}
