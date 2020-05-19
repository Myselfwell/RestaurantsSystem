package Data;
import java.io.*;

public class PrintBill {

    private static String path = "src/Database/Ticket";//文件保存路径，记得写，别忘了，不然用不了
    private static String filenameTemp;
    public static void creatTxt(String fName) throws IOException{
        // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
        /* 写入Txt文件 */
        try{
            filenameTemp =  path + fName + ".txt";
            File writename = new File(filenameTemp);// 相对路径，如果没有则要建立一个新的output。txt文件
            if(!writename.exists()){
                writename.createNewFile(); // 创建新文件
            }
        }
        catch (IOException e1) {
            throw e1;
        }

    }
    public static void writeTxt(String newStr) throws IOException {
        // 先读取原有文件内容，然后进行写入操作

        String filein = newStr + "\r\n";
        String temp = "";

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        FileOutputStream fos = null;
        PrintWriter pw = null;
        try {
            // 文件路径
            File file = new File(filenameTemp);
            // 将文件读入输入流
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();

            // 保存该文件原有的内容
            for (int j = 1; (temp = br.readLine()) != null; j++) {
                buf = buf.append(temp);
                // System.getProperty("line.separator")
                // 行与行之间的分隔符 相当于“\n”
                buf = buf.append(System.getProperty("line.separator"));
                System.out.println(j);//计数用，无意义
            }
            buf.append(filein);

            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
            pw.write(buf.toString().toCharArray());
            pw.flush();
        } catch (IOException e1) {
            throw e1;
        } finally {
            if (pw != null) {
                pw.close();
            }
            if (fos != null) {
                fos.close();
            }
            if (br != null) {
                br.close();
            }
            if (isr != null) {
                isr.close();
            }
            if (fis != null) {
                fis.close();
            }
        }

    }

    public static void main(String[] args) throws IOException{
    	/*测试用代码，使用例
    	PrintBill.creatTxt("test");
    	PrintBill.writeTxt("asd");
*/
    }

}