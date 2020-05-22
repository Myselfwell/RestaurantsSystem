package Control;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import Entity.*;
import Data.*;

public class PrintTicket
{
    private Customer customer;
    private PrintBill prt;

    private String loyaltyNum;
    private String firstName;
    private String lastName;
    private int vStamp;
    private int dishNum;
    private String orderNum;
    private int method;
    private Boolean istakeout;
    private double price;

    public PrintTicket(Customer cusInfo, int method, Boolean istakeout){
        this.customer = cusInfo;
        this.method = method;
        this.istakeout = istakeout;
    }

    public void printTic() throws IOException{
        SimpleDateFormat datePtrn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat orderDatePtrn = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = datePtrn.format(new Date());
        orderNum = orderDatePtrn.format(new Date()) + loyaltyNum;

        prt = new PrintBill();
        prt.creatTxt(orderNum);


        loyaltyNum = customer.getLoyaltyNum();
        firstName = customer.getFirstName();
        lastName = customer.getLastName();
        vStamp = customer.getVStamp();
        dishNum = customer.getDishNum();

        prt.writeTxt("Welcome to the restaurant " + firstName + lastName);
        prt.writeTxt("Order Number : " + orderNum);
        prt.writeTxt("Date : " + time);
        prt.writeTxt("Loyalty Number : " + loyaltyNum);
        prt.writeTxt("Your have been order :");

        if(vStamp != 10){
            customer.incVStamp();
            customer.update();
        }
        else{
            customer.clearVStamp();
            customer.update();
            dishNum --;
            method = 3;
        }

        for(int i = 1; i <= dishNum; i++){
            Dish dish = customer.getOrder(i);
            price = price + dish.getSum();
            prt.writeTxt(dish.getNoodles() + "     " + dish.getSum());
        }
        prt.writeTxt("Total Price : " + price);
        prt.writeTxt("Number of Virtual Stamp : " + customer.getVStamp());

        if(method == 0){
            if(istakeout == true){
                prt.writeTxt("Take out   By Cash");
            }
            else prt.writeTxt("Eat in   By Cash");
        }
        else if(method == 1){
            if(istakeout == true){
                prt.writeTxt("Take out   By Card");
            }
            else prt.writeTxt("Eat in   By Card");
        }
        else{
            if(istakeout == true){
                prt.writeTxt("Take out   By Virtual Stamp");
            }
            else prt.writeTxt("Eat in   By Virtual Stamp");
        }


    }
}