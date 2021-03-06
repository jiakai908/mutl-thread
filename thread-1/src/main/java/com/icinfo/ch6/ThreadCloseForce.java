package com.icinfo.ch6;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月05
 */
public class ThreadCloseForce {

    public static void main(String[] args) {

        ThreadService service = new ThreadService();
        long start = System.currentTimeMillis();
        service.execute(() -> {
            //load a very heavy resource.
            /*while (true) {

            }*/
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.shutdown(10000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
