package com.UHT.Insight.utils;


import java.io.*;

//读取文件内容
public class FileUtils {
    //读取txt文件内容(Json格式数据)：resourse下的文件.json
    public static String reader(String filePath) {
        try {
            //URL url = new URL(filePath);远程
            File file = new File(filePath);//本地
            if (file.isFile() && file.exists()) {
                String enc = "utf-8"; // or NULL to use systemdefault
                FileInputStream fis = new FileInputStream(file);
                UnicodeInputStream uin = new UnicodeInputStream(fis, enc);
                enc = uin.getEncoding(); // check and skip possible BOM bytes
                InputStreamReader in;
                if (enc == null) in = new InputStreamReader(uin);
                else in = new InputStreamReader(uin, enc);
//                InputStreamReader read = new InputStreamReader(fis,"utf-8");
                BufferedReader bufferedReader = new BufferedReader(in);
                String lineTxt;
                StringBuffer buffer=new StringBuffer();
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    System.out.println(lineTxt);
                    buffer.append(lineTxt);
                }
                return buffer.toString();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find the file specified!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error reading file content!");
            e.printStackTrace();
        }
        return null;
    }

}