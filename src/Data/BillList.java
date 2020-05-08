package Data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class BillList {
    public static boolean exportCsv(File file, List<String> dataList){//返回值为是否写入成功
        boolean isSucess=false;

        FileOutputStream out=null;
        OutputStreamWriter osw=null;
        BufferedWriter bw=null;
        try {
            out = new FileOutputStream(file);
            osw = new OutputStreamWriter(out);
            bw =new BufferedWriter(osw);
            if(dataList!=null && !dataList.isEmpty()){
                for(String data : dataList){
                    bw.append(data).append("\r");
                }
            }
            isSucess=true;
        } catch (Exception e) {
            isSucess=false;
        }finally{
            if(bw!=null){
                try {
                    bw.close();
                    bw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(osw!=null){
                try {
                    osw.close();
                    osw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null){
                try {
                    out.close();
                    out=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return isSucess;
    }


    public static List<String> importCsv(File file){//读取数据返回值为全部数据，注意！第一行为表头
        List<String> dataList=new ArrayList<String>();

        BufferedReader br=null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                dataList.add(line);
            }
        }catch (Exception e) {
        }finally{
            if(br!=null){
                try {
                    br.close();
                    br=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return dataList;
    }

    public static List<Bill> getBillList () {
        List<String> dataList=BillList.importCsv(new File("BillList.csv"));
        List<Bill> billList = new ArrayList<Bill>(dataList.size());
        if(dataList!=null && !dataList.isEmpty()){
            //打印所有数据
            for(int i=0; i<dataList.size();i++ ){
                if(i!=0){
                    String s=dataList.get(i);
                    //System.out.println("s  "+s);
                    billList.add(new Bill(s));
                }
            }
        }
        return billList;
    }

    public static List<String> setBillList (List<Bill> billList){
        List<String> dataList=new ArrayList<String>();
        if(billList != null && !billList.isEmpty()) {
            for(int i = 0; i < billList.size()+1; i++) {
                if(i == 0) {
                    dataList.add("BillNumber,MenbershipNumber,Data,Price,Payment,TakeOut");
                }
                else {
                    String s = Integer.toString(billList.get(i-1).getBillNumber());s += ",";
                    s += Integer.toString(billList.get(i-1).getMenbershipNumber());s += ",";
                    s += Integer.toString(billList.get(i-1).getData());s += ",";
                    s += Double.toString(billList.get(i-1).getPrice());s += ",";
                    s += Integer.toString(billList.get(i-1).getPayment());s += ",";

                    if(billList.get(i-1).getTakeOut()) {
                        s += "true,";
                    }
                    else {
                        s += "false,";
                    }
                    dataList.add(s);
                }
            }
        }


        return dataList;
    }



    public static void main(String[] args){

    }


    public static void importCsv()  {
        List<String> dataList=UserList.importCsv(new File("BillList.csv"));
        if(dataList!=null && !dataList.isEmpty()){
            //打印所有数据
            for(int i=0; i<dataList.size();i++ ){
                if(i!=0){
                    String s=dataList.get(i);
                    //System.out.println("s  "+s);
                    String[] as = s.split(",");
                    System.out.println(as[0]);
                    System.out.println(as[1]);
                    System.out.println(as[2]);
                    System.out.println(as[3]);
                    System.out.println(as[4]);
                    System.out.println(as[5]);
                }
            }
        }
    }


    public static void exportCsv() {
        List<String> dataList=new ArrayList<String>();
        dataList.add("BillNumber,MenbershipNumber,Data,Price,Payment,TakeOut");
        dataList.add("11111111,11111111,20200331,9.9,1,true");
        boolean isSuccess=BillList.exportCsv(new File("BillList.csv"), dataList);
        System.out.println(isSuccess);
    }

}
