package com.jk1123.mock.common;

import java.util.Random;
/**
 * @author huyoufu <https://github.com/huyoufu>
 * @TIME 2022/11/2 23:06
 * @description 理论上年龄1-180岁都行 因为人的极限寿命差不多就是 180左右 依旧希望数据生成最好控制在18-90之间
 */
public class MockAgeGenerator {
    private static final Random RANDOM = new Random(System.currentTimeMillis());

    public static int generate() {
        //18岁到80岁之间
        return generate(18,80);
    }
    public static int generate(int min,int max) {
        if (min>max){
            int tmp=min;
            min=max;
            max=tmp;
        }
        if (min<0){
            min=1;
        }
        if (max>180){
            max=180;
        }
        return min + RANDOM.nextInt(max-min);
    }
}
