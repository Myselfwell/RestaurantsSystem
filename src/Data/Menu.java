package Data;

public class Menu {
    String type;
    String name;
    int level;
    double price;
    int sales;
    int inventory;

    public Menu (String s) {
        String[] as = s.split(",");
        this.setType(as[0]);
        this.setName(as[1]);
        this.setLevel(Integer.parseInt(as[2]));
        this.setPrice(Integer.parseInt(as[3]));
        this.setSales(Integer.parseInt(as[4]));
        this.setInventory(Integer.parseInt(as[5]));
    }



    public void setType (String t) {
        this.type = t;
    }

    public void setName (String n) {
        this.name = n;
    }

    public void setLevel (int l) {
        this.level = l;
    }

    public void setPrice (double p) {
        this.price = p;
    }

    public void setSales (int s) {
        this.sales = s;
    }

    public void setInventory (int i) {
        this.inventory = i;
    }

    public String getType () {
        return this.type;
    }

    public String getName () {
        return this.name;
    }

    public int getLevel () {
        return this.level;
    }

    public double getPrice () {
        return this.price;
    }

    public int getSales () {
        return this.sales;
    }

    public int getInventory () {
        return this.inventory;
    }




}
