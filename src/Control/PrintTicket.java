package Control;

import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import Entity.*;

public class PrintTicket
{
    private Customer customer;
    private String loyaltyNum;
    private String firstName;
    private String lastName;
    private int vStamp;
    private int dishNum;
    private String orderNum;
    private int method;
    private float price;

    public PrintTicket(Customer cusInfo, int method){
        this.customer = cusInfo;
    }

    public void printTicket(){
        Date date = new Date();
        SimpleDateFormat datePtrn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat orderDatePtrn = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = datePtrn.format(new Date());
        orderNum = orderDatePtrn.format(new Date()) + loyaltyNum;
        String addr = "src/Database/Ticket" + orderNum + ".txt";

        loyaltyNum = customer.getLoyaltyNum();
        firstName = customer.getFirstName();
        lastName = customer.getLastName();
        vStamp = customer.getVStamp();
        dishNum = customer.getDishNum();

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
        }


    }
}