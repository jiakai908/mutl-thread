package com.icinfo.ch1;

import java.util.stream.IntStream;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月30
 */
public class SingletonObject7 {
    private SingletonObject7(){

    }

    private enum Singleton {
        INSTANCE;

        private final SingletonObject7 instance;

        Singleton(){
            instance = new SingletonObject7();
        }

        public SingletonObject7 getInstance(){
            return instance;
        }
    }

    public static SingletonObject7 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1,10)
                .forEach(i -> new Thread(String.valueOf(i)){
                    @Override
                    public void run() {
                        System.out.println(SingletonObject7.getInstance());
                    }
                }.start());
    }
}
