package com.UHT.Insight.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class DataAnalyzeService {
    //    public boolean buildStartFile(int gameId, String scrapyType, String startFilePath) {
//        String filePath;
//        if(isWindows()){
//            filePath = startFilePath + "\\" + gameId + "start.py";
//        }else {
//            filePath = startFilePath + "/" + gameId + "start.py";
//        }
//        //构建启动文本
//        String build1 = "from scrapy import cmdline\n";
//        String build2 = "cmdline.execute(\"kmeans.py -s LOG_FILE=py.log\".split())";
////        cmdline.execute("scrapy crawl tap -a gameNub=147488 -s LOG_FILE=147488.log".split())
////        拼接结果如上
//        try {
//            Files.write(Paths.get(filePath), (build1 + build2).getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
//    public void runKmeans(int gameId, String filePath, Integer limit) {
//        Process process;
//        try {
//            String executePath,executePath2;
//            String[] cmdArr;
//            if (isWindows()) {
//                executePath = filePath + "\\" + "kmeans.py " + gameId + " LIMIT " + limit;
////                executePath = "cd /d "+filePath ;
////                executePath2="kmeans.py " + gameId + " LIMIT " + limit;
//                cmdArr = new String[]{"python3", executePath};
//            } else {
//                executePath = filePath + "/" + "kmeans.py " + gameId + " LIMIT " + limit;
//                cmdArr = new String[]{"python3", executePath};
//            }
//            System.out.println(executePath);
//
//            process = Runtime.getRuntime().
//                    exec(cmdArr, null, new File(filePath));
//            InputStream inputStream = process.getInputStream();
//            byte[] b = new byte[1024];
//            while (inputStream.read(b) != -1) {
//                String writeFilePath = new String(b);
//                System.out.println(writeFilePath);
//            }//返回linux执行状态码，0为执行正常
//            int statusNum = process.waitFor();
//            inputStream.close();
//            process.destroy();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void runTFIDF(int gameId, String filePath, Integer limit) {
//        Process process;
//        try {
//            String executePath;
//            String[] cmdArr;
//            if (isWindows()) {
//                executePath = filePath + " " + "TFIDF.py " + gameId + " LIMIT " + limit;
//                cmdArr = new String[]{"python", executePath};
//            } else {
//                executePath = filePath + " " + "TFIDF.py " + gameId + " LIMIT " + limit;
//                cmdArr = new String[]{"python3", executePath};
//            }
//            System.out.println(executePath);
//
//            process = Runtime.getRuntime().
//                    exec(cmdArr, null, new File(filePath));
//            InputStream inputStream = process.getInputStream();
//            byte[] b = new byte[1024];
//            while (inputStream.read(b) != -1) {
//                String writeFilePath = new String(b);
//            }//返回linux执行状态码，0为执行正常
//            int statusNum = process.waitFor();
//            inputStream.close();
//            process.destroy();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void runSnowNLP(String content, String filePath) {
//        Process process;
//        try {
//            String executePath;
//            String[] cmdArr;
//            if (isWindows()) {
//                executePath = filePath + " " + "sentiment.py " + content ;
//                cmdArr = new String[]{"python", executePath};
//            } else {
//                executePath = filePath + " " + "sentiment.py " + content ;
//                cmdArr = new String[]{"python3", executePath};
//            }
//            System.out.println(executePath);
//
//            process = Runtime.getRuntime().
//                    exec(cmdArr, null, new File(filePath));
//            InputStream inputStream = process.getInputStream();
//            byte[] b = new byte[1024];
//            while (inputStream.read(b) != -1) {
//                String writeFilePath = new String(b);
//            }//返回linux执行状态码，0为执行正常
//            int statusNum = process.waitFor();
//            inputStream.close();
//            process.destroy();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
    public boolean buildStartFile(String var, String analyzeType, Integer limit, String startFilePath) {
        String filePath;
        if (isWindows()) {
            filePath = startFilePath + "\\" + analyzeType + "Start.py";
        } else {
            filePath = startFilePath + "/" + analyzeType + "Start.py";
        }
        //构建启动文本
        String build1 = "import os\n";
        String build2 = null;
//        os.system('kmeans.py 168332 limit 50')
//        拼接结果如上
        if (!"sentiment".equals(analyzeType)) {//当参数不为情感分析脚本时
            build2 = "os.system(\'" + analyzeType + ".py " + var + " limit " + limit + "')";
        } else {
            build2 = "os.system(\'" + analyzeType + ".py " + var + "')";
            //构建情感分析文本
        }
        try {
            Files.write(Paths.get(filePath), (build1 + build2).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void runStartFile(String analyzeType, String startFilePath) {
        Process process;
        try {
            String executePath, executePath2;
            String[] cmdArr;
            if (isWindows()) {
                executePath = startFilePath + "\\" + analyzeType + "Start.py ";
                cmdArr = new String[]{"python", executePath};
            } else {
                executePath = startFilePath + "\\" + analyzeType + "Start.py ";
                cmdArr = new String[]{"python3", executePath};
            }
            System.out.println(executePath);

            process = Runtime.getRuntime().
                    exec(cmdArr, null, new File(startFilePath));
            InputStream inputStream = process.getInputStream();
            byte[] b = new byte[1024];
            while (inputStream.read(b) != -1) {
                String writeFilePath = new String(b);
                System.out.println(writeFilePath);
            }//返回linux执行状态码，0为执行正常
            int statusNum = process.waitFor();
            inputStream.close();
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void worldCloud(String gameId, String startFilePath) {
        String filePath;
        if (isWindows()) {
            filePath = startFilePath + "\\" + "Wc" + "Start.py";
        } else {
            filePath = startFilePath + "/" + "Wc" + "Start.py";
        }
        //构建启动文本
        String build1 = "import os\n";
        String build2 = "os.system(\'" + "build" + ".py " + gameId + "')";
        //构建情感分析文本
        try {
            Files.write(Paths.get(filePath), (build1 + build2).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //上面是构建启动脚本
        //下面是运行启动脚本
        Process process;
        try {
            String executePath;
            String[] cmdArr;
            if (isWindows()) {
                executePath = startFilePath + "\\" + "Wc" + "Start.py ";
                cmdArr = new String[]{"python", executePath};
            } else {
                executePath = startFilePath + "/" + "Wc" + "Start.py ";
                cmdArr = new String[]{"python3", executePath};
            }
            System.out.println(executePath);

            process = Runtime.getRuntime().
                    exec(cmdArr, null, new File(startFilePath));
            InputStream inputStream = process.getInputStream();
            byte[] b = new byte[1024];
            while (inputStream.read(b) != -1) {
                String writeFilePath = new String(b);
                System.out.println(writeFilePath);
            }//返回linux执行状态码，0为执行正常
            int statusNum = process.waitFor();
            inputStream.close();
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isWindows() {
        return System.getProperties().getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1;
    }
//    public enum analyzeType{
//        ;
//
//        private String type;
//        private String var;
//        analyzeType() {
//
//        }
//    }

}
