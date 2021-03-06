package com.icinfo.ch7;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月05
 */
public class BankVersion3 {

    public static void main(String[] args) {
        final SynchronizedRunnable ticketWindow = new SynchronizedRunnable();

        Thread windowThread1 = new Thread(ticketWindow, "一号窗口");
        Thread windowThread2 = new Thread(ticketWindow, "二号窗口");
        Thread windowThread3 = new Thread(ticketWindow, "三号窗口");
        windowThread1.start();
        windowThread2.start();
        windowThread3.start();
    }
}
