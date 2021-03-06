package com.icinfo.ch6;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月04
 */
public class ReaderWorker extends Thread{
    private final SharedData data;

    public ReaderWorker(SharedData data){
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true){
                char[] readBuf = data.read();
                System.out.println(Thread.currentThread().getName()+" reads " +String.valueOf(readBuf));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
