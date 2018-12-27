package com.kabir.huiping.socketdemo;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class FrameSocketServer extends Thread {
    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(12345);
            System.out.println(ss.getLocalPort());
            System.out.println("Tcp Server is on.....");
            while (true) {
                Socket s = ss.accept();
                System.out.println("Client " + s.getInetAddress().getHostAddress() + " is connected.");
                FrameCallBack cb = new FrameCallBack(s);
                new FrameSendThread(cb).start();
                new FrameReceiverThread(cb).start();
            }
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }
}
