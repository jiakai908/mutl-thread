package com.icinfo.ch5;

/**
 * @program: mutl-thread
 * @description: ${description}
 * @author: jkk
 * @create: 2019-09-02 22:19
 */
public class Client {

    public static void main(String[] args) {
        Gate gate = new Gate();

        User bj = new User("Baobao", "Beijing", gate);
        User sh = new User("ShangLao", "XhangHai", gate);
        User gz = new User("GuangLao", "GuangZhou", gate);

        bj.start();
        sh.start();
        gz.start();
    }

}
