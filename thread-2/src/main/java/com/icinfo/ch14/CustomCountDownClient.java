package com.icinfo.ch14;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月05
 */
public class CustomCountDownClient {
    private static final Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {
        final CountDown latch = new CountDown(5);
        System.out.println("准备多线程处理任务");

        IntStream.rangeClosed(1,5)
                .forEach(i->{
                    new Thread(()->{
                        System.out.println(Thread.currentThread().getName() + " is working.");
                        try {
                            Thread.sleep(random.nextInt(1000));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        latch.down();
                    },String.valueOf(i)).start();
                });

        latch.await();
        //The second phase.
        System.out.println("多线程任务全部结束,准备第二阶段任务");
        System.out.println("............");
        System.out.println("FINISH");

    }
}
