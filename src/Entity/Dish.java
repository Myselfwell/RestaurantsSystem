package Entity;

import Data.Menu;
import Data.MenuList;

import java.util.ArrayList;
import java.util.List;

public class Dish {
    private String soup,noodles,onion;
    private boolean origNori,chashu,boiledEgg,isvalid;
    private int spiciness;
    private int exNori,exEgg,exBamboo,exChashu,sum;


    public Dish(String soup, String noodles, String onion, boolean origNori, boolean chashu, boolean boiledEgg, int spiciness, int exNori, int exEgg, int exBamboo, int exChashu) {
        this.soup = soup;
        this.noodles = noodles;
        this.onion = onion;
        this.origNori = origNori;
        this.chashu = chashu;
        this.boiledEgg = boiledEgg;
        this.spiciness = spiciness;
        this.exNori = exNori;
        this.exEgg = exEgg;
        this.exBamboo = exBamboo;
        this.exChashu = exChashu;
        this.isvalid=true;
    }

    public String getSoup() {
        return soup;
    }

    public void setSoup(String soup) {
        this.soup = soup;
    }

    public String getNoodles() {
        return noodles;
    }

    public void setNoodles(String noodles) {
        this.noodles = noodles;
    }

    public String getOnion() {
        return onion;
    }

    public void setOnion(String onion) {
        this.onion = onion;
    }

    public boolean isOrigNori() {
        return origNori;
    }

    public void setOrigNori(boolean origNori) {
        this.origNori = origNori;
    }

    public boolean isChashu() {
        return chashu;
    }

    public void setChashu(boolean chashu) {
        this.chashu = chashu;
    }

    public boolean isBoiledEgg() {
        return boiledEgg;
    }

    public void setBoiledEgg(boolean boiledEgg) {
        this.boiledEgg = boiledEgg;
    }

    public int getSpiciness() {
        return spiciness;
    }

    public void setSpiciness(int spiciness) {
        this.spiciness = spiciness;
    }

    public int getExNori() {
        return exNori;
    }

    public void setExNori(int exNori) {
        this.exNori = exNori;
    }

    public int getExEgg() {
        return exEgg;
    }

    public void setExEgg(int exEgg) {
        this.exEgg = exEgg;
    }

    public int getExBamboo() {
        return exBamboo;
    }

    public void setExBamboo(int exBamboo) {
        this.exBamboo = exBamboo;
    }

    public int getExChashu() {
        return exChashu;
    }

    public void setExChashu(int exChashu) {
        this.exChashu = exChashu;
    }
    public double calculationPrice () {

        double allPrice = 9.9;
        List<Menu> menuList = MenuList.getMenuList();
        if(menuList != null && !menuList.isEmpty()) {
            for(int i = 0; i < menuList.size(); i++) {
                if(menuList.get(i).getType().equals("AddOne")) {
                    if(menuList.get(i).getName().equals("Nori")){
                        allPrice += this.exNori * menuList.get(i).getPrice();
                    }
                    if(menuList.get(i).getName().equals("Egg")){
                        allPrice += this.exEgg * menuList.get(i).getPrice();
                    }
                    if(menuList.get(i).getName().equals("Bamboo")){
                        allPrice += this.exBamboo  * menuList.get(i).getPrice();
                    }
                    if(menuList.get(i).getName().equals("Chashu")){
                        allPrice += this.exChashu * menuList.get(i).getPrice();
                    }
                }
            }
        }
        return allPrice;
    }

    public boolean isIsvalid() {
        return isvalid;
    }

    public void setIsvalid(boolean isvalid) {
        this.isvalid = isvalid;
    }
}
