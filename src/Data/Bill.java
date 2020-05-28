package Data;
import Entity.Dish;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Bill {
    //membershipNumber,password,firstName,surname,email,phoneNumber,isAdmin,virtualStamps
    int BillNumber;
    int MembershipNumber;
    String Data;
    double Price;
    int Payment;
    boolean TakeOut;

    public Bill (String s) {
        String[] as = s.split(",");
        this.setBillNumber(Integer.parseInt(as[0]));
        this.setMenbershipNumber(Integer.parseInt(as[1]));
        this.setData(as[2]);
        this.setPrice(Double.valueOf(as[3]));
        this.setPayment(Integer.parseInt(as[4]));
        this.setTakeOut(as[5].equals("true"));
    }

    public void setBillNumber (int m) {
        this.BillNumber = m;
    }

    public void setMenbershipNumber (int m) {
        this.MembershipNumber = m;
    }

    public void setData (String d) {
        this.Data = d;
    }

    public void setPrice (double v) {
        this.Price = v;
    }

    public void setPayment (int i) {
        this.Payment = i;
    }

    public void setTakeOut (boolean i) {
        this.TakeOut = i;
    }

    public int getBillNumber () {
        return this.BillNumber;
    }

    public int getMenbershipNumber () {
        return this.MembershipNumber;
    }

    public String getData () {
        return this.Data;
    }

    public double getPrice () {
        return this.Price;
    }

    public int getPayment () {
        return this.Payment;
    }

    public boolean getTakeOut () {
        return this.TakeOut;
    }

}




