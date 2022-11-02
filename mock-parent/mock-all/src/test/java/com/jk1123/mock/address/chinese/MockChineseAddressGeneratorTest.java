package com.jk1123.mock.address.chinese;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * @author huyoufu <https://github.com/huyoufu>
 * @TIME 2022/11/3 0:09
 * @description
 */
public class MockChineseAddressGeneratorTest {
    @Test
    public void testGenerate() {
        String s = MockChineseAddressGenerator.generate(5);
        Assert.assertNotNull(s);
    }

    @Test
    public void testGenerateWithDelimiter() {
        String s = MockChineseAddressGenerator.generate(5, ".");
        Assert.assertTrue(s.contains("."));
    }

    //@Test
    public void testGenerateBatch() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000 * 1000; i++) {
            String s = MockChineseAddressGenerator.generate(1);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    //@Test
    public void testGenerateWithTread() throws InterruptedException {
        int threadNum = 10;
        CountDownLatch latch = new CountDownLatch(threadNum);
        ArrayList<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ts.add(new Thread(() -> {
                for (int x = 0; x < 10000 * 1; x++) {
                    String s = MockChineseAddressGenerator.generate(5);
                    System.out.println(s);
                }
                latch.countDown();
            }));
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            ts.get(i).start();
        }
        latch.await();
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}
