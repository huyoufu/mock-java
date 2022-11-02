package com.jk1123.mock.common;

import java.util.Random;
/**
 * @author huyoufu <https://github.com/huyoufu>
 * @TIME 2022/11/2 23:06
 * @description
 */
public class MockPhoneNumberGenerator {

    private static final Random RANDOM = new Random();
    private static final String[] TOP3 = {"133", "149", "153", "173", "177",
            "180", "181", "189", "199", "130", "131", "132",
            "145", "155", "156", "166", "171", "175", "176", "185", "186", "166", "134", "135",
            "136", "137", "138", "139", "147", "150", "151", "152", "157", "158", "159", "172",
            "178", "182", "183", "184", "187", "188", "198", "170", "171"};

    public static String generate() {
        String top3 = TOP3[RANDOM.nextInt(TOP3.length)];
        String lastNum = "";
        final int last = 8;
        for (int i = 0; i < last; i++) {
            //每次循环都从0~9挑选一个随机数
            lastNum += RANDOM.nextInt(10);
        }
        //最终将号段和尾数连接起来
        return top3 + lastNum;
    }


}
