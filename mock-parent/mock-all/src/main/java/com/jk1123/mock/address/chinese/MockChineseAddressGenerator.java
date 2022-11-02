package com.jk1123.mock.address.chinese;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author huyoufu <https://github.com/huyoufu>
 * @TIME 2022/11/2 23:06
 * @description
 */
public class MockChineseAddressGenerator {
    private static Logger logger = LoggerFactory.getLogger(MockChineseAddressGenerator.class);

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static String generate(int level) {
        return generate(level, "-");
    }

    public static String generate(int level, String delimiter) {
        StringBuffer sb = new StringBuffer();
        //保证区间在1-5之间 因为全国省市只有五级
        if (level <= 0) {
            level = 1;
        }
        if (level > 5) {
            level = 5;
        }
        //线程安全 每次都从原始列表开始指向
        List<Region> tmp = REGION_LIST;

        while (level > 0) {
            //循环一次 减少一级
            level--;
            Region c = tmp.get(RANDOM.nextInt(tmp.size()));
            String name = c.getName();
            sb.append(name);
            tmp = (List) c.getChildren();
            if (tmp == null) {
                break;
            }
            if (level > 0) {
                sb.append(delimiter);
            }
        }
        return sb.toString();
    }

    /**
     * 初始化数据
     */
    private static Random RANDOM = new Random(System.currentTimeMillis());
    private static List<Region> REGION_LIST;

    static {
        logger.debug("开始初始化全国省市区县乡镇村模拟数据");
        logger.debug("开始加载2021年全国省市区县乡镇村数据(大约65万数据左右),花费时间1-2秒,请稍后...");
        long start = System.currentTimeMillis();
        InputStream inputStream = MockChineseAddressGenerator.class.getClassLoader().getResourceAsStream("mock/address/chinese/region-2021.zip");
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        try {
            ZipEntry regionData = zipInputStream.getNextEntry();
            ObjectMapper objectMapper = new ObjectMapper();
            REGION_LIST = objectMapper.readValue(zipInputStream, new TypeReference<List<Region>>() {
            });
            long end = System.currentTimeMillis();
            logger.debug("加载2021年全国省市区县乡镇村数据完成,花费了{}毫秒", end - start);
        } catch (IOException e) {
            logger.error("open mock/address/chinese/region-2021.zip failed");
            throw new RuntimeException(e);
        } finally {
            try {
                zipInputStream.close();
            } catch (IOException e) {
                //do noting
            }
        }
    }

    public static void init() {
        //其实啥也不干 主要是触发类加载用的
    }
}
