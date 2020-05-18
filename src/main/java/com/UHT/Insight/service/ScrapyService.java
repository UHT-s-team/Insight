package com.UHT.Insight.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class ScrapyService {
    //    此服务主要是用于调用爬虫
    public boolean buildScrapyStartFile(int gameId, String scrapyType, String startFilePath) {
        String filePath;
        if(isWindows()){
             filePath = startFilePath + "\\" + gameId + "start.py";
        }else {
            filePath = startFilePath + "/" + gameId + "start.py";
        }
        //构建启动文本
        String build1 = "from scrapy import cmdline\n";
        String build2 = "cmdline.execute(\"scrapy crawl "
//                + scrapyType + " -a gameNub=" + gameId + " -s LOG_FILE=" + gameId + ".log\".split())\n";
                + scrapyType + " -a gameNub=" + gameId + ")\n";
//        cmdline.execute("scrapy crawl tap -a gameNub=147488 -s LOG_FILE=147488.log".split())
//        拼接结果如上
        try {
            Files.write(Paths.get(filePath), (build1 + build2).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void runScrapyStartFile(int gameId, String startFilePath) {
        Process process;
        try {
            String executePath;
            String[] cmdArr;
            if(isWindows()) {
                executePath = startFilePath + "\\" + gameId + "start.py";
                cmdArr = new String[]{"python", executePath};
            }else {
                executePath = startFilePath + "/" + gameId + "start.py";
                cmdArr = new String[]{"python3", executePath};
            }
            System.out.println(executePath);

            process = Runtime.getRuntime().
                    exec(cmdArr, null, new File(startFilePath));
            InputStream inputStream = process.getInputStream();
            byte[] b = new byte[1024];
            while (inputStream.read(b) != -1) {
                String writeFilePath = new String(b);
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


}
