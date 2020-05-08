package Data;

public class Menu {
    String tayp;
    String name;
    int level;
    int price;
    int sales;
    int inventory;

    public Menu (String s) {
        String[] as = s.split(",");
        this.setTayp(as[0]);
        this.setName(as[1]);
        this.setLevel(Integer.parseInt(as[2]));
        this.setPrice(Integer.parseInt(as[3]));
        this.setSales(Integer.parseInt(as[4]));
        this.setInventory(Integer.parseInt(as[5]));
    }

    public void setTayp (String t) {
        this.tayp = t;
    }

    public void setName (String n) {
        this.name = n;
    }

    public void setLevel (int l) {
        this.level = l;
    }

    public void setPrice (int p) {
        this.price = p;
    }

    public void setSales (int s) {
        this.sales = s;
    }

    public void setInventory (int i) {
        this.inventory = i;
    }

    public String getTayp () {
        return this.tayp;
    }

    public String getName () {
        return this.name;
    }

    public int getLevel () {
        return this.level;
    }

    public int getPrice () {
        return this.price;
    }

    public int getSales () {
        return this.sales;
    }

    public int getInventory () {
        return this.inventory;
    }
}
