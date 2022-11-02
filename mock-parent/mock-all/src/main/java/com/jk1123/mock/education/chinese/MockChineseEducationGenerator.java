package com.jk1123.mock.education.chinese;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author huyoufu <https://github.com/huyoufu>
 * @TIME 2022/7/6 22:41
 * @description
 */
public class MockChineseEducationGenerator {
    private static Logger logger=LoggerFactory.getLogger(MockChineseEducationGenerator.class);
    private static Random RANDOM = new Random(System.currentTimeMillis());

    public static String generate() {
        return COLLEGES.get(RANDOM.nextInt(COLLEGES.size()));
    }
    private static List<String> COLLEGES=new ArrayList(1000);
    static {
        logger.debug("开始加载全国大学模拟数据");
        long start = System.currentTimeMillis();
        InputStream inputStream = MockChineseEducationGenerator.class.getClassLoader().getResourceAsStream("mock/education/chinese/colleges-2021.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String s=null;
            while ((s=bufferedReader.readLine())!=null){
                if (s.trim()!=""){
                    COLLEGES.add(s);
                }
            }
            long end = System.currentTimeMillis();
            logger.debug("加载2021年全国大学数据完成,花费了{}毫秒", end - start);
        } catch (IOException e) {
            logger.error("open mock/education/chinese/colleges-2021.txt failed");
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                //do noting
            }
        }
    }

    public static void init() {
        //啥也不做
    }
}
