package com.example.myutils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BJB184
 * 扫描工具类
 * Created by tang on 2017/2/13.
 */

public class ScanUtil {
    public static List<String> scanMeterId(String result) {
        boolean isNum = result.matches("[0-9]+");
        if (!isNum) {
            return null;
        }
        List<String> results = new ArrayList<>(3);
        //厂家
        results.add(result.substring(0, 1));
        //类型
        results.add(result.substring(1, 3));
        //口径
        results.add(result.substring(3, 4));
        return results;
    }

    public static String checkBarCode(String barcode) {
        boolean isNum = barcode.matches("[0-9]+");
        if (!isNum) {
            return "";
        }
        String checkNum="";

        char[] chars = barcode.toCharArray();
        int count= Integer.parseInt(barcode.charAt(0)+"")*3+ Integer.parseInt(barcode.charAt(1)+"")+
                Integer.parseInt(barcode.charAt(2)+"")*3+ Integer.parseInt(barcode.charAt(3)+"")+
                Integer.parseInt(barcode.charAt(4)+"")*3+ Integer.parseInt(barcode.charAt(5)+"")+
                Integer.parseInt(barcode.charAt(6)+"")*3+ Integer.parseInt(barcode.charAt(7)+"")+
                Integer.parseInt(barcode.charAt(8)+"")*3+ Integer.parseInt(barcode.charAt(9)+"")+
                Integer.parseInt(barcode.charAt(10)+"")*3+ Integer.parseInt(barcode.charAt(11)+"")+
                Integer.parseInt(barcode.charAt(12)+"")*3;
        int remainder = count % 10;
        checkNum=(10-remainder%10)%10+"";
        return barcode+checkNum;

/*        for (int i = 0; i <barcode.length()-1; i++) {
            String str1 = chars[i] + "";
            String str2 = chars[i+1] + "";
            if (i%2==0)
            {
                int i1 = Integer.parseInt(str1) * 3;
            }
            count +=  + Integer.parseInt(str2);
            int yushu = count % 10;
            String checksum = (10 - yushu) % 10 + "";

            return

        }*/

    }

}
