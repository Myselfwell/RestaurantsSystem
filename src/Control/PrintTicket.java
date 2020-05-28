package Control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import Entity.*;
import Data.*;

public class PrintTicket
{
    private Customer customer;
    private PrintData prt;
    private List<String> bill;

    private String loyaltyNum;
    private String firstName;
    private String lastName;
    private int vStamp;
    private int dishNum;
    private String orderNum;
    private int method;
    private Boolean istakeout;
    private double price;

    public PrintTicket(Customer cusInfo, int method, Boolean isTakeOut){
        this.customer = cusInfo;
        this.method = method;
        this.istakeout = isTakeOut;
    }

    public void printTic() throws IOException{

        SimpleDateFormat datePtrn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat billdatePtrn = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat orderDatePtrn = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = datePtrn.format(new Date());
        String billTime = billdatePtrn.format(new Date());
        orderNum = orderDatePtrn.format(new Date()) + customer.getLoyaltyNum();

        prt = new PrintData("src/Database/Ticket/");
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

        if(vStamp < 10){
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
            if(dish.isIsvalid()){
                price = price + dish.calculationPrice();
                prt.writeTxt(dish.getNoodles() + "     " + dish.calculationPrice());
                dish.updateSale();
                customer.incVStamp();
            }
        }

        if(customer.getLoyaltyNum() != "00000000"){
            customer.update();
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

        bill = new ArrayList<String>();
        bill.add(orderNum);
        System.out.println(bill.get(0));
        bill.add(loyaltyNum);
        bill.add(billTime);
        bill.add(String.valueOf(price));
        bill.add(String.valueOf(method));
        if(istakeout){
            bill.add("true");
        }else bill.add("false");

        Bill billins = new Bill();
        billins .setOrder(bill);
    }
}