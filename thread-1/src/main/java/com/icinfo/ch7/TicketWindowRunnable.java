package com.icinfo.ch7;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月05
 */
public class TicketWindowRunnable implements Runnable{
    private int index = 1;
    private final static int MAX = 500;

    private final Object MONITOR = new Object();


    @Override
    public void run() {
        while (true){
            synchronized (MONITOR){
                if (index > MAX){
                    break;
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " 的号码是:" + (index++));

            }
        }
    }
}
