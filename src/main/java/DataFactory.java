import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by wfsovereign on 15-3-21.
 */
public class DataFactory {
    public int[] personInfo;
    public String getDayInfo(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();

        return simpleDateFormat.format(date);
    }

    public void getPersonInfo(){
        Scanner input = new Scanner(System.in);
        int[] personInfo = new int[7];
        String[] person = {"冯杨琦君","王中碧","赵 鹏","曾璞阳","罗 阳","陈世超","汪 鑫"};
//        System.out.println("******人员编号匹配表******");
//        System.out.println("1：冯杨琦君  2：王中碧");
//        System.out.println("3：赵 鹏    4：曾璞阳");
//        System.out.println("5：罗 阳    6：陈世超");
//        System.out.println("7：汪 鑫");
        for (int i = 0; i < 7; i++) {
            System.out.println(i+"："+person[i]);
        }
        System.out.println("下面请按序输入人员到位情况：（输入1/0,1表示到，0表示未到）");
        int i=0;
        while (i<7){
            System.out.println("现在请输入编号为 "+ (i+1) +" 的同志到位情况：");
            personInfo[i] = input.nextInt();
            System.out.println(i);
            i++;
        }
        System.out.println("输入完毕，谢谢配合");
        System.out.println("您输入的结果为：");
        String inputResult="";
        TransferInput transferInput = new TransferInput();
        for (int j = 0; j < 7; j++) {
            inputResult += person[j] + transferInput.transfer(personInfo[j])+"\n";
        }

        System.out.println(inputResult);
        this.personInfo = personInfo;
    }
}
