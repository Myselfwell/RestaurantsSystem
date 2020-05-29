package Entity;
/**
 * @ClassName: Dish
 * @description: This class is used to record the options of the customer
 *
 **/
import Control.Menu;
import Control.MenuList;

import java.io.File;
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
        this.isvalid=true; //false means the customer delete the item
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


    public  void showAll (){
        System.out.println(this.soup);
        System.out.println(this.noodles);
        System.out.println(this.onion);
    }

    public  void updateSale (){

        List<Menu> menuList = MenuList.getMenuList();
        if(menuList != null && !menuList.isEmpty()) {
            for(int i = 0; i < menuList.size(); i++) {
                menuList.get(i).setSales(0);
            }//清空list
            for(int i = 0; i < menuList.size(); i++) {
                if(menuList.get(i).getType().equals("Soup")){
                    if(menuList.get(i).getName().equals("Tonkotsu") && this.soup.equals("Tonkotsu")){
                        menuList.get(i).setSales(1);
                    }
                    if(menuList.get(i).getName().equals("Shoyu") && this.soup.equals("Shoyu")){
                        menuList.get(i).setSales(1);
                    }
                    if(menuList.get(i).getName().equals("Shio") && this.soup.equals("Shio")){
                        menuList.get(i).setSales(1);
                    }
                }
                if(menuList.get(i).getType().equals("Noodles")){
                    if(menuList.get(i).getName().equals("Soft") && this.noodles.equals("Soft")){
                        menuList.get(i).setSales(1);
                    }
                    if(menuList.get(i).getName().equals("Medium") && this.noodles.equals("Medium")){
                        menuList.get(i).setSales(1);
                    }
                    if(menuList.get(i).getName().equals("Firm") && this.noodles.equals("Firm")){
                        menuList.get(i).setSales(1);
                    }
                }
                if(menuList.get(i).getType().equals("Onion")){
                    if(menuList.get(i).getName().equals("No") && this.onion.equals("No")){
                        menuList.get(i).setSales(1);
                    }
                    if(menuList.get(i).getName().equals("Onion") && menuList.get(i).getLevel() == 1 && this.onion.equals("Little")){
                        menuList.get(i).setSales(1);
                    }
                    if(menuList.get(i).getName().equals("Firm") && menuList.get(i).getLevel() == 2 && this.onion.equals("Lot")){
                        menuList.get(i).setSales(1);
                    }
                }
                if(menuList.get(i).getType().equals("Nori")){
                    if(menuList.get(i).getName().equals("Nori") && this.origNori){
                        menuList.get(i).setSales(1);
                    }
                    if(menuList.get(i).getName().equals("No") && !this.origNori){
                        menuList.get(i).setSales(1);
                    }
                }
                if(menuList.get(i).getType().equals("Chashu")){
                    if(menuList.get(i).getName().equals("Chashu") && this.chashu){
                        menuList.get(i).setSales(1);
                    }
                    if(menuList.get(i).getName().equals("No") && !this.chashu){
                        menuList.get(i).setSales(1);
                    }
                }
                if(menuList.get(i).getType().equals("Egg")){
                    if(menuList.get(i).getName().equals("Egg") && this.boiledEgg){
                        menuList.get(i).setSales(1);
                    }
                    if(menuList.get(i).getName().equals("No") && !this.boiledEgg){
                        menuList.get(i).setSales(1);
                    }
                }
                if(menuList.get(i).getType().equals("Spiciness")){
                    if(menuList.get(i).getLevel() == this.spiciness){
                        menuList.get(i).setSales(1);
                    }
                }
                if(menuList.get(i).getType().equals("AddOne")){
                    if(menuList.get(i).getName().equals("Nori")){
                        menuList.get(i).setSales(exNori);
                    }
                    if(menuList.get(i).getName().equals("Egg")){
                        menuList.get(i).setSales(exEgg);
                    }
                    if(menuList.get(i).getName().equals("Bamboo")){
                        menuList.get(i).setSales(exBamboo);
                    }
                    if(menuList.get(i).getName().equals("Chashu")){
                        menuList.get(i).setSales(exChashu);
                    }
                }
            }
            menuList = MenuList.checkInventory(menuList);
            List<Menu> newMenuList = MenuList.getMenuList();
            if(newMenuList != null && !newMenuList.isEmpty()) {
                for (int i = 0; i < newMenuList.size(); i++) {
                    newMenuList.get(i).setSales(newMenuList.get(i).getSales() + menuList.get(i).getSales());
                    newMenuList.get(i).setInventory(menuList.get(i).getInventory());
                }
            }
            MenuList.exportCsv(new File("src/Database/MenuList.csv"), MenuList.setMenuList(newMenuList));
        }
    }

}



