package com.jk1123.mock.name.chinese;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huyoufu <https://github.com/huyoufu>
 * @TIME 2022/11/3 2:25
 * @description
 */
public class MockChineseNameGeneratorTest {
    @Test
    public void testGenerate(){
        String s = MockChineseNameGenerator.generate();
        Assert.assertNotNull(s);
    }
    @Test
    public void testBatch(){
        for (int i = 0; i < 10000*1; i++) {
            System.out.println(MockChineseNameGenerator.generate());
        }

    }
}
