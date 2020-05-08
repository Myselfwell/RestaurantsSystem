package Data;

public class Bill {
    //menbershipNumber,password,firstName,surname,email,phoneNumber,isAdmin,virtualStamps
    int BillNumber;
    int MenbershipNumber;
    int Data;
    double Price;
    int Payment;
    boolean TakeOut;

    public Bill (String s) {
        String[] as = s.split(",");
        this.setBillNumber(Integer.parseInt(as[0]));
        this.setMenbershipNumber(Integer.parseInt(as[1]));
        this.setData(Integer.parseInt(as[2]));
        this.setPrice(Double.valueOf(as[3]));
        this.setPayment(Integer.parseInt(as[4]));
        this.setTakeOut(as[5].equals("true"));
    }

    public void setBillNumber (int m) {
        this.BillNumber = m;
    }

    public void setMenbershipNumber (int m) {
        this.MenbershipNumber = m;
    }

    public void setData (int v) {
        this.Data = v;
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
        return this.MenbershipNumber;
    }

    public int getData () {
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
