package com.icinfo.ch5;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月05
 */
public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(()->{
            IntStream.range(1, 100).forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
        });

        Thread t2 = new Thread(()->{
            IntStream.range(1, 1000000).forEach(i -> System.out.println(Thread.currentThread().getName() + "->" +i));
        });


        t1.start();
        t2.start();
        t1.join();
        t2.join();

        Optional.of("All of tasks finish done.").ifPresent(System.out::println);
        IntStream.range(1, 1000)
                .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));

    }
}
