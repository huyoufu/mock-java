package com.jk1123.mock.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huyoufu <https://github.com/huyoufu>
 * @TIME 2022/11/3 2:14
 * @description
 */
public class Text2ListUtil {
    public static List<String> transferClassPath(String file) {
        return transfer(Text2ListUtil.class.getClassLoader().getResourceAsStream(file));
    }
    public static List<String> transferAbsolute(String file) throws FileNotFoundException {
        return transfer(new FileInputStream(file));
    }
    public static List<String> transfer(InputStream in){
        List<String> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        try {
            String s=null;
            while ((s=bufferedReader.readLine())!=null){
                if (s.trim()!=""){
                    list.add(s);
                }
            }
            return list;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                //do noting
            }
        }
    }

}
