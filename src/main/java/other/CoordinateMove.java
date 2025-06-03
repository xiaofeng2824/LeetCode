package other;

import java.util.Scanner;

public class CoordinateMove {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.nextLine();


        int x=0,y=0;

        // 边界判断
        if(str == null || str.length() == 0){
            System.out.println(x + "," + y);
            return;
        }

        int l = 0;


        while(str == null || str.length() > 0){
            // ; 的位置
            int r = str.indexOf(";");
            String substring = str.substring(0,r);

            //违法行判断
            if(!substring.startsWith("A") && !substring.startsWith("D")
                    && !substring.startsWith("S") && !substring.startsWith("W")){
                str = str.substring(r+1);
                continue;
            }

            String flag = substring.substring(0,1);
            String numStr = substring.substring(1);

            int step = 0;
                try{
                  step =  Integer.parseInt(numStr);
               }catch (Exception e){
                    str = str.substring(r+1);
                continue;
                }


            // 步骤 step 违法判断
            if(step < 0 || step >= 100){
                str = str.substring(r+1);
                continue;
            }

            if(flag.equals("A")){
                x -=  step;
            }
            if(flag.equals("S")){
                y -= step;
            }
            if(flag.equals("W")){
                y += step;
            }

            if(flag.equals("D")){
                x += step;
            }


            l = r+1;
            str = str.substring(l);
        }

        System.out.println(x + "," + y);
    }
}
