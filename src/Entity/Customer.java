package Entity;
import java.util.*;
import Data.*;
import java.io.File;

public class Customer
{
    private String loyaltyNum;
    private String firstName;
    private String lastName;
    private String phoneNum;
    private String emailAdr;
    private String password;
    private int vStamp;            // Virtual stamp

    private List<Dish> order = new ArrayList<Dish>();
    private int dishNum;   		   // Number of dishes

    private UserList cus = new UserList();    // File I/O class

    // Used for registration
    public Customer(){
        this.loyaltyNum = "00000000";
        this.firstName = "Guest";
        this.lastName = "guest";
        this.vStamp=0;
    }

    // Creat customer instance through passing the loyalty number
    // Used for login
    public Customer(List<String> cusInfo){
        this.loyaltyNum = cusInfo.get(0);
        this.password = cusInfo.get(1);
        this.firstName = cusInfo.get(2);
        this.lastName = cusInfo.get(3);
        this.emailAdr = cusInfo.get(4);
        this.phoneNum = cusInfo.get(5);
        this.vStamp = Integer.parseInt(cusInfo.get(7));
    }

    // Get loyalty number
    public String getLoyaltyNum(){
        return loyaltyNum;
    }

    // Be used on registration, store the data into the database
    public void setLoyaltyNum(String num){
        this.loyaltyNum = num;
    }

    // Get first name
    public String getFirstName(){
        return firstName;
    }

    //be used on registration, store the data into the database
    public void setFirstName(String name){
        this.firstName = name;
    }

    // Get last name
    public String getLastName(){
        return lastName;
    }

    // Be used on registration, store the data into the database
    public void setLastName(String name){
        this.lastName = name;
    }

    // Get phone number
    public String getPhoneNum(){
        return phoneNum;
    }

    // Be used on registration, store the data into the database
    public void setPhoneNum(String num){
        this.phoneNum = num;
    }

    // Get email address
    public String getEmailAdr(){
        return emailAdr;
    }

    // Be used on registration, store the data into the database
    public void setEmailAdr(String adr){
        this.emailAdr = adr;
    }

    // Get the number of virtual stamps
    public int getVStamp(){
        return vStamp;
    }

    // Add one virtual stamp
    public void incVStamp(){
        vStamp ++;
    }

    // Set the virtual stamp back to zero
    public void clearVStamp(){
        vStamp = 0;
    }

    // Get the total number of dish ordered by customer
    public int getDishNum(){
        return dishNum;
    }

    // Get the Dish instance through giving the number of dish
    public Dish getOrder(int dishNo){
        dishNo --;
        Dish dish = order.get(dishNo);
        return dish;
    }

    // Add one dish instance
    public void setOrder(Dish dish){
        order.add(dish);
    }

    // Only used for registration where customer need to set password
    public void setPassword(String pswd){
        this.password = pswd;
    }

    // When user finish registration, update information to database
    public void update(){
        List<User> userList = UserList.getUserList();

        if(userList != null && !userList.isEmpty()) {
            for(int i = 0; i < userList.size(); i++) {
                if(Integer.parseInt(this.loyaltyNum) == userList.get(i).getMembershipNumber())
                    userList.get(i).setPassword(this.password);
                userList.get(i).setFirstName(this.firstName);
                userList.get(i).setSurName(this.lastName);
                userList.get(i).setEmail(this.emailAdr);
                userList.get(i).setPhoneNumber(this.phoneNum);
                userList.get(i).setVirtualStamps(this.vStamp);
            }
        }

        boolean isSuccess=UserList.exportCsv(new File("UserList.csv"), UserList.setUserList(userList));

        if(isSuccess){
            System.out.println("Logs:Success to write UserList.");
        }
        else{
            System.out.println("Logs:Fail to write UserList.");
        }// write the data into database
    }
}