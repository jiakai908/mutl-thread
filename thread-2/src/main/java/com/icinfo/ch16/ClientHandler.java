package com.icinfo.ch16;

import java.io.*;
import java.net.Socket;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月05
 */
public class ClientHandler implements Runnable{

    private final Socket socket;

    private volatile boolean running = true;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try(final InputStream inputStream = socket.getInputStream();
            final OutputStream outputStream = socket.getOutputStream();
            final BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            final PrintWriter printWriter = new PrintWriter(outputStream)
        ){
            while (running){
                final String message = br.readLine();
                if (message==null){
                    break;
                }
                System.out.println("Come from client >" + message);
                printWriter.write("echo " + message + "\n");
                printWriter.flush();
            }
        }catch (IOException e){
//            e.printStackTrace();
            this.running = false;
        }finally {
            this.stop();
        }
    }

    public void stop(){
        if (!running){
            return;
        }
        this.running = false;
        try {
            this.socket.close();
        } catch (IOException e) {
            //
        }

    }
}
