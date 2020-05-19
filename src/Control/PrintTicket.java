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
    private double price;

    public PrintTicket(Customer cusInfo, int method){
        this.customer = cusInfo;
    }

    public void printTicket() throws IOException{
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
        }

        for(int i = 1; i <= dishNum; i++){
            Dish dish = customer.getOrder(i);
            price = price + dish.getSum();
            prt.writeTxt(dish.getNoodles() + "     " + dish.getSum());
        }
        prt.writeTxt("Total Price : " + price);
        prt.writeTxt("Number of Virtual Stamp : " + customer.getVStamp());


    }
}